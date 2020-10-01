package ec.hcam.orquestrator;

import ec.hcam.data.Temp;
import ec.hcam.data.GasesMedicinales;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.BEAN;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

@Stateless
@TransactionManagement(BEAN)
public class GasesMedicinalesService extends Basica implements GasesMedicinalesRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistrosGasesMedicinales(String unidMedica, Integer fecha1,Integer nivel,Integer unidpk,Integer ubicapk) {

        utx = ctx.getUserTransaction();
        String fecha = fecha1.toString();

        System.out.println("Hora Inicio GasesMedicinales:" + imprimirHora().toString());

        String strMes = fecha.substring(4, 6);
        String strDia = fecha.substring(6, 8);
        String strAnio = fecha.substring(0, 4);

        Integer intMes = Integer.parseInt(strMes);
        Integer intDia = Integer.parseInt(strDia);
        Integer intAnio = Integer.parseInt(strAnio);

        existenciaCabecera(intMes, intDia, intAnio,unidpk,ubicapk);

        ///////////////////////////////
        //FALTA FILTRAR POR DEPENDENCIA
        //AUN NO TENGO EL CAMPO DEP.
        ///////////////////////////////
        List<GasesMedicinales> lstRegistros = obtenerRegistros(unidMedica, fecha);
        
        for (GasesMedicinales registro : lstRegistros) {
            aplicarRegla(registro);
        }

        try {
            utx.begin();

            for (Detplantbl detplantbl : listaDetalles) {
                detalleService.createDetplantbl(detplantbl);
            }
            utx.commit();
            
        } catch (NotSupportedException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SystemException ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(FarmacosAplicadosService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FarmacosAplicadosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();

        System.out.println("Hora Fin Servicios Institucionales:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    private List<GasesMedicinales> obtenerRegistros(String unidadMedica, String fecha) {

            String sqlHistorias
                    = "SELECT  'OXIGENO' AS tipo, 1 as identificador, EGUNME as unidadMedica, EGHICL as historiaClinica, "
                    + "        EGOXLM as litrosMinuto, EGOXTI as tiempo, "
                    + "        ((INTEGER(EGOXTI /100) * 60)  + (EGOXTI-(INTEGER(EGOXTI /100)*100))) as parcial, "
                    + "        (((INTEGER(EGOXTI /100) * 60)  + (EGOXTI-(INTEGER(EGOXTI /100)*100))) * EGOXLM) AS total, "
                    + "        EGFECR as fechaCreacion, EGHOCR as horaCreacion, '911111' AS CODIGO "
                    + "FROM    PACLIBME.EGAM01 A "
                    + "WHERE   A.EGCSAD <> '  ' AND A.EGUNME = :unidadMedica AND A.EGFREG = :fecha "
                    + "UNION "
                    + "SELECT  'GASES MEDICINALES' AS tipo, 2 as identificador, EGUNME as unidadMedica, EGHICL as historiaClinica, "
                    + "        EGACLM as litrosMinuto, EGACTI as tiempo, "
                    + "        ((INTEGER(EGACTI /100) * 60)  + (EGACTI-(INTEGER(EGACTI /100)*100))) as parcial, "
                    + "        (((INTEGER(EGACTI /100) * 60)  + (EGACTI-(INTEGER(EGACTI /100)*100))) * EGACLM)  AS total, "
                    + "        EGFECR as fechaCreacion, EGHOCR as horaCreacion , '911112' AS CODIGO "
                    + "FROM    PACLIBME.EGAM01 A "
                    + "WHERE   A.EGCSAD = '  ' AND A.EGUNME = :unidadMedica AND A.EGFREG = :fecha";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        List<GasesMedicinales> lstHistorias = queryExecutor.executeQuery(sqlHistorias, params, GasesMedicinales.class);

        return lstHistorias;

    }

    private Temp valorGas(int identificador) {

        String sqlHistorias = "SELECT P.PACODTAR as valor, P.PADESCRI as descripcion " //por facilidad se usa descriipcion porque es un string
                + "FROM FACWEB.PARANIVETBL P "
                + "WHERE   P.PANIDH=207 AND "
                + "        P.PADET1= :identificador";

        Map<String, Object> params = new HashMap<>();
        params.put("identificador", identificador);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros.get(0);
    }

    private void aplicarRegla(GasesMedicinales registroGasesMedicinales) {

        //////////////////////////////////////////////
        // Registro Directo a detalle de Planillaje //
        /////////////////////////////////////////////
        Calendar clnCalendario = Calendar.getInstance();

        Detplantbl entidadDetalle = new Detplantbl();
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

                                                              //Revisar esto
        entidadDetalle.setNumplad(cab.getNumplanilla());

        entidadDetalle.setCoditem(registroGasesMedicinales.getCodigo());
     
        Temp registro = valorGas(registroGasesMedicinales.getIdentificador());

        entidadDetalle.setDescItem(registro.getDescripcion());
        

        entidadDetalle.setHistoCli(registroGasesMedicinales.getHistoriaClinica());
        entidadDetalle.setFechaReg(clnCalendario.getTime());
        entidadDetalle.setCoddeprea(BigInteger.valueOf(1142));                          /// QUEMADO ////        
        
        entidadDetalle.setCantidad((int)registroGasesMedicinales.getTotal());
        entidadDetalle.setValorUnit(registro.getValor());
        entidadDetalle.setValorTotal(registroGasesMedicinales.getTotal() * registro.getValor());
        
        
        entidadDetalle.setDuracionAtencion(0); //ver este campo
        entidadDetalle.setEstado('A');
        entidadDetalle.setTipoRubro("OTR");
        
        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        listaDetalles.add(entidadDetalle);
        registrarPorBloque(listaDetalles);
        

    }

}

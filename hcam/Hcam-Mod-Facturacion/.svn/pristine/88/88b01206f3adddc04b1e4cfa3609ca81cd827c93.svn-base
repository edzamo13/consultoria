package ec.hcam.orquestrator;

import ec.hcam.data.ServiciosInstitucionales;
import ec.hcam.data.Temp;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
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
public class AltaHospitalariaService extends Basica implements AltaHospitalariaRemote {

    @Override
    @Asynchronous
    public Future obtenerAltasHospitalarias(String unidMedica, Integer fecha1, Integer unidpk,Integer ubicapk) {

        utx = ctx.getUserTransaction();
        String fecha = fecha1.toString();
        System.out.println("Hora AltasHospitalarias:" + imprimirHora().toString());

        String strMes = fecha.substring(4, 6);
        String strDia = fecha.substring(6, 8);
        String strAnio = fecha.substring(0, 4);

        Integer intMes = Integer.parseInt(strMes);
        Integer intDia = Integer.parseInt(strDia);
        Integer intAnio = Integer.parseInt(strAnio);

        existenciaCabecera(intMes, intDia, intAnio,unidpk,ubicapk);

        //FILTRO POR DEPENDENCIAS
        List<ServiciosInstitucionales> lstDependencias = obtenerDependencias(unidMedica, fecha);
        for (ServiciosInstitucionales registroDependencia : lstDependencias) {

            //FILTRO POR HISTORIAS CLINICAS
            List<ServiciosInstitucionales> lstHistoriasClinicas = obtenerHistoriasClinicas(unidMedica, fecha, String.valueOf(registroDependencia.getDependenciaAlta()));
            for (ServiciosInstitucionales historiaClinica : lstHistoriasClinicas) {

                //OBTENGO REGISTROS Y APLICO REGLA
                List<ServiciosInstitucionales> lstRegistros = obtenerRegistrosDeHistoriasClinicas(unidMedica, fecha, String.valueOf(registroDependencia.getDependenciaAlta()), String.valueOf(historiaClinica.getHistoriaClinica()));
                for (ServiciosInstitucionales registro : lstRegistros) {
                    aplicarRegla(registro, unidMedica);
                }
            }
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
        //bagDependecia.clear();
        listaDetalles.clear();

        System.out.println("Hora Fin Altas Medicas:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    private List<ServiciosInstitucionales> obtenerDependencias(String unidadMedica, String fecha) {
        //private List<tempPOJO> obtenerHistoricasClinicas(String unidadMedica, String fecha) {

        String sqlHistorias
                = "SELECT  DISTINCT A.H9DEAL as dependenciaAlta "
                + "FROM    PACLIBME.PACF09 A "
                + "WHERE   H9UNME=:unidadMedica AND "
                + "        a.H9FEAE =:fecha AND "
                + "        A.H9MOAL='ALT' "
                + "ORDER BY A.H9DEAL "
                + "       ";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        List<ServiciosInstitucionales> lstDependenncias = queryExecutor.executeQuery(sqlHistorias, params, ServiciosInstitucionales.class);

        return lstDependenncias;

    }

    private List<ServiciosInstitucionales> obtenerHistoriasClinicas(String unidadMedica, String fecha, String dependencia) {
        //private List<tempPOJO> obtenerHistoricasClinicas(String unidadMedica, String fecha) {

        String sqlHistorias
                = "SELECT  DISTINCT A.H9NUHI as historiaClinica "
                + "FROM    PACLIBME.PACF09 A "
                + "WHERE   H9UNME=:unidadMedica AND     "
                + "        a.H9FEAE = :fecha AND     "
                + "        A.H9MOAL='ALT' and "
                + "        A.H9DEAL =:dependencia "
                + "ORDER BY A.H9NUHI";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("dependencia", dependencia);
        List<ServiciosInstitucionales> lstDependenncias = queryExecutor.executeQuery(sqlHistorias, params, ServiciosInstitucionales.class);

        return lstDependenncias;

    }

    private List<ServiciosInstitucionales> obtenerRegistrosDeHistoriasClinicas(String unidadMedica, String fecha, String dependencia, String historiaClinica) {
        //private List<tempPOJO> obtenerHistoricasClinicas(String unidadMedica, String fecha) {

        String sqlHistorias
                = "SELECT  A.H9UNME as unidadMedica, A.H9NUHI as historiaClinica, A.H9FEIN as fechaIngreso, A.H9HOIN as horaIngreso, "
                + "        A.H9DEIN as dependenciaIngreso, A.H9FEAL as fechaAlta, A.H9HOAL as horaAlta, A.H9DEAL as dependenciaAlta, "
                + "        A.H9MOAL as motivoAlta, A. H9FEAE as fechaAltaEnf, A.H9HOAE as horaAltaEnf, "
                + "        A.H9DEAE as dependenciaAltaEnf, A.H9FIL5 as honorario "
                + "FROM    PACLIBME.PACF09 A "
                + "WHERE   H9UNME=:unidadMedica AND      "
                + "        a.H9FEAE =:fecha AND     "
                + "        A.H9MOAL='ALT'         AND "
                + "        A.H9DEAL =:dependencia         AND "
                + "        A.H9NUHI =:historiaClinica      AND  "
                + "        A.H9FIL5 != '' "
                + "order by A. H9FEIN";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("dependencia", dependencia);
        params.put("historiaClinica", historiaClinica);
        List<ServiciosInstitucionales> lstDependenncias = queryExecutor.executeQuery(sqlHistorias, params, ServiciosInstitucionales.class);

        return lstDependenncias;

    }

    private Temp valorTarifario(String codigo, String unidadMedica) {

        String sqlHistorias = "SELECT T.TADESCRIPC AS descripcion, T.TACODIGO as codigo, T.TAVALOR as temp "
                + "FROM FACWEB.TARIFAFTBL T "
                + "WHERE T.TACODIGO =:codigo "
                + " and "
                + "      T.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK )"
                + "                             FETCH FIRST 1 ROWS ONLY";

        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        params.put("unidadMedica", unidadMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros.get(0);

    }

    private void aplicarRegla(ServiciosInstitucionales registro, String unidMedica) {

        //////////////////////////////////////////////
        // Registro Directo a detalle de Planillaje //
        /////////////////////////////////////////////
        Calendar clnCalendario = Calendar.getInstance();

        Detplantbl entidadDetalle = new Detplantbl();
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

        entidadDetalle.setCantidad(1);                                                      //Revisar esto
        entidadDetalle.setNumplad(cab.getNumplanilla());

        /**
         * *********************
         *
         * Revisar los siguientes:
         *
         ***********************
         */
        //entidadDetalle.setDepRea(String.valueOf(registroQuery.getDependenciaAlta()));     //falta
        entidadDetalle.setHistoCli(String.valueOf(registro.getHistoriaClinica()));

        entidadDetalle.setFechaReg(clnCalendario.getTime());
        
        BigDecimal codDependencia = BigDecimal.valueOf(registro.getDependenciaAlta());
        BigInteger dependenciaBI = codDependencia.toBigInteger();
        
        entidadDetalle.setCoddeprea(dependenciaBI);
        entidadDetalle.setCoddepsol(dependenciaBI);

        String dependencia1 = NombreDependenciaSQL(dependenciaBI);
        entidadDetalle.setDepRea(dependencia1);

        Temp valorTarifario = valorTarifario(registro.getHonorario(), unidMedica);
        entidadDetalle.setDescItem("ALTA HOSPITALARIA POR EL ULTIMO DIA");
        entidadDetalle.setTipoRubro("OTR");
        entidadDetalle.setCoditem(valorTarifario.getCodigo());
        entidadDetalle.setValorUnit(valorTarifario.getTemp());
        entidadDetalle.setValorTotal(valorTarifario.getTemp());
        entidadDetalle.setEstado('A');

        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        listaDetalles.add(entidadDetalle);
    }

}

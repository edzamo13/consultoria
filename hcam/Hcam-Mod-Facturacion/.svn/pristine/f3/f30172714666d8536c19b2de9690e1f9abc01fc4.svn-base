/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.Dependencia;
import ec.hcam.data.LaboratorioCli;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
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

/**
 *
 * @author Programacion
 */
@Stateless
@TransactionManagement(BEAN)
public class LabClinicoService extends Basica implements LabClinicoServiceRemote {

    @Override
    public void registrarDetallePlanillaje(LaboratorioCli registro, String uniMed, String iofeor) {
        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera        
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
        // TODO Solicitar a bdd que cree la BDD SEQUENCE para poder autogenrer secuenciales

        //Empieza            
        Calendar c1 = Calendar.getInstance();

        //detalle.setReidpk(2);poner la correspondiente
        detalle.setNumplad(cab.getNumplanilla());
        detalle.setCoditem(String.valueOf(registro.getItemtarifario()));//Verificar Campo
        detalle.setHistoCli(String.valueOf(registro.getHistoriaClinica()));
        detalle.setFechaReg(c1.getTime());
        detalle.setDescItem(registro.getDescripcion()); //imp
        detalle.setDepRea(NombreDependenciaSQL(BigDecimal.valueOf(registro.getDepeRealiza()).toBigInteger()));
        detalle.setCoddepsol(BigDecimal.valueOf(registro.getDepeSolicita()).toBigInteger());
        detalle.setCoddeprea(BigDecimal.valueOf(registro.getDepeRealiza()).toBigInteger());
        detalle.setTipSer(registro.getServicioRealiza());  //ver este campo
        detalle.setSubtipser(registro.getSubtiposervicio());
        detalle.setCantidad(1);
        detalle.setValorUnit(registro.getValor()); //ver este campo
        detalle.setValorTotal(registro.getValor());
        detalle.setNumOrden(registro.getNumeroOrden()); //ver este campo
        detalle.setTipoRubro("LAB"); //Tipo de servicio
       
        detalle.setCodMedico(registro.getMedicoSolicita());
        detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en farmacos
        detalle.setCodDerivacion("CD"); //ver este campo
        detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
        detalle.setContingenCubre(0);

        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);
        //Termina

        // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);
    }

    @Override
    @Asynchronous
    public Future obtenerRegistrosLaboratorio(String iounme, Integer iofeor, Integer nivel, Integer unidpk, Integer ubicapk) {
        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Laboratorio:" + imprimirHora().toString());
        cargarDependencias(iounme, String.valueOf(iofeor));
        List<Dependencia> lstDependencias = (List<Dependencia>) bagDependecia.get("lstDependencias");
        
        for (Dependencia depend : lstDependencias) {
            
            String mesSt = String.valueOf(iofeor).substring(4, 6);
            String diaSt = String.valueOf(iofeor).substring(6, 8);
            String anioSt = String.valueOf(iofeor).substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            Integer anioI = Integer.parseInt(anioSt);

            existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);

            obtenerTodosLosLaboratorios(iounme, String.valueOf(iofeor), depend.getIR2DEP(), nivel);
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
                Logger.getLogger(LabClinicoService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(LabClinicoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bag != null) {
            bag.clear();
        }
        if (bagDependecia != null) {
            bagDependecia.clear();
        }
        if (listaDetalles != null) {
            listaDetalles.clear();
        }
        System.out.println("Hora Fin Laboratorio:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    @Override
    public List<LaboratorioCli> obtenerTodosLosLaboratorios(String iounme, String iofeor, Double depend, int nivel) {

        String sqlLaboratorios = "select i.IOUNME unidadmedica, I.IONUOR numeroorden, I.IOCOSD serviciorealiza,I.IOHIST historiaclinica, I.IOTISE tiposervicio, I.IOSBTP subtiposervicio, I.IOITEM itemtarifario, I.IOXDAT fecharesultado,a.iodepe depesolicita, a.iomedi medicosolicita , b.isddep deperealiza ,coalesce(t.tadescripc, 'TARIFARIO ANTERIOR SIN VALOR') AS descripcion  , COALESCE(t.tavalor, 0) AS valor from ceddta.ioxr01 i join CEDDTA.iord01 a on a.iounme=i.iounme and a.ionuor=i.ionuor join CEDDTA.iser01 b on b.isdunm=i.iounme and b.isdcod=i.iocosd left join facweb.tarifaftbl t on i.ioitem=t.tacodigo and t.ctidpk=:nivel where I.iounme=:iounme and I.ioxdat=:iofeor and I.iotise=2 and I.iostde='V' and a.iodepe =:irdep";

        Map<String, Object> params = new HashMap<>();
        params.put("nivel",nivel);
        params.put("iounme", iounme);
        params.put("iofeor", iofeor);
        params.put("irdep", depend);
        List<LaboratorioCli> laboratoriosList = queryExecutor.executeQuery(sqlLaboratorios, params, LaboratorioCli.class);

        for (LaboratorioCli laboratoriosList1 : laboratoriosList) {
            registrarDetallePlanillaje(laboratoriosList1, iounme, iofeor);
            
        }
        return laboratoriosList;
    }

    public void cargarDependencias(String ir2unm, String ir2cit) {
        String sqlString1 = "select DISTINCT a.iodepe IR2DEP from ceddta.ioxr01 i join CEDDTA.iord01 a on a.iounme=i.iounme and a.ionuor=i.ionuor join CEDDTA.iser01 b on b.isdunm=i.iounme and b.isdcod=i.iocosd left join facweb.tarifaftbl t on i.ioitem=t.tacodigo and t.ctidpk=1 where I.iounme=:iounme and I.ioxdat=:iofeor and I.iotise=2 and I.iostde='V' ";
        Map<String, Object> params = new HashMap<>();
        params.put("iounme", ir2unm);
        params.put("iofeor", ir2cit);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString1, params, Dependencia.class);
        if (bagDependecia == null) {
            bagDependecia = new HashMap<>();
        }
        bagDependecia.clear();
        bagDependecia.put("lstDependencias", informacionDependenciaList);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.DatosMedico;
import ec.hcam.data.Dependencia;
import ec.hcam.data.DerechoSalaRecuperacion;
import ec.hcam.data.MinDerechosSalCir;
import ec.hcam.data.TarifarioCir;
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

/**
 *
 * @author programacion
 */
@Stateless
@TransactionManagement(BEAN)
public class DerechosSalaRecuperacionService extends Basica implements DerechosSalaRecuperacionServiceRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistros(String opunme, int opdata, Integer nivel, Integer unidpk, Integer ubicapk) {

        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Derecho de Sala Recuperacion:" + imprimirHora().toString());
        List<Dependencia> lstDependencias = cargarDependenciasPartesOperatorios(opunme, opdata);
        
        String fechaSt = Integer.toString(opdata);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        Integer anioI = Integer.parseInt(anioSt);

        existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);

        
        for (Dependencia depend : lstDependencias) {

            double unidMed = Double.valueOf(opunme);
            double fecha = (double) opdata;

            List<DerechoSalaRecuperacion> listaDerechoSalaR = ObtenerDerechosSalaRecuperacion(unidMed, fecha, (int)depend.getIR2DEP());
            
            for (DerechoSalaRecuperacion derSalaR : listaDerechoSalaR) {

                aplicarRegla(derSalaR);
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
                Logger.getLogger(DerechosSalaRecuperacionService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DerechosSalaRecuperacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();
        System.out.println("Hora Fin Derecho de Sala de Recuperacion: " + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    @Override
    public List<DerechoSalaRecuperacion> ObtenerDerechosSalaRecuperacion(double unidMed, double fecha, int dependencia) {

        
        String sqlString1 = "SELECT DISTINCT OP2UNM UNIDADMEDICA, OP2NUH HISTORIA, OP2FEO FECHAOPERACION, OP2HOO HORAOPERACION, COALESCE(CAMPO1, 0) DEPESOLICITA, COALESCE(CAMPO1, 0) DEPEREALIZA, opciru CODMEDICO FROM paclibme.pacf22 INNER JOIN PACLIBME.PACF08 ON OP2UNM= OPUNMe AND OP2NUH=OPNUHI AND OP2FEO=OPFEOP AND OP2HOO=OPHOOP INNER JOIN PACLIBME.PACF12 ON SAUNME=OPUNME AND OPUNID = SACOUO AND OPSALA = SACOSA WHERE OP2UNM||OP2NUH||OP2FEO||OP2HOO in( SELECT OPUNMe|| OPNUHI||OPFEOP||OPHOOP FROM paclibme.pacf08 WHERE opunme =:unidMed AND OPdata =:fecha AND CAMPO1 =:dependencia AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S)) AND op2est='REC' AND OP2TRA='FIC' AND (CAMPO1 <= 5000 OR CAMPO1 >= 59999)";

        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("fecha", fecha);
        params.put("dependencia", dependencia);
        //params.put("depend", depend);
        List<DerechoSalaRecuperacion> derechosList = queryExecutor.executeQuery(sqlString1, params, DerechoSalaRecuperacion.class);

        
        return derechosList;
    }

    public void aplicarRegla(DerechoSalaRecuperacion derechoSR) {

        
        List<MinDerechosSalCir> minDerechosSalCirList = consultarMinDerechos(derechoSR.getUnidadMedica());

        for (MinDerechosSalCir derS : minDerechosSalCirList) {            
            
            if (derS.getMinutosInicio() == derechoSR.getDepeSolicita()) {                
                TarifarioCir tarifario = obtenerValorTarifario(derS.getCodigoTarifario(), derechoSR.getUnidadMedica());
                registrarDetallePlanillaje(derechoSR, tarifario);
            }           
        }
    }

    @Override
    public void registrarDetallePlanillaje(DerechoSalaRecuperacion derSR, TarifarioCir tarifario) {

        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera        
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
        // TODO Solicitar a bdd que cree la BDD SEQUENCE para poder autogenrer secuenciales

        //Empieza 
        Calendar c1 = Calendar.getInstance();

        //detalle.setReidpk();
        detalle.setNumplad(cab.getNumplanilla());
        //String fechaSt = Double.toString(opdata);
        detalle.setCoditem(tarifario.getCODIGO()); //codigo de la tabla de minutos
        
        int historia = (int) derSR.getHistoria();
        detalle.setHistoCli(Integer.toString(historia));
        detalle.setFechaReg(c1.getTime()); //ver este campo
        detalle.setDescItem(tarifario.getDESCRIPCION()); //vpro.getITEMTARIFARIO() descripcion de este campo

        //se obtiene el nombre de la dependencia
        //ver si se pone el nombre de la dependencia del primer procedimiento como se toma el codigo
        
        BigDecimal codDependencia = BigDecimal.valueOf(derSR.getDepeSolicita());
        BigInteger dependenciaBI = codDependencia.toBigInteger();  
        
        String dependencia = NombreDependencia(dependenciaBI);
        detalle.setDepRea(dependencia);
        detalle.setCoddepsol(dependenciaBI);
        detalle.setCoddeprea(dependenciaBI);

        detalle.setTipSer(99);  //quemado dado por Jairo
        detalle.setSubtipser(06);  //quemado dado por Jairo
        detalle.setCantidad(1);  //según los tiempos
        detalle.setValorUnit(tarifario.getVALORTARIFARIO());
        detalle.setValorTotal(tarifario.getVALORTARIFARIO());
        //detalle.setNumOrden(2); //El numero de orden no se registra.
        detalle.setTipoRubro("DSR"); //Dato dado DSR
        detalle.setCodMedico((int) derSR.getCodMedico());

        detalle.setTimeAntestesia(Short.parseShort("0"));

        detalle.setCodDerivacion(""); //se manda vacío
        detalle.setSecDerivacion(Short.parseShort("0")); //se manda cero

        detalle.setEstado('A');
        detalle.setReidpk(2);
        
        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);
        
    }

    private List<DatosMedico> consultaDatosMedicos(DerechoSalaRecuperacion derSR) {

        String queryString = "SELECT A.IRMDP1 AS diag1, A.IRMDP2 AS diag2, A.IRMDP3 AS diag3, A.IRMDD1 AS diag4, A.IRMDD2 AS diag5, A.IRMDD3 AS diag6, 'PRESUNTIVO' AS tipodiag1, 'PRESUNTIVO' AS tipodiag2, 'PRESUNTIVO' AS tipodiag3, 'DEFINITIVO' AS tipodiag4, 'DEFINITIVO' AS tipodiag5, 'DEFINITIVO' AS tipodiag6, A.IRMCOD AS codmedico, B.IMMNOM AS nommedico FROM CEDDTA.IRME01 A LEFT JOIN CEDDTA.IMME01 B ON A.IRMUNM = B.IMMUNM AND A.IRMCOD = B.IMMCOD WHERE A.IRMUNM =:unidadmedi AND A.IRMHIS =:hisCli AND A.IRMCIT <=:fechaOp AND A.IRMDEP =:dependencia";

        Map<String, Object> paramsDatosMedicos = new HashMap();
        //inicio 15 de mayo
        paramsDatosMedicos.put("unidadmedi", derSR.getUnidadMedica());//recepta la unidad medica        
        paramsDatosMedicos.put("hisCli", derSR.getHistoria());
        paramsDatosMedicos.put("fechaOp", derSR.getFechaOperacion());
        paramsDatosMedicos.put("dependencia", derSR.getDepeSolicita());

        List<DatosMedico> datosMedico = queryExecutor.executeQuery(queryString, paramsDatosMedicos, DatosMedico.class);
        
        return datosMedico;
    }

    private List<MinDerechosSalCir> consultarMinDerechos(String unidadMedica) {

        String unidMed = unidadMedica;
        while (unidMed.length() < 10) {
            unidMed = "0" + unidMed;
        }
        String sqlString1 = "SELECT C.PACODTAR AS CODIGOTARIFARIO, C.PADET1 AS MINUTOSINICIO, C.PADET2 AS MINUTOSFIN, C.PADESCRI AS DESCRIPCION FROM FACWEB.PANICODTBL A JOIN FACWEB.CABTARITBL B ON A.CTIDPK = B.CTIDPK JOIN FACWEB.PARANIVETBL C ON A.PANIDPK = C.PANIDPK AND A.PANIDH = C.PANIDH JOIN FACWEB.CT_UMTBL D ON D.CTIDPK = B.CTIDPK JOIN FACWEB.UNIDMEDTBL E ON D.UNIDPK = E.UNIDPK AND D.UBICAPK = E.UBICAPK WHERE C.PANIDH =:codigo AND E.UNCODIGO =:unidMed";
        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("codigo", 210);

        List<MinDerechosSalCir> minDerechosSalCirList = queryExecutor.executeQuery(sqlString1, params, MinDerechosSalCir.class);
        return minDerechosSalCirList;
    }

    public List<Dependencia> cargarDependenciasPartesOperatorios(String unidMed, int fechaOp) {
        String sqlString = "SELECT DISTINCT COALESCE(CAMPO1, 0) IR2DEP FROM paclibme.pacf22 INNER JOIN PACLIBME.PACF08 ON OP2UNM= OPUNMe AND OP2NUH=OPNUHI AND OP2FEO=OPFEOP AND OP2HOO=OPHOOP INNER JOIN PACLIBME.PACF12 ON SAUNME=OPUNME AND OPUNID = SACOUO AND OPSALA = SACOSA WHERE OP2UNM||OP2NUH||OP2FEO||OP2HOO in( SELECT OPUNMe|| OPNUHI||OPFEOP||OPHOOP FROM paclibme.pacf08 WHERE opunme =:unidMed AND OPdata =:fechaOp AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S)) AND op2est='REC' AND OP2TRA='FIC' AND (CAMPO1 <= 5000 OR CAMPO1 >= 59999)";
        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("fechaOp", fechaOp);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString, params, Dependencia.class);
        return informacionDependenciaList;
    }
}

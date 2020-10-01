/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.Cabecera;
import ec.hcam.data.CodigosTiempo;
import ec.hcam.data.DatosMedico;
import ec.hcam.data.Dependencia;
import ec.hcam.data.MinDerechosSalCir;
import ec.hcam.data.ParteOperatorio;
import ec.hcam.data.TarifarioCir;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class MaterialesUsoMenorService extends Basica implements MaterialesUsoMenorServiceRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistros(String opunme, int opdata, Integer nivel, Integer unidpk, Integer ubicapk) { //opunme= Unidad Medica  OPdata=fecha en entero
        //int opunme=Integer.parseInt(unimed);
        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Materiales de uso Menor:" + imprimirHora().getTime());

        String fechaSt = Integer.toString(opdata);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        Integer anioI = Integer.parseInt(anioSt);

        existenciaCabecera(mesI, diaI, anioI, unidpk, ubicapk);

        List<Dependencia> lstDependencias = cargarDependenciasPartesOperatorios(opunme, opdata);
        
        for (Dependencia depend : lstDependencias) {
           
            List<ParteOperatorio> listaParteOperatorio;

            //listaParteOperatorio = obtenerTodosPartesOper(opunme, opdata, depend.getIR2DEP());
            listaParteOperatorio = obtenerTodosPartesOper(opunme, opdata, depend.getIR2DEP());

            for (ParteOperatorio partOp : listaParteOperatorio) {

                aplicarRegla(partOp);
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
                Logger.getLogger(MaterialesUsoMenorService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MaterialesUsoMenorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();

        System.out.println("Hora Fin Materiales de uso menor:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    private void aplicarRegla(ParteOperatorio parOp) {

        List<MinDerechosSalCir> minDerechosSalCirList = consultarMinDerechos(parOp.getUNIDADMEDICA());

        int minutosBuscar = diferenciaHoras(parOp.getHORAENTRADAQUIROFANO(), parOp.getHORASALIDAQUIROFANO());

        String codTarifarioResiduo = "";
        String codTarifarioCoeficiente = "";

        int coeficiente = minutosBuscar / 420;
        int residuo = minutosBuscar % 420;


        List<CodigosTiempo> listaCodigosTiempos = new ArrayList<>();

        if (residuo >= 391) {
            coeficiente = coeficiente + 1;
            residuo = 0;
        }

        if (residuo != 0) {
            codTarifarioResiduo = obtenerCodigoTarifarioResiduo(residuo, minDerechosSalCirList);
            TarifarioCir tarifario = obtenerValorTarifario(codTarifarioResiduo, parOp.getUNIDADMEDICA());

            CodigosTiempo codTiempo = new CodigosTiempo();
            codTiempo.setCodigoTarifario(codTarifarioResiduo);
            codTiempo.setValorUnitario(tarifario.getVALORTARIFARIO());
            codTiempo.setCantidad(1);
            codTiempo.setValorCobrar(tarifario.getVALORTARIFARIO());
            codTiempo.setDescripcion(tarifario.getDESCRIPCION());            
            listaCodigosTiempos.add(codTiempo);

        }

        if (coeficiente != 0) {
            codTarifarioCoeficiente = obtenerCodigoTarifarioCoeficiente(coeficiente, minDerechosSalCirList);
            TarifarioCir tarifario = obtenerValorTarifario(codTarifarioCoeficiente, parOp.getUNIDADMEDICA());
            
            CodigosTiempo codTiempo = new CodigosTiempo();
            codTiempo.setCodigoTarifario(codTarifarioCoeficiente);
            codTiempo.setValorUnitario(tarifario.getVALORTARIFARIO());
            codTiempo.setCantidad(coeficiente);
            codTiempo.setDescripcion(tarifario.getDESCRIPCION());
            double valorCobrar = coeficiente * tarifario.getVALORTARIFARIO();
            codTiempo.setValorCobrar(valorCobrar);

            listaCodigosTiempos.add(codTiempo);
        }

        if (!listaCodigosTiempos.isEmpty()) {
            for (CodigosTiempo codTiempo : listaCodigosTiempos) {
                registrarDetallePlanillaje(parOp, codTiempo);
            }
        }
    }

    private List<MinDerechosSalCir> consultarMinDerechos(String unidadMedica) {
        
        String unidMed = unidadMedica;
        while (unidMed.length() < 10) {
            unidMed = "0" + unidMed;
        }

        String sqlString1 = "SELECT C.PACODTAR AS CODIGOTARIFARIO, C.PADET1 AS MINUTOSINICIO, C.PADET2 AS MINUTOSFIN, C.PADESCRI AS DESCRIPCION FROM FACWEB.PANICODTBL A JOIN FACWEB.CABTARITBL B ON A.CTIDPK = B.CTIDPK JOIN FACWEB.PARANIVETBL C ON A.PANIDPK = C.PANIDPK AND A.PANIDH = C.PANIDH JOIN FACWEB.CT_UMTBL D ON D.CTIDPK = B.CTIDPK JOIN FACWEB.UNIDMEDTBL E ON D.UNIDPK = E.UNIDPK AND D.UBICAPK = E.UBICAPK WHERE C.PANIDH =:codigo AND E.UNCODIGO =:unidMed";
        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("codigo", 130);

        List<MinDerechosSalCir> minDerechosSalCirList = queryExecutor.executeQuery(sqlString1, params, MinDerechosSalCir.class);
        return minDerechosSalCirList;

    }

    @Override
    public List<ParteOperatorio> obtenerTodosPartesOper(String opunme, int opdata, double depend) {

        String sqlString1 = "SELECT OPFEFI AS FECHAFINCIRUGIA, OPHOEQ AS HORAENTRADAQUIROFANO, OPHOSQ AS HORASALIDAQUIROFANO, OPUNME AS UNIDADMEDICA, OPNUHI AS HISTORIACLINICA, OPFEOP AS FECHAOPERACION, OPHOOP AS HORAOPERACION, OPTIPO AS TIPOCIRUGIA, OPRIE1 AS RIESGOANESTESIA, OPFEIA AS FECINICIAANEST, OPHOAI AS HORAINICIAANEST, OPFEFA AS FECFINANEST, OPHOAF AS HORAFINANEST, opciru AS cirujano1, OPAXC1 AS cirujano2, OPAXC2 AS cirujano3, OPAXC3 AS cirujano4, OPACC1 AS ayudantecc1, OPACC2 AS ayudantecc2, OPACC3 AS ayudantecc3, OPPAP1 AS personalapoyo1, OPPAP2 AS personalapoyo2, OPPAP3 AS personalapoyo3, OPAYC1 AS ayudantecce1, OPAYC2 AS ayudantecce2, OPAYC3 AS ayudantecce3, OPANES AS anestesiologo, OPAAC1 AS anestesiologo1 , OPAAC2 AS anestesiologo2 , OPAAC3 AS anestesiologo3, OPAYA1 AS ayudanteanes1, OPAYA2 AS ayudanteanes2, OPAYA3 AS ayudanteanes3, OPINST AS instrumentista1, OPINS1 AS instrumentista2, OPCIRC AS circulante1, OPCIR1 AS circulante2, OPASIS AS perfusionista, OPESTA AS ESTADO, OPTRAS AS TRASLADO, OPOBSF AS APROBACIONPARTE, OPUSUA AS USUARIOACTUALIZA, OPPGMA AS PROGRAMA, OPDATA AS FECHA, OPHORA AS HORA, SADEPE AS DEPEQUIROFANO, OPSERV AS DEPECIRU FROM paclibme.pacf08 INNER JOIN PACLIBME.PACF12 ON SAUNME = OPUNME AND  SACOUO=OPUNID AND SACOSA=OPSALA WHERE opunme =:opunme AND OPdata =:opdata AND SADEPE =:depend AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPHOEQ>0 and OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S) ORDER BY OPUNME, OPNUHI, OPFEOP, OPHOOP";
        //String sqlString1 = "SELECT C.IOUNME PLAUBME, 'NUM_PLANILLA' PLANUM,  C.IORHIS PLAHIC, CASE WHEN C.IOORIG ='CE' THEN 'FAR' WHEN C.IOORIG ='EM' THEN 'FAH' WHEN C.IOORIG ='HO' THEN 'FAH' ELSE '--' END PLATIP, 'SECUENCIAL' PLASEC, D.COTIPO || D.COGRUP || D.COSUBG || D.COORDI || D.COESPE PLACOD, D.CODESC PLACOP, '' PLACOX, C.IODEPE PALDEX, A.IONUOR, C.IODEPE PLADSX, C.IOTISE PLATSE, C.IOSBTP PLASSE, A.IOCADE PLACAN, (B.FFPREC) ValorUnitario, (A.IOCADE * B.FFPREC) PLACTO, C.IONUOR PLAORD, '' PLAINH, '' PLAFIH, '' PLAPOR, C.IOMEDI COD_MEDICO, C.IOFEOR FECHA_ORDEN FROM S101719R.CEDDTA.IOFI01 A INNER JOIN S101719R.INVLIB.INVF35 B ON A.IOUNME = B.FFUNME AND DIGITS(A.IOELE1) = B.FFGRUP AND DIGITS(A.IOELE2) = B.FFSUBG AND DIGITS(A.IOGENE) = B.FFORDI AND B.FFTIPO = '321' INNER JOIN INVLIB.INVF11 D ON A.IOUNME = D.COCDUN AND DIGITS(A.IOELE1) = D.COGRUP AND DIGITS(A.IOELE2) = D.COSUBG AND DIGITS(A.IOGENE) = D.COORDI AND D.COTIPO = '321' RIGHT JOIN CEDDTA.IORD01 C ON C.IONUOR = A.IONUOR AND C.IOUNME = A.IOUNME WHERE A.IOUNME =:ioinme AND C.IOFEOR =:iofeor AND C.IORHIS = '234543' AND A.IOSTSI='D'";
        Map<String, Object> params = new HashMap<>();
        params.put("opunme", opunme);
        params.put("opdata", opdata);
        params.put("depend", depend);
        List<ParteOperatorio> derechosList = queryExecutor.executeQuery(sqlString1, params, ParteOperatorio.class);

        return derechosList;
    }

    @Override
    public List<Cabecera> buscadorCabecera(Integer mes, Integer dia) {

        String sqlString = "SELECT CAB.CPIDPK AS CPIDPK, CAB.UNIDPK AS UNIDPK, CAB.UBICAPK AS UBICAPK, CAB.NUMPLANILLA AS NUMPLANILLA, CAB.FECHA_REG AS FECHA_REG, CAB.MESPLANILLA AS MESPLANILLA, CAB.DIAPLANILLA AS DIAPLANILLA FROM facweb.cabplantbl CAB WHERE MESPLANILLA =:mes AND DIAPLANILLA =:dia FETCH FIRST 1 ROWS ONLY";
        Map<String, Object> params = new HashMap<>();
        params.put("dia", dia);
        params.put("mes", mes);

        List<Cabecera> lstCabecera;

        lstCabecera = queryExecutor.executeQuery(sqlString, params, Cabecera.class);
        return lstCabecera;
    }

    @Override
    public void registrarDetallePlanillaje(ParteOperatorio parteO, CodigosTiempo codTiempo) {

        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera        
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
        Calendar c1 = Calendar.getInstance();

        //detalle.setReidpk();
        detalle.setNumplad(cab.getNumplanilla());
        //String fechaSt = Double.toString(opdata);
        detalle.setCoditem(codTiempo.getCodigoTarifario()); //codigo de la tabla de minutos
        int historia = (int) parteO.getHISTORIACLINICA();
        detalle.setHistoCli(Integer.toString(historia));

        detalle.setFechaReg(c1.getTime()); //ver este campo
        detalle.setDescItem(codTiempo.getDescripcion()); //vpro.getITEMTARIFARIO() descripcion de este campo
        
        BigDecimal codDependencia = BigDecimal.valueOf(parteO.getDEPEQUIROFANO());
        BigInteger dependenciaBI = codDependencia.toBigInteger();  
        
        String dependencia = NombreDependencia(dependenciaBI);
        detalle.setDepRea(dependencia);
        detalle.setCoddepsol(dependenciaBI);
        detalle.setCoddeprea(dependenciaBI);

        detalle.setTipSer(99);  //quemado dado por Jairo
        detalle.setSubtipser(03);  //quemado dado por Jairo
        detalle.setCantidad(codTiempo.getCantidad());  //según los tiempos
        detalle.setValorUnit(codTiempo.getValorUnitario());
        detalle.setValorTotal(codTiempo.getValorCobrar());
        //detalle.setNumOrden(2); //El numero de orden no se registra.
        detalle.setTipoRubro("OPR"); //Dato dado OPR
        detalle.setCodMedico(parteO.getCIRUJANO1());
        detalle.setTimeAntestesia(Short.parseShort("0"));

        detalle.setCodDerivacion(""); //se manda vacío
        detalle.setSecDerivacion(Short.parseShort("0")); //se manda cero        
        detalle.setEstado('A');
        detalle.setReidpk(2);

        // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);

    }

    String descripcionTablaTiempo = "";

    private String obtenerCodigoTarifarioResiduo(int residuo, List<MinDerechosSalCir> minDerechosSalCirList) {
        
        String codTarifarioResiduo = null;
        descripcionTablaTiempo = "";
        for (MinDerechosSalCir min : minDerechosSalCirList) {

            if ((min.getMinutosInicio() <= residuo) && (min.getMinutosFin() >= residuo)) {
                codTarifarioResiduo = min.getCodigoTarifario();
                descripcionTablaTiempo = min.getDescripcion();
                break;
            }
        }
        
        return codTarifarioResiduo;
    }

    private String obtenerCodigoTarifarioCoeficiente(int coeficiente, List<MinDerechosSalCir> minDerechosSalCirList) {

        String codTarifarioCoeficiente = null;
        descripcionTablaTiempo = "";
        if (coeficiente != 0) {
            int i = minDerechosSalCirList.size();
            codTarifarioCoeficiente = minDerechosSalCirList.get(i - 1).getCodigoTarifario();
            descripcionTablaTiempo = minDerechosSalCirList.get(i - 1).getDescripcion();
        }
        
        return codTarifarioCoeficiente;
    }

    private List<DatosMedico> consultaDatosMedicos(ParteOperatorio parteO) {

        String queryString = "SELECT A.IRMDP1 AS diag1, A.IRMDP2 AS diag2, A.IRMDP3 AS diag3, A.IRMDD1 AS diag4, A.IRMDD2 AS diag5, A.IRMDD3 AS diag6, 'PRESUNTIVO' AS tipodiag1, 'PRESUNTIVO' AS tipodiag2, 'PRESUNTIVO' AS tipodiag3, 'DEFINITIVO' AS tipodiag4, 'DEFINITIVO' AS tipodiag5, 'DEFINITIVO' AS tipodiag6, A.IRMCOD AS codmedico, B.IMMNOM AS nommedico FROM CEDDTA.IRME01 A LEFT JOIN CEDDTA.IMME01 B ON A.IRMUNM = B.IMMUNM AND A.IRMCOD = B.IMMCOD WHERE A.IRMUNM =:unidadmedi AND A.IRMHIS =:hisCli AND A.IRMCIT <=:fechaOp AND A.IRMDEP =:dependencia";

        Map<String, Object> paramsDatosMedicos = new HashMap();
        //inicio 15 de mayo
        paramsDatosMedicos.put("unidadmedi", parteO.getUNIDADMEDICA());//recepta la unidad medica        
        paramsDatosMedicos.put("hisCli", parteO.getHISTORIACLINICA());
        paramsDatosMedicos.put("fechaOp", parteO.getFECHAOPERACION());
        paramsDatosMedicos.put("dependencia", parteO.getDEPECIRU());

        List<DatosMedico> datosMedico = queryExecutor.executeQuery(queryString, paramsDatosMedicos, DatosMedico.class);
        

        if (datosMedico.isEmpty()) {
            String queryString2 = "SELECT A.IRMDP1 AS diag1, A.IRMDP2 AS diag2, A.IRMDP3 AS diag3, A.IRMDD1 AS diag4, A.IRMDD2 AS diag5, A.IRMDD3 AS diag6, 'PRESUNTIVO' AS tipodiag1, 'PRESUNTIVO' AS tipodiag2, 'PRESUNTIVO' AS tipodiag3, 'DEFINITIVO' AS tipodiag4, 'DEFINITIVO' AS tipodiag5, 'DEFINITIVO' AS tipodiag6, A.IRMCOD AS codmedico, B.IMMNOM AS nommedico FROM CEDDTA.IRME01 A LEFT JOIN CEDDTA.IMME01 B ON A.IRMUNM = B.IMMUNM AND A.IRMCOD = B.IMMCOD WHERE A.IRMUNM =:unidadmedi AND A.IRMHIS =:hisCli AND A.IRMCIT <=:fechaOp AND A.IRMDEP =:dependencia";

            Map<String, Object> paramsDatosMedicos2 = new HashMap();
            //inicio 15 de mayo
            paramsDatosMedicos2.put("unidadmedi", parteO.getUNIDADMEDICA());//recepta la unidad medica        
            paramsDatosMedicos2.put("hisCli", parteO.getHISTORIACLINICA());
            paramsDatosMedicos2.put("fechaOp", parteO.getFECHAOPERACION());
            paramsDatosMedicos2.put("dependencia", parteO.getDEPEQUIROFANO());

            datosMedico = queryExecutor.executeQuery(queryString2, paramsDatosMedicos2, DatosMedico.class);
            
        }
        return datosMedico;
    }

    public List<Dependencia> cargarDependenciasPartesOperatorios(String unidMed, int fechaOp) {
        String sqlString = "SELECT DISTINCT SADEPE AS IR2DEP FROM paclibme.pacf08 INNER JOIN PACLIBME.PACF12 ON SAUNME = OPUNME AND  SACOUO=OPUNID AND SACOSA=OPSALA WHERE opunme =:unidMed AND OPdata =:fechaOp AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPHOEQ>0 and OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S) ";
        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("fechaOp", fechaOp);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString, params, Dependencia.class);
        return informacionDependenciaList;
    }
}

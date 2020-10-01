/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.DatosMedico;
import ec.hcam.data.DatosPaciente;
import ec.hcam.data.Dependencia;
import ec.hcam.data.MinDerechosSalCir;
import ec.hcam.data.ParteOperatorio;
import ec.hcam.data.ProcedimientoCirugia;
import ec.hcam.data.ProcedimientosQ;
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
public class HonorariosMedicosCirugiaService extends Basica implements HonorariosMedicosCirugiaServiceRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistros(String opunme, Integer opdata, Integer nivel, Integer unidpk, Integer ubicapk) { //opunme= Unidad Medica  OPdata=fecha en entero
        //int opunme = Integer.parseInt(unimed);
        utx = ctx.getUserTransaction();
        System.out.println("Hora Inicio Honorarios Médicos:" + imprimirHora().toString());

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
            List<ProcedimientosQ> listaProcedimientosPorPaciente = new ArrayList<>();
            BigDecimal dependencia = BigDecimal.valueOf(depend.getIR2DEP());
            BigInteger dependenciaBI = dependencia.toBigInteger();

            listaParteOperatorio = obtenerTodosPartesOper(opunme, opdata, depend.getIR2DEP());

            for (ParteOperatorio partOp : listaParteOperatorio) {
                listaProcedimientosPorPaciente.clear();

                listaProcedimientosPorPaciente = obtenerProcedimientos(opunme, partOp.getFECHAOPERACION(), partOp.getHISTORIACLINICA(), partOp.getHORAOPERACION());

                if (!listaProcedimientosPorPaciente.isEmpty()) {
                    aplicarRegla(partOp, listaProcedimientosPorPaciente);
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
                Logger.getLogger(HonorariosMedicosCirugiaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(HonorariosMedicosCirugiaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        bag.clear();
        listaDetalles.clear();

        System.out.println("Hora Fin Honorarios Médicos:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    @Override
    public List<ParteOperatorio> obtenerTodosPartesOper(String opunme, int opdata, double dependencia) {

        String sqlString1 = "SELECT OPFEFI AS FECHAFINCIRUGIA, OPHOEQ AS HORAENTRADAQUIROFANO, OPHOSQ AS HORASALIDAQUIROFANO, OPUNME AS UNIDADMEDICA, OPNUHI AS HISTORIACLINICA, OPFEOP AS FECHAOPERACION, OPHOOP AS HORAOPERACION, OPTIPO AS TIPOCIRUGIA, OPRIE1 AS RIESGOANESTESIA, OPFEIA AS FECINICIAANEST, OPHOAI AS HORAINICIAANEST, OPFEFA AS FECFINANEST, OPHOAF AS HORAFINANEST, opciru AS cirujano1, OPAXC1 AS cirujano2, OPAXC2 AS cirujano3, OPAXC3 AS cirujano4, OPACC1 AS ayudantecc1, OPACC2 AS ayudantecc2, OPACC3 AS ayudantecc3, OPPAP1 AS personalapoyo1, OPPAP2 AS personalapoyo2, OPPAP3 AS personalapoyo3, OPAYC1 AS ayudantecce1, OPAYC2 AS ayudantecce2, OPAYC3 AS ayudantecce3, OPANES AS anestesiologo, OPAAC1 AS anestesiologo1 , OPAAC2 AS anestesiologo2 , OPAAC3 AS anestesiologo3, OPAYA1 AS ayudanteanes1, OPAYA2 AS ayudanteanes2, OPAYA3 AS ayudanteanes3, OPINST AS instrumentista1, OPINS1 AS instrumentista2, OPCIRC AS circulante1, OPCIR1 AS circulante2, OPASIS AS perfusionista, OPESTA AS ESTADO, OPTRAS AS TRASLADO, OPOBSF AS APROBACIONPARTE, OPUSUA AS USUARIOACTUALIZA, OPPGMA AS PROGRAMA, OPDATA AS FECHA, OPHORA AS HORA, SADEPE AS DEPEQUIROFANO, opserv AS DEPECIRU FROM paclibme.pacf08 INNER JOIN PACLIBME.PACF12 ON SAUNME = OPUNME AND  SACOUO=OPUNID AND SACOSA=OPSALA WHERE opunme =:opunme AND OPdata =:opdata AND SADEPE =:dependencia AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPHOEQ>0 and OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S) ORDER BY OPUNME, OPNUHI, OPFEOP, OPHOOP";

        Map<String, Object> params = new HashMap<>();
        params.put("opunme", opunme);
        params.put("opdata", opdata);
        params.put("dependencia", dependencia);
        List<ParteOperatorio> derechosList = queryExecutor.executeQuery(sqlString1, params, ParteOperatorio.class);

        return derechosList;
    }

    @Override
    public List<ProcedimientosQ> obtenerProcedimientos(String unidMed, int fechaOp, int hisCli, int horaOp) {

        String sqlString1 = "SELECT PAUNME AS UNIDADMEDICA, PANUHI AS HISTORIACLINICA, PAFEOP AS FECHAOPERACION, PAHOOP AS HORAOPERACION, PACDEP AS DEPENDENCIAPROCEDIMIENTO, PADTAR AS ITEMTARIFARIO, PASIBI AS INDSIMPLEBILATERAL, PANUMP AS NUMEROPROCEDIMIENTOS, PADABO AS LINEAABORDAJE from paclibme.pacf20 where PAUNME|| PANUHI||PAFEOP||PAHOOP in(SELECT OPUNME||OPNUHI||OPFEOP||OPHOOP FROM paclibme.pacf08 WHERE opunme =:unidMed AND PAFEOP =:fechaOp AND PANUHI =:hisCli AND PAHOOP =:horaOp AND OPESTA='FIN' AND OPTRAS<>'REP' AND OPHOEQ>0 and OPOBSF<>' ' and OPUNME||OPNUHI||OPFEOP||OPHOOP NOT IN(SELECT OSUNME||OSNUHI||OSFEOP||OSHOOP FROM paclibme.PACF08S))";

        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidMed);
        params.put("fechaOp", fechaOp);
        params.put("hisCli", hisCli);
        params.put("horaOp", horaOp);
        List<ProcedimientosQ> procedimientosList = queryExecutor.executeQuery(sqlString1, params, ProcedimientosQ.class);

        return procedimientosList;
    }

    public void aplicarRegla(ParteOperatorio parteO, List<ProcedimientosQ> listaProc) {

        List<ProcedimientoCirugia> listaProdCirugia = new ArrayList<>();

        if (listaProc.size() == 1) {
            listaProdCirugia = obtenerValorProcedimiento(listaProc.get(0), parteO);

        } else {
            for (ProcedimientosQ prod : listaProc) {
                List<ProcedimientoCirugia> listaProcAbor;
                listaProcAbor = obtenerValorProcedimiento(prod, parteO);
                for (ProcedimientoCirugia proC : listaProcAbor) {
                    listaProdCirugia.add(proC);
                }
            }
        }

        //DATOS PACIENTE
        List<DatosPaciente> datosPaciente = datosPacientePorHistoriaClinica(parteO.getHISTORIACLINICA(), parteO.getUNIDADMEDICA());
        /*HONORARIO CIRUJANO*/
        /*Cuando existe un cirujano*/
        if (parteO.getCIRUJANO1() != 0 && parteO.getCIRUJANO2() == 0) {
            for (ProcedimientoCirugia proCr : listaProdCirugia) {
                registrarDetallePlanillaje(parteO, proCr, parteO.getCIRUJANO1(), proCr.getValorCobra(), "HCI1", datosPaciente);
            }
        } else if (parteO.getCIRUJANO1() != 0 && parteO.getCIRUJANO2() != 0) {

            for (ProcedimientoCirugia proCr : listaProdCirugia) {
                //1116 dependencia de transplantes
                //BigInteger depTrans = BigInteger.valueOf(1116);

                if (proCr.getProd().getDEPENDENCIAPROCEDIMIENTO() == 1116) {

                    registrarDetallePlanillaje(parteO, proCr, parteO.getCIRUJANO1(), proCr.getValorCobra(), "HCI1", datosPaciente);
                    registrarDetallePlanillaje(parteO, proCr, parteO.getCIRUJANO2(), proCr.getValorCobra(), "HCI2", datosPaciente);
                } else {

                    double valorACobrar = (62.5 * proCr.getValorCobra()) / 100;
                    registrarDetallePlanillaje(parteO, proCr, parteO.getCIRUJANO1(), valorACobrar, "HCI1", datosPaciente);
                    registrarDetallePlanillaje(parteO, proCr, parteO.getCIRUJANO2(), valorACobrar, "HCI2", datosPaciente);
                }
            }
        }

        /*HONORARIO DE AYUDANTES*/
        if (parteO.getAYUDANTECC1() != 0) {

            for (ProcedimientoCirugia proCr : listaProdCirugia) {
                if (proCr.getPorcentajeCobrado() == 100) {
                    double valorAyudante1 = (20 * proCr.getValorCobra()) / 100;
                    registrarDetallePlanillaje(parteO, proCr, parteO.getAYUDANTECC1(), valorAyudante1, "HAY", datosPaciente);
                }
            }
        }
        if (parteO.getAYUDANTECC2() != 0 && parteO.getAYUDANTECC3() == 0) {
            for (ProcedimientoCirugia proCr : listaProdCirugia) {

                if (proCr.getPorcentajeCobrado() == 100) {
                    double valorAyudante2 = (10 * proCr.getValorCobra()) / 100;
                    registrarDetallePlanillaje(parteO, proCr, parteO.getAYUDANTECC2(), valorAyudante2, "HAYA", datosPaciente);
                }
            }
        } else if (parteO.getAYUDANTECC2() != 0 && parteO.getAYUDANTECC3() != 0) {
            for (ProcedimientoCirugia proCr : listaProdCirugia) {
                if (proCr.getPorcentajeCobrado() == 100) {

                    double valorAyudante = (10 * proCr.getValorCobra()) / 100;
                    registrarDetallePlanillaje(parteO, proCr, parteO.getAYUDANTECC2(), valorAyudante, "HAYA", datosPaciente);
                    registrarDetallePlanillaje(parteO, proCr, parteO.getAYUDANTECC3(), valorAyudante, "HAYA", datosPaciente);
                }
            }
        }

        /*HONORARIO DE PERFUSIONISTA*/
        if (parteO.getPERFUSIONISTA() != 0) {

            double mayorPer = listaProdCirugia.get(0).getValorCobra();
            ProcedimientoCirugia procCirPer = new ProcedimientoCirugia();
            for (ProcedimientoCirugia proCr : listaProdCirugia) {
                if (proCr.getPorcentajeCobrado() == 100) {
                    if (proCr.getValorCobra() >= mayorPer) {
                        mayorPer = proCr.getValorCobra();
                        procCirPer = proCr;
                    }
                }
            }
            double valorPerfusionista = (35 * mayorPer) / 100;
            registrarDetallePlanillaje(parteO, procCirPer, parteO.getPERFUSIONISTA(), valorPerfusionista, "OTR", datosPaciente);
        }

        //ANESTESIA
        /*HONORARIO DE ANESTESIOLOGO*/
        if (parteO.getANESTESIOLOGO() != 0 && parteO.getHORAINICIAANEST() != 0 && parteO.getHORAFINANEST() != 0) {

            double valorCobrarAnestesia = 0;

            //verificamos con el # de procedimientos 
            ProcedimientoCirugia proAnestesia = new ProcedimientoCirugia();
            if (listaProc.size() == 1) {
                if (listaProdCirugia.get(0).getPorcentajeCobrado() == 100) {
                    proAnestesia = new ProcedimientoCirugia();
                    valorCobrarAnestesia = listaProdCirugia.get(0).getValorAnestesia();

                    if (valorCobrarAnestesia != 0) {
                        proAnestesia = listaProdCirugia.get(0);
                        registrarDetallePlanillaje(parteO, listaProdCirugia.get(0), parteO.getANESTESIOLOGO(), valorCobrarAnestesia, "HAN", datosPaciente);
                    }
                }
            } else {

                double mayor = listaProdCirugia.get(0).getValorCobra();
                proAnestesia = new ProcedimientoCirugia();

                for (ProcedimientoCirugia objProC : listaProdCirugia) {

                    if (objProC.getPorcentajeCobrado() == 100) {

                        if (objProC.getValorCobra() >= mayor) {
                            mayor = objProC.getValorCobra();
                            valorCobrarAnestesia = objProC.getValorAnestesia();
                            proAnestesia = objProC;
                        }
                    }
                }

                if (valorCobrarAnestesia != 0) {
                    registrarDetallePlanillaje(parteO, proAnestesia, parteO.getANESTESIOLOGO(), valorCobrarAnestesia, "HAN", datosPaciente);
                }
            }

            /* VALOR DE MINUTOS DE ANESTESIA */
            List<MinDerechosSalCir> minDerechosSalCirList = consultarMinDerechos(parteO.getUNIDADMEDICA());

            int minutos = diferenciaHoras(parteO.getHORAINICIAANEST(), parteO.getHORAFINANEST());
            int coeficiente = minutos / 15;
            int residuo = minutos % 15;

            if (residuo >= 5) {
                coeficiente = coeficiente + 1;
            }

            double valorCobrarA;

            for (MinDerechosSalCir mdc : minDerechosSalCirList) {
                if ("VALOR ANESTESIA".equals(mdc.getDescripcion())) {

                    TarifarioCir tarifarioA = obtenerValorTarifarioQ(mdc.getCodigoTarifario(), parteO.getUNIDADMEDICA());
                    valorCobrarA = tarifarioA.getVALORANEST() * coeficiente;
                    registrarDetallePlanillajeAnestesia(parteO, tarifarioA, parteO.getANESTESIOLOGO(), valorCobrarA, "HANA", datosPaciente, Integer.toString(minutos), coeficiente, proAnestesia);
                }
            }

            //Ver si se puede solo sacar el minDerechoSalCir de EDAD ANESTECIA
            for (MinDerechosSalCir mdc : minDerechosSalCirList) {
                if ("EDAD DE ANESTECIA".equals(mdc.getDescripcion())) {
                    if (!datosPaciente.isEmpty()) {
                        if (datosPaciente.get(0).getEDADPACIENTE() != null) {
                            if ((datosPaciente.get(0).getEDADPACIENTE() <= mdc.getMinutosInicio()) || (datosPaciente.get(0).getEDADPACIENTE() > mdc.getMinutosFin())) {

                                TarifarioCir tarifarioA = obtenerValorTarifarioQ(mdc.getCodigoTarifario(), parteO.getUNIDADMEDICA());
                                valorCobrarA = tarifarioA.getVALORANEST();
                                registrarDetallePlanillajeAnestesia(parteO, tarifarioA, parteO.getANESTESIOLOGO(), valorCobrarA, "HANE", datosPaciente, Integer.toString(0), 1, proAnestesia);
                            }
                        }
                    }
                }
            }

            /*COBRO ADICIONAL POR CIRUGIA DE EMERGENCIA TIPO DE CIRUGIA*/
            if ("EME".equals(parteO.getTIPOCIRUGIA())) {
                for (MinDerechosSalCir mdc : minDerechosSalCirList) {
                    if ("EMERGENCIA".equals(mdc.getDescripcion())) {
                        TarifarioCir tarifarioA = obtenerValorTarifarioQ(mdc.getCodigoTarifario(), parteO.getUNIDADMEDICA());
                        valorCobrarA = tarifarioA.getVALORANEST();
                        registrarDetallePlanillajeAnestesia(parteO, tarifarioA, parteO.getANESTESIOLOGO(), valorCobrarA, "HEM", datosPaciente, Integer.toString(0), 1, proAnestesia);
                    }
                }
            }

            /*COBRO ADICIONAL POR RIESTO EN ANESTESIA  falta el rubro*/
            if (!parteO.getRIESGOANESTESIA().isEmpty()) {
                for (MinDerechosSalCir riesgo : minDerechosSalCirList) {
                    if ((riesgo.getMinutosInicio() == Integer.parseInt(parteO.getRIESGOANESTESIA())) && ("RIESGO ANESTESIA".equals(riesgo.getDescripcion()))) {

                        TarifarioCir tarifarioA = obtenerValorTarifarioQ(riesgo.getCodigoTarifario(), parteO.getUNIDADMEDICA());
                        valorCobrarA = tarifarioA.getVALORANEST();
                        registrarDetallePlanillajeAnestesia(parteO, tarifarioA, parteO.getANESTESIOLOGO(), valorCobrarA, "HANEM", datosPaciente, Integer.toString(0), 1, proAnestesia);

                    }
                }
            }

        } //fin de anestesia
    }

    private List<ProcedimientoCirugia> obtenerValorProcedimiento(ProcedimientosQ proced, ParteOperatorio parteO) {

        ProcedimientoCirugia prodCirugia;
        List<ProcedimientoCirugia> listaProdCirugia = new ArrayList<>();

        double valorProcedCobrar = 0;

        TarifarioCir objTarifario = obtenerValorTarifarioQ(Integer.toString(proced.getITEMTARIFARIO()), parteO.getUNIDADMEDICA());
        double valorPro = objTarifario.getVALORTARIFARIO();

        if (proced.getLINEAABORDAJE() == 1) { //cuando es 1 linea de abordaje

            valorProcedCobrar = valorPro;

            prodCirugia = new ProcedimientoCirugia();
            prodCirugia.setProd(proced);
            prodCirugia.setValorCobra(valorProcedCobrar);
            prodCirugia.setPorcentajeCobrado(100);
            prodCirugia.setValorAnestesia(objTarifario.getVALORANEST());
            prodCirugia.setDescripcionProd(objTarifario.getDESCRIPCION());
            listaProdCirugia.add(prodCirugia);

        } else if (proced.getLINEAABORDAJE() < 9 && proced.getLINEAABORDAJE() >= 2) { //cuando son menos de 9

            int numLineasAbordaje = proced.getLINEAABORDAJE();

            for (int i = 0; i < numLineasAbordaje; i++) {
                if (i == 0) {

                    valorProcedCobrar = valorPro;

                    prodCirugia = new ProcedimientoCirugia();
                    prodCirugia.setProd(proced);
                    prodCirugia.setValorCobra(valorProcedCobrar);
                    prodCirugia.setPorcentajeCobrado(100);
                    prodCirugia.setValorAnestesia(objTarifario.getVALORANEST());
                    prodCirugia.setDescripcionProd(objTarifario.getDESCRIPCION());
                    listaProdCirugia.add(prodCirugia);

                } else {

                    valorProcedCobrar = (valorPro * 50) / 100;

                    prodCirugia = new ProcedimientoCirugia();
                    prodCirugia.setProd(proced);
                    prodCirugia.setValorCobra(valorProcedCobrar);
                    prodCirugia.setPorcentajeCobrado(50);
                    prodCirugia.setValorAnestesia(objTarifario.getVALORANEST());
                    prodCirugia.setDescripcionProd(objTarifario.getDESCRIPCION());
                    listaProdCirugia.add(prodCirugia);
                }
            }
        } else { //mas de 9 vias de abordaje

            for (int i = 0; i < 9; i++) {
                if (i == 0) {

                    valorProcedCobrar = valorPro;
                    prodCirugia = new ProcedimientoCirugia();
                    prodCirugia.setProd(proced);
                    prodCirugia.setValorCobra(valorProcedCobrar);
                    prodCirugia.setPorcentajeCobrado(100);
                    prodCirugia.setValorAnestesia(objTarifario.getVALORANEST());
                    prodCirugia.setDescripcionProd(objTarifario.getDESCRIPCION());
                    listaProdCirugia.add(prodCirugia);
                } else {

                    valorProcedCobrar = (valorPro * 50) / 100;

                    prodCirugia = new ProcedimientoCirugia();
                    prodCirugia.setProd(proced);
                    prodCirugia.setValorCobra(valorProcedCobrar);
                    prodCirugia.setPorcentajeCobrado(50);
                    prodCirugia.setValorAnestesia(objTarifario.getVALORANEST());
                    prodCirugia.setDescripcionProd(objTarifario.getDESCRIPCION());
                    listaProdCirugia.add(prodCirugia);
                }
            }
        }

        return listaProdCirugia;
    }

    @Override
    public void registrarDetallePlanillaje(ParteOperatorio parteO, ProcedimientoCirugia proCir, int codCirujano, double valorCobrar, String rubro, List<DatosPaciente> datosPaciente) {

        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera        
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

        //Empieza 
        Calendar c1 = Calendar.getInstance();

        //detalle.setReidpk();
        detalle.setNumplad(cab.getNumplanilla());
        //String fechaSt = Double.toString(opdata);
        detalle.setCoditem(Integer.toString(proCir.getProd().getITEMTARIFARIO())); //item_tarifario VERIFICAR
        int historia = (int) (parteO.getHISTORIACLINICA());
        detalle.setHistoCli(Integer.toString(historia));
        detalle.setFechaReg(c1.getTime()); //ver este campo       

        detalle.setDescItem(proCir.getDescripcionProd()); //vpro.getITEMTARIFARIO() descripcion de este campo

        //se obtiene el nombre de la dependencia
        //ver si se pone el nombre de la dependencia del primer procedimiento como se toma el codigo   
        BigDecimal codDependencia = BigDecimal.valueOf(proCir.getProd().getDEPENDENCIAPROCEDIMIENTO());
        BigInteger dependenciaBI = codDependencia.toBigInteger();

        String dependenciaDesc = NombreDependenciaSQL(dependenciaBI);
        detalle.setDepRea(dependenciaDesc);
        detalle.setCoddepsol(dependenciaBI);
        detalle.setCoddeprea(dependenciaBI);

        detalle.setTipSer(99);  //quemado dado por Jairo
        detalle.setSubtipser(05);  //quemado dado por Jairo VERIFICAR
        detalle.setCantidad(1);  //según los tiempos
        detalle.setValorUnit(valorCobrar);
        detalle.setValorTotal(valorCobrar);
        //detalle.setNumOrden(2); //El numero de orden no se registra.
        detalle.setTipoRubro(rubro);
        detalle.setCodMedico(codCirujano);

        detalle.setTimeAntestesia(Short.parseShort("0"));
        detalle.setCodDerivacion(""); //se manda vacío
        detalle.setSecDerivacion(Short.parseShort("0")); //se manda cero                
        detalle.setEdadBenefic(datosPaciente.get(0).getEDADPACIENTE());
        detalle.setEstado('A');

        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);
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

    private List<DatosPaciente> datosPacientePorHistoriaClinica(int historia, String unidadMed) {
        List<DatosPaciente> datosPaciente;

        String queryPaciente = "SELECT TIMESTAMPDIFF (256, CHAR ( CURRENT TIMESTAMP - TO_DATE (CHAR ( A.IAFFNA ) , 'YYYYMMDD' ) ) ) AS EDADPACIENTE FROM CEDDTA.IAFI01 A WHERE A.IAFUNM =:unidmed AND A.IAFHIS =:hisCli";

        Map<String, Object> paramsDatosPaciente = new HashMap();
        paramsDatosPaciente.put("hisCli", historia);//Poner la historia clinica del paciente
        paramsDatosPaciente.put("unidmed", unidadMed);//Poner la historia clinica del paciente

        datosPaciente = queryExecutor.executeQuery(queryPaciente, paramsDatosPaciente, DatosPaciente.class);
        return datosPaciente;
    }

    public TarifarioCir obtenerValorTarifarioQ(String codTarifario, String unidadMedica) {

        String unidMed = unidadMedica;
        while (unidMed.length() < 10) {
            unidMed = "0" + unidMed;
        }

        String sqlStringT = "SELECT T.TAIDPK AS IDTARIFARIO, T.TAVALOR AS VALORTARIFARIO, T.TAESTADO AS ESTADO, T.VALOR_ANES AS VALORANEST, T.TADESCRIPC AS DESCRIPCION, T.TACODIGO AS  CODIGO FROM FACWEB.TARIFAFTBL T JOIN FACWEB.CABTARITBL C ON T.CTIDPK = C.CTIDPK JOIN FACWEB.CT_UMTBL M ON M.CTIDPK = C.CTIDPK JOIN FACWEB.UNIDMEDTBL U ON U.UNIDPK = M.UNIDPK WHERE T.TACODIGO =:codTarifario  AND U.UNCODIGO =:uniMed";
        Map<String, Object> params = new HashMap<>();
        //params.put("codTarifario", String.valueOf(codTarifario));
        params.put("codTarifario", codTarifario);
        params.put("uniMed", unidMed);
        // Definir el anio
        //params.put("anio", 2014);

        List<TarifarioCir> tarifario = queryExecutor.executeQuery(sqlStringT, params, TarifarioCir.class);

        if (!tarifario.isEmpty()) {
            return tarifario.get(0);
        } else {
            TarifarioCir tarifarioV = new TarifarioCir();
            tarifarioV.setCODIGO(codTarifario);
            tarifarioV.setDESCRIPCION("TARIFARIO ANTERIOR SIN VALOR");
            return tarifarioV;
        }
    }

    private List<MinDerechosSalCir> consultarMinDerechos(String unidadMedica) {

        String sqlString1 = "SELECT C.PACODTAR AS CODIGOTARIFARIO, C.PADET1 AS MINUTOSINICIO, C.PADET2 AS MINUTOSFIN, C.PADESCRI AS DESCRIPCION FROM FACWEB.PANICODTBL A JOIN FACWEB.CABTARITBL B ON A.CTIDPK = B.CTIDPK JOIN FACWEB.PARANIVETBL C ON A.PANIDPK = C.PANIDPK AND A.PANIDH = C.PANIDH JOIN FACWEB.CT_UMTBL D ON D.CTIDPK = B.CTIDPK JOIN FACWEB.UNIDMEDTBL E ON D.UNIDPK = E.UNIDPK AND D.UBICAPK = E.UBICAPK WHERE C.PANIDH =:codigo AND E.UNCODIGO =:unidMed";
        Map<String, Object> params = new HashMap<>();
        params.put("unidMed", unidadMedica);
        params.put("codigo", 4);

        List<MinDerechosSalCir> minDerechosSalCirList = queryExecutor.executeQuery(sqlString1, params, MinDerechosSalCir.class);
        return minDerechosSalCirList;

    }

    public void registrarDetallePlanillajeAnestesia(ParteOperatorio parteO, TarifarioCir tarf, int codCirujano, double valorCobrar, String rubro, List<DatosPaciente> datosPaciente, String minutos, int cantidadMin, ProcedimientoCirugia prodCir) {

        Detplantbl detalle = new Detplantbl();
        //Datos Cabecera        
        Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

        //Empieza 
        Calendar c1 = Calendar.getInstance();

        //detalle.setReidpk();
        detalle.setNumplad(cab.getNumplanilla());
        //String fechaSt = Double.toString(opdata);
        detalle.setCoditem(tarf.getCODIGO()); //item_tarifario VERIFICAR
        int historia = (int) parteO.getHISTORIACLINICA();
        detalle.setHistoCli(Integer.toString(historia));
        detalle.setFechaReg(c1.getTime()); //ver este campo
        detalle.setDescItem(tarf.getDESCRIPCION()); //vpro.getITEMTARIFARIO() descripcion de este campo

        //se obtiene el nombre de la dependencia
        //ver si se pone el nombre de la dependencia del primer procedimiento como se toma el codigo
        BigDecimal codDependencia = BigDecimal.valueOf(parteO.getDEPECIRU());
        BigInteger dependenciaBI = codDependencia.toBigInteger();

        String dependencia = NombreDependenciaSQL(dependenciaBI);
        detalle.setDepRea(dependencia);
        detalle.setCoddepsol(dependenciaBI);
        detalle.setCoddeprea(dependenciaBI);

        detalle.setTipSer(99);  //quemado dado por Jairo
        detalle.setSubtipser(05);  //quemado dado por Jairo VERIFICAR
        detalle.setCantidad(cantidadMin);  //según los tiempos
        detalle.setValorUnit(valorCobrar);
        detalle.setValorTotal(valorCobrar);
        //detalle.setNumOrden(2); //El numero de orden no se registra.
        detalle.setTipoRubro(rubro);
        detalle.setCodMedico(codCirujano);
        detalle.setTimeAntestesia((Short.parseShort(minutos)));
        detalle.setCodDerivacion(""); //se manda vacío
        detalle.setSecDerivacion(Short.parseShort("0")); //se manda cero        
        detalle.setEdadBenefic(datosPaciente.get(0).getEDADPACIENTE());
        detalle.setEstado('A');

        cab.setDetplantblList(null);
        detalle.setCpidpk(cab);

        listaDetalles.add(detalle);
        registrarPorBloque(listaDetalles);
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

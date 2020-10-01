package ec.hcam.orquestrator;

import ec.hcam.data.DatosMedico;
import ec.hcam.data.DatosPaciente;
import ec.hcam.data.Dependencia;
import ec.hcam.data.InformacionB;
import ec.hcam.data.InformacionHC;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
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

@Stateless
@TransactionManagement(BEAN)
public class HonorarioMedicoService extends Basica implements HonorarioMedicoServiceRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistrosHM(int nivel, String iounme, Integer ioxdat, Integer unimedpk, Integer ubicapk) {

        System.out.println("Hora Inicio de Honorarios Medicos EM y HO:" + imprimirHora().toString());

        //obtenemos todas las dependencias, 
        List<Dependencia> listaDep;
        listaDep = obtenerDependencias(nivel, iounme, ioxdat);

        procesarDependenciasUnaAUna(nivel, iounme, ioxdat, listaDep, unimedpk, ubicapk);

        System.out.println("Hora Fin de Honorarios Medicos EM y HO:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    //obtener lista de dependencias de la unidad medica solicitada 1
    public List<Dependencia> obtenerDependencias(int ctidpk, String ir2unm, int ir2cit) {

        String sqlString = "SELECT ir2dep as IR2DEP FROM CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2CIT=:ir2cit GROUP BY IR2DEP";
        Map<String, Object> params = new HashMap<>();
        params.put("ctidpk", ctidpk);
        params.put("ir2unm", ir2unm);
        //params.put("ir2dep", ir2dep);
        params.put("ir2cit", ir2cit);
        List<Dependencia> informacionDependenciaList = queryExecutor.executeQuery(sqlString, params, Dependencia.class);
        
        return informacionDependenciaList;
    }

    public List<InformacionHC> obtenerHistoriasClinicasPacientePorDependencia(int ctidpk, String ir2unm, BigInteger ir2dep, int ir2cit) {

        String sqlString = "SELECT ir2his as IR2HIS FROM CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit GROUP BY IR2HIS";
        //String sqlString = "SELECT ir2his as IR2HIS FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit AND IR2SUB='P' AND IR2INT=' ' GROUP BY IR2HIS";
        //String sqlString = "SELECT ir2his as IR2HIS FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2CIT=:ir2cit GROUP BY IR2HIS";
        Map<String, Object> params = new HashMap<>();
        params.put("ctidpk", ctidpk);
        params.put("ir2unm", ir2unm);
        params.put("ir2dep", ir2dep);
        params.put("ir2cit", ir2cit);
        List<InformacionHC> informacionHCList = queryExecutor.executeQuery(sqlString, params, InformacionHC.class);

        return informacionHCList;
    }

    public List<InformacionB> obtenerTodosLosRegistrosPacienteDeUnaDependencia(int ctidpk, String ir2unm, BigInteger ir2dep, int ir2cit) {
        //primera  vez, sin interconsultas y P
        //caso intersonsultas y P
        //caso interconsultas y S
        // sacar la descripcion que seria tadescripc t
        String sqlString = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, ir2hop as IR2HOP, i.ir2int as IR2INT, i.ir2sub as IR2SUB, i.ir2sfa as IR2SFA, t.TADESCRIPC as descripcion, i.ir2com AS IR2COM FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit order by ir2his";
        //Antes de agregar descripcion        
        //String sqlString = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, ir2hop as IR2HOP, i.ir2int as IR2INT, i.ir2sub as IR2SUB, i.ir2sfa as IR2SFA FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit order by ir2his";
        //String sqlString = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, ir2hop as IR2HOP, i.ir2int as IR2INT, i.ir2sub as IR2SUB, i.ir2sfa as IR2SFA FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit AND IR2SUB='P' AND IR2INT=' ' order by ir2his";
        //Este deberia funcionar
        //String sqlString = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, i.ir2hop as IR2HOP, i.ir2int as IR2INT, i.ir2sub as IR2SUB, i.ir2sfa as IR2SFA FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2CIT=:ir2cit order by ir2his FETCH FIRST 20 ROWS ONLY";
        //String sqlString = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, ir2hop as IR2HOP FROM S101719R.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=:ctidpk WHERE IR2UNM=:ir2unm AND IR2DEP=:ir2dep AND IR2CIT=:ir2cit order by ir2his FETCH FIRST 20 ROWS ONLY";
        Map<String, Object> params = new HashMap<>();
        params.put("ctidpk", ctidpk);
        params.put("ir2unm", ir2unm);
        params.put("ir2dep", ir2dep);
        params.put("ir2cit", ir2cit);
        List<InformacionB> informacionBList = queryExecutor.executeQuery(sqlString, params, InformacionB.class);

        return informacionBList;
    }

    @Override
    public void procesarDependenciasUnaAUna(int nivel, String iounme, int ioxdat, List<Dependencia> listaDependencia, Integer unimedpk, Integer ubicapk) {

        utx = ctx.getUserTransaction();
        // Hacer una lista para moverse dependencia a dependencia y empesar el procesamiento...
        double dependeciaObtenida = 0.0;
        //int dependenciaObtenidaInt = 0;
        //instancio BigInteger
        BigInteger dependenciaObtenidaBi = new BigInteger("0");

        String fechaSt = Integer.toString(ioxdat);
        String mesSt = fechaSt.substring(4, 6);
        String diaSt = fechaSt.substring(6, 8);
        String anioSt = fechaSt.substring(0, 4);

        Integer mesI = Integer.parseInt(mesSt);
        Integer diaI = Integer.parseInt(diaSt);
        int anioI = Integer.parseInt(anioSt);

        existenciaCabecera(mesI, diaI, anioI, unimedpk, ubicapk);
        int i = 0;

        for (Dependencia dependencia : listaDependencia) {
            dependeciaObtenida = listaDependencia.get(i).getIR2DEP();
            //dependenciaObtenidaInt = (int)dependeciaObtenida;
            BigDecimal dependeciaObtenidaBd = BigDecimal.valueOf(listaDependencia.get(i).getIR2DEP());
            dependenciaObtenidaBi = dependeciaObtenidaBd.toBigInteger();

            //Obtener la lista de Historias Clinicas de ese departamento...
            List<InformacionHC> listaHC;
            listaHC = obtenerHistoriasClinicasPacientePorDependencia(nivel, iounme, dependenciaObtenidaBi, ioxdat);

            //Obtener la lista de registros de un paciente..
            List<InformacionB> listaHCTotalDependencia;
            listaHCTotalDependencia = obtenerTodosLosRegistrosPacienteDeUnaDependencia(nivel, iounme, dependenciaObtenidaBi, ioxdat);

            double historiaClinica = 0.0;
            
            for (InformacionHC informacionHC : listaHC) {
                historiaClinica = informacionHC.getIR2HIS();                
                obtenerRegistroDeUnPacientePorHistoriaClinica(nivel, iounme, dependenciaObtenidaBi, ioxdat, historiaClinica, listaHCTotalDependencia);
                
            }
            i++;
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

        //procesarRegistrosPorPaciente(tasks, tasksT, ctidpk, irunm, irdep, ircit);
    }

    public void procesarRegistrosPorPaciente(List<InformacionHC> listaHistoriasClinicas, List<InformacionB> listaHistoriasClinicasT, int ctidpk, String ir2unm, BigInteger ir2dep, int ir2cit) {

        //CODIGO JORGE       
        //Declaro una lista para poder ir guardando la informacion de cada paciente y mandar a procesar.
        double historiaClinica = 0.0;
        
        for (InformacionHC informacionHC : listaHistoriasClinicas) {
            historiaClinica = informacionHC.getIR2HIS();            
            obtenerRegistroDeUnPacientePorHistoriaClinica(ctidpk, ir2unm, ir2dep, ir2cit, historiaClinica, listaHistoriasClinicasT);
        }

    }

    @Override
    public void obtenerRegistroDeUnPacientePorHistoriaClinica(int ctidpk, String ir2unm, BigInteger ir2dep, int ir2cit, double ir2his, List<InformacionB> tasksT) {

        List<InformacionB> listaSalida = new ArrayList<>();

        int historiaClinicaActual = (int) ir2his;

        InformacionB objeto = new InformacionB();
       
        int banderaContador = 0;
        for (InformacionB listaB2 : tasksT) {

            String ir2subVard = listaB2.getIR2SUB();
            String ir2intVard = listaB2.getIR2INT();
            if ("P".equals(listaB2.getIR2SUB()) && "".equals(listaB2.getIR2INT()))//al parecer este es el problema
            {
                if (ir2his == listaB2.getIR2HIS()) {
                    listaSalida.add(listaB2);
                    banderaContador = banderaContador + 1;
                }
            } else if ("P".equals(listaB2.getIR2SUB()) && "V".equals(listaB2.getIR2INT())) {
                if (ir2his == listaB2.getIR2HIS()) {
                    listaSalida.add(listaB2);
                    banderaContador = banderaContador + 1;
                }
            } else if ("S".equals(listaB2.getIR2SUB()) && "".equals(listaB2.getIR2INT())) //al parecer es el problema
            {
                if (ir2his == listaB2.getIR2HIS()) {
                    listaSalida.add(listaB2);
                    banderaContador = banderaContador + 1;
                }
            } else if ("S".equals(listaB2.getIR2SUB()) && "V".equals(listaB2.getIR2INT())) {
                if (ir2his == listaB2.getIR2HIS()) {
                    listaSalida.add(listaB2);
                    banderaContador = banderaContador + 1;
                }
            }
            
        }
        aplicarRegla(listaSalida, ir2unm, ir2dep, ir2cit);

    }

    @Override
    public void aplicarRegla(List<InformacionB> listaB, String ir2unm, BigInteger ir2dep, int ir2cit) {

        if (!listaB.isEmpty()) {
            Double mayor = listaB.get(0).getTAVALOR();
            InformacionB objeto = new InformacionB();
            for (InformacionB listaB1 : listaB) {
                if (listaB1.getTAVALOR() >= mayor) {
                    mayor = listaB1.getTAVALOR();
                    objeto = listaB1;
                }
            }
          
            if (objeto.getIR2HOP() <= 600 || objeto.getIR2HOP() >= 2200) {
                objeto.setTAVALOR(objeto.getTAVALOR() * 1.1);
                
            }
            
            registrarDetallePlanillaje(objeto, ir2unm, ir2dep, ir2cit);
        }
    }

    @Override
    public void registrarDetallePlanillaje(InformacionB objeto, String ir2unm, BigInteger ir2dep, int ir2cit) {

        int banderaEntradaEjecucion = 1;
        if (banderaEntradaEjecucion == 0) {
            String queryString = "SELECT A.IRMDP1 as diag1, A.IRMDP2 as diag2, A.IRMDP3 as diag3, "
                    + "A.IRMDD1 as diag4, A.IRMDD2 as diag5, A.IRMDD3 as diag6, 'PRESUNTIVO' as tipodiag1, "
                    + "'PRESUNTIVO' as tipodiag2, 'PRESUNTIVO' as tipodiag3, 'DEFINITIVO' as tipodiag4, "
                    + "'DEFINITIVO' as tipodiag5, 'DEFINITIVO' as tipodiag6, A.IRMCOD as codmedico, "
                    + "B.IMMNOM as nommedico FROM CEDDTA.IRME01 A LEFT JOIN CEDDTA.IMME01 B ON A.IRMUNM = B.IMMUNM AND "
                    + "A.IRMCOD = B.IMMCOD WHERE A.IRMUNM =:ir2unm AND A.IRMHIS =:irmhis AND "
                    + "A.IRMCIT =:ir2cit AND A.IRMHOP =:irmhop";

            Map<String, Object> paramsDatosMedicos = new HashMap();
            paramsDatosMedicos.put("irmhis", objeto.getIR2HIS());
            paramsDatosMedicos.put("irmhop", objeto.getIR2HOP());
            paramsDatosMedicos.put("ir2unm", ir2unm);
            paramsDatosMedicos.put("ir2cit", ir2cit);
            
            List<DatosMedico> datosMedico = queryExecutor.executeQuery(queryString, paramsDatosMedicos, DatosMedico.class
            );
            
            String queryPaciente = "SELECT COALESCE(B.IACNOM, A.IAFNOM) as NOMBREAFILIADO, "
                    + "COALESCE(B.IACCED, A.IAFCED) as CEDULAAFILIADO, CASE WHEN A.IAFCRE = '  ' "
                    + "THEN 'MA' ELSE A.IAFCRE END PARENTESCO, "
                    + "TIMESTAMPDIFF ( 256 , CHAR ( CURRENT TIMESTAMP - TO_DATE ( CHAR ( A.IAFFNA ) , 'YYYYMMDD' ) ) ) as EDADPACIENTE, "
                    + "A.IAFSEX as GENEROPACIENTE, A.IAFFNA as FECNACIMIENTO, A.IAFNOM as NOMBREPACIENTE, "
                    + "A.IAFCED as CEDULAPACIENTE, CASE WHEN A.IAFCRE ='  ' THEN 'MA' ELSE A.IAFCRE END as RELACIONFAMILIAR "
                    + "FROM CEDDTA.IAFI01 A LEFT JOIN CEDDTA.IAFI03 B ON  A.IAFCED=B.IACCED WHERE A.IAFUNM =:ir2unm AND "
                    + "A.IAFHIS =:irhis";

            Map<String, Object> paramsDatosPaciente = new HashMap();

            paramsDatosPaciente.put(
                    "irhis", objeto.getIR2HIS());
            paramsDatosPaciente.put(
                    "ir2unm", ir2unm);

            List<DatosPaciente> datosPaciente = queryExecutor.executeQuery(queryPaciente, paramsDatosPaciente, DatosPaciente.class);

            Detplantbl detalle = new Detplantbl();
            //Datos Cabecera        
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            //Consultar datos cliente
            //Detplantbl detalle = new Detplantbl();
            String fechaSt = Integer.toString(ir2cit);
            String mesSt = fechaSt.substring(4, 6);
            String diaSt = fechaSt.substring(6, 8);
            String anioSt = fechaSt.substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            int anioI = Integer.parseInt(anioSt);

            Calendar c1 = Calendar.getInstance();

            //Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
            detalle.setReidpk(1);
            detalle.setNumplad(cab.getNumplanilla());
            detalle.setCoditem(objeto.getIR2ITE());

            int historiaClinicai = (int) objeto.getIR2HIS();
            detalle.setHistoCli(String.valueOf(historiaClinicai));
            // detalle.setHistoCli(String.valueOf(objeto.getIR2HIS()));
            detalle.setFechaReg(c1.getTime());

            //descripcion
            detalle.setDescItem("Honorarios Medicos Hospitalizacion y Emergencia"); //con el codigo del tarifario descripcion
            String nombreDependenciaRealiza = NombreDependenciaSQL(ir2dep);
            detalle.setDepRea(nombreDependenciaRealiza); //buscar por código de dependencia, preguntar en que talla hallar el nombre

            //BigInteger codepsolbi = BigInteger.valueOf(ir2dep);
            detalle.setCoddepsol(ir2dep);
            detalle.setCoddeprea(ir2dep); //ver esta campo
            detalle.setTipSer(2);  //ver este campo
            detalle.setSubtipser(1);
            detalle.setCantidad(1);
            detalle.setValorUnit(objeto.getTAVALOR()); //ver este campo
            detalle.setValorTotal(objeto.getTAVALOR());
            detalle.setNumOrden(1); //ver este campo
            detalle.setTipoRubro("AMB");
            detalle.setCodMedico(datosMedico.get(0).getCODMEDICO());
            detalle.setNomMedico(datosMedico.get(0).getNOMMEDICO());
            detalle.setDiagnostico1(datosMedico.get(0).getDIAG1());
            detalle.setDiagnostico2(datosMedico.get(0).getDIAG2());
            detalle.setDiagnostico3(datosMedico.get(0).getDIAG3());
            detalle.setDiagnostico4(datosMedico.get(0).getDIAG4());
            detalle.setDiagnostico5(datosMedico.get(0).getDIAG5());
            detalle.setDiagnostico6(datosMedico.get(0).getDIAG6());
            detalle.setTipoDiag1(datosMedico.get(0).getTIPODIAG1().charAt(0));
            detalle.setTipoDiag2(datosMedico.get(0).getTIPODIAG2().charAt(0));
            detalle.setTipoDiag3(datosMedico.get(0).getTIPODIAG3().charAt(0));
            detalle.setTipoDiag4(datosMedico.get(0).getTIPODIAG4().charAt(0));
            detalle.setTipoDiag5(datosMedico.get(0).getTIPODIAG5().charAt(0));
            detalle.setTipoDiag6(datosMedico.get(0).getTIPODIAG6().charAt(0));

            detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en honorarios
            detalle.setCodDerivacion("CD"); //ver este campo
            detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
            detalle.setContingenCubre(0);

            detalle.setNombreAfiliado(datosPaciente.get(0).getNOMBREAFILIADO());
            detalle.setCedulaAfiliado(datosPaciente.get(0).getCEDULAAFILIADO());
            detalle.setParentesco(datosPaciente.get(0).getPARENTESCO());
            detalle.setCedulaBeneficia(datosPaciente.get(0).getCEDULAPACIENTE());
            detalle.setNombreBeneficia(datosPaciente.get(0).getNOMBREPACIENTE());
            detalle.setTipoBeneficia(datosPaciente.get(0).getTIPOBENEFICIARIO()); //ver este campo

            //Para sacar la fecha de nacimiento se ejecuta lo siguiente
            String fechaNa = datosPaciente.get(0).getFECNACIMIENTO();
            String mesNa = fechaNa.substring(4, 6);
            String diaNa = fechaNa.substring(6, 8);
            String anioNa = fechaNa.substring(0, 4);

            String fechaNac = anioNa + "-" + mesNa + "-" + diaNa;

            detalle.setFecNacBenef(Date.valueOf(fechaNac)); //ver este campo
            detalle.setEdadBenefic(datosPaciente.get(0).getEDADPACIENTE());
            detalle.setGeneroBenef(datosPaciente.get(0).getGENEROPACIENTE().charAt(0));
            detalle.setDuracionAtencion(0); //ver este campo
            detalle.setEstado('A');

            cab.setDetplantblList(null);
            detalle.setCpidpk(cab);
        
            listaDetalles.add(detalle);
            registrarPorBloque(listaDetalles);

        }

        if (banderaEntradaEjecucion == 1) {

            Detplantbl detalle = new Detplantbl();
            //Datos Cabecera        
            Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");

            Map<String, Object> paramsDatosMedicos = new HashMap();

            paramsDatosMedicos.put("irmhis", objeto.getIR2HIS());
            paramsDatosMedicos.put("irmhop", objeto.getIR2HOP());
            paramsDatosMedicos.put("ir2unm", ir2unm);
            paramsDatosMedicos.put("ir2cit", ir2cit);

            List<DatosMedico> datosMedico = new ArrayList<>();

            Map<String, Object> paramsDatosPaciente = new HashMap();

            paramsDatosPaciente.put("irhis", objeto.getIR2HIS());
            paramsDatosPaciente.put("ir2unm", ir2unm);

            List<DatosPaciente> datosPaciente = new ArrayList<>();
            //Consultar datos cliente
            //Detplantbl detalle = new Detplantbl();

            String fechaSt = Integer.toString(ir2cit);
            String mesSt = fechaSt.substring(4, 6);
            String diaSt = fechaSt.substring(6, 8);
            String anioSt = fechaSt.substring(0, 4);

            Integer mesI = Integer.parseInt(mesSt);
            Integer diaI = Integer.parseInt(diaSt);
            int anioI = Integer.parseInt(anioSt);

            Calendar c1 = Calendar.getInstance();

            //Cabplantbl cab = (Cabplantbl) bag.get("cabplantbl");
            detalle.setReidpk(1);
            detalle.setNumplad(cab.getNumplanilla());
            detalle.setCoditem(objeto.getIR2ITE());

            int historiaClinicai = (int) objeto.getIR2HIS();
            detalle.setHistoCli(String.valueOf(historiaClinicai));
            // detalle.setHistoCli(String.valueOf(objeto.getIR2HIS()));

            detalle.setFechaReg(c1.getTime());

            //descripcion
            //detalle.setDescItem("Honorarios Medicos Hospitalizacion y Emergencia"); //con el codigo del tarifario descripcion
            detalle.setDescItem(objeto.getDescripcion());
            //objeto.get
            String nombreDependenciaRealiza = NombreDependenciaSQL(ir2dep);
            detalle.setDepRea(nombreDependenciaRealiza); //buscar por código de dependencia, preguntar en que talla hallar el nombre
            //objeto.get
            //BigInteger codepsolbi = BigInteger.valueOf(ir2dep);

            detalle.setCoddepsol(ir2dep);
            detalle.setCoddeprea(ir2dep); //ver esta campo
            detalle.setTipSer(99);  //ver este campo
            //va el 99 cuando los honorarios no tiene tipo de servicio que esta asociados a una orden aqui va 99
            detalle.setSubtipser(8);
            //hay que ir a buscar hacer una tabla
            detalle.setCantidad(1);
            detalle.setValorUnit(objeto.getTAVALOR()); //ver este campo
            detalle.setValorTotal(objeto.getTAVALOR());
            detalle.setNumOrden(1); //ver este campo
            detalle.setTipoRubro("HON");

            double codigoMedicod = objeto.getIR2COM();
            int codigoMedicoi = (int) codigoMedicod;

            detalle.setCodMedico(codigoMedicoi); // se podria traer en el primer select // cambio numero 2
            detalle.setNomMedico(" ");
            detalle.setDiagnostico1("E");
            detalle.setDiagnostico2(" ");
            detalle.setDiagnostico3(" ");
            detalle.setDiagnostico4(" ");
            detalle.setDiagnostico5(" ");
            detalle.setDiagnostico6(" ");
            detalle.setTipoDiag1('A');
            detalle.setTipoDiag2(' ');
            detalle.setTipoDiag3(' ');
            detalle.setTipoDiag4(' ');
            detalle.setTipoDiag5(' ');
            detalle.setTipoDiag6(' ');

            detalle.setTimeAntestesia(Short.parseShort("0"));  //no aplica anestencia en honorarios
            detalle.setCodDerivacion("CD"); //ver este campo
            detalle.setSecDerivacion(Short.parseShort("0")); //ver este campo
            detalle.setContingenCubre(0);

            detalle.setNombreAfiliado("Usuario 1");
            detalle.setCedulaAfiliado(" ");
            detalle.setParentesco(" ");
            detalle.setCedulaBeneficia(" ");
            detalle.setNombreBeneficia(" ");
            detalle.setTipoBeneficia(" "); //ver este campo

            //Para sacar la fecha de nacimiento se ejecuta lo siguiente
            String fechaNa; //datosPaciente.get(0).getFECNACIMIENTO();
            String mesNa = "11";
            String diaNa = "11";//fechaNa.substring(6, 8);
            String anioNa = "1985";//fechaNa.substring(0, 4);

            String fechaNac = anioNa + "-" + mesNa + "-" + diaNa;

            detalle.setFecNacBenef(Date.valueOf(fechaNac)); //ver este campo
            detalle.setEdadBenefic(29);
            detalle.setGeneroBenef('B');
            detalle.setDuracionAtencion(0); //ver este campo
            detalle.setEstado('A');

            cab.setDetplantblList(null);
            detalle.setCpidpk(cab);

            listaDetalles.add(detalle);
            registrarPorBloque(listaDetalles);
        }

    }

}

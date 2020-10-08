package ec.hcam.orquestrator;

import ec.hcam.data.ServiciosInstitucionales;
import ec.hcam.data.Temp;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
public class ServiciosInstitucionalesService extends Basica implements ServiciosInstitucionalesRemote {

    @Override
    @Asynchronous
    public Future obtenerRegistrosServiciosInstitucionales(String unidMedica, Integer fecha1, Integer nivel, Integer unidpk, Integer ubicapk) {

        utx = ctx.getUserTransaction();
        String fecha = fecha1.toString();

        System.out.println("Hora Inicio Servicios Institucionales:" + imprimirHora().toString());

        String strMes = fecha.substring(4, 6);
        String strDia = fecha.substring(6, 8);
        String strAnio = fecha.substring(0, 4);

        Integer intMes = Integer.parseInt(strMes);
        Integer intDia = Integer.parseInt(strDia);
        Integer intAnio = Integer.parseInt(strAnio);

        existenciaCabecera(intMes, intDia, intAnio, unidpk, ubicapk);

        //Dependencias 
        List<Temp> lstDependencias = obtenerDependencias(unidMedica, fecha);

        for (Temp depend : lstDependencias) {

            //Historias Clinicas 
            List<Temp> lstHistorias = obtenerHistoricasClinicas(unidMedica, fecha, String.valueOf(depend.getTemp()));

            for (Temp lstHistoria : lstHistorias) {

                try { //Aplicación de regla a registros de cada paciente
                    aplicarRegla(lstHistoria.getTemp(), (int) depend.getTemp(), unidMedica, fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(ServiciosInstitucionalesService.class.getName()).log(Level.SEVERE, null, ex);
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

        System.out.println("Hora Fin Servicios Institucionales:" + imprimirHora().toString());
        return new AsyncResult("OK");
    }

    private List<ServiciosInstitucionales> obtenerRegistrosPACF09(double historiaClinica, int dependencia, String unidadMedica, String fecha) {

//        System.out.println("EN METODO OBTENERREGISTROSPACF09. Registros que entran: ");
//        System.out.println("historia: " + historiaClinica + " dependencia " + dependencia + " unidadMedica " + unidadMedica + " fecha " + fecha);
        String sqlEquipos
                = "SELECT  A.H9UNME as unidadMedica, A.H9NUHI as historiaClinica, A.H9FEIN as fechaIngreso, "
                + "A.H9HOIN as horaIngreso, "
                + "A.H9DEIN as dependenciaIngreso, A.H9FEAL  as fechaAlta, A.H9HOAL as horaAlta, A.H9DEAL as dependenciaAlta, "
                + "A.H9MOAL as motivoAlta, A.H9FEAE as fechaAlta, A.H9HOAE as horaAltaEnf,  A.H9DEAE as dependenciaAltaEnf, "
                + "A.H9FIL5 as honorario "
                + "FROM PACLIBME.PACF09 A "
                + "WHERE H9UNME=:unidadMedica and "
                + "      coalesce(case when A.H9FEAL=0 then '99999999' end,A. H9FEAL) >=:fecha "
                + "AND "
                + "A.H9NUHI =:historiaClinica "
                + "AND A.H9DEIN =:dependencia "
                + "order by A.H9FEIN ";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("historiaClinica", historiaClinica);
        params.put("dependencia", dependencia);
        List<ServiciosInstitucionales> lstRegistros = queryExecutor.executeQuery(sqlEquipos, params, ServiciosInstitucionales.class);

        return lstRegistros;

    }

    //private List<ServiciosInstitucionales> obtenerRegistrosPACF03(double historiaClinica, int dependencia, String unidadMedica, String fecha) {
    private List<ServiciosInstitucionales> obtenerRegistrosPACF03(double historiaClinica, String unidadMedica, String fecha) {

        String sqlRegistrosPACF03
                = "SELECT  COALESCE(B.PCUNME,'0') AS unidadMedica, COALESCE(B.PCNUHI, '0') AS historiaClinica, "
                + "        COALESCE(B.PCFEIN,'0') AS fechaIngreso, COALESCE(B.PCHOIN,'0') AS horaIngreso, "
                + "        ' ' AS fechaAlta,  ' ' as horaAlta, ' ' AS motivoAlta, "
                + "        COALESCE(B.PCSVAC ,'0') AS  dependenciaAlta, COALESCE(D.HBMAXC, '99') as totalCamas, "
                + "        COALESCE(B.PCDIAG,' ') AS diagnostico1, '' AS  diagnostico2, ' '  AS  diagnostico3 "
                + "FROM    PACLIBME.PACF03 B LEFT JOIN PACLIBME.PACF01 D ON D.HBUNME =B.PCUNME AND D.HBCODI=B.PCHBAC "
                + "WHERE   B.PCUNME=:unidadMedica and B.PCFEIN<=:fecha  AND "
                + "        B.PCNUHI=:historiaClinica";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("historiaClinica", historiaClinica);
        //params.put("dependencia", dependencia);        
        List<ServiciosInstitucionales> lstRegistros = queryExecutor.executeQuery(sqlRegistrosPACF03, params, ServiciosInstitucionales.class);
        return lstRegistros;
    }

    private List<ServiciosInstitucionales> obtenerRegistrosPACF04(double historiaClinica, String unidadMedica, String fecha) {

        String sqlRegistrosPACF04
                = "select  COALESCE(C.HIUNME ,'0') AS unidadMedica, COALESCE(C.HINUHI ,'0') AS  historiaClinica, "
                + "        COALESCE(C.HIFEIN ,'0') AS fechaIngreso, COALESCE(C.HIHOIN ,'0')  AS  horaIngreso,  "
                + "        COALESCE(C.HIFEAL ,'0') AS fechaAlta,    COALESCE(C.HIHOAL ,'0') AS  horaAlta, "
                + "        COALESCE(C.HIMOAL ,' ') AS motivoAlta,   COALESCE(C.HISVAC ,'0') AS  dependenciaAlta, "
                + "        COALESCE(E.HBMAXC, '99') AS totalCamas,  COALESCE(C.HIDIAG ,' ') AS  diagnostico1, "
                + "        COALESCE(C.HIDIA2 ,' ') AS  diagnostico2, COALESCE(C.HIDIA3 ,' ') AS  diagnostico3 "
                + "FROM    PACLIBME.PACF04 as C LEFT JOIN PACLIBME.PACF01 E ON E.HBUNME =C.hiUNME AND E.HBCODI=C.hiHBAC "
                + "WHERE   C.HIUNME=:unidadMedica and C.HIFEAL>=:fecha "
                + "        and C.HINUHI=:historiaClinica "
                + "        ORDER BY C.HIFEIN";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("historiaClinica", historiaClinica);
        List<ServiciosInstitucionales> lstRegistros = queryExecutor.executeQuery(sqlRegistrosPACF04, params, ServiciosInstitucionales.class);
        return lstRegistros;
    }

    //TODO: Verificar que se encuentre bien el query    
    private List<Temp> obtenerDependencias(String unidadMedica, String fecha) {

        String sqlDependencias = "SELECT A.H9DEIN AS temp "
                + "FROM PACLIBME.PACF09 A "
                + "WHERE H9UNME=:unidadMedica  and coalesce(case when A.H9FEAL=0 then '99999999' end, A. H9FEAL) >=:fecha  "
                + "group by A.H9DEIN ";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        List<Temp> lstDependencias = queryExecutor.executeQuery(sqlDependencias, params, Temp.class);

        return lstDependencias;

    }

    private List<Temp> obtenerHistoricasClinicas(String unidadMedica, String fecha, String dependencia) {
        //private List<Temp> obtenerHistoricasClinicas(String unidadMedica, String fecha) {

        String sqlHistorias = "SELECT A.H9NUHI AS temp "
                + "FROM PACLIBME.PACF09 A "
                + "WHERE H9UNME=:unidadMedica  and coalesce(case when A.H9FEAL=0 then '99999999' end,A. H9FEAL) >=:fecha "
                + "AND A.H9DEIN=:dependencia "
                + "group by A.H9NUHI ";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidadMedica);
        params.put("fecha", fecha);
        params.put("dependencia", dependencia);
        List<Temp> lstHistorias = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);

        return lstHistorias;

    }

    private List<Temp> valorDependenciasEspeciales(String dependencia, String unidadMedica) {

        String sqlHistorias = "SELECT T.TADESCRIPC AS descripcion, T.TACODIGO as codigo, T.TAVALOR as temp "
                + "FROM FACWEB.TARIFAFTBL T "
                + "WHERE T.TACODIGO = (SELECT TBL1.PACODTAR as intTemp "
                + "                    FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                    WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "                            TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                            TBL1.PANIDH=6 AND "
                + "                            TBL1.PADET1=:dependencia AND "
                + "                            TBL2.CTIDPK = ( SELECT  CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CABTARITBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK )"
                + "                             FETCH FIRST 1 ROWS ONLY"
                + "                             ) and "
                + "      T.CTIDPK = (SELECT TBL2.CTIDPK as intTemp "
                + "                    FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                    WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "                            TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                            TBL1.PANIDH=6 AND "
                + "                            TBL1.PADET1=:dependencia AND "
                + "                            TBL2.CTIDPK = ( SELECT  CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CABTARITBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK )"
                + "                             FETCH FIRST 1 ROWS ONLY)";

        Map<String, Object> params = new HashMap<>();
        params.put("dependencia", dependencia);
        params.put("unidadMedica", unidadMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros;

    }

    private boolean dependenciaEspecial(String dependencia, String unidadMedica) {

        String sqlHistorias = "SELECT TBL1.PADET1 as intTemp "
                + "FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "        TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "        TBL1.PANIDH=6 AND "
                + "        TBL1.PADET1=:dependencia AND "
                + "        TBL2.CTIDPK = ( SELECT  CAB.CTIDPK  "
                + "                        FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                        WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                U1.UNIDPK = U2.UNIDPK AND "
                + "                                U1.UBICAPK = U2.UBICAPK AND "
                + "                                U2.CTIDPK = CAB.CTIDPK"
                + "                                FETCH FIRST 1 ROW ONLY)";

        Map<String, Object> params = new HashMap<>();
        params.put("dependencia", dependencia);
        params.put("unidadMedica", unidadMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        boolean existe = false;

        if (!lstRegistros.isEmpty()) {
            existe = true;
            //System.out.println("Dependencia especial.!! ");
        } else {
            //System.out.println("Dependencia NO especial.!! ");
        }

        return existe;
    }

    private List<Temp> valorDietaHospitalaria(String unidadMedica) {

//        System.out.println("METODO valorDietaHospitalaria(). Metodos que entran: ");
//        System.out.println("unidadMedica: " + unidadMedica);
        List<Temp> lstRetorno = new ArrayList<>();
        List<Temp> lstTarifario = obtenerCodigoYNivelParaDietaHospitalaria(unidadMedica);
        for (Temp objTarifario : lstTarifario) {

            String sqlValores
                    = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC AS descripcion, T.TACODIGO as codigo "
                    + "FROM    FACWEB.TARIFAFTBL T "
                    + "WHERE   T.CTIDPK=:nivel AND "
                    + "        T.TACODIGO=:codigo";

            Map<String, Object> params = new HashMap<>();
            params.put("nivel", objTarifario.getNivel());
            params.put("codigo", objTarifario.getCodigo());
            List<Temp> lstRegistros = queryExecutor.executeQuery(sqlValores, params, Temp.class);

            lstRetorno.add(lstRegistros.get(0));
        }
        return lstRetorno;
    }

    private List<Temp> obtenerCodigoYNivelParaDietaHospitalaria(String unidMedica) {

//        System.out.println("METODO valorDietaHospitalaria(). Metodos que entran: ");
//        System.out.println("unidadMedica: " + unidMedica);
        String sqlCodigosComidas
                = "SELECT TBL1.PACODTAR as codigo, TBL2.CTIDPK as nivel "
                + "FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "        TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "        TBL1.PANIDH=3 AND "
                + "        TBL1.PADESCRI != 'REFRIGERIO' AND " //Por ahora no se esta cobrando refrigerio
                + "        TBL2.CTIDPK = (SELECT  CAB.CTIDPK "
                + "                       FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                       WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                               U1.UNIDPK = U2.UNIDPK AND "
                + "                               U1.UBICAPK = U2.UBICAPK AND "
                + "                               U2.CTIDPK = CAB.CTIDPK "
                + "                               FETCH FIRST 1 ROWS ONLY)";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlCodigosComidas, params, Temp.class);
        return lstRegistros;
    }

    private List<Temp> valorHospitalDelDia(String unidMedica) {

        String sqlHistorias = "SELECT T.TADESCRIPC AS descripcion, T.TACODIGO as codigo, T.TAVALOR as temp FROM FACWEB.TARIFAFTBL T WHERE T.TACODIGO = (SELECT TBL1.PACODTAR FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 WHERE TBL1.PANIDH = TBL2.PANIDH AND TBL1.PANIDPK = TBL2.PANIDPK AND TBL1.PANIDH=119 AND TBL2.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK FROM FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB WHERE U1.UNCODIGO =:unidadMedica AND U1.UNIDPK = U2.UNIDPK AND U1.UBICAPK = U2.UBICAPK AND U2.CTIDPK = CAB.CTIDPK )) and T.CTIDPK = (SELECT TBL2.CTIDPK FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 WHERE TBL1.PANIDH = TBL2.PANIDH AND TBL1.PANIDPK = TBL2.PANIDPK AND TBL1.PANIDH=119 AND TBL2.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK FROM FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB WHERE U1.UNCODIGO =:unidadMedica AND U1.UNIDPK = U2.UNIDPK AND U1.UBICAPK = U2.UBICAPK AND U2.CTIDPK = CAB.CTIDPK ))";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros;

    }

    private List<Temp> valorCuidadoManejoDiario(String unidMedica) {

//        System.out.println("METODO cuidadoManejodiario(). Metodos que entran: ");
//        System.out.println("unidadMedica: " + unidMedica);
        String sqlHistorias = "SELECT  T.TAVALOR AS temp, T.TADESCRIPC AS descripcion, T.TACODIGO as codigo "
                + "FROM    FACWEB.TARIFAFTBL T "
                + "WHERE   T.CTIDPK = ( SELECT TBL2.CTIDPK"
                + "                     FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                     WHERE TBL1.PANIDH = 2 AND "
                + "                     TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                     TBL1.PANIDH = TBL2.PANIDH AND "
                + "                     TBL2.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK "
                + "                                                    FETCH FIRST 1 ROWS ONLY )) and "
                + "        T.TACODIGO = ( SELECT  TBL1.PACODTAR"
                + "                     FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                     WHERE TBL1.PANIDH = 2 AND "
                + "                     TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                     TBL1.PANIDH = TBL2.PANIDH AND "
                + "                     TBL2.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK "
                + "                                                    FETCH FIRST 1 ROWS ONLY))";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidMedica);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros;

    }

    private List<Temp> valorHabitacion(String unidMedica, int numeroCamas) {

//        System.out.println("METODO valorHabitacion(). Metodos que entran: ");
//        System.out.println("unidadMedica: " + unidMedica);
        if (numeroCamas > 4) {
            numeroCamas = 4;
        }

        String sqlHistorias = "SELECT T.TADESCRIPC AS descripcion, T.TACODIGO as codigo, T.TAVALOR as temp "
                + "FROM FACWEB.TARIFAFTBL T "
                + "WHERE T.TACODIGO = (SELECT TBL1.PACODTAR "
                + "                    FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                    WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "                            TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                            TBL1.PANIDH=1 AND "
                + "                            TBL1.PADET1=:numeroCamas AND"
                + "                            TBL2.CTIDPK = ( SELECT DISTINCT CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB "
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK "
                + "                                                    FETCH FIRST 1 ROWS ONLY )) and "
                + "      T.CTIDPK = (SELECT TBL2.CTIDPK "
                + "                    FROM FACWEB.PARANIVETBL TBL1, FACWEB.PANICODTBL TBL2 "
                + "                    WHERE   TBL1.PANIDH = TBL2.PANIDH AND "
                + "                            TBL1.PANIDPK = TBL2.PANIDPK AND "
                + "                            TBL1.PANIDH=1 AND "
                + "                            TBL1.PADET1=:numeroCamas AND"
                + "                            TBL2.CTIDPK = ( SELECT  DISTINCT CAB.CTIDPK  "
                + "                                            FROM    FACWEB.UNIDMEDTBL U1, FACWEB.CT_UMTBL U2, FACWEB.CT_UMTBL CAB \n"
                + "                                            WHERE   U1.UNCODIGO =:unidadMedica AND "
                + "                                                    U1.UNIDPK = U2.UNIDPK AND "
                + "                                                    U1.UBICAPK = U2.UBICAPK AND "
                + "                                                    U2.CTIDPK = CAB.CTIDPK "
                + "                                                    FETCH FIRST 1 ROWS ONLY))";

        Map<String, Object> params = new HashMap<>();
        params.put("unidadMedica", unidMedica);
        params.put("numeroCamas", numeroCamas);
        List<Temp> lstRegistros = queryExecutor.executeQuery(sqlHistorias, params, Temp.class);
        return lstRegistros;

    }

    private boolean comprobarRangoFechas(String fecha, ServiciosInstitucionales registroPACF09) throws ParseException {

        boolean flag = false;

        if (registroPACF09.getFechaAlta() != 0) {

            SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");

            //Fecha de registro
            Date fechaRegistro = objSimpleDateFormat.parse(fecha);

            //Fecha de ingreso            
            Date fechaIngreso = objSimpleDateFormat.parse(String.valueOf(registroPACF09.getFechaIngreso()));

            //Fecha de alta            
            Date fechaAlta1 = objSimpleDateFormat.parse(String.valueOf(registroPACF09.getFechaAlta()));
            //System.out.println("Fecha alta 1 " + fechaAlta1);

            Calendar c = Calendar.getInstance();
            c.setTime(fechaAlta1);
            c.add(Calendar.DAY_OF_MONTH, -1);

            //c.add(Calendar.DATE, -1);
//            System.out.println("Fecha alta " + c.getTime());
//            System.out.println("Fecha Ingreso " + fechaIngreso);
//            System.out.println("Fecha Registro" + fechaRegistro);
            Date fechaAlta = c.getTime();

            if ((fechaRegistro.after(fechaIngreso) || fechaRegistro.equals(fechaIngreso)) && (fechaRegistro.before(fechaAlta) || fechaRegistro.equals(fechaAlta))) { //|| fechaRegistro.equals(fechaAlta)
                flag = true;
            }
        }

        return flag;
    }

    private boolean comprobarRangoFechas1(String fecha, ServiciosInstitucionales registroPACF09) throws ParseException {

        boolean flag = false;

        System.out.println("fecha que entra al metodo: " + fecha);

        if (registroPACF09.getFechaAlta() != 0) {

            SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");

            //Fecha de registro
            Date fechaRegistro = objSimpleDateFormat.parse(fecha);

            //Fecha de ingreso            
            Date fechaIngreso = objSimpleDateFormat.parse(String.valueOf(registroPACF09.getFechaIngreso()));

            //Fecha de alta            
            Date fechaAlta = objSimpleDateFormat.parse(String.valueOf(registroPACF09.getFechaAlta()));

            if ((fechaRegistro.after(fechaIngreso) || fechaRegistro.equals(fechaIngreso)) && (fechaRegistro.before(fechaAlta) || fechaRegistro.equals(fechaAlta))) { //|| fechaRegistro.equals(fechaAlta)
                flag = true;
            }

//            System.out.println("(fechaRegistro.after(fechaIngreso) )" + (fechaRegistro.after(fechaIngreso)));
//            System.out.println(" fechaRegistro.equals(fechaIngreso))" + (fechaRegistro.equals(fechaIngreso)));

        }
        return flag;
    }

    private boolean comprobarRangoFechasPACF04(String fecha, ServiciosInstitucionales registroPACF09) throws ParseException {

        boolean flag = false;

        if (registroPACF09.getFechaAlta() != 0) {

            SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            //Fecha de registro
            String strMesFecha = fecha.substring(4, 6);
            String strDiaFecha = fecha.substring(6, 8);
            String strAnioFecha = fecha.substring(0, 4);
            java.util.Date fechaRegistro = objSimpleDateFormat.parse(strAnioFecha + "-" + strMesFecha + "-" + strDiaFecha);

            //Fecha de ingreso
            String strMesFechaIngreso = String.valueOf(registroPACF09.getFechaIngreso()).substring(4, 6);
            String strDiaFechaIngreso = String.valueOf(registroPACF09.getFechaIngreso()).substring(6, 8);
            String strAnioFechaIngreso = String.valueOf(registroPACF09.getFechaIngreso()).substring(0, 4);
            java.util.Date fechaIngreso = objSimpleDateFormat.parse(strAnioFechaIngreso + "-" + strMesFechaIngreso + "-" + strDiaFechaIngreso);

            //Fecha de alta
            String strMesFechaAlta = String.valueOf(registroPACF09.getFechaAlta()).substring(4, 6);
            String strDiaFechaAlta = String.valueOf(registroPACF09.getFechaAlta()).substring(6, 8);
            String strAnioFechaAlta = String.valueOf(registroPACF09.getFechaAlta()).substring(0, 4);
            java.util.Date fechaAlta = objSimpleDateFormat.parse(strAnioFechaAlta + "-" + strMesFechaAlta + "-" + strDiaFechaAlta);

            if ((fechaRegistro.after(fechaIngreso) || fechaRegistro.equals(fechaIngreso)) && (fechaRegistro.before(fechaAlta) || fechaRegistro.equals(fechaAlta))) { //|| fechaRegistro.equals(fechaAlta)
                flag = true;
            }
        }

        return flag;
    }

    private ServiciosInstitucionales obtenerRegistroPACF04(List<ServiciosInstitucionales> lstRegistrosPACF04, String fecha) throws ParseException {

        //System.out.println("Registros originales: " + lstRegistrosPACF04.size());

        List<ServiciosInstitucionales> lstRegistrosFiltrados = new ArrayList<>();

        for (ServiciosInstitucionales registro : lstRegistrosPACF04) {
            //System.out.println("fecha que entra a al comprobacion de las fechas: " + fecha);
            if (comprobarRangoFechas1(fecha, registro)) {
                lstRegistrosFiltrados.add(registro);
            }
        }

        //System.out.println("Registros filtrados: " + lstRegistrosFiltrados.size());
        ServiciosInstitucionales objRetorno = null;
        if (lstRegistrosFiltrados.size() == 1) {
            objRetorno = lstRegistrosFiltrados.get(0);
//            System.out.println("Registro:" + String.valueOf(1));
//            System.out.println("Dependencia ingreso:" + lstRegistrosFiltrados.get(0).getDependenciaIngreso());
//            System.out.println("Dependencia salida:" + lstRegistrosFiltrados.get(0).getDependenciaAlta());
//            System.out.println("Fecha Ingreso:" + lstRegistrosFiltrados.get(0).getFechaIngreso());
//            System.out.println("Fecha Alta:" + lstRegistrosFiltrados.get(0).getFechaAlta());
        } else {

            int i = 0;
            for (Iterator<ServiciosInstitucionales> iterator = lstRegistrosFiltrados.iterator(); iterator.hasNext();) {
                ServiciosInstitucionales registro = iterator.next();
                
                if (iterator.hasNext()) {
//                    System.out.println("Registro:" + String.valueOf(i + 1));
//                    System.out.println("Dependencia ingreso:" + registro.getDependenciaIngreso());
//                    System.out.println("Dependencia salida:" + registro.getDependenciaAlta());
//                    System.out.println("Fecha Ingreso:" + registro.getFechaIngreso());
//                    System.out.println("Fecha Alta:" + registro.getFechaAlta());

                    if (dependenciaEspecial(String.valueOf(registro.getDependenciaAlta()), String.valueOf(registro.getUnidadMedica()))) {

                        //System.out.println("Dependencia es especial. !");

                        registrarDetallePlanillaje(
                                registro,
                                valorDependenciasEspeciales(String.valueOf(registro.getDependenciaAlta()), String.valueOf(registro.getUnidadMedica())).get(0)
                        );
                    }
                } else {

                    //System.out.println("Ultimo Registro:");
                    objRetorno = registro;
                }

                i++;

            }
        }

        return objRetorno;
    }

    private void aplicarRegla(double historiaClinica, int dependencia, String uniMed, String iofeor) throws ParseException {

        //System.out.println("fecha antes de entrar a pacf09:" + iofeor);
        //System.out.println("Historia clinica: " + historiaClinica + " dependencia: " + dependencia + " unidMedica: " + uniMed + " fecha: " + iofeor);
        List<ServiciosInstitucionales> lstRegistrosPACF09 = obtenerRegistrosPACF09(historiaClinica, dependencia, uniMed, iofeor);

        //System.out.println("PACF09.size()" + lstRegistrosPACF09.size());
        if (!lstRegistrosPACF09.isEmpty()) {

            //.println("Registrospacf09.size():" + lstRegistrosPACF09.size());
            //////////////////////////////////
            // lista de Registros de PACF09 //
            //////////////////////////////////
            int i = 1;

            for (ServiciosInstitucionales registroPACF09 : lstRegistrosPACF09) {

                if (i == 1) {

                    //System.out.println("Primera vez en PACF09");
                    if (comprobarRangoFechas1(iofeor, registroPACF09)) {

                        //System.out.println("Paso la comprobacion de fechas");
                        if (((registroPACF09.getDependenciaAlta() >= 5000) && (registroPACF09.getDependenciaAlta() <= 5999)) && "ALT".equals(registroPACF09.getMotivoAlta())) {

                            //System.out.println("Paso la comprobacion de dependencias >=5000 <= 5999");
                            //////////////////////////////////
                            // Registro tiene dep Especial? //
                            //////////////////////////////////                                        
                            if (dependenciaEspecial(String.valueOf(registroPACF09.getDependenciaAlta()), uniMed)) {

                                //System.out.println("Comprobacion de PACF09. La dependencia es especial.: " + String.valueOf(registroPACF09.getDependenciaAlta()));
                                //////////////////////////////////
                                // Cobro codigo directo de tabla //
                                //////////////////////////////////
                                List<Temp> listaValores = valorDependenciasEspeciales(String.valueOf(registroPACF09.getDependenciaAlta()), uniMed);
                                if (!listaValores.isEmpty()) {
                                    registrarDetallePlanillaje(
                                            registroPACF09,
                                            listaValores.get(0)
                                    );
                                }

                            } else {

                                //System.out.println("PACF09. La dependencia noe s especial. cobro hospital del dia");
                                //////////////////////////////////
                                //     Cobro Hospital del Dia   //
                                //////////////////////////////////
                                List<Temp> valores = valorHospitalDelDia(uniMed);
                                if (!valores.isEmpty()) {
                                    registrarDetallePlanillaje(
                                            registroPACF09,
                                            valores.get(0));
                                }
                            }

                        } else {

                            //////////////////////////////////
                            // lista de Registros de PACF03 //
                            //////////////////////////////////
                            List<ServiciosInstitucionales> lstRegistrosPACF03 = obtenerRegistrosPACF03(historiaClinica, uniMed, iofeor);

                            if (!lstRegistrosPACF03.isEmpty()) {

                                //System.out.println("PACF03.SIZE: " + lstRegistrosPACF03.size());
                                ServiciosInstitucionales objPACF03 = lstRegistrosPACF03.get(0);

                                //////////////////////////////////
                                // Cobro de dieta Hospitalaria. //
                                //////////////////////////////////
                                List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                for (Temp registroDieta : lstDietas) {
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            registroDieta);
                                }

                                if (dependenciaEspecial(String.valueOf(objPACF03.getDependenciaAlta()), uniMed)) {

                                    //System.out.println("PACF03. La dependencia es especial. cobro hospital del dia");
                                    //////////////////////////////////
                                    // Cobro codigo directo de tabla //
                                    ////////////////////////////////// 
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorDependenciasEspeciales(String.valueOf(objPACF03.getDependenciaAlta()), uniMed).get(0)
                                    );

                                } else {

                                    //////////////////////////////////
                                    // Cobro Cuidado y manejo Diario //
                                    //////////////////////////////////                            
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorCuidadoManejoDiario(uniMed).get(0)
                                    );

                                    //////////////////////////////////
                                    //       Cobro habitacion       //
                                    ////////////////////////////////// 
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorHabitacion(uniMed, objPACF03.getTotalCamas()).get(0)
                                    );

                                }

                            } else {

                                //////////////////////////////////
                                // lista de Registros de PACF04 //
                                //////////////////////////////////                                
                                List<ServiciosInstitucionales> lstRegistrosPACF04 = obtenerRegistrosPACF04(historiaClinica, uniMed, iofeor);

                                //System.out.println("PACF04.size()" + lstRegistrosPACF04.size());
                                if (!lstRegistrosPACF04.isEmpty()) {

                                    ServiciosInstitucionales registroPACF04 = obtenerRegistroPACF04(lstRegistrosPACF04, iofeor);

                                    //System.out.println(registroPACF04);
                                    //System.out.println("Despues de obtener registro. unidadMedica: " + uniMed);
                                    //////////////////////////////////
                                    // Registro tiene dep Especial? //
                                    //////////////////////////////////   
                                    if (registroPACF04 != null) {
                                        if (dependenciaEspecial(String.valueOf(registroPACF04.getDependenciaAlta()), uniMed)) {

                                            //System.out.println("PACF04. La dependencia es especial.");

                                            //////////////////////////////////
                                            // Cobro codigo directo de tabla //
                                            ////////////////////////////////// 
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorDependenciasEspeciales(String.valueOf(registroPACF04.getDependenciaAlta()), uniMed).get(0)
                                            );
                                            //////////////////////////////////
                                            // Cobro de dieta Hospitalaria. //
                                            //////////////////////////////////
                                            List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                            //System.out.println("lstDietas.size():  " + lstDietas.size());
                                            for (Temp registroDieta : lstDietas) {
                                                registrarDetallePlanillaje(
                                                        registroPACF04,
                                                        registroDieta
                                                );
                                            }

                                        } else {

                                            //System.out.println("PACF04. La dependencia NO es especial.");

                                            //////////////////////////////////
                                            // Cobro Cuidado y manejo Diario //
                                            //////////////////////////////////                            
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorCuidadoManejoDiario(uniMed).get(0)
                                            );

                                            //////////////////////////////////
                                            //       Cobro habitacion       //
                                            ////////////////////////////////// 
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorHabitacion(uniMed, registroPACF04.getTotalCamas()).get(0)
                                            );

                                            //////////////////////////////////
                                            // Cobro de dieta Hospitalaria. //
                                            //////////////////////////////////
                                            //System.out.println("Antes de entrar a metodo valorDietaHospitalaria(). unidadMedica: " + String.valueOf(registroPACF04.getUnidadMedica()));
                                            List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                            //System.out.println("lstDietas.size():  " + lstDietas.size());
                                            for (Temp registroDieta : lstDietas) {
                                                registrarDetallePlanillaje(
                                                        registroPACF04,
                                                        registroDieta
                                                );
                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }
                } else {
                    if (comprobarRangoFechas(iofeor, registroPACF09)) {

                        if (((registroPACF09.getDependenciaAlta() >= 5000) && (registroPACF09.getDependenciaAlta() <= 5999)) && "ALT".equals(registroPACF09.getMotivoAlta())) {

                            //////////////////////////////////
                            // Registro tiene dep Especial? //
                            //////////////////////////////////                                        
                            if (dependenciaEspecial(String.valueOf(registroPACF09.getDependenciaAlta()), uniMed)) {

                                //System.out.println("\nLa dependencia es especial: " + String.valueOf(registroPACF09.getDependenciaAlta()));
                                //////////////////////////////////
                                // Cobro codigo directo de tabla //
                                //////////////////////////////////
                                List<Temp> listaValores = valorDependenciasEspeciales(String.valueOf(registroPACF09.getDependenciaAlta()), uniMed);
                                if (!listaValores.isEmpty()) {
                                    registrarDetallePlanillaje(
                                            registroPACF09,
                                            listaValores.get(0)
                                    );
                                }

                            } else {

                                //////////////////////////////////
                                //     Cobro Hospital del Dia   //
                                //////////////////////////////////
                                List<Temp> valores = valorHospitalDelDia(uniMed);
                                if (!valores.isEmpty()) {
                                    registrarDetallePlanillaje(
                                            registroPACF09,
                                            valores.get(0));
                                }
                            }

                        } else {

                            //////////////////////////////////
                            // lista de Registros de PACF03 //
                            //////////////////////////////////
                            List<ServiciosInstitucionales> lstRegistrosPACF03 = obtenerRegistrosPACF03(historiaClinica, uniMed, iofeor);

                            //.err.println("PACF03.SIZE: " + lstRegistrosPACF03.size());
                            if (!lstRegistrosPACF03.isEmpty()) {

                                ServiciosInstitucionales objPACF03 = lstRegistrosPACF03.get(0);

                                //////////////////////////////////
                                // Cobro de dieta Hospitalaria. //
                                //////////////////////////////////
                                List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                //System.out.println("lstDietas.size():  " + lstDietas.size());
                                for (Temp registroDieta : lstDietas) {
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            registroDieta);
                                }
//
//                                /*
//                                 VERIFICACION DE NUEVA TABLA
//                                 si la dependencia se encuentra en la nueva tabla se cobra el codigo de dicha tabla
//                                 */
//                                if (false) {
//
//                                } //////////////////////////////////
//                                // Registro tiene dep Especial? //
//                                //////////////////////////////////                  
//                                else 
                                if (dependenciaEspecial(String.valueOf(objPACF03.getDependenciaAlta()), uniMed)) {

                                    //////////////////////////////////
                                    // Cobro codigo directo de tabla //
                                    ////////////////////////////////// 
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorDependenciasEspeciales(String.valueOf(objPACF03.getDependenciaAlta()), uniMed).get(0)
                                    );

                                } else {

                                    //////////////////////////////////
                                    // Cobro Cuidado y manejo Diario //
                                    //////////////////////////////////                            
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorCuidadoManejoDiario(uniMed).get(0)
                                    );

                                    //////////////////////////////////
                                    //       Cobro habitacion       //
                                    ////////////////////////////////// 
                                    registrarDetallePlanillaje(
                                            objPACF03,
                                            valorHabitacion(uniMed, objPACF03.getTotalCamas()).get(0)
                                    );

                                }

                            } else {

                                //////////////////////////////////
                                // lista de Registros de PACF04 //
                                //////////////////////////////////
                                List<ServiciosInstitucionales> lstRegistrosPACF04 = obtenerRegistrosPACF04(historiaClinica, uniMed, iofeor);

//                                System.out.println("\nSegunda vez en pacf04");
//                                System.out.println("PACF04.size()" + lstRegistrosPACF04.size());
                                if (!lstRegistrosPACF04.isEmpty()) {

                                    ServiciosInstitucionales registroPACF04 = obtenerRegistroPACF04(lstRegistrosPACF04, iofeor);

                                    //////////////////////////////////
                                    // Registro tiene dep Especial? //
                                    //////////////////////////////////   
                                    if (registroPACF04 != null) {
                                        if (dependenciaEspecial(String.valueOf(registroPACF04.getDependenciaAlta()), uniMed)) {

                                            //////////////////////////////////
                                            // Cobro codigo directo de tabla //
                                            ////////////////////////////////// 
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorDependenciasEspeciales(String.valueOf(registroPACF04.getDependenciaAlta()), uniMed).get(0)
                                            );
                                            //////////////////////////////////
                                            // Cobro de dieta Hospitalaria. //
                                            //////////////////////////////////
                                            List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                            //System.out.println("lstDietas.size():  " + lstDietas.size());
                                            for (Temp registroDieta : lstDietas) {
                                                registrarDetallePlanillaje(
                                                        registroPACF04,
                                                        registroDieta
                                                );
                                            }

                                        } else {

                                            //////////////////////////////////
                                            // Cobro Cuidado y manejo Diario //
                                            //////////////////////////////////                            
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorCuidadoManejoDiario(uniMed).get(0)
                                            );

                                            //////////////////////////////////
                                            //       Cobro habitacion       //
                                            ////////////////////////////////// 
                                            registrarDetallePlanillaje(
                                                    registroPACF04,
                                                    valorHabitacion(uniMed, registroPACF04.getTotalCamas()).get(0)
                                            );

                                            //////////////////////////////////
                                            // Cobro de dieta Hospitalaria. //
                                            //////////////////////////////////
                                            List<Temp> lstDietas = valorDietaHospitalaria(uniMed);
                                            //System.out.println("lstDietas.size():  " + lstDietas.size());
                                            for (Temp registroDieta : lstDietas) {
                                                registrarDetallePlanillaje(
                                                        registroPACF04,
                                                        registroDieta
                                                );
                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }
                }

                i++;
            }

        }

    }

    private void registrarDetallePlanillaje(ServiciosInstitucionales registroQuery, Temp objetoTarifario) {
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
        //entidadDetalle.setNumOrden(registroDieta.getNumeroOrden());                       Revisar esto
        //entidadDetalle.setCodMedico(registroDieta.getCodigoMedico());                     Revisar esto
        entidadDetalle.setCoditem(objetoTarifario.getCodigo());
        entidadDetalle.setHistoCli(String.valueOf(registroQuery.getHistoriaClinica()));
        entidadDetalle.setFechaReg(clnCalendario.getTime());
        entidadDetalle.setDescItem(objetoTarifario.getDescripcion());

        BigDecimal codDependencia = BigDecimal.valueOf(registroQuery.getDependenciaAlta());
        BigInteger dependenciaBI = codDependencia.toBigInteger();

        entidadDetalle.setDepRea(NombreDependenciaSQL(dependenciaBI));
        entidadDetalle.setCoddepsol(dependenciaBI);              //Revisar esto
        entidadDetalle.setCoddeprea(dependenciaBI);              //  Revisar cual es el siguiente numero

        entidadDetalle.setValorUnit(objetoTarifario.getTemp());
        entidadDetalle.setValorTotal(objetoTarifario.getTemp());
        entidadDetalle.setTipoRubro("SEI");

        
        entidadDetalle.setDuracionAtencion(0); //ver este campo
        entidadDetalle.setEstado('A');

        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        // TODO Completar el objeto detalle para que pueda ser almacenado correctamente sin restriccionescab.setDetplantblList(null);
        cab.setDetplantblList(null);
        entidadDetalle.setCpidpk(cab);

        ////////////////////
        //TENER EN CUENTA
        //////////////////
        listaDetalles.add(entidadDetalle);
        //System.out.println("Descripcion:  " + entidadDetalle.getDescItem() + "  Valor: " + entidadDetalle.getValorUnit());
        registrarPorBloque(listaDetalles);

    }

}
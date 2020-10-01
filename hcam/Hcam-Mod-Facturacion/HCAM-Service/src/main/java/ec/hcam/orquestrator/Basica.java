package ec.hcam.orquestrator;

import ec.hcam.CabplantblServiceRemote;
import ec.hcam.DetplantblServiceRemote;
import ec.hcam.DeunitblServiceRemote;
import ec.hcam.data.DatosPaciente;
import ec.hcam.data.TarifarioCir;
import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Detplantbl;
import ec.hcam.entity.Unidmedtbl;
import ec.hcam.executor.IQueryExecutor;
import java.math.BigInteger;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Programacion
 */
public class Basica {

    @EJB
    public IQueryExecutor queryExecutor;

    @EJB
    CabplantblServiceRemote cabplantblService;

    @EJB
    DetplantblServiceRemote detalleService;

    @EJB
    DeunitblServiceRemote dependencia;

    @Resource
    public SessionContext ctx;
    public UserTransaction utx;

    public Map<String, Object> bag;
    public Map<String, Object> bagDependecia;

    public List<Detplantbl> listaDetalles = new ArrayList<>();

    public void existenciaCabecera(int mes, int dia, int anio, Integer unidpk, Integer ubicapk) {
        Cabplantbl cabeceraBuscada = cabplantblService.findCabplantblByMesDia(mes, dia, anio, unidpk);         

        //if ((cabeceraBuscada == null) || (bag != null && bag.get("cabplantbl") == null)) {
        if (cabeceraBuscada == null) {
            insertarCabecera(mes, dia, anio, unidpk, ubicapk);
        } else if (cabeceraBuscada != null) {
            buscarCabecera(mes, dia, anio, unidpk);
        }
    }

    public void insertarCabecera(int mes, int dia, int anio, Integer unidpk, Integer ubicapk) {

        Cabplantbl cabplantbl = new Cabplantbl();
        
        Calendar clnCalendario = Calendar.getInstance();

        java.util.Date fechaRegistro = new java.util.Date();

        //int diaRegistro = fechaRegistro.getDay();
        int diaRegistro = clnCalendario.getTime().getDay();
        int mesRegistro = clnCalendario.getTime().getMonth();
        int anioRegistro = clnCalendario.getTime().getYear();
        String fechaRegString = anioRegistro + "" + mesRegistro + "" + diaRegistro;
        int fechaRegInt = Integer.parseInt(fechaRegString);

        //Implementar secuencial numPlanilla
        cabplantbl.setNumplanilla(1);
        //implementar fecha de registro
        cabplantbl.setFechaReg(fechaRegInt);
        cabplantbl.setUsuarioreg(null);
        cabplantbl.setMesplanilla(mes);
        cabplantbl.setAnioplanilla(anio);
        cabplantbl.setEstadoplanilla('A');
        cabplantbl.setDiaplanilla(dia);
        cabplantbl.setDiaregistro(diaRegistro);
        cabplantbl.setMesregistro(mesRegistro);
        cabplantbl.setAnioregistro(anioRegistro);
        cabplantbl.setUnidpk(unidpk);
        cabplantbl.setUbicapk(ubicapk);

        //Implementar secuencial numPland
        cabplantbl.setNumpland(1);
        //Implementar funciÃ³n para las ids de unidad medica
        cabplantbl.setUnidmedtbl(new Unidmedtbl(unidpk, ubicapk));
        if (bag == null) {
            bag = new HashMap<>();
        }
        cabplantblService.createCabPlantbl(cabplantbl);
        Cabplantbl cabeceraIngresada = cabplantblService.findCabplantblByMesDia(mes, dia, anio, unidpk);
        bag.put("cabplantbl", cabeceraIngresada);
    }

    private void buscarCabecera(Integer mes, Integer dia, Integer ano, Integer unimedpk) {
        Cabplantbl cabplantbl = cabplantblService.findCabplantblByMesDia(mes, dia, ano, unimedpk);
        if (bag == null) {
            bag = new HashMap<>();
        }
        bag.clear();
        bag.put("cabplantbl", cabplantbl);
    }

    public java.sql.Date transformarFechaString(String fecha) {

        String mesSt = fecha.substring(4, 6);
        String diaSt = fecha.substring(6, 8);
        String anioSt = fecha.substring(0, 4);

        String fechaSt = anioSt + "-" + mesSt + "-" + diaSt;

        java.sql.Date fechaTrans = java.sql.Date.valueOf(fechaSt);
        return fechaTrans;
    }

    public String obtenerPrimerCaracter(String cadena) {
        String primerC = cadena.substring(0, 1);
        return primerC;
    }

    public int diferenciaHoras(int horaI, int horaF) {
        int diferencia = 0;
        try {
            Calendar dateInicio = Calendar.getInstance();
            Calendar dateFin = Calendar.getInstance();

            dateInicio.setTime(new SimpleDateFormat("HHmm").parse(String.format("%04d", horaI)));
            dateFin.setTime(new SimpleDateFormat("HHmm").parse(String.format("%04d", horaF)));

            if (dateFin.getTimeInMillis() < dateInicio.getTimeInMillis()) {
                dateFin.add(Calendar.DATE, 1);
            }

            long diff = dateFin.getTimeInMillis() - dateInicio.getTimeInMillis();

            diferencia = (int) TimeUnit.MILLISECONDS.toMinutes(diff);
        } catch (ParseException ex) {
            System.err.println(ex);
        }
        return diferencia;
    }

    public TarifarioCir obtenerValorTarifario(String codTarifario, String unidadMedica) {
        
        String unidMed = unidadMedica;
        while (unidMed.length() < 10) {
            unidMed = "0" + unidMed;
        }

        String sqlStringT = "SELECT T.TAIDPK AS IDTARIFARIO, T.TAVALOR AS VALORTARIFARIO, T.TAESTADO AS ESTADO, T.TADESCRIPC AS DESCRIPCION, T.TACODIGO AS CODIGO FROM FACWEB.TARIFAFTBL T JOIN FACWEB.CABTARITBL C ON T.CTIDPK = C.CTIDPK JOIN FACWEB.CT_UMTBL M ON M.CTIDPK = C.CTIDPK JOIN FACWEB.UNIDMEDTBL U ON U.UNIDPK = M.UNIDPK WHERE T.TACODIGO =:codTarifario  AND U.UNCODIGO =:uniMed";
        Map<String, Object> params = new HashMap<>();
        params.put("codTarifario", String.valueOf(codTarifario));
        params.put("uniMed", String.valueOf(unidMed));
        // Definir el anio
        //params.put("anio", 2014);

        List<TarifarioCir> tarifario = queryExecutor.executeQuery(sqlStringT, params, TarifarioCir.class);

        if(!tarifario.isEmpty()){
        return tarifario.get(0);
        }
        else {
            TarifarioCir tar = new TarifarioCir();
            tar.setCODIGO(codTarifario);
            tar.setDESCRIPCION("TARIFARIO ANTERIOR SIN VALOR");
            return tar;
        }
    }

    public String NombreDependencia(BigInteger codDependencia) {
        
        String codDep = String.valueOf(codDependencia);

        while (codDep.length() < 10) {
            codDep = "0" + codDep;
        }

        String nombreDep;
        try {
            if (dependencia.findNameDependencyByCodeDependency(codDep) != null) {
                nombreDep = dependencia.findNameDependencyByCodeDependency(codDep);
            } else {
                nombreDep = "SIN DESCRIPCION";
            }
        } catch (Exception ex) {
            nombreDep = "SIN DESCRIPCION";
        }
        return nombreDep;
    }

    public Date imprimirHora() {
        Calendar hora = Calendar.getInstance();
        Date horaD = hora.getTime();
        return horaD;
    }

    public void registrarPorBloque(List<Detplantbl> listaDetalles) {
        int batchSize = 500;
        if (listaDetalles.size() == batchSize) {
            try {
                utx.begin();
                for (Detplantbl detplantbl : listaDetalles) {
                    detalleService.createDetplantbl(detplantbl);
                }
                utx.commit();
                listaDetalles.clear();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                try {
                    utx.rollback();
                } catch (IllegalStateException | SecurityException | SystemException ex1) {
                    Logger.getLogger(HonorariosMedicosCirugiaService.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(HonorariosMedicosCirugiaService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String NombreDependenciaSQL(BigInteger codDependencia) {
        
        String codDep = codDependencia.toString();

        while (codDep.length() < 10) {
            codDep = "0" + codDep;
        }

        String sqlString = "select d.DENOMBRE from FACWEB.DEUNITBL d where d.DEDEPEND =:codDep";
        Map<String, Object> params = new HashMap<>();
        params.put("codDep", codDep);

        List<String> listaNombre = queryExecutor.executeQuery(sqlString, params, String.class);

        String varNombre = "";
        if (listaNombre.isEmpty()) {
            varNombre = "SIN DESCRIPCION";
        } else {
            varNombre = listaNombre.get(0);
        }
        return varNombre;
    }
}

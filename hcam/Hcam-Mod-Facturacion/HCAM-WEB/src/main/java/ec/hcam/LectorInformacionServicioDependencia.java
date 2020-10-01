package ec.hcam;

import ec.hcam.orquestrator.AltaHospitalariaRemote;
import ec.hcam.orquestrator.EquiposEspecialesEmergenciasRemote;
import ec.hcam.orquestrator.EquiposEspecialesHospitalizacionRemote;
import ec.hcam.orquestrator.DerechosSalaRecuperacionServiceRemote;
import ec.hcam.orquestrator.EquiposEspecialesQuirofanoRemote;
import ec.hcam.orquestrator.FarmacosAplicadosServiceRemote;
import ec.hcam.orquestrator.LabClinicoServiceRemote;
import ec.hcam.orquestrator.FarmacosPrescritosServiceRemote;
import ec.hcam.orquestrator.GasesMedicinalesRemote;
import ec.hcam.orquestrator.HonorarioMedicoCEServiceRemote;
import ec.hcam.orquestrator.HonorarioMedicoServiceRemote;
import ec.hcam.orquestrator.HonorariosMedicosCirugiaServiceRemote;
import ec.hcam.orquestrator.ImagenologiaServiceRemote;
import ec.hcam.orquestrator.InsumosEnfermeriaServiceRemote;
import ec.hcam.orquestrator.InsumosServiceRemote;
import ec.hcam.orquestrator.ProcedimientosServiceRemote;
import ec.hcam.orquestrator.MaterialesUsoMenorServiceRemote;
//import ec.hcam.orquestrator.derechoSalaQServiceRemote;
//import ec.hcam.orquestrator.verificarEstanciaServiceRemote;
import java.io.Serializable;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ec.hcam.orquestrator.ServiciosInstitucionalesRemote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Clase: LectorInformacionController Controla la logica de la ejecucion de las
 * reglas en los metodos que tiene implementados.
 *
 * @author Programacion
 * @version 1.0.0
 */
@ViewScoped
@ManagedBean(name = "lectorInformacionServicioDependencia")
public class LectorInformacionServicioDependencia implements Serializable {

    //Find a database connection
    //javax.naming.InitialContext ctx = new javax.naming.InitialContext();
    //javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("jdbc/hcamd");
    //java.sql.Connection conn = ds.getConnection();
//	private Connection conn;	
    // InitialContext cxt;
    //@Resource(name = "jdbc/hcam")
    //private DataSource ds;
    @EJB
    private HonorarioMedicoServiceRemote veHonorarioMedicoServiceRemote;

    @EJB
    private HonorarioMedicoCEServiceRemote veHonorarioMedicoCEServiceRemote;

    /*
     @EJB
     private HonorariosMedicosSubsecuenteServiceRemote veHonorariosMedicosSubsecuenteServiceRemote;

     @EJB
     private HonorariosMedicosInterconsultaServiceRemote veHonorariosMedicosInterconsultaServiceRemote;

     @EJB
     private HonorariosMedicosInterconsultaSubsecuenteServiceRemote veHonorariosMedicosInterconsultaSubsecuenteServiceRemote;
     */
    @EJB
    private FarmacosPrescritosServiceRemote veFarmacosRemote;
    @EJB
    private LabClinicoServiceRemote veLabClinicoRemote;
    @EJB
    private FarmacosAplicadosServiceRemote veFarmacosServRemote;
    @EJB
    private InsumosServiceRemote veInsumosServRemote;

    @EJB
    private ImagenologiaServiceRemote veImagenRemote;

    @EJB
    private EquiposEspecialesQuirofanoRemote equiposQuirofanoRemote;

    @EJB
    private EquiposEspecialesEmergenciasRemote equiposEmergenciasRemote;

    @EJB
    private EquiposEspecialesHospitalizacionRemote equiposHospitalizacionRemote;

//    @EJB
//    private derechoSalaQServiceRemote derechoSalaService;

    @EJB
    private InsumosEnfermeriaServiceRemote veEnfermeriaRemote;
    @EJB
    private HonorariosMedicosCirugiaServiceRemote honorarioMedCirgService;
    @EJB
    private MaterialesUsoMenorServiceRemote materialesUsoMenorService;
    @EJB
    private DerechosSalaRecuperacionServiceRemote derechoSalaRecService;

    @EJB
    private ProcedimientosServiceRemote procedimientosRemote;

    @EJB
    private ServiciosInstitucionalesRemote serviciosInstitucionalesRemote;

    @EJB
    private GasesMedicinalesRemote gasesMedicinalesRemote;

    @EJB
    private AltaHospitalariaRemote altaHospitalariaRemote;

    public void obtenerRegistrosHM() {
        System.out.println("Invocando metodo obtenerRegistros()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);
        veHonorarioMedicoServiceRemote.obtenerRegistrosHM(1, "1110100000", 2015050, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerRegistrosCE() {
        System.out.println("Invocando metodo obtenerRegistros()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);
        veHonorarioMedicoCEServiceRemote.obtenerRegistrosCE(1, "1110100000", 20150429, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }
    /*
     public void obtenerRegistrosHMS() {
     System.out.println("Invocando metodo obtenerRegistros()");
     //        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);
     veHonorariosMedicosSubsecuenteServiceRemote.obtenerRegistros(1, "1110100000", 1142, 20150508);
     //        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
     }

     public void obtenerRegistrosHMI() {
     System.out.println("Invocando metodo obtenerRegistros()");
     //        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);
     veHonorariosMedicosInterconsultaServiceRemote.obtenerRegistros(1, "1110100000", 1142, 20150508);
     //        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
     }

     public void obtenerRegistrosHMIS() {
     System.out.println("Invocando metodo obtenerRegistros()");
     //        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);
     veHonorariosMedicosInterconsultaSubsecuenteServiceRemote.obtenerRegistros(1, "1110100000", 1142, 20150508);
     //        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
     }
     */

    public void obtenerRegistrosFarmacos() {
        System.out.println("Invocando metodo obtenerRegistrosFarmacos()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veFarmacosRemote.obtenerRegistrosF("1110100000", 20150429, 1, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerRegistrosFarmacosSer() {
        System.out.println("Invocando metodo obtenerRegistrosFarmacos() para servicios");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veFarmacosServRemote.obtenerRegistrosF("1110100000", 20150429, 1, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerRegistrosLaboratorio() {
        System.out.println("Invocando metodo obtenerRegistrosLaboratorio()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veLabClinicoRemote.obtenerRegistrosLaboratorio("1110100000", 1, 20150429, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerInsumosServicios() {
        System.out.println("Invocando metodo obtenerRegistrosInsumosServicios()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veInsumosServRemote.obtenerRegistrosInsumosServicios("1110100000", 1, 20150429, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerInsumosEnfermeria() {
        System.out.println("Invocando metodo obtenerRegistrosInsumosEnfermeria()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veEnfermeriaRemote.obtenerRegistrosInsumosEnfermeria("1110100000", 1, 20150429, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerRegistrosImagen() {
        System.out.println("Invocando metodo obtenerRegistrosImagen()");
//        veEstanciaRemote.obtenerRegistros(1, "11101000001142", 1142, 20150421);

        veImagenRemote.obtenerRegistrosI(1, "1110100000", 20150519, 8, 1323);
//        t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421
    }

    public void obtenerEquiposQuirofano() {
        System.out.println("Metodo obtener Registros Quirofano()");
        equiposQuirofanoRemote.obtenerEquiposEspeciales("1110100000", 20150401, 1, 8, 1323);
    }

    public void obtenerEquiposEmergencias() {
        System.out.println("Metodo obtener Registros Emergencias()");
        equiposEmergenciasRemote.obtenerEquiposEspeciales("5117400000", 20150430, 1, 8, 1323);
    }

    public void obtenerEquiposHospitalizacion() {
        System.out.println("Metodo obtener Registros Hospitalizacion()");
        equiposHospitalizacionRemote.obtenerEquiposEspeciales("1110100000", 20150429, 1, 8, 1323);
    }

    public void recuperaInfo() {
        System.out.print("Llego hasta aqui");
    }

    public void obtenerRegistrosDerechosSala() {
        System.out.println("Metodo Derechos de Sala");
        //derechoSalaService.obtenerRegistros("1110100000", 20150429);
    }

    /*
     *Prueba Procedimientos
     */
    public void obtenerProcedimientos() {
        System.out.println("Procedimientos");
        procedimientosRemote.obtenerRegistrosProcedimientoEmergecia("1110100000", 7, 20150421, 1, 8, 1323 );

    }

    /*
     *Prueba Procedimientos
     */
    public void obtenerProcedimientosRehabilitacion() {
        System.out.println("Procedimientos");
        procedimientosRemote.obtenerRegistrosProcedimientoRehabilitacion("1110100000", 20150428, 1, 8, 1323);

    }

    public void generarPlanillaje() {

        Calendar cal = Calendar.getInstance();
        cal.set(2015, 4, 1, 0, 0, 0);
        System.out.println("Fecha 1 " + cal.getTime());

        //cal.add(Calendar.DATE, 1);
        System.out.println("Fecha 2 " + cal.getTime());

        Calendar calF = Calendar.getInstance();
        calF.set(2015, 4, 3, 0, 0, 0);
        //calF.add(Calendar.DATE, 1);

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(dateFormat.format(cal.getTime()));
//        System.out.println(dateFormat.format(calF.getTime()));

        /*
        while (cal.before(calF)) {

            System.out.println(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);

            String strFecha = dateFormat.format(cal.getTime());

            System.out.println("Metodo Derechos de Sala");
            // 1
            derechoSalaService.obtenerRegistros("1110100000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosFarmacos()");
            // 2
            veFarmacosRemote.obtenerRegistrosF("1110100000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosFarmacos() para servicios");
            veFarmacosServRemote.obtenerRegistrosF("1110100000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosInsumosServicios()");
            // 3
            veInsumosServRemote.obtenerRegistrosInsumosServicios("1110100000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosInsumosEnfermeria()");
            veEnfermeriaRemote.obtenerRegistrosInsumosEnfermeria("1110100000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosLaboratorio()");
            veLabClinicoRemote.obtenerRegistrosLaboratorio("1110100000", Integer.parseInt(strFecha));
            System.out.println("Metodo obtener Registros Quirofano()");
            equiposQuirofanoRemote.obtenerEquiposEspeciales("1110100000", Integer.parseInt(strFecha));
            System.out.println("Metodo obtener Registros Emergencias()");
            equiposEmergenciasRemote.obtenerEquiposEspeciales("5117400000", Integer.parseInt(strFecha));
            System.out.println("Metodo obtener Registros Hospitalizacion()");
            equiposHospitalizacionRemote.obtenerEquiposEspeciales("5117400000", Integer.parseInt(strFecha));
            System.out.println("Invocando metodo obtenerRegistrosImagen()");
            veImagenRemote.obtenerRegistrosI(1, "1110100000", Integer.parseInt(strFecha));

            System.out.println("Invocando metodo obtenerRegistrosHonorariosMedicos()");
            veHonorarioMedicoServiceRemote.obtenerRegistrosHM(1, "1110100000", Integer.parseInt(strFecha));
            System.out.println("Metodo de materiales de uso menor");
            materialesUsoMenorService.obtenerRegistros("1110100000", Integer.parseInt(strFecha));
            System.out.println("Metodo de Derechos de Sala de Recuperacion");
            derechoSalaRecService.obtenerRegistros("1110100000", Integer.parseInt(strFecha));
            System.out.println("Metodo Honorarios CirugÃ­a");
            honorarioMedCirgService.obtenerRegistros("1110100000", Integer.parseInt(strFecha));
//            clnAuxiliar.setTime(dtFechaInicio);
//            clnAuxiliar.add(Calendar.DATE, 1);
//            System.out.println("Acabo un dÃ­a, va a sumar un dia");
//            dtFechaInicio = (Date) clnAuxiliar.getTime();
        }
                */
    }

    public void obtenerRegistrosHonorariosMedicosCirugia() {
        System.out.println("Metodo Honorarios CirugÃ­a");
        honorarioMedCirgService.obtenerRegistros("1110100000", 20150430, 1,8,1323);
    }

    public void obtenerRegistrosMaterialesUsoMenor() {
        System.out.println("Metodo de materiales de uso menor");
        materialesUsoMenorService.obtenerRegistros("1110100000", 20150430, 1,8,1323);
    }

    public void obtenerRegistrosDerechosSalaRecuperacion() {
        System.out.println("Metodo de Derechos de Sala de Recuperacion");
        derechoSalaRecService.obtenerRegistros("1110100000", 20150529, 1,8,1323);
    }

    public void obtenerServiciosInstitucionales() {
        serviciosInstitucionalesRemote.obtenerRegistrosServiciosInstitucionales("1110100000", 20150529, 1,8,1323);
    }

    public void obtenerRegistrosGasesMedicinales() {
        gasesMedicinalesRemote.obtenerRegistrosGasesMedicinales("1110100000", 20150403, 1,8,1323);
    }

    public void obtenerRegistrosAltasHospitalarias() {
        altaHospitalariaRemote.obtenerAltasHospitalarias("1110100000", 20150403, 8,1323);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.ejb.client;

import ec.hcam.data.CodigoUnidMedica;
import ec.hcam.orquestrator.AltaHospitalariaRemote;
import ec.hcam.orquestrator.DerechoSalaQServiceRemote;
import ec.hcam.orquestrator.DerechosSalaRecuperacionServiceRemote;
import ec.hcam.orquestrator.EquiposEspecialesEmergenciasRemote;
import ec.hcam.orquestrator.EquiposEspecialesHospitalizacionRemote;
import ec.hcam.orquestrator.EquiposEspecialesQuirofanoRemote;
import ec.hcam.orquestrator.FarmacosAplicadosServiceRemote;
import ec.hcam.orquestrator.FarmacosPrescritosServiceRemote;
import ec.hcam.orquestrator.GasesMedicinalesRemote;
import ec.hcam.orquestrator.HonorarioMedicoCEServiceRemote;
import ec.hcam.orquestrator.HonorarioMedicoODServiceRemote;
import ec.hcam.orquestrator.HonorarioMedicoServiceRemote;
import ec.hcam.orquestrator.HonorariosMedicosCirugiaServiceRemote;
import ec.hcam.orquestrator.ImagenologiaServiceRemote;
import ec.hcam.orquestrator.InsumosEnfermeriaServiceRemote;
import ec.hcam.orquestrator.InsumosServiceRemote;
import ec.hcam.orquestrator.LabClinicoServiceRemote;
import ec.hcam.orquestrator.MaterialesUsoMenorServiceRemote;
import ec.hcam.orquestrator.ObtenerUnidadMedicaServiceRemote;
import ec.hcam.orquestrator.ProcedimientosServiceRemote;
import ec.hcam.orquestrator.ServiciosInstitucionalesRemote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pestupinan
 */
public class HCAMEJBClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<CodigoUnidMedica> codigoUnidMedicaList = null;

        try {
            InitialContext ic = new InitialContext();
            ObtenerUnidadMedicaServiceRemote obtenerUnidadMedicaService = (ObtenerUnidadMedicaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ObtenerUnidadMedicaService");
            codigoUnidMedicaList = obtenerUnidadMedicaService.obtenerNivelTarifario();
        } catch (NamingException ex) {
            Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (CodigoUnidMedica codigoUnidMedica : codigoUnidMedicaList) {
            
            String unidadMedica = codigoUnidMedica.getCODIGO();
            Integer nivel = codigoUnidMedica.getNIVEL();
            Integer idUnidadMedica = codigoUnidMedica.getIDUNIDMED();
            Integer ubicapk = codigoUnidMedica.getIDUBICA();
//        String unidadMedica = "5108000600";
//        Integer nivel = 3;
//        Integer idUnidadMedica = 208;
//        Integer ubicapk = 1327;

        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.APRIL, 1, 0, 0, 0);
        System.out.println("Fecha 1 " + cal.getTime());
        System.out.println("Unidad Medica: " + unidadMedica);

        Calendar calF = Calendar.getInstance();
        calF.set(2015, Calendar.APRIL, 30, 0, 0, 0);
        System.out.println("Fecha 2 " + calF.getTime());

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Future futureFarmacosPrescritosService = null;
        Future futureFarmacosAplicadosService = null;
        Future futureInsumosService = null;
        Future futureInsumosEnfermeriaService = null;
        Future futureLabClinicoService = null;
        Future futureEquiposEspecialesQuirofano = null;
        Future futureEquiposEspecialesEmergencias = null;
        Future futureEquiposEspecialesHospitalizacion = null;
        Future futureImagenologiaService = null;
        Future futureHonorariosMedicosCirugiaService = null;
        Future futureMaterialesUsoMenorService = null;
        Future futureDerechosSalaRecuperacionService = null;
        Future futureProcedimientosEmergencia = null;
        Future futureProcedimientosRehabilitacion = null;
        Future futureGasesMedicinales = null;
        Future futureServiciosInstitucionales = null;
        Future futureAltaHospitalaria = null;
        Future futureHonorarioMedicoCEService = null;
        Future futureHonorarioMedicoService = null;
        Future futureHorarioMedicoODService = null;

        while (cal.before(calF) || cal.equals(calF)) {

            System.out.println(dateFormat.format(cal.getTime()));

            String strFecha = dateFormat.format(cal.getTime());
            Integer fecha = Integer.valueOf(strFecha);

            System.out.println("Ejecutando proceso inicial DerechoSalaQService");

            try {
                InitialContext ic = new InitialContext();
                DerechoSalaQServiceRemote derechosSalaQService = (DerechoSalaQServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/DerechoSalaQService");
                Future future = derechosSalaQService.obtenerRegistros(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);
                boolean continuar = true;
                System.out.println("Ejecutando proceso asincrono DerechoSalaQService");
                while (continuar) {
                    // Si el proceso asincrono termina puedo capturar la respuesta
                    if (future.isDone()) {
                        System.out.println("Termino el proceso asincrono DerechoSalaQService");
                        System.out.println(future.get());
                        continuar = false;
                    }
                }
                System.out.println("Ejecutando proceso asincrono DerechoSalaQService");
            } catch (NamingException | InterruptedException | ExecutionException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                FarmacosPrescritosServiceRemote farmacosPrescritosService = (FarmacosPrescritosServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/FarmacosPrescritosService");
                futureFarmacosPrescritosService = farmacosPrescritosService.obtenerRegistrosF(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono FarmacosPrescritosService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                FarmacosAplicadosServiceRemote farmacosAplicadosService = (FarmacosAplicadosServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/FarmacosAplicadosService");
                futureFarmacosAplicadosService = farmacosAplicadosService.obtenerRegistrosF(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono FarmacosAplicadosService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                InsumosServiceRemote insumosService = (InsumosServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/InsumosService");
                futureInsumosService = insumosService.obtenerRegistrosInsumosServicios(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono InsumosService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                InsumosEnfermeriaServiceRemote insumosEnfermeriaService = (InsumosEnfermeriaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/InsumosEnfermeriaService");
                futureInsumosEnfermeriaService = insumosEnfermeriaService.obtenerRegistrosInsumosEnfermeria(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono InsumosEnfermeriaService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                LabClinicoServiceRemote labClinicoService = (LabClinicoServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/LabClinicoService");
                futureLabClinicoService = labClinicoService.obtenerRegistrosLaboratorio(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono LabClinicoService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                EquiposEspecialesQuirofanoRemote equiposEspecialesQuirofano = (EquiposEspecialesQuirofanoRemote) ic.lookup("java:global/HCAM-Service-1.0.0/EquiposEspecialesQuirofanoService");
                futureEquiposEspecialesQuirofano = equiposEspecialesQuirofano.obtenerEquiposEspeciales(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono EquiposEspecialesQuirofano");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                EquiposEspecialesEmergenciasRemote equiposEspecialesEmergencias = (EquiposEspecialesEmergenciasRemote) ic.lookup("java:global/HCAM-Service-1.0.0/EquiposEspecialesEmergenciasService");
                futureEquiposEspecialesEmergencias = equiposEspecialesEmergencias.obtenerEquiposEspeciales(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono EquiposEspecialesEmergencias");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                EquiposEspecialesHospitalizacionRemote equiposEspecialesHospitalizacion = (EquiposEspecialesHospitalizacionRemote) ic.lookup("java:global/HCAM-Service-1.0.0/EquiposEspecialesHospitalizacionService");
                futureEquiposEspecialesHospitalizacion = equiposEspecialesHospitalizacion.obtenerEquiposEspeciales(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono EquiposEspecialesHospitalizacion");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                ImagenologiaServiceRemote imagenologiaService = (ImagenologiaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ImagenologiaService");
                futureImagenologiaService = imagenologiaService.obtenerRegistrosI(nivel, unidadMedica, fecha, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono ImagenologiaService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

//                try {
//            InitialContext ic = new InitialContext();
//            ImagenologiaServiceRemote imagenologiaService = (ImagenologiaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ImagenologiaService");
//            Future future = imagenologiaService.obtenerRegistrosI(nivel, unidadMedica, fecha, idUnidadMedica, ubicapk);
//
//            boolean continuar = true;
//            System.out.println("Ejecutando proceso asincrono ImagenologiaService");
//            while (continuar) {
//                // Si el proceso asincrono termina puedo capturar la respuesta
//                if (future.isDone()) {
//                    System.out.println("Termino el proceso asincrono");
//                    System.out.println(future.get());
//                    continuar = false;
//                }
//            }
//        } catch (NamingException | InterruptedException | ExecutionException ex) {
//            Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
            try {
                InitialContext ic = new InitialContext();
                HonorariosMedicosCirugiaServiceRemote honorariosMedicosCirujia = (HonorariosMedicosCirugiaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/HonorariosMedicosCirugiaService");
                futureHonorariosMedicosCirugiaService = honorariosMedicosCirujia.obtenerRegistros(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono honorariosMedicosCirujiaService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                InitialContext ic = new InitialContext();
                MaterialesUsoMenorServiceRemote materialesUsoMenor = (MaterialesUsoMenorServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/MaterialesUsoMenorService");
                futureMaterialesUsoMenorService = materialesUsoMenor.obtenerRegistros(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono MaterialesUsoMenorService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                DerechosSalaRecuperacionServiceRemote derechoSalaRecuperacion = (DerechosSalaRecuperacionServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/DerechosSalaRecuperacionService");
                futureDerechosSalaRecuperacionService = derechoSalaRecuperacion.obtenerRegistros(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono DerechoSaraRecuperacionService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                InitialContext ic = new InitialContext();
                ProcedimientosServiceRemote procedimientosEmergencia = (ProcedimientosServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ProcedimientosService");
                futureProcedimientosEmergencia = procedimientosEmergencia.obtenerRegistrosProcedimientoEmergecia(unidadMedica, 7, fecha, nivel, idUnidadMedica, ubicapk);

                boolean continuar = true;
                System.out.println("Ejecutando proceso asincrono ProcedimientosEmergenciaService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                InitialContext ic = new InitialContext();
                ProcedimientosServiceRemote procedimientosRehabilitacion = (ProcedimientosServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ProcedimientosService");
                futureProcedimientosRehabilitacion = procedimientosRehabilitacion.obtenerRegistrosProcedimientoRehabilitacion(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono ProcedimientosRehabilitacionService");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                GasesMedicinalesRemote gasesMedicinales = (GasesMedicinalesRemote) ic.lookup("java:global/HCAM-Service-1.0.0/GasesMedicinalesService");
                futureGasesMedicinales = gasesMedicinales.obtenerRegistrosGasesMedicinales(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono Gases Medicinales");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                ServiciosInstitucionalesRemote serviciosInstitucionales = (ServiciosInstitucionalesRemote) ic.lookup("java:global/HCAM-Service-1.0.0/ServiciosInstitucionalesService");
                futureServiciosInstitucionales = serviciosInstitucionales.obtenerRegistrosServiciosInstitucionales(unidadMedica, fecha, nivel, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono Servicios Institucionales");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                AltaHospitalariaRemote altaHospitalaria = (AltaHospitalariaRemote) ic.lookup("java:global/HCAM-Service-1.0.0/AltaHospitalariaService");
                futureAltaHospitalaria = altaHospitalaria.obtenerAltasHospitalarias(unidadMedica, fecha, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono Alta Hospitalaria");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                HonorarioMedicoCEServiceRemote honorariosMedicosCEService = (HonorarioMedicoCEServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/HonorarioMedicoCEService");
                futureHonorarioMedicoCEService = honorariosMedicosCEService.obtenerRegistrosCE(nivel, unidadMedica, fecha, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono Honorario Medico CE");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                HonorarioMedicoServiceRemote honorarioMedico = (HonorarioMedicoServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/HonorarioMedicoService");
                futureHonorarioMedicoService = honorarioMedico.obtenerRegistrosHM(nivel, unidadMedica, fecha, idUnidadMedica, ubicapk);

                System.out.println("Ejecutando proceso asincrono Honorarios Medicos");
            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InitialContext ic = new InitialContext();
                HonorarioMedicoODServiceRemote honorariosMedicosODService = (HonorarioMedicoODServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/HonorarioMedicoODService");
                futureHorarioMedicoODService = honorariosMedicosODService.obtenerRegistrosCE(1, "1110100000", 20150504, 8, 1323);

                System.out.println("Ejecutando proceso asincrono Honorario Medico Odontologia");

            } catch (NamingException ex) {
                Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            cal.add(Calendar.DATE, 1);
        }

    }

//            boolean continuar = true;
//            while (continuar) {
//                // Si los procesos asincronos terminan puedo continuar a la sigueinte unidad medica
//                if (futureFarmacosPrescritosService.isDone()
//                        && futureFarmacosAplicadosService.isDone()
//                        && futureInsumosService.isDone()
//                        && futureInsumosEnfermeriaService.isDone()
//                        && futureLabClinicoService.isDone()
//                        && futureEquiposEspecialesQuirofano.isDone()
//                        && futureEquiposEspecialesEmergencias.isDone()
//                        && futureEquiposEspecialesHospitalizacion.isDone()
//                        && futureImagenologiaService.isDone()
//                        && futureHonorariosMedicosCirugiaService.isDone()
//                        && futureMaterialesUsoMenorService.isDone()
//                        && futureDerechosSalaRecuperacionService.isDone()
//                        && futureProcedimientosEmergencia.isDone()
//                        && futureProcedimientosRehabilitacion.isDone()
//                        && futureGasesMedicinales.isDone()
//                        && futureServiciosInstitucionales.isDone()
//                        && futureAltaHospitalaria.isDone()
//                        && futureHonorarioMedicoCEService.isDone()
//                        && futureHonorarioMedicoService.isDone()) {
//                    System.out.println("Terminaron procesos asincronos.");
//                    continuar = false;
//                }
//            }
    }
}

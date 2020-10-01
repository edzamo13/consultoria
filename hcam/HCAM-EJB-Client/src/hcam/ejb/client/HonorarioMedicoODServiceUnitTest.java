/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.ejb.client;

import ec.hcam.orquestrator.HonorarioMedicoODServiceRemote;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author programacion
 */
public class HonorarioMedicoODServiceUnitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InitialContext ic = new InitialContext();
            HonorarioMedicoODServiceRemote honorariosMedicosODService = (HonorarioMedicoODServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/HonorarioMedicoODService");
            Future future = honorariosMedicosODService.obtenerRegistrosCE(1, "1110100000", 20150504, 8, 1323);

            boolean continuar = true;
            System.out.println("Ejecutando proceso asincrono Honorario Medico Odontologia");
            while (continuar) {
                // Si el proceso asincrono termina puedo capturar la respuesta
                if (future.isDone()) {
                    System.out.println("Termino el proceso asincrono");
                    System.out.println(future.get());
                    continuar = false;
                }
            }
        } catch (NamingException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(HCAMEJBClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

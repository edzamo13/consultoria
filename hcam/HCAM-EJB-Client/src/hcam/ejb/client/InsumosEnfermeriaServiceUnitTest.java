/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.ejb.client;

import ec.hcam.orquestrator.InsumosEnfermeriaServiceRemote;
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
public class InsumosEnfermeriaServiceUnitTest {

    public static void main(String[] args) {
        try {
            InitialContext ic = new InitialContext();
            InsumosEnfermeriaServiceRemote insumosEnfermeriaService = (InsumosEnfermeriaServiceRemote) ic.lookup("java:global/HCAM-Service-1.0.0/InsumosEnfermeriaService");
            Future future = insumosEnfermeriaService.obtenerRegistrosInsumosEnfermeria("1110100000", 20150429, 1, 1, 1);

            boolean continuar = true;
            System.out.println("Ejecutando proceso asincrono InsumosEnfermeriaService");
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

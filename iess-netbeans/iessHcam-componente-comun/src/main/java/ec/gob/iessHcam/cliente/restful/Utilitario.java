/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.cliente.restful;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class Utilitario {

    private Utilitario() {
        
    }

    public static void error(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.SEVERE, mensaje.toUpperCase(), e);
    }
}

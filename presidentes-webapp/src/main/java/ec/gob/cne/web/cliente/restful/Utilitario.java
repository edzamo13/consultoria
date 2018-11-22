/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.web.cliente.restful;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezamora
 */
public class Utilitario {

    /**
     * @author ezamora Constructor privado
     */
    private Utilitario() {
    }

    /**
     * @author ezamora
     * @param clase clase
     * @param mensaje mensaje
     * @param e e
     */
    public static void error(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.SEVERE, mensaje.toUpperCase(), e);
    }
}

/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 11/04/2016]</p>
 */
public class LabAccesoRetorno {

    @Getter
    @Setter
    private boolean isLabAccesoValidado;
    
    @Getter
    @Setter
    private String mensaje;

    public LabAccesoRetorno(boolean isLabAccesoValidado, String mensaje) {
        this.isLabAccesoValidado = isLabAccesoValidado;
        this.mensaje = mensaje;
    }
    
    public LabAccesoRetorno() {

    }
    
}

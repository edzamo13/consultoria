/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.correo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class CorreoSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String envio;

    public CorreoSalida() {
    }

    public CorreoSalida(String envio) {
        this.envio = envio;
    }

    
  

}

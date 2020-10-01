/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;


import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class AplicacionRespuesta implements Serializable {

    private static final long serialVersionUID = -4002897314076938975L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private AplicacionSalida cuerpo;
    @Getter
    @Setter
    private String mensaje;

    /**
     *
     * <b>
     * Constructor.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 21/09/2016]</p>
     */
    public AplicacionRespuesta() {
    }


    
}

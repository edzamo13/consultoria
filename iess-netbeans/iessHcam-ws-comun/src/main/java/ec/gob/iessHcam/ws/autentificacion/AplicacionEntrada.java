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
public class AplicacionEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String idAplicacion;

    /**
     *
     * <b>
     * Constructor.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 21/09/2016]</p>
     */
    public AplicacionEntrada() {
    }
  

}

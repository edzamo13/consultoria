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
public class MenuEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String codigoAplicacion;
    @Getter
    @Setter
    private String idUsuario;

    public MenuEntrada() {
    }

}

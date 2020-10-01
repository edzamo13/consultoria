/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.autentificacion;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 27/01/2016]</p>
 */
public class UsuarioEntrada implements Serializable {

    private static final long serialVersionUID = -7880084267722228034L;

    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String clave;

}

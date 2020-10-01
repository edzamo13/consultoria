/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.bb;

import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase  backing bean que respalda al controlador.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 26/01/2016]</p>
 */
@Dependent
public class LoginBb implements Serializable {

    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private String nombreUsuario;
    @Getter
    @Setter
    private String contrasenia;
    @Getter
    @Setter
    private Usuario usuario;

}

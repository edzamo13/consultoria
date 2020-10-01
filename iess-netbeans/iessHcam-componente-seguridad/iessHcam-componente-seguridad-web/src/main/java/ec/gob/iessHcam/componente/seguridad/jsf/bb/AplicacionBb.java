/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.bb;

import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Usuario;
import ec.gob.iessHcam.ws.autentificacion.UsuarioRespuesta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase backing bean que respalda al controlador.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 26/01/2016]</p>
 */
@Dependent
public class AplicacionBb implements Serializable {

    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Usuario usuario;
    @Getter
    @Setter
    private UsuarioRespuesta respuesta;
    @Getter
    @Setter
    private Aplicacion aplicacion;
    @Getter
    @Setter
    private List<Aplicacion> aplicacions;
    @Getter
    @Setter
    private List<Dependencias> dependenciasApp;
    

}

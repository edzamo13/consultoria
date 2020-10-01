/*
* Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.cs.autentificacion;

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
 * [$Author: ezamora $, $Date: 21/02/2017]</p>
 */
public class LoginCsEntrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String clave;
    @Getter
    @Setter
    private String codigoAplicacion;

    public LoginCsEntrada() {
    }
    

    

}

/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.interno;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENIN
 * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
 */
public class LoginSalida implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;

    @Getter
    @Setter
    private int estado;
    
    @Getter
    @Setter
    private String usuario;

    public LoginSalida() {
    }

    public LoginSalida(int estado, String usuario) {
        super();
        this.estado = estado;
        this.usuario = usuario;
    }
}


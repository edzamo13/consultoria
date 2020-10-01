/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.hcam;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENIN
 * <p>[$Author: LENIN $, $Date: 01-mar-2016]</p>
 */
public class FarmacoEntrada implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;

    @Getter
    @Setter
    private String um;

}


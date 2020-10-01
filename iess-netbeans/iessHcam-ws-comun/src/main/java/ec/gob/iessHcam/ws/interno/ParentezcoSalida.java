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
public class ParentezcoSalida implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private String PAR_ID;
    @Getter
    @Setter
    private String PAR_NOMBRE;
    @Getter
    @Setter
    private String PAR_DESCRIPCION;
    @Getter
    @Setter
    private String PAR_ESTADO;

    public ParentezcoSalida(String PAR_ID, String PAR_NOMBRE, String PAR_DESCRIPCION, String PAR_ESTADO) {
        this.PAR_ID = PAR_ID;
        this.PAR_NOMBRE = PAR_NOMBRE;
        this.PAR_DESCRIPCION = PAR_DESCRIPCION;
        this.PAR_ESTADO = PAR_ESTADO;
    }

}


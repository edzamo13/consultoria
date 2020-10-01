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
 * <p>[$Author: LENIN $, $Date: 04-mar-2016]</p>
 */
public class Cie10Respuesta implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;
    
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private int nivel;
    @Getter
    @Setter
    private int idPadre;

    public Cie10Respuesta() {
    }

    public Cie10Respuesta(int id, String codigo, String descripcion, int nivel, int idPadre) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.idPadre = idPadre;
    }

    

}


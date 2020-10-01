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
public class Cie10Salida implements Serializable {
    
    private static final long serialVersionUID = -7880084267722228034L;

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String nivel;
    @Getter
    @Setter
    private String idPadre;
    
    public Cie10Salida() {
        super();
    }

    public Cie10Salida(String id, String codigo, String descripcion, String nivel, String idPadre) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.idPadre = idPadre;
    }

}


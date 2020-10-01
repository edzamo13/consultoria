/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.gestionAs400;

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
 * [$Author: ezamora $, $Date: 20/01/2016]</p>
 */
public class TipoAfiliadoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String valorA;
    @Getter
    @Setter
    private String valorB;

    public TipoAfiliadoSalida(String codigo, String descripcion, String valorA, String valorB) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valorA = valorA;
        this.valorB = valorB;
    }

    public TipoAfiliadoSalida() {
    }
    

   

}

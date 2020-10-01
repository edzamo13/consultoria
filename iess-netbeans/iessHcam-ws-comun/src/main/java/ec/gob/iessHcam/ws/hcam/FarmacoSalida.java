/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.hcam;

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
public class FarmacoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String codigoitem;
    @Getter
    @Setter
    private String descripcionfarmaco;
    @Getter
    @Setter
    private String presentacion;
    @Getter
    @Setter
    private String tipo;
    
    public FarmacoSalida() {
        super();
    }

    public FarmacoSalida(String unidadMedica, String codigoitem, String descripcionfarmaco, String presentacion, String tipo) {
        this.unidadMedica = unidadMedica;
        this.codigoitem = codigoitem;
        this.descripcionfarmaco = descripcionfarmaco;
        this.presentacion = presentacion;
        this.tipo = tipo;
    }

        
}

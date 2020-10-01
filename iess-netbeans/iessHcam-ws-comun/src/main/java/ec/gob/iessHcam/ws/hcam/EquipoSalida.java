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
public class EquipoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String codUnidadMedica;
    @Getter
    @Setter
    private String desUnidadMedica;
    @Getter
    @Setter
    private String codEquipoEspecial;
    @Getter
    @Setter
    private String desEquipoEspecial;
    
    public EquipoSalida() {
        super();
    }

    public EquipoSalida(String codUnidadMedica, String desUnidadMedica, String codEquipoEspecial, String desEquipoEspecial) {
        this.codUnidadMedica = codUnidadMedica;
        this.desUnidadMedica = desUnidadMedica;
        this.codEquipoEspecial = codEquipoEspecial;
        this.desEquipoEspecial = desEquipoEspecial;
    }
    
    
}

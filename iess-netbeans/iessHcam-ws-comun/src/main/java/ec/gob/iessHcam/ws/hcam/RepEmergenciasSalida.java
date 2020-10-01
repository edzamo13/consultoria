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
public class RepEmergenciasSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    String paciente;
    @Getter
    @Setter
    String habitacion;
    @Getter
    @Setter
    String fechaIngreso;
    @Getter
    @Setter
    String horaIngreso;
    @Getter
    @Setter
    String estadoClinico;
    
    public RepEmergenciasSalida() {
        super();
    }

    public RepEmergenciasSalida(String paciente, String habitacion, String fechaIngreso, String horaIngreso, String estadoClinico) {
        this.paciente = paciente;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.estadoClinico = estadoClinico;
    }
    
}

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
public class CitaMedicaSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;
    
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String paciente;
    @Getter
    @Setter
    private String dependencia;
    @Getter
    @Setter
    private String medico;
    @Getter
    @Setter
    private String fechaCita;
    @Getter
    @Setter
    private String horaCita;

    public CitaMedicaSalida() {
        super();
    }

    public CitaMedicaSalida(String cedula, String paciente, String dependencia, String medico, String fechaCita, String horaCita) {
        this.cedula = cedula;
        this.paciente = paciente;
        this.dependencia = dependencia;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

}

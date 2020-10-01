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
public class MedicoSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String codMedico;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String codEspecialidad;
    @Getter
    @Setter
    private String especialidad;

    public MedicoSalida(String estado, String unidadMedica, String codMedico, String cedula, String nombre, String codEspecialidad, String especialidad) {
        this.estado = estado;
        this.unidadMedica = unidadMedica;
        this.codMedico = codMedico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.codEspecialidad = codEspecialidad;
        this.especialidad = especialidad;
    }
    
    public MedicoSalida() {
    }

}

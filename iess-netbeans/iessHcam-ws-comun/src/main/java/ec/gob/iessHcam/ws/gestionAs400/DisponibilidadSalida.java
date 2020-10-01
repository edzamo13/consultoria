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
 * [$Author: ezamora $, $Date: 09-jun-2016]</p>
 */
public class DisponibilidadSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String fechaCita;
    @Getter
    @Setter
    private String codigoUnidaadMedica;
    @Getter
    @Setter
    private String nombreUnidaadMedica;
    @Getter
    @Setter
    private String direccionUnidaadMedica;
    @Getter
    @Setter
    private String codMedico;
    @Getter
    @Setter
    private String nombreMedico;
    @Getter
    @Setter
    private String prioridad;

    public DisponibilidadSalida(String fechaCita, String codigoUnidaadMedica, String nombreUnidaadMedica, String direccionUnidaadMedica, String codMedico, String nombreMedico, String prioridad) {
        this.fechaCita = fechaCita;
        this.codigoUnidaadMedica = codigoUnidaadMedica;
        this.nombreUnidaadMedica = nombreUnidaadMedica;
        this.direccionUnidaadMedica = direccionUnidaadMedica;
        this.codMedico = codMedico;
        this.nombreMedico = nombreMedico;
        this.prioridad = prioridad;
    }

    public DisponibilidadSalida() {
    }
}

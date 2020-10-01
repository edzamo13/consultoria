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
public class PacienteInternadoxDepSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String fechaIngreso;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String tipoDocumento;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String codServicioOrigen;
    @Getter
    @Setter
    private String dependenciaOrigen;
    @Getter
    @Setter
    private String codServicioActual;
    @Getter
    @Setter
    private String estadoInterno;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String dependenciaActual;
    @Getter
    @Setter
    private String ambiente;
    
    public PacienteInternadoxDepSalida() {
        super();
    }

    public PacienteInternadoxDepSalida(String unidadMedica, String fechaIngreso, String historiaClinica, String tipoDocumento, String cedula, String nombre, String codServicioOrigen, String dependenciaOrigen, String codServicioActual, String estadoInterno, String estado, String dependenciaActual, String ambiente) {
        this.unidadMedica = unidadMedica;
        this.fechaIngreso = fechaIngreso;
        this.historiaClinica = historiaClinica;
        this.tipoDocumento = tipoDocumento;
        this.cedula = cedula;
        this.nombre = nombre;
        this.codServicioOrigen = codServicioOrigen;
        this.dependenciaOrigen = dependenciaOrigen;
        this.codServicioActual = codServicioActual;
        this.estadoInterno = estadoInterno;
        this.estado = estado;
        this.dependenciaActual = dependenciaActual;
        this.ambiente = ambiente;
    }

    
    
}

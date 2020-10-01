package ec.gob.iessHcam.ws.gestionAs400;

/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase que determina los parámetros de salida del Web Service.
 * </b>
 *
 * @author ezamoram
 * <p>
 * [$Author: ezamoram $, $Date: 23/03/2016]</p>
 */
public class PacienteHospitalizadoSalida implements Serializable {

    private static final long serialVersionUID = -1912979416331865052L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String codDepOrigen;
    @Getter
    @Setter
    private String nombreDepOrigen;
    @Getter
    @Setter
    private String codDepActual;
    @Getter
    @Setter
    private String nombreDepActual;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String descripcionEstado;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String habitacion;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String fechaIngreso;
    
    /**
     *
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>
     * [$Author: laguirrec $, $Date: 10/06/2016]</p>
     */
    public PacienteHospitalizadoSalida() {
    }

    public PacienteHospitalizadoSalida(String unidadMedica, String codDepOrigen, String nombreDepOrigen, String codDepActual, String nombreDepActual, String estado, String descripcionEstado, String cedula, String historiaClinica, String habitacion, String nombre, String fechaIngreso) {
        this.unidadMedica = unidadMedica;
        this.codDepOrigen = codDepOrigen;
        this.nombreDepOrigen = nombreDepOrigen;
        this.codDepActual = codDepActual;
        this.nombreDepActual = nombreDepActual;
        this.estado = estado;
        this.descripcionEstado = descripcionEstado;
        this.cedula = cedula;
        this.historiaClinica = historiaClinica;
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

}

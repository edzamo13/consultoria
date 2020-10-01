/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.modulo.enfermeria;

import ec.gob.iessHcam.ws.listaEsperaCirugia.Diagnostico;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Incluir aquí la descripción de la clase.</b>
 *
 * @author dtapiam@iess.gob.ec
 * @version 1.0 (Revisión)
 * @since 1.0
 * <p>
 * [Author: Daniel Tapia, Date: 23/02/2017]
 * </p>
 */
public class PacienteHOEnfermeriaSalida implements Serializable {

    private static final long serialVersionUID = -1819857853978128332L;

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
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String edad;
    @Getter
    @Setter
    private String edadDias;
    @Getter
    @Setter
    private String edadM;
    @Getter
    @Setter
    private String edadD;
    @Getter
    @Setter
    private List<Diagnostico> diagnosticos;

    /**
     * <b>método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 21/06/2017]
     * </p>
     *
     */
    public PacienteHOEnfermeriaSalida() {
        //vacio
    }

    public PacienteHOEnfermeriaSalida(String unidadMedica, String codDepOrigen,
            String nombreDepOrigen, String codDepActual, String nombreDepActual,
            String estado, String descripcionEstado, String cedula,
            String historiaClinica, String habitacion, String nombre,
            String fechaIngreso, String fechaNacimiento, String edad,
            String edadDias, String edadM, String edadD) {
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
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.edadDias = edadDias;
        this.edadM = edadM;
        this.edadD = edadD;
    }
}

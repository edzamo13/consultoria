/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.gestionAs400;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 16-may-2016]</p>
 */
public class MovimientosHospitalizacionSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String histClinica;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String fechaIngreso;
    @Getter
    @Setter
    private String horaIngreso;
    @Getter
    @Setter
    private String fechaAlta;
    @Getter
    @Setter
    private String horaAlta;
    @Getter
    @Setter
    private String motivoAlta;
    @Getter
    @Setter
    private String codMedicoOrdena;
    @Getter
    @Setter
    private String codMedicoTratante;
    @Getter
    @Setter
    private String dependenciaOrigen;
    @Getter
    @Setter
    private String habitacionOrigen;
    @Getter
    @Setter
    private String camaOrigen;
    @Getter
    @Setter
    private String dependenciaActual;
    @Getter
    @Setter
    private String habitacionActual;
    @Getter
    @Setter
    private String camaActual;
    @Getter
    @Setter
    private String estadoClinico;
    @Getter
    @Setter
    private String estadoInternacion;
    @Getter
    @Setter
    private String codDiagnostico1;
    
    @Getter
    @Setter
    private String codDiagnostico2;
    
    @Getter
    @Setter
    private String codDiagnostico3;
    
    @Getter
    @Setter
    private List<DiagnosticoSalida> diagnosticos;

    public MovimientosHospitalizacionSalida(String unidadMedica, String histClinica, String nombre, String fechaIngreso, String horaIngreso, String fechaAlta, String horaAlta, String motivoAlta, String codMedicoOrdena, String codMedicoTratante, String dependenciaOrigen, String habitacionOrigen, String camaOrigen, String dependenciaActual, String habitacionActual, String camaActual, String estadoClinico, String estadoInternacion, String codDiagnostico1, String codDiagnostico2, String codDiagnostico3) {
        this.unidadMedica = unidadMedica;
        this.histClinica = histClinica;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaAlta = fechaAlta;
        this.horaAlta = horaAlta;
        this.motivoAlta = motivoAlta;
        this.codMedicoOrdena = codMedicoOrdena;
        this.codMedicoTratante = codMedicoTratante;
        this.dependenciaOrigen = dependenciaOrigen;
        this.habitacionOrigen = habitacionOrigen;
        this.camaOrigen = camaOrigen;
        this.dependenciaActual = dependenciaActual;
        this.habitacionActual = habitacionActual;
        this.camaActual = camaActual;
        this.estadoClinico = estadoClinico;
        this.estadoInternacion = estadoInternacion;
        this.codDiagnostico1 = codDiagnostico1;
        this.codDiagnostico2 = codDiagnostico2;
        this.codDiagnostico3 = codDiagnostico3;
    }

    
    
    public MovimientosHospitalizacionSalida() {
        
    }

}

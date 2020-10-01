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
public class HospitalizacionSalida implements Serializable {

    private static final long serialVersionUID = 6355444685829133592L;

    @Getter
    @Setter
    private String unidadMedica;
    @Getter
    @Setter
    private String histClinica;
    @Getter
    @Setter
    private String numCaso;
    @Getter
    @Setter
    private String fechaIngreso;
    @Getter
    @Setter
    private String horaIngreso;
    @Getter
    @Setter
    private String dependenciaIngreso;
    @Getter
    @Setter
    private String fechaAlta;
    @Getter
    @Setter
    private String horaAlta;
    @Getter
    @Setter
    private String dependenciaAlta;
    @Getter
    @Setter
    private String motivoAlta;
    @Getter
    @Setter
    private String soat;
    @Getter
    @Setter
    private List<MovimientosHospitalizacionSalida> movimientosHospitalizacion;

    public HospitalizacionSalida(String unidadMedica, String histClinica, String numCaso, String fechaIngreso, String horaIngreso, String dependenciaIngreso, String fechaAlta, String horaAlta, String dependenciaAlta, String motivoAlta, String soat) {
        this.unidadMedica = unidadMedica;
        this.histClinica = histClinica;
        this.numCaso = numCaso;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.dependenciaIngreso = dependenciaIngreso;
        this.fechaAlta = fechaAlta;
        this.horaAlta = horaAlta;
        this.dependenciaAlta = dependenciaAlta;
        this.motivoAlta = motivoAlta;
        this.soat = soat;
    }

    public HospitalizacionSalida() {
        
    }

}

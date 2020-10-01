/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Pojo con los datos del paciente.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 15/03/2017]
 * </p>
 */
public class PacienteSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String institucion;

    @Getter
    @Setter
    private String unidadOperativa;

    @Getter
    @Setter
    private String codUnidadOp;

    @Getter
    @Setter
    private String codDependencia;

    @Getter
    @Setter
    private String provincia;

    @Getter
    @Setter
    private String canton;

    @Getter
    @Setter
    private String parroquia;

    @Getter
    @Setter
    private String historia;

    @Getter
    @Setter
    private String apellidoPaterno;

    @Getter
    @Setter
    private String apellidoMaterno;

    @Getter
    @Setter
    private String primerNombre;

    @Getter
    @Setter
    private String segundoNombre;

    @Getter
    @Setter
    private String edad;

    @Getter
    @Setter
    private String cedula;

    @Getter
    @Setter
    private String fechaOrden;

    @Getter
    @Setter
    private String horaOrden;

    @Getter
    @Setter
    private String habitacion;

    @Getter
    @Setter
    private String cama;

    @Getter
    @Setter
    private String nombreProfesional;

    @Getter
    @Setter
    private String cedulaProfesional;

    public PacienteSalida() {

    }

    public PacienteSalida(String institucion, String unidadOperativa, String codUnidadOp, String codDependencia, String provincia, String canton, String parroquia, String historia, String apellidoPaterno, String apellidoMaterno, String primerNombre, String segundoNombre, String edad, String cedula, String fechaOrden, String horaOrden, String habitacion, String cama, String nombreProfesional, String cedulaProfesional) {
        this.institucion = institucion;
        this.unidadOperativa = unidadOperativa;
        this.codUnidadOp = codUnidadOp;
        this.codDependencia = codDependencia;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.historia = historia;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaOrden = fechaOrden;
        this.horaOrden = horaOrden;
        this.habitacion = habitacion;
        this.cama = cama;
        this.nombreProfesional = nombreProfesional;
        this.cedulaProfesional = cedulaProfesional;
    }
}

/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.unidadmedica.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase .</b>
 *
 * @author jsaltosbm@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 13/06/2017]
 * </p>
 */
public class CitasSalida implements Serializable {

    private static final long serialVersionUID = 7107702050568937845L;

    @Getter
    @Setter
    private String historiaClinica;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombrePaciente;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String fechaCita;
    @Getter
    @Setter
    private String horaCita;
    @Getter
    @Setter
    private String tipoSeguro;
    @Getter
    @Setter
    private String seguroDescrip;
    @Getter
    @Setter
    private String codigoMedico;
    @Getter
    @Setter
    private String codMedicoAtiende;
    @Getter
    @Setter
    private String cedulaMedico;
    @Getter
    @Setter
    private String nombreMedico;
    @Getter
    @Setter
    private String codEspecialidad;
    @Getter
    @Setter
    private String especialidad;
    @Getter
    @Setter
    private String estadoCalificacion;
    @Getter
    @Setter
    private String codEstadoCita;
    @Getter
    @Setter
    private String estadoCita;

    /**
     * <b>método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 13/06/2017]
     * </p>
     *
     */
    public CitasSalida() {
        //vacio
    }

    /**
     * <b>método .</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 13/06/2017]
     * </p>
     *
     * @param historiaClinica numero hostoria
     * @param cedula cedula
     * @param nombrePaciente nombres
     * @param fechaNacimiento fecha nacimiento
     * @param fechaCita fecha cita
     * @param horaCita hora cita
     * @param tipoSeguro tipo seguro
     * @param seguroDescrip descripcion seguro
     * @param codigoMedico codigo del medico
     * @param codMedicoAtiende codigo del medico atiende
     * @param cedulaMedico cedula del medico
     * @param nombreMedico nombre del medico
     * @param codEspecialidad codigo de especialidad
     * @param especialidad especialidad
     * @param estadoCalificacion estado calificacion
     * @param codEstadoCita codigo de estado cita
     * @param estadoCita estado cita
     */
    public CitasSalida(String historiaClinica, String cedula,
            String nombrePaciente, String fechaNacimiento,
            String fechaCita, String horaCita, String tipoSeguro, String seguroDescrip,
            String codigoMedico, String codMedicoAtiende, String cedulaMedico,
            String nombreMedico, String codEspecialidad,
            String especialidad, String estadoCalificacion, String codEstadoCita,
            String estadoCita) {
        this.historiaClinica = historiaClinica;
        this.cedula = cedula;
        this.nombrePaciente = nombrePaciente;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.tipoSeguro = tipoSeguro;
        this.seguroDescrip = seguroDescrip;
        this.codigoMedico = codigoMedico;
        this.codMedicoAtiende = codMedicoAtiende;
        this.cedulaMedico = cedulaMedico;
        this.nombreMedico = nombreMedico;
        this.codEspecialidad = codEspecialidad;
        this.especialidad = especialidad;
        this.estadoCalificacion = estadoCalificacion;
        this.codEstadoCita = codEstadoCita;
        this.estadoCita = estadoCita;
    }

}

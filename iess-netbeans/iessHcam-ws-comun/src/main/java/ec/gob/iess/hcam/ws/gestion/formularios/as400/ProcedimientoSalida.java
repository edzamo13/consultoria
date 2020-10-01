/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase base para objetos tipo procedimientos.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 12/04/2017]
 * </p>
 */
public class ProcedimientoSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codServicio;
    @Getter
    @Setter
    private String nomServicio;

    @Getter
    @Setter
    private String codSubServicio;
    @Getter
    @Setter
    private String nomSubServicio;

    @Getter
    @Setter
    private String codNivel;
    @Getter
    @Setter
    private String nomNivel;

    @Getter
    @Setter
    private String codProcedimiento;
    @Getter
    @Setter
    private String nomProcedimiento;

    /**
     * <b>método constructor vacío.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 12/04/2017]
     * </p>
     *
     */
    public ProcedimientoSalida() {
    }

    /**
     * <b>método constructor de la clase.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 12/04/2017]
     * </p>
     *
     * @param codServicio código del servicio
     * @param nomServicio nombre del servicio
     * @param codSubServicio código del subservicio
     * @param nomSubServicio nombre del subservicio
     * @param codNivel código del nivel
     * @param nomNivel nombre del nivel
     * @param codProcedimiento código del procedimiento
     * @param nomProcedimiento nombre del procedimiento
     */
    public ProcedimientoSalida(String codServicio, String nomServicio, String codSubServicio, String nomSubServicio, String codNivel, String nomNivel, String codProcedimiento, String nomProcedimiento) {
        this.codServicio = codServicio;
        this.nomServicio = nomServicio;
        this.codSubServicio = codSubServicio;
        this.nomSubServicio = nomSubServicio;
        this.codNivel = codNivel;
        this.nomNivel = nomNivel;
        this.codProcedimiento = codProcedimiento;
        this.nomProcedimiento = nomProcedimiento;
    }

}

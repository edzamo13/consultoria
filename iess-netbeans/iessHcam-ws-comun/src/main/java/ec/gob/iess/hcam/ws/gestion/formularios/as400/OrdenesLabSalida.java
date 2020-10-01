/*
 * Copyright 2017 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.hcam.ws.gestion.formularios.as400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>clase Pojo con las ordenes de la consulta del servicio.</b>
 *
 * @author jsaltosb@iess.gob.ec
 * <p>
 * [Author: Gabriel Saltos, Date: 11/05/2017]
 * </p>
 */
public class OrdenesLabSalida implements Serializable {

    private static final long serialVersionUID = -6094633682555503187L;

    @Getter
    @Setter
    private String codDepen;

    @Getter
    @Setter
    private String depencia;

    @Getter
    @Setter
    private String numOrden;

    @Getter
    @Setter
    private String fechaOrden;

    @Getter
    @Setter
    private String horaOrden;

    @Getter
    @Setter
    private String numHistoria;

    @Getter
    @Setter
    private String cedula;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String medico;

    @Getter
    @Setter
    private String cedMedico;

    /**
     * <b>método constructor.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 11/05/2017]
     * </p>
     *
     */
    public OrdenesLabSalida() {
        //vacio
    }

    /**
     * <b>método constructor de la clase.</b>
     * <p>
     * [Autor: Gabriel Saltos, Date: 11/05/2017]
     * </p>
     *
     * @param codDepen codigo dependencia
     * @param depencia dependencia
     * @param numOrden numero orden
     * @param fechaOrden fecha orden
     * @param horaOrden hora orden
     * @param numHistoria numero de historia
     * @param cedula cedula afiliado
     * @param nombre nombre afiliado
     * @param medico nombre medico
     * @param cedMedico cedula medico
     */
    public OrdenesLabSalida(String codDepen, String depencia, String numOrden, String fechaOrden, String horaOrden, String numHistoria, String cedula, String nombre, String medico, String cedMedico) {
        this.codDepen = codDepen;
        this.depencia = depencia;
        this.numOrden = numOrden;
        this.fechaOrden = fechaOrden;
        this.horaOrden = horaOrden;
        this.numHistoria = numHistoria;
        this.cedula = cedula;
        this.nombre = nombre;
        this.medico = medico;
        this.cedMedico = cedMedico;
    }

}

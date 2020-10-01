/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 *
 * <b>
 * Enumerador para ambiente de desarrollo a trabajar.
 * </b>
 * <p>
 * [$Author: ezamora $, $Date: 6/04/2017]</p>
 */
public enum AmbienteEnum {

    AMBIENTE_DESARROLLO("DESARROLLO", " Ambiente desarrollo"),
    AMBIENTE_CAPACITACION("CAPACITACION", "Ambiente pruebas"),
    AMBIENTE_PRODUCCION("PRODUCCION", "Ambiente Producción");

    @Getter
    private String ambiente;
    @Getter
    private String descripcion;

    /**
     *
     * <b>
     * Contructor de clase inicizalizador .
     * </b>
     * <p>
     * [$Author: ezamora $, $Date: 02/02/2017]</p>
     */
    private AmbienteEnum(String ambiente, String descripcion) {
        this.ambiente = ambiente;
        this.descripcion = descripcion;
    }

}

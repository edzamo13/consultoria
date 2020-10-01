/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para representar todos los tipos de estados de un aplicativo. </b>
 *
 * @author fochoac
 *         <p>
 *         [$Author: fochoac $, $Date: 22/07/2015]
 *         </p>
 * @param <T>
 */
public enum EstadoEnum {

    ACTIVO("A", "Estado activo"), INACTIVO("I", "Estado inactivo"), VERDADERO("1", "true"), FALSO("0", "falso"), VISIBLE("1", "true"), INVISIBLE("0", "false"), LOGUEADO("1", "LOGUEADO"), NO_LOGUEADO("0", "NO LOGUEADO");

    @Getter
    private String estado;
    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param estado
     *            estado
     * @param descripcion
     *            del estado
     */
    private EstadoEnum(String estado, String descripcion) {
        this.estado = estado;
        this.descripcion = descripcion;
    }

}

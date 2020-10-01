/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.enumeraciones;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <b> Clase para manejar valores constantes del módulo de Fondos de Reserva.
 * </b>
 *
 * @author gvega
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: gvega $, $Date: 11/8/2015 $]
 * </p>
 */
public enum ConstantesEnum {

    CONSTANTE("VALOR");

    @Getter
    @Setter
    private String codigo;

    /**
     *
     * <b> Constructor ConstantesEnum. </b>
     * <p>
     * [Author: gvega, Date: 11/08/2015]
     * </p>
     *
     * @param codigo Codigo
     */
    ConstantesEnum(String codigo) {
        setCodigo(codigo);
    }
}

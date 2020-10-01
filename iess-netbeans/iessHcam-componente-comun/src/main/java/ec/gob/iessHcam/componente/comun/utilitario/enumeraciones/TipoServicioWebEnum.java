/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para controlar los tipos de un servicio web </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 29/7/2015 $]
 *          </p>
 */
public enum TipoServicioWebEnum {

    INTERNO("INT"), EXTERNO("EXT"), MIXTO("MIX");
    @Getter
    private String tipo;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param tipo de servicio
     */
    private TipoServicioWebEnum(String tipo) {
        this.tipo = tipo;
    }

}

/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 *
 * <b>
 * Incluir aqui­ la descripcion del metodo.
 * </b>
 * <p>
 * [$Author: ezamoram $, $Date: 20/12/2016]</p>
 */
public enum CatalogoEnum {

    CORRECTO("C", "CATALOGO"), ;
    @Getter
    private String codigo;
    @Getter
    private String mensaje;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param codigo
     *            de retorno
     * @param mensaje
     *            de retorno
     */
    private CatalogoEnum(final String codigo, final String mensaje) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

  

}

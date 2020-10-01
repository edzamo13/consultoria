/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 5/8/2015 $]
 *          </p>
 */
public enum GeneroEnum {
    MASCULINO("1", "MASCULINO"), FEMENINO("2", "FEMENINO");

    @Getter
    private String valor;
    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param valor
     *            identificacion del genero
     * @param descripcion
     *            del genero
     */
    private GeneroEnum(String valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }
}

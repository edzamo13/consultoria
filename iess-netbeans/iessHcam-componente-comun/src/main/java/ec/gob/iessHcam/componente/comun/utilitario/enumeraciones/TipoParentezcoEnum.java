/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para determinar el parentezco del afiliado. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 14/12/2015 $]
 *          </p>
 */
public enum TipoParentezcoEnum {

    CONYUGE("CON", "Cónyuge"), CONVIVIENTE("CNV", "Conviviente o Unión Libre"), HIJO("HIJ", "Hijo/a");
    @Getter
    private String codigo;
    @Getter
    private String descripcion;

    /**
     * @param codigo de la enumeracion
     * @param descripcion del tipo
     */
    private TipoParentezcoEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

}

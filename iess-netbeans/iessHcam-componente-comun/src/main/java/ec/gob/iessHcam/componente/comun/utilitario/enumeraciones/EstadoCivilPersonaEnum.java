/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
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
 *          [$Author: fochoac $, $Date: 2/1/2016 $]
 *          </p>
 */
public enum EstadoCivilPersonaEnum {
    SOLTERO("SOLTERO"), CASADO("CASADO"), VIUDO("VIUDO"), DIVORCIADO("DIVORCIADO"), UNION_LIBRE("UNIÓN LIBRE"), NO_DEFINIDO("NO DEFINIDO");
    @Getter
    private String estado;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 2/1/2016]
     * </p>
     *
     * @param estado
     */
    private EstadoCivilPersonaEnum(String estado) {
        this.estado = estado;
    }

}

/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import lombok.Getter;

/**
 * <b> Enumeracion para definir la orientacion del reporte </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 17/9/2015 $]
 *          </p>
 */
public enum OrientacionReporteEnum {
    LARGO("LARGO"), ANCHO("ANCHO");
    
    @Getter
    private String valor;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 17/9/2015]
     * </p>
     *
     */
    private OrientacionReporteEnum(final String orientacion) {
        this.valor = orientacion;
    }
}

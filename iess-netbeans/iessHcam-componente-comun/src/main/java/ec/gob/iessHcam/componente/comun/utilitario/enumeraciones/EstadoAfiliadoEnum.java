/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para manejar los estados de los afiliados. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 5/8/2015 $]
 *          </p>
 */
public enum EstadoAfiliadoEnum {
    CESANTE("CES", "Cesante"), PENSIONISTA("PEN", "Pensionista"), JUBILADO("JUB", "Jubilado"), SOLICITANTE("SOL",
            "Solicitante"), ACTIVO("ACT", "Activo"), INACTIVO("INA", "Inactivo"), BLOQUEO_DIARIO("Z", "Diario"), BLOQUEO_DEFINITIVO(
            "X", "Definitivo");
    @Getter
    private String codigo;

    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]
     * </p>
     *
     * @param codigo
     *            del estado de afiliado
     * @param descripcion
     *            del estado del afiliado
     */
    private EstadoAfiliadoEnum(String codigo, String descripcion) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
}

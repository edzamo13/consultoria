/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para almacenar los codigos de los correos a enviar por los sistemas. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 23/9/2015 $]
 *          </p>
 */
public enum ObjetoSesionEnum {

    /**
    * 
    */
    MAPA_URLS_SERVICIOS("MAPA_URLS_SERVICIOS", "Clave de acceso la variable de sesion de los urls de servicios"),
    MAPA_URLS_MENUS("MAPA_URLS_MENUS", "Clave de acceso la variable de sesion de los urls de menus")
    ;

    @Getter
    private String codigo;
    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 23/9/2015]
     * </p>
     *
     * @param codigo
     *            de la tabla
     * @param descripcion
     *            del item
     */
    private ObjetoSesionEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}

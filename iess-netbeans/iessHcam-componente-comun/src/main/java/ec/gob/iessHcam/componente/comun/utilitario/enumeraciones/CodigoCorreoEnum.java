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
 *          [$Author: ezamoram $, $Date: 14/09/2016 $]
 *          </p>
 */
public enum CodigoCorreoEnum {

  
    /**
     * Codigo para enviar notificacion de Arhivo Clinico
     */
    MAIL_ENV_DER("NACL01", "Codigo para envio de notificaciones Achivo Clinico");

    @Getter
    private String codigo;
    @Getter
    private String descripcion;

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: ezamoram, Date: 14/09/2016]
     * </p>
     *
     * @param codigo
     *            de la tabla
     * @param descripcion
     *            del item
     */
    private CodigoCorreoEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}

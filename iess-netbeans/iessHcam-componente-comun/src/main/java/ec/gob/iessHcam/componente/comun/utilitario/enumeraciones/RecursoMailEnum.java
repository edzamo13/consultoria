/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import lombok.Getter;

/**
 * <b> Enumeracion para representar . </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 25/8/2015 $]
 *          </p>
 */
public enum RecursoMailEnum {

    JAVA_SESION_MAIL("java/notificacionesSesionMail");

    @Getter
    private String valor;

   
    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>[Author: fochoac, Date: 10/9/2015]</p>
     *
     * @param valor url del recurso
     */ 
    private RecursoMailEnum(String valor) {
        this.valor = valor;
    }
}

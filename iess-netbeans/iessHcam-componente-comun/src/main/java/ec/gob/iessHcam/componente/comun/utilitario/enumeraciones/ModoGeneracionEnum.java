/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import ec.gob.iessHcam.componente.comun.utilitario.RandomicoUtil;

/**
 * <b> Enumeracion para determinar los tipos de cadenas a utilizar con la clase {@link RandomicoUtil}. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 19/8/2015 $]
 *          </p>
 */
public enum ModoGeneracionEnum {

    /**
     * Modo de trabajo solo con caracteres A-Z y a-z
     */
    ALFA,

    /**
     * Modo de trabajo con el alfabeto completo incluido numeros
     */
    ALFA_NUMERICO,

    /**
     * Modo de trabajo solo con numeros
     * 
     */
    NUMERICO,

    /**
     * Modod e trabajo con _.@&$/%
     */
    CARACTERES_EXPECIALES
}

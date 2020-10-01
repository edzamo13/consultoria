/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;
/**
 * <b>
 *   Parámetro de entrada para salida para descarga de orden desde CEDDTA.MISDTL3
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 25/02/2016]</p>
 */
public class OrdenRespuesta {

    @Getter
    @Setter
    private String numeroRegistros;
    @Getter
    @Setter
    private String error;
    
}

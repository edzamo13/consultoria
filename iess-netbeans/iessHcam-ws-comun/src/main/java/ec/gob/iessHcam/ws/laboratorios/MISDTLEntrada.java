/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.laboratorios;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Parámetro de entrada para MISDTL.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>[$Author: fsalazarn@iess.gob.ec $, $Date: 19/02/2016]</p>
 */
public class MISDTLEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;
    
    @Getter
    @Setter
    private String dlunme;
    
    @Getter
    @Setter
    private String dlnuor;
    
}

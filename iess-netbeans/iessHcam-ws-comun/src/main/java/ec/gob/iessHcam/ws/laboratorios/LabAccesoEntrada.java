/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.ws.laboratorios;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Parámetro de entrada para verificación de IP dentro de un rango determinado.
 * </b>
 *
 * @author fsalazarn@iess.gob.ec
 * <p>
 * [$Author: fsalazarn@iess.gob.ec $, $Date: 25/02/2016]</p>
 */

public class LabAccesoEntrada {

    @Getter
    @Setter
    private String ip;
    
    @Getter
    @Setter
    private String codigoUnme;

    public LabAccesoEntrada(String ip, String codigoUnme) {
        this.ip = ip;
        this.codigoUnme = codigoUnme;
    }
    
    public LabAccesoEntrada() {

    }

}

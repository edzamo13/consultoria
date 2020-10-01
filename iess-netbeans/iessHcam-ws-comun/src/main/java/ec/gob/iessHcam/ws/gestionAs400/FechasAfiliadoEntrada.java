/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.ws.gestionAs400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *  * <b>
 *  *   Incluir aqui la descripción de la clase.  * </b>
 *  *
 *  * @author user
 
 * <p>
 * [$Author: fquisiguina $, $Date: date]</p>
 
 */
public class FechasAfiliadoEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String codigoUnidadMedica;

    @Getter
    @Setter
    private String historiaClinica;
    

    public FechasAfiliadoEntrada() {
    }
}


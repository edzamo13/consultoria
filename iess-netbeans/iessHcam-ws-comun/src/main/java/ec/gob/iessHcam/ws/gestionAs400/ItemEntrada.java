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
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 02-jun-2016]</p>
 */
public class ItemEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String codigoUnidadMedica;
    @Getter
    @Setter
    private String codigoItemGenerico;
    
    public ItemEntrada() {
    }
}


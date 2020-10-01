/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.componente.comun.utilitario;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Desarrollo
 * <p>[$Author: Desarrollo $, $Date: 06-abr-2016]</p>
 */
public class EdadPojo {

    @Getter
    @Setter
    private Integer anios;
    
    @Getter
    @Setter
    private Integer meses;
    
    @Getter
    @Setter
    private Integer dias;

    @Getter
    @Setter
    private String descripcionEdad;
    
    public EdadPojo() {
    }
    
    
}


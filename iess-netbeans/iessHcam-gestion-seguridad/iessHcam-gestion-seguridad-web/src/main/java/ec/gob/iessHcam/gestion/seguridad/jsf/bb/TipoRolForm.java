/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.gestion.seguridad.jsf.bb;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Objeto para formulario de ingreso de tipos de roles
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 07-mar-2016]</p>
 */
@Dependent
public class TipoRolForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String descripcion;
        
    @Getter
    @Setter
    private String estado;
    
}


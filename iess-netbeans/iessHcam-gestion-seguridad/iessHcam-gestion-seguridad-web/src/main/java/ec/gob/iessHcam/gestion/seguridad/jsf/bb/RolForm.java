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

import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Tiporol;
import java.io.Serializable;
import java.util.List;
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
public class RolForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Integer idTipoRol;
     
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String descripcion;
        
    @Getter
    @Setter
    private String estado;

    @Getter
    @Setter
    private List<Rol> roles;

    @Getter
    @Setter
    private Rol rol;

    @Getter
    @Setter
    private List<Tiporol> tiposRoles;

    @Getter
    @Setter
    private Tiporol tipoRol;
}


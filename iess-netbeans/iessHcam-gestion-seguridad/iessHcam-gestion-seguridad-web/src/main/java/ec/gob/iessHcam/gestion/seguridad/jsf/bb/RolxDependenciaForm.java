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

import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxdependencia;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 21-mar-2016]</p>
 */
@Dependent
public class RolxDependenciaForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private List<Institucion> instituciones;

    @Getter
    @Setter
    private Institucion institucion;

    @Getter
    @Setter
    private List<Rol> roles;

    @Getter
    @Setter
    private Rol rol;

    @Getter
    @Setter
    private List<Rolxdependencia> dependenciasxRol;

    @Getter
    @Setter
    private Rolxdependencia dependenciaxRol;
    
    @Getter
    @Setter
    private List<Dependencia> dependencias;

    @Getter
    @Setter
    private Dependencia dependencia;

    @Getter
    @Setter
    private Boolean muestraPanel;
    
    @Getter
    @Setter
    private Boolean inactivaComponente;
    
    @Getter
    @Setter
    private String estado;
  
}


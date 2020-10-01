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

import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Menu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.TreeNode;

/**
 * <b>
 *   Objeto que se utiliza para ser llenados por formularios de ingreso de Aplicaciones
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 08-mar-2016]</p>
 */
@Dependent
public class MenuForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Integer idPadre;
    
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private Integer orden;
    
    @Getter
    @Setter
    private String url;
    
    @Getter
    @Setter
    private Integer isFinal;
    
    @Getter
    @Setter
    private String estado;
    
    @Getter
    @Setter
    private List<Institucion> instituciones;

    @Getter
    @Setter
    private Institucion institucion;

    @Getter
    @Setter
    private List<Dependencia> dependencias;

    @Getter
    @Setter
    private Dependencia dependencia;

    @Getter
    @Setter
    private List<Aplicacion> aplicaciones;

    @Getter
    @Setter
    private Aplicacion aplicacion;
    
    @Getter
    @Setter
    private List<Menu> menus;

    @Getter
    @Setter
    private Menu menu;
    
    @Getter
    @Setter
    private TreeNode root;
     
    @Getter
    @Setter
    private TreeNode selectedNode;
     
    @Getter
    @Setter
    private Boolean muestraPanel;
}


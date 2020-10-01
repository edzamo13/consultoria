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
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.TreeNode;

/**
 * <b>
 *   Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author Desarrollo
 * <p>[$Author: Desarrollo $, $Date: 04-mar-2016]</p>
 */
@Dependent
public class DependenciaForm implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String tipoDependencia;
    
    @Getter
    @Setter
    private Integer idPadre;
    
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
    private TreeNode root;
     
    @Getter
    @Setter
    private TreeNode selectedNode;
     
    @Getter
    @Setter
    private Boolean muestraPanel;
}


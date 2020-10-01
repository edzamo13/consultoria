package iesshcam.plantilla.jsf.bb;

/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */


import ec.gob.iessHcam.ws.autentificacion.MenuSalida;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.TreeNode;
import org.primefaces.model.menu.MenuModel;

/**
 * <b> Comentario PlantillaBb. </b>
 *
 * @author ezamora
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: gvega $, $Date: 21/7/2015 $]
 * </p>
 */
@Dependent
public class PlantillaBb implements Serializable {

    private static final long serialVersionUID = 4771202443169902266L;

    @Getter
    @Setter
    private UsuarioSalida salida;
    @Getter
    @Setter
    private List<MenuSalida> menusH;
    @Getter
    @Setter
    private List<MenuSalida> menusN;

    @Getter
    @Setter
    private TreeNode root;
    
    @Getter
    @Setter
    private String url;
    
    @Getter
    @Setter
    private Boolean dialogEspera;
    
    @Getter
    @Setter
    private List<MenuSalida> listaMenu;
    
    @Getter
    @Setter
    private String descripcionUnme;
    
    @Getter
    @Setter
    List<String> etiquetas;
    
    @Getter
    @Setter
    private String breadCrumb;
    
    @Getter
    @Setter
    private MenuModel breadcrumbmodel;
}

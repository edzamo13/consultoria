/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.bb;

import ec.gob.iessHcam.ws.autentificacion.MenuSalida;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.TreeNode;


/**
 * <b>
 * Clase  backing bean que respalda al controlador.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 26/01/2016]</p>
 */
@Dependent
public class PrincipalBb implements Serializable {

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

}

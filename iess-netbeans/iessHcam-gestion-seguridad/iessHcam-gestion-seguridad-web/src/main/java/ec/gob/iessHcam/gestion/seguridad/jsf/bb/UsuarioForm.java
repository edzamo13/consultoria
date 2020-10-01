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

import ec.gob.iessHcam.gestion.seguridad.modelo.Usuario;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaSalida;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;

/**
 * <b>
 *   Objeto que se utiliza para ser llenados por formularios de ingreso de Aplicaciones
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>[$Author: Jorge Zúñiga $, $Date: 25-feb-2016]</p>
 */
@Dependent
public class UsuarioForm implements Serializable  {
    
    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Integer idUsuario;
    
    @Getter
    @Setter
    private String nombrePersona;
    
    @Getter
    @Setter
    private String nombreUsuario;
    
    @Getter
    @Setter
    private String identificacion;
    
    @Getter
    @Setter
    private String email;
    
    @Getter
    @Setter
    private String unme;
    
    @Getter
    @Setter
    private String telefono;
    
    @Getter
    @Setter
    private Integer estado;
    
    @Getter
    @Setter
    private List<Usuario> usuarios;

    @Getter
    @Setter
    private Usuario usuario;
    
    @Getter
    @Setter
    private List<UnidadMedicaSalida> unidadesMedicas;

    @Getter
    @Setter
    UploadedFile imagen;
  
    @Getter
    @Setter
    private Boolean muestraPanel;
    
    @Getter
    @Setter
    private String tipoBusqueda;
    
    @Getter
    @Setter
    private String busqueda;
    
    
    public UsuarioForm() {
    }
    
}
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.componente.seguridad.jsf.bb;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

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
    private String usuario;
    
    @Getter
    @Setter
    private String nombrePersona;
    
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
    private String nuevoPass;
    
    @Getter
    @Setter
    private String repitePass;

    public UsuarioForm() {
    }
    
}
    
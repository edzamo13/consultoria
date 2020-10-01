/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.gestionAs400Externo.actDatos;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class ActDatosAfiliadoEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;
    
    
    @Getter
    @Setter
    private String cedula; 
    
    @Getter
    @Setter
    private String estadoCivil; 
    
    @Getter
    @Setter
    private Integer provincia; 
    
    @Getter
    @Setter
    private Integer canton; 
    
    @Getter
    @Setter
    private Integer parroquia; 
    
    @Getter
    @Setter
    private String direccion; 
    
    @Getter
    @Setter
    private Integer telefono; 
    
    @Getter
    @Setter
    private Integer resideDesde; 
    
    @Getter
    @Setter
    private String relacionRef; 
    
    @Getter
    @Setter
    private String nombreRef; 
    
    @Getter
    @Setter
    private String direccionRef; 
    
    @Getter
    @Setter
    private Integer  provinciaRef; 
    
    @Getter
    @Setter
    private Integer cantonRef; 
    
    @Getter
    @Setter
    private Integer parroquiaRef; 
    
    @Getter
    @Setter
    private Integer telefonoRef; 
    
    @Getter
    @Setter
    private String instruccion; 
    
    @Getter
    @Setter
    private String ocupacionActual; 
    
    @Getter
    @Setter
    private String profesion; 
    
    @Getter
    @Setter
    private String lugarTrabajo; 
    
    @Getter
    @Setter
    private String direccionTrab; 
    
    @Getter
    @Setter
    private Integer provinciaTrab; 
    
    @Getter
    @Setter
    private Integer cantonTrab; 
    
    @Getter
    @Setter
    private Integer parroquiaTrab; 
    
    @Getter
    @Setter
    private Integer telefonoTrab; 
    
    @Getter
    @Setter
    private String observaciones; 
    
    @Getter
    @Setter
    private Integer nivSeguridad; 
    
    @Getter
    @Setter
    private String usuarioModi;
    
    @Getter
    @Setter
    private String usuarioConex;
    
    @Getter
    @Setter
    private String ipUsuario; 
}

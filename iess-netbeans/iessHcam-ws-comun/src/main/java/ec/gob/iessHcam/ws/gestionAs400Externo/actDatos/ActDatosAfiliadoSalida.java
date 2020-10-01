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
public class ActDatosAfiliadoSalida implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String estado; 
    
    @Getter
    @Setter
    private String unidadMedica; 
    
    @Getter
    @Setter
    private String historia; 
    
    @Getter
    @Setter
    private String estadoCivil; 
    
    @Getter
    @Setter
    private String provincia; 
    
    @Getter
    @Setter
    private String canton; 
    
    @Getter
    @Setter
    private String parroquia; 
    
    @Getter
    @Setter
    private String direccion; 
    
    @Getter
    @Setter
    private String telefono; 
    
    @Getter
    @Setter
    private String resideDesde; 
    
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
    private String  provinciaRef; 
    
    @Getter
    @Setter
    private String cantonRef; 
    
    @Getter
    @Setter
    private String parroquiaRef; 
    
    @Getter
    @Setter
    private String telefonoRef; 
    
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
    private String provinciaTrab; 
    
    @Getter
    @Setter
    private String cantonTrab; 
    
    @Getter
    @Setter
    private String parroquiaTrab; 
    
    @Getter
    @Setter
    private String telefonoTrab; 
    
    @Getter
    @Setter
    private String observaciones; 
    
    @Getter
    @Setter
    private String nivSeguridad; 
    
    @Getter
    @Setter
    private String usuario; 
    
    @Getter
    @Setter
    private String fechaCreacion; 
    
    @Getter
    @Setter
    private String horaActualizacion; 
    
    @Getter
    @Setter
    private String pantallaActualizacion; 

    public ActDatosAfiliadoSalida() {
    }

    public ActDatosAfiliadoSalida(String estado, String unidadMedica, String historia, String estadoCivil, String provincia, String canton, String parroquia, String direccion, String telefono, String resideDesde, String relacionRef, String nombreRef, String direccionRef, String provinciaRef, String cantonRef, String parroquiaRef, String telefonoRef, String instruccion, String ocupacionActual, String profesion, String lugarTrabajo, String direccionTrab, String provinciaTrab, String cantonTrab, String parroquiaTrab, String telefonoTrab, String observaciones, String nivSeguridad, String usuario, String fechaCreacion, String horaActualizacion, String pantallaActualizacion) {
        this.estado = estado;
        this.unidadMedica = unidadMedica;
        this.historia = historia;
        this.estadoCivil = estadoCivil;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.resideDesde = resideDesde;
        this.relacionRef = relacionRef;
        this.nombreRef = nombreRef;
        this.direccionRef = direccionRef;
        this.provinciaRef = provinciaRef;
        this.cantonRef = cantonRef;
        this.parroquiaRef = parroquiaRef;
        this.telefonoRef = telefonoRef;
        this.instruccion = instruccion;
        this.ocupacionActual = ocupacionActual;
        this.profesion = profesion;
        this.lugarTrabajo = lugarTrabajo;
        this.direccionTrab = direccionTrab;
        this.provinciaTrab = provinciaTrab;
        this.cantonTrab = cantonTrab;
        this.parroquiaTrab = parroquiaTrab;
        this.telefonoTrab = telefonoTrab;
        this.observaciones = observaciones;
        this.nivSeguridad = nivSeguridad;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.horaActualizacion = horaActualizacion;
        this.pantallaActualizacion = pantallaActualizacion;
    }
    
    
}

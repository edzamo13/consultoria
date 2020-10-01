/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iess.hcam.ws.huella.digital;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jorge
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String tipoIdentificacion;
    
    @Getter
    @Setter
    private String identificacion;
    
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String estadoEnrolamiento;
    
    @Getter
    @Setter
    private String fechaNacimiento;
    
    @Getter
    @Setter
    private List<Huella> huellas;

    public Persona() {
    }

    public Persona(String tipoIdentificacion, String identificacion, String nombre, String estadoEnrolamiento, String fechaNacimiento) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.estadoEnrolamiento = estadoEnrolamiento;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}

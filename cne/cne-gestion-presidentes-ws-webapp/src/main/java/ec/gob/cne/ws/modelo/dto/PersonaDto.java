/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.modelo.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
public class PersonaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String idPersona;
    @Getter
    @Setter
    private String cedula;
    @Getter
    @Setter
    private String nombres;
    @Getter
    @Setter
    private String apellidos;
    @Getter
    @Setter
    private String fechaNacimiento;
    @Getter
    @Setter
    private String fechaFallecimiento;
    @Getter
    @Setter
    private String religion;
    @Getter
    @Setter
    private String genero;
    @Getter
    @Setter
    private String nacionalidad;
    @Getter
    @Setter
    private String imagen;
  

    public PersonaDto() {
    }

}

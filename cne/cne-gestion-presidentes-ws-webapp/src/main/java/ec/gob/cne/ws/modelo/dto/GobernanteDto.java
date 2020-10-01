/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.modelo.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
public class GobernanteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String idGobernate;
    @Getter
    @Setter
    private String ctgIdTipogobierno;
    @Getter
    @Setter
    private String tituloMandato;
    @Getter
    @Setter
    private String tipoPeriodo;
    @Getter
    @Setter
    private String partidoPolitico;
    @Getter
    @Setter
    private String fechaMandatoinicio;
    @Getter
    @Setter
    private String fechaMandatofin;
    @Getter
    @Setter
    private String fechaCreacionr;
    @Getter
    @Setter
    private String idUsr;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private PersonaDto personaDto;

  

    public GobernanteDto() {
    }
    
    
    
    

}

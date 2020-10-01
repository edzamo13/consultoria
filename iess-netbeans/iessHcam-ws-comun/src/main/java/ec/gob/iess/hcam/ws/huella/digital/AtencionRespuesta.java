/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iess.hcam.ws.huella.digital;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jorge
 */
public class AtencionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String mensaje;

    @Getter
    @Setter
    private Persona medico;
    @Getter
    @Setter
    private Persona paciente;
    
    public AtencionRespuesta() {
    }
    
}

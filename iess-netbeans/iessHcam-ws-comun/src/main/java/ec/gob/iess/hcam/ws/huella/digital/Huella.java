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
 * @author HCAM
 */
public class Huella implements Serializable {

    private static final long serialVersionUID = 1L;

  
    @Getter
    @Setter
    private String huella;
  
    
    public Huella() {
    }

    public Huella(String huella) {
        this.huella = huella;
    }

}


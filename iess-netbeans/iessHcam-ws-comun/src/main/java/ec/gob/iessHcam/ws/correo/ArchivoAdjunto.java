/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.correo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jorge
 */
public class ArchivoAdjunto implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String archivo;
    @Getter
    @Setter
    private String mimeType;

    public ArchivoAdjunto() {
    }
    
    
    
}

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
public class HuellaEntrada implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;

    @Getter
    @Setter
    private String cedula;
    
    @Getter
    @Setter
    private String nombreAfiliado;

    @Getter
    @Setter
    private Integer formato;
    
    @Getter
    @Setter
    private String plantilla;
    
    @Getter
    @Setter
    private int[] Plantilla_MedidaArray;

    public HuellaEntrada() {
    }

}
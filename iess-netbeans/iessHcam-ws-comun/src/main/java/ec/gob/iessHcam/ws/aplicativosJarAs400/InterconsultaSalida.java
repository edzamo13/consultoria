/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.aplicativosJarAs400;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class InterconsultaSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String intClavePrimaria;
    @Getter
    @Setter
    private String intCodigoUnme;
    @Getter
    @Setter
    private String intDependencia;
    @Getter
    @Setter
    private String intDescrDepe;
    @Getter
    @Setter
    private String intMedico;
    @Getter
    @Setter
    private String intIpUsuario;
    @Getter
    @Setter
    private String intPid;
    @Getter
    @Setter
    private String intNumsVentana;

    @Getter
    @Setter
    private String numInterconsultas;
    
    public InterconsultaSalida() {
    }

    public InterconsultaSalida(String intClavePrimaria, String intCodigoUnme, String intDependencia, String intDescrDepe, String intMedico, String intIpUsuario, String intPid, String intNumsVentana) {
        this.intClavePrimaria = intClavePrimaria;
        this.intCodigoUnme = intCodigoUnme;
        this.intDependencia = intDependencia;
        this.intDescrDepe = intDescrDepe;
        this.intMedico = intMedico;
        this.intIpUsuario = intIpUsuario;
        this.intPid = intPid;
        this.intNumsVentana = intNumsVentana;
    }

    public InterconsultaSalida(String numInterconsultas) {
        this.numInterconsultas = numInterconsultas;
    }

   
}


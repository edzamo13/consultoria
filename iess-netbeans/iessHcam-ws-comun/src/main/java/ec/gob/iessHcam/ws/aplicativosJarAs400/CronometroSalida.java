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
public class CronometroSalida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String croClavePrimaria;
    @Getter
    @Setter
    private String croCodigoUnme;
    @Getter
    @Setter
    private String croNumHistoria;
    @Getter
    @Setter
    private String croFechaCita;
    @Getter
    @Setter
    private String croHoraCita;
    @Getter
    @Setter
    private String croNombrePaciente;
    @Getter
    @Setter
    private String croIpUsuario;
    @Getter
    @Setter
    private String croPid;
    @Getter
    @Setter
    private String croNumVentana;
    
    public CronometroSalida() {
    }

    @Override
    public String toString() {
        return "CronometroSalida{" + "croClavePrimaria=" + croClavePrimaria + ", croCodigoUnme=" + croCodigoUnme + ", croNumHistoria=" + croNumHistoria + ", croFechaCita=" + croFechaCita + ", croHoraCita=" + croHoraCita + ", croNombrePaciente=" + croNombrePaciente + ", croIpUsuario=" + croIpUsuario + ", croPid=" + croPid + ", croNumVentana=" + croNumVentana + " '}'";
    }

    public CronometroSalida(String croClavePrimaria, String croCodigoUnme, String croNumHistoria, String croFechaCita, String croHoraCita, String croNombrePaciente, String croIpUsuario, String croPid, String croNumVentana) {
        this.croClavePrimaria = croClavePrimaria;
        this.croCodigoUnme = croCodigoUnme;
        this.croNumHistoria = croNumHistoria;
        this.croFechaCita = croFechaCita;
        this.croHoraCita = croHoraCita;
        this.croNombrePaciente = croNombrePaciente;
        this.croIpUsuario = croIpUsuario;
        this.croPid = croPid;
        this.croNumVentana = croNumVentana;
    }

}


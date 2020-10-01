/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

import java.io.Serializable;

/**
 *
 * @author programacion
 */
public class Imagen implements Serializable {
    
    private double UNIDAD_MEDICA;
    private double NUM_ORDEN;
    private double SERVICIO_REALIZA;
    private double HISTORIA_CLINICA;
    private double TIPO_SERVICIO;
    private double SUBTIPO_SERVICIO;
    private String ITEM_TARIFARIO;
    private String STS_VERIFICA; //nuevo char de 1 
    private double FECHA_RESULTADO;
    private String STS_ASISTENCIA;       //nuevo
    private double FECHA_ASISTENCIA; // nuevo
    private double DEPE_SOLICITA;
    private double MEDICO_SOLICITA;
    private double DEPE_REALIZA;
    private String DESCRIPCION;
    private double VALOR;
   

    public double getUNIDAD_MEDICA() {
        return UNIDAD_MEDICA;
    }

    public void setUNIDAD_MEDICA(double UNIDAD_MEDICA) {
        this.UNIDAD_MEDICA = UNIDAD_MEDICA;
    }

    public double getNUM_ORDEN() {
        return NUM_ORDEN;
    }

    public void setNUM_ORDEN(double NUM_ORDEN) {
        this.NUM_ORDEN = NUM_ORDEN;
    }

    public double getSERVICIO_REALIZA() {
        return SERVICIO_REALIZA;
    }

    public void setSERVICIO_REALIZA(double SERVICIO_REALIZA) {
        this.SERVICIO_REALIZA = SERVICIO_REALIZA;
    }

    public double getHISTORIA_CLINICA() {
        return HISTORIA_CLINICA;
    }

    public void setHISTORIA_CLINICA(double HISTORIA_CLINICA) {
        this.HISTORIA_CLINICA = HISTORIA_CLINICA;
    }

    public double getTIPO_SERVICIO() {
        return TIPO_SERVICIO;
    }

    public void setTIPO_SERVICIO(double TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public double getSUBTIPO_SERVICIO() {
        return SUBTIPO_SERVICIO;
    }

    public void setSUBTIPO_SERVICIO(double SUBTIPO_SERVICIO) {
        this.SUBTIPO_SERVICIO = SUBTIPO_SERVICIO;
    }

    public String getITEM_TARIFARIO() {
        return ITEM_TARIFARIO;
    }

    public void setITEM_TARIFARIO(String ITEM_TARIFARIO) {
        this.ITEM_TARIFARIO = ITEM_TARIFARIO;
    }

    public double getFECHA_RESULTADO() {
        return FECHA_RESULTADO;
    }

    public void setFECHA_RESULTADO(double FECHA_RESULTADO) {
        this.FECHA_RESULTADO = FECHA_RESULTADO;
    }

    public double getDEPE_SOLICITA() {
        return DEPE_SOLICITA;
    }

    public void setDEPE_SOLICITA(double DEPE_SOLICITA) {
        this.DEPE_SOLICITA = DEPE_SOLICITA;
    }

    public double getMEDICO_SOLICITA() {
        return MEDICO_SOLICITA;
    }

    public void setMEDICO_SOLICITA(double MEDICO_SOLICITA) {
        this.MEDICO_SOLICITA = MEDICO_SOLICITA;
    }

    public double getDEPE_REALIZA() {
        return DEPE_REALIZA;
    }

    public void setDEPE_REALIZA(double DEPE_REALIZA) {
        this.DEPE_REALIZA = DEPE_REALIZA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public double getVALOR() {
        return VALOR;
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }
    
    public String getSTS_VERIFICA() {
        return STS_VERIFICA;
    }

    public void setSTS_VERIFICA(String STS_VERIFICA) {
        this.STS_VERIFICA = STS_VERIFICA;
    }

    public String getSTS_ASISTENCIA() {
        return STS_ASISTENCIA;
    }

    public void setSTS_ASISTENCIA(String STS_ASISTENCIA) {
        this.STS_ASISTENCIA = STS_ASISTENCIA;
    }

    public double getFECHA_ASISTENCIA() {
        return FECHA_ASISTENCIA;
    }

    public void setFECHA_ASISTENCIA(double FECHA_ASISTENCIA) {
        this.FECHA_ASISTENCIA = FECHA_ASISTENCIA;
    }
    
        
       
}

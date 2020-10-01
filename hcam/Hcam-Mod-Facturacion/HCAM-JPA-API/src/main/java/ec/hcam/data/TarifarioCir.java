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
public class TarifarioCir implements Serializable{
    
    private int IDTARIFARIO;
    private double VALORTARIFARIO;
    private String ESTADO;
    private double VALORANEST;
    private String DESCRIPCION;
    private String CODIGO;
    private int nivelTar;

    public int getIDTARIFARIO() {
        return IDTARIFARIO;
    }

    public void setIDTARIFARIO(int IDTARIFARIO) {
        this.IDTARIFARIO = IDTARIFARIO;
    }

    public double getVALORTARIFARIO() {
        return VALORTARIFARIO;
    }

    public void setVALORTARIFARIO(double VALORTARIFARIO) {
        this.VALORTARIFARIO = VALORTARIFARIO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }  

    public double getVALORANEST() {
        return VALORANEST;
    }

    public void setVALORANEST(double VALORANEST) {
        this.VALORANEST = VALORANEST;
    }   

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public int getNivelTar() {
        return nivelTar;
    }

    public void setNivelTar(int nivelTar) {
        this.nivelTar = nivelTar;
    }   
    
}

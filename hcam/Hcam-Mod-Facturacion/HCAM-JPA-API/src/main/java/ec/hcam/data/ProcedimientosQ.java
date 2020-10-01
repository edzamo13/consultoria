/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author programacion
 */
public class ProcedimientosQ implements Serializable{
    
    private int UNIDADMEDICA;
    private int HISTORIACLINICA;
    private int FECHAOPERACION;
    private int HORAOPERACION;
    private Double DEPENDENCIAPROCEDIMIENTO;
    private int ITEMTARIFARIO;
    private String INDSIMPLEBILATERAL;
    private int NUMEROPROCEDIMIENTOS;
    private int LINEAABORDAJE;
    

    public int getUNIDADMEDICA() {
        return UNIDADMEDICA;
    }

    public void setUNIDADMEDICA(int UNIDADMEDICA) {
        this.UNIDADMEDICA = UNIDADMEDICA;
    }

    public int getHISTORIACLINICA() {
        return HISTORIACLINICA;
    }

    public void setHISTORIACLINICA(int HISTORIACLINICA) {
        this.HISTORIACLINICA = HISTORIACLINICA;
    }    

    public int getFECHAOPERACION() {
        return FECHAOPERACION;
    }

    public void setFECHAOPERACION(int FECHAOPERACION) {
        this.FECHAOPERACION = FECHAOPERACION;
    }

    public int getHORAOPERACION() {
        return HORAOPERACION;
    }

    public void setHORAOPERACION(int HORAOPERACION) {
        this.HORAOPERACION = HORAOPERACION;
    }

    public Double getDEPENDENCIAPROCEDIMIENTO() {
        return DEPENDENCIAPROCEDIMIENTO;
    }

    public void setDEPENDENCIAPROCEDIMIENTO(Double DEPENDENCIAPROCEDIMIENTO) {
        this.DEPENDENCIAPROCEDIMIENTO = DEPENDENCIAPROCEDIMIENTO;
    }

    public int getITEMTARIFARIO() {
        return ITEMTARIFARIO;
    }

    public void setITEMTARIFARIO(int ITEMTARIFARIO) {
        this.ITEMTARIFARIO = ITEMTARIFARIO;
    }

    public String getINDSIMPLEBILATERAL() {
        return INDSIMPLEBILATERAL;
    }

    public void setINDSIMPLEBILATERAL(String INDSIMPLEBILATERAL) {
        this.INDSIMPLEBILATERAL = INDSIMPLEBILATERAL;
    }

    public int getNUMEROPROCEDIMIENTOS() {
        return NUMEROPROCEDIMIENTOS;
    }

    public void setNUMEROPROCEDIMIENTOS(int NUMEROPROCEDIMIENTOS) {
        this.NUMEROPROCEDIMIENTOS = NUMEROPROCEDIMIENTOS;
    }

    public int getLINEAABORDAJE() {
        return LINEAABORDAJE;
    }

    public void setLINEAABORDAJE(int LINEAABORDAJE) {
        this.LINEAABORDAJE = LINEAABORDAJE;
    }
    
    
}

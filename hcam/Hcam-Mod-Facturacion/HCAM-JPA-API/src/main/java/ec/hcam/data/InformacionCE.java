package ec.hcam.data;

import java.io.Serializable;

public class InformacionCE implements Serializable {

//private int b;
    private String IADSTA;

    public String getIADSTA() {
        return IADSTA;
    }

    public void setIADSTA(String IADSTA) {
        this.IADSTA = IADSTA;
    }

    public double getIADUNM() {
        return IADUNM;
    }

    public void setIADUNM(double IADUNM) {
        this.IADUNM = IADUNM;
    }

    public double getIADDEP() {
        return IADDEP;
    }

    public void setIADDEP(double IADDEP) {
        this.IADDEP = IADDEP;
    }

    public double getIADCOD() {
        return IADCOD;
    }

    public void setIADCOD(double IADCOD) {
        this.IADCOD = IADCOD;
    }

    public double getIADCIT() {
        return IADCIT;
    }

    public void setIADCIT(double IADCIT) {
        this.IADCIT = IADCIT;
    }

    public double getIADHOP() {
        return IADHOP;
    }

    public void setIADHOP(double IADHOP) {
        this.IADHOP = IADHOP;
    }

    public double getIADHIS() {
        return IADHIS;
    }

    public void setIADHIS(double IADHIS) {
        this.IADHIS = IADHIS;
    }

    public double getIADACM() {
        return IADACM;
    }

    public void setIADACM(double IADACM) {
        this.IADACM = IADACM;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getDIAGPRES() {
        return DIAGPRES;
    }

    public void setDIAGPRES(String DIAGPRES) {
        this.DIAGPRES = DIAGPRES;
    }

    public String getDIAGDEF() {
        return DIAGDEF;
    }

    public void setDIAGDEF(String DIAGDEF) {
        this.DIAGDEF = DIAGDEF;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getODONT() {
        return ODONT;
    }

    public void setODONT(String ODONT) {
        this.ODONT = ODONT;
    }   
    
    
    private double IADUNM;
    private double IADDEP;
    private double IADCOD;
    private double IADCIT;
    private double IADHOP;
    private double IADHIS;
    private double IADACM;
    private String TIPO;
    private String DIAGPRES;
    private String DIAGDEF;
    private String DESCRIPCION;
    private String ODONT;


}

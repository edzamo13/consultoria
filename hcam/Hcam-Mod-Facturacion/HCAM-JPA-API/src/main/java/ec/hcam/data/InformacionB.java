package ec.hcam.data;

import java.io.Serializable;

public class InformacionB implements Comparable<InformacionB>, Serializable {

//private int b;
    private double IR2HIS;
    private String IR2ITE;
    private double TAVALOR;
    private double IR2HOP;
    private String IR2INT;
    private String IR2SUB;
    private String IR2SFA;
    private String descripcion;
    private double IR2COM;

    public double getIR2COM() {
        return IR2COM;
    }

    public void setIR2COM(double IR2COM) {
        this.IR2COM = IR2COM;
    }

    public double getIR2HIS() {
        return IR2HIS;
    }

    public void setIR2HIS(double iR2HIS) {
        IR2HIS = iR2HIS;
    }

    public String getIR2ITE() {
        return IR2ITE;
    }

    public void setIR2ITE(String iR2ITE) {
        IR2ITE = iR2ITE;
    }

    public double getTAVALOR() {
        return TAVALOR;
    }

    public void setTAVALOR(double tAVALOR) {
        TAVALOR = tAVALOR;
    }

    public double getIR2HOP() {
        return IR2HOP;
    }

    public void setIR2HOP(double iR2HOP) {
        IR2HOP = iR2HOP;
    }

    public String getIR2INT() {
        return IR2INT;
    }

    public void setIR2INT(String IR2INT) {
        this.IR2INT = IR2INT;
    }

    public String getIR2SUB() {
        return IR2SUB;
    }

    public void setIR2SUB(String IR2SUB) {
        this.IR2SUB = IR2SUB;
    }

    public String getIR2SFA() {
        return IR2SFA;
    }

    public void setIR2SFA(String IR2SFA) {
        this.IR2SFA = IR2SFA;
    }
    
    @Override
    public int compareTo(InformacionB o) {
        String a = new String(String.valueOf(this.getIR2HIS()));
        String b = new String(String.valueOf(o.getIR2HIS()));
        return a.compareTo(b);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

}

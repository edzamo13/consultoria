package ec.hcam.data;

import java.io.Serializable;

public class Cabecera implements Serializable {

    private int cpidpk;    
    private int numPlanilla;
    private int fecha_reg;
    private String usuarioReg;
    private int mesPlanilla;
    private int anioPlanilla;
    private String estadoPlanilla;
    private int diaPlanilla;
    private int diaRegistro;
    private int mesRegistro;
    private int anioRegistro;
    private int numPland;
    private int unidpk;
    private int ubicapk;

    public int getCpidpk() {
        return cpidpk;
    }

    public void setCpidpk(int cpidpk) {
        this.cpidpk = cpidpk;
    }

    public int getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(int numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public int getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(int fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public String getUsuarioReg() {
        return usuarioReg;
    }

    public void setUsuarioReg(String usuarioReg) {
        this.usuarioReg = usuarioReg;
    }

    public int getMesPlanilla() {
        return mesPlanilla;
    }

    public void setMesPlanilla(int mesPlanilla) {
        this.mesPlanilla = mesPlanilla;
    }

    public int getAnioPlanilla() {
        return anioPlanilla;
    }

    public void setAnioPlanilla(int anioPlanilla) {
        this.anioPlanilla = anioPlanilla;
    }

    public String getEstadoPlanilla() {
        return estadoPlanilla;
    }

    public void setEstadoPlanilla(String estadoPlanilla) {
        this.estadoPlanilla = estadoPlanilla;
    }

    public int getDiaPlanilla() {
        return diaPlanilla;
    }

    public void setDiaPlanilla(int diaPlanilla) {
        this.diaPlanilla = diaPlanilla;
    }

    public int getDiaRegistro() {
        return diaRegistro;
    }

    public void setDiaRegistro(int diaRegistro) {
        this.diaRegistro = diaRegistro;
    }

    public int getMesRegistro() {
        return mesRegistro;
    }

    public void setMesRegistro(int mesRegistro) {
        this.mesRegistro = mesRegistro;
    }

    public int getAnioRegistro() {
        return anioRegistro;
    }

    public void setAnioRegistro(int anioRegistro) {
        this.anioRegistro = anioRegistro;
    }

    public int getNumPland() {
        return numPland;
    }

    public void setNumPland(int numPland) {
        this.numPland = numPland;
    }

    public int getUnidpk() {
        return unidpk;
    }

    public void setUnidpk(int unidpk) {
        this.unidpk = unidpk;
    }

    public int getUbicapk() {
        return ubicapk;
    }

    public void setUbicapk(int ubicapk) {
        this.ubicapk = ubicapk;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

import java.io.Serializable;

/**
 *
 * @author ezamora
 */
public class UnidaMedica implements Serializable {

    private Double unidadMedica;
    private Double numOrden;
    private Double codServicio;
    private Double historia;
    private Double tipoServicio;
    private Double subtiPoservicio;
    private String itemTarifario;
    private String stsVerifica;
    private Double fecItRes;
    private Double depeSolicita;
    private Double medicoSolicita;
    private Double depeRealiza;
    private String descripcion;
    private Double valor;

    public Double getUnidadMedica() {
        return unidadMedica;
    }

    public void setUnidadMedica(Double unidadMedica) {
        this.unidadMedica = unidadMedica;
    }

    public Double getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Double numOrden) {
        this.numOrden = numOrden;
    }

    public Double getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(Double codServicio) {
        this.codServicio = codServicio;
    }

    public Double getHistoria() {
        return historia;
    }

    public void setHistoria(Double historia) {
        this.historia = historia;
    }

    public Double getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Double tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Double getSubtiPoservicio() {
        return subtiPoservicio;
    }

    public void setSubtiPoservicio(Double subtiPoservicio) {
        this.subtiPoservicio = subtiPoservicio;
    }

    public String getItemTarifario() {
        return itemTarifario;
    }

    public void setItemTarifario(String itemTarifario) {
        this.itemTarifario = itemTarifario;
    }

    public String getStsVerifica() {
        return stsVerifica;
    }

    public void setStsVerifica(String stsVerifica) {
        this.stsVerifica = stsVerifica;
    }

    public Double getFecItRes() {
        return fecItRes;
    }

    public void setFecItRes(Double fecItRes) {
        this.fecItRes = fecItRes;
    }

    public Double getDepeSolicita() {
        return depeSolicita;
    }

    public void setDepeSolicita(Double depeSolicita) {
        this.depeSolicita = depeSolicita;
    }

    public Double getMedicoSolicita() {
        return medicoSolicita;
    }

    public void setMedicoSolicita(Double medicoSolicita) {
        this.medicoSolicita = medicoSolicita;
    }

    public Double getDepeRealiza() {
        return depeRealiza;
    }

    public void setDepeRealiza(Double depeRealiza) {
        this.depeRealiza = depeRealiza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    

    
    

}

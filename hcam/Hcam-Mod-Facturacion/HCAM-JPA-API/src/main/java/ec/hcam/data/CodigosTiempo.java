/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.data;

/**
 *
 * @author programacion
 */
public class CodigosTiempo {
    
    String codigoTarifario;
    double valorCobrar;
    int cantidad;
    String descripcion;
    double valorUnitario;
    int nivelTar;

    public String getCodigoTarifario() {
        return codigoTarifario;
    }

    public void setCodigoTarifario(String codigoTarifario) {
        this.codigoTarifario = codigoTarifario;
    }

    public double getValorCobrar() {
        return valorCobrar;
    }

    public void setValorCobrar(double valorCobrar) {
        this.valorCobrar = valorCobrar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }   

    public int getNivelTar() {
        return nivelTar;
    }

    public void setNivelTar(int nivelTar) {
        this.nivelTar = nivelTar;
    }
    
}

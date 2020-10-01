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
 * @author Programacion
 */
public class InsumosServicios implements Serializable {
    private int unidadMedica;
    private int historia;
    private String codigoItem;
    private int cantidad;
    private Double dependencia;
    private Double precioTotal;
    private int fechaActualizacion;
    private Double precioUnitario;
    private int tipoServicio;
    private int subTipoServicio;
    private String descripcionItem;

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcion) {
        this.descripcionItem = descripcion;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getSubTipoServicio() {
        return subTipoServicio;
    }

    public void setSubTipoServicio(int subTipoServicio) {
        this.subTipoServicio = subTipoServicio;
    }

    public int getUnidadMedica() {
        return unidadMedica;
    }

    public void setUnidadMedica(int unidadMedica) {
        this.unidadMedica = unidadMedica;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDependencia() {
        return dependencia;
    }

    public void setDependencia(Double dependencia) {
        this.dependencia = dependencia;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(int fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    
    
}

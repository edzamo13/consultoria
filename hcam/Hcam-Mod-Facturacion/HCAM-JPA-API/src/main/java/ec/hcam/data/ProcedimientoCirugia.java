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
public class ProcedimientoCirugia implements Serializable{
    
    private ProcedimientosQ prod;
    
    private double valorCobra;
    
    private int porcentajeCobrado;
    
    private double valorAnestesia;
    
    private String descripcionProd;

    public ProcedimientosQ getProd() {
        return prod;
    }

    public void setProd(ProcedimientosQ prod) {
        this.prod = prod;
    }    

    public double getValorCobra() {
        return valorCobra;
    }

    public void setValorCobra(double valorCobra) {
        this.valorCobra = valorCobra;
    }

    public int getPorcentajeCobrado() {
        return porcentajeCobrado;
    }

    public void setPorcentajeCobrado(int porcentajeCobrado) {
        this.porcentajeCobrado = porcentajeCobrado;
    }

    public double getValorAnestesia() {
        return valorAnestesia;
    }

    public void setValorAnestesia(double valorAnestesia) {
        this.valorAnestesia = valorAnestesia;
    }   

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Programacion
 */
@Embeddable
public class UnidmedtblPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDPK")
    private int unidpk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UBICAPK")
    private int ubicapk;

    public UnidmedtblPK() {
    }

    public UnidmedtblPK(int unidpk, int ubicapk) {
        this.unidpk = unidpk;
        this.ubicapk = ubicapk;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) unidpk;
        hash += (int) ubicapk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidmedtblPK)) {
            return false;
        }
        UnidmedtblPK other = (UnidmedtblPK) object;
        if (this.unidpk != other.unidpk) {
            return false;
        }
        if (this.ubicapk != other.ubicapk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.UnidmedtblPK[ unidpk=" + unidpk + ", ubicapk=" + ubicapk + " ]";
    }
    
}

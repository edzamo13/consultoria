/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

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
public class CtUmtblPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTUMIDPK")
    private int ctumidpk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTUMCTFK")
    private int ctumctfk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTUMUMFK")
    private int ctumumfk;

    public CtUmtblPK() {
    }

    public CtUmtblPK(int ctumidpk, int ctumctfk, int ctumumfk) {
        this.ctumidpk = ctumidpk;
        this.ctumctfk = ctumctfk;
        this.ctumumfk = ctumumfk;
    }

    public int getCtumidpk() {
        return ctumidpk;
    }

    public void setCtumidpk(int ctumidpk) {
        this.ctumidpk = ctumidpk;
    }

    public int getCtumctfk() {
        return ctumctfk;
    }

    public void setCtumctfk(int ctumctfk) {
        this.ctumctfk = ctumctfk;
    }

    public int getCtumumfk() {
        return ctumumfk;
    }

    public void setCtumumfk(int ctumumfk) {
        this.ctumumfk = ctumumfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ctumidpk;
        hash += (int) ctumctfk;
        hash += (int) ctumumfk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtUmtblPK)) {
            return false;
        }
        CtUmtblPK other = (CtUmtblPK) object;
        if (this.ctumidpk != other.ctumidpk) {
            return false;
        }
        if (this.ctumctfk != other.ctumctfk) {
            return false;
        }
        if (this.ctumumfk != other.ctumumfk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.CtUmtblPK[ ctumidpk=" + ctumidpk + ", ctumctfk=" + ctumctfk + ", ctumumfk=" + ctumumfk + " ]";
    }
    
}

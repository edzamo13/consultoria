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
public class UnimdeptblPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNMEDDEPPK")
    private int unmeddeppk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDMEDFK")
    private int unidmedfk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPFK")
    private int depfk;

    public UnimdeptblPK() {
    }

    public UnimdeptblPK(int unmeddeppk, int unidmedfk, int depfk) {
        this.unmeddeppk = unmeddeppk;
        this.unidmedfk = unidmedfk;
        this.depfk = depfk;
    }

    public int getUnmeddeppk() {
        return unmeddeppk;
    }

    public void setUnmeddeppk(int unmeddeppk) {
        this.unmeddeppk = unmeddeppk;
    }

    public int getUnidmedfk() {
        return unidmedfk;
    }

    public void setUnidmedfk(int unidmedfk) {
        this.unidmedfk = unidmedfk;
    }

    public int getDepfk() {
        return depfk;
    }

    public void setDepfk(int depfk) {
        this.depfk = depfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) unmeddeppk;
        hash += (int) unidmedfk;
        hash += (int) depfk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnimdeptblPK)) {
            return false;
        }
        UnimdeptblPK other = (UnimdeptblPK) object;
        if (this.unmeddeppk != other.unmeddeppk) {
            return false;
        }
        if (this.unidmedfk != other.unidmedfk) {
            return false;
        }
        if (this.depfk != other.depfk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.UnimdeptblPK[ unmeddeppk=" + unmeddeppk + ", unidmedfk=" + unidmedfk + ", depfk=" + depfk + " ]";
    }
    
}

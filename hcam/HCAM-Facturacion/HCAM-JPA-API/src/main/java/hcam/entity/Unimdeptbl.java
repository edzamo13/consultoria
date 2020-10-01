/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "UNIMDEPTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unimdeptbl.findAll", query = "SELECT u FROM Unimdeptbl u"),
    @NamedQuery(name = "Unimdeptbl.findByUnmeddeppk", query = "SELECT u FROM Unimdeptbl u WHERE u.unimdeptblPK.unmeddeppk = :unmeddeppk"),
    @NamedQuery(name = "Unimdeptbl.findByUnidmedfk", query = "SELECT u FROM Unimdeptbl u WHERE u.unimdeptblPK.unidmedfk = :unidmedfk"),
    @NamedQuery(name = "Unimdeptbl.findByDepfk", query = "SELECT u FROM Unimdeptbl u WHERE u.unimdeptblPK.depfk = :depfk"),
    @NamedQuery(name = "Unimdeptbl.findByFechaasig", query = "SELECT u FROM Unimdeptbl u WHERE u.fechaasig = :fechaasig"),
    @NamedQuery(name = "Unimdeptbl.findByEstado", query = "SELECT u FROM Unimdeptbl u WHERE u.estado = :estado")})
public class Unimdeptbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnimdeptblPK unimdeptblPK;
    @Column(name = "FECHAASIG")
    @Temporal(TemporalType.DATE)
    private Date fechaasig;
    @Size(max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "DEPFK", referencedColumnName = "DEPUNPK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Deunitbl deunitbl;
    @JoinColumn(name = "UNIDMEDFK", referencedColumnName = "UNIDPK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidmedtbl unidmedtbl;

    public Unimdeptbl() {
    }

    public Unimdeptbl(UnimdeptblPK unimdeptblPK) {
        this.unimdeptblPK = unimdeptblPK;
    }

    public Unimdeptbl(int unmeddeppk, int unidmedfk, int depfk) {
        this.unimdeptblPK = new UnimdeptblPK(unmeddeppk, unidmedfk, depfk);
    }

    public UnimdeptblPK getUnimdeptblPK() {
        return unimdeptblPK;
    }

    public void setUnimdeptblPK(UnimdeptblPK unimdeptblPK) {
        this.unimdeptblPK = unimdeptblPK;
    }

    public Date getFechaasig() {
        return fechaasig;
    }

    public void setFechaasig(Date fechaasig) {
        this.fechaasig = fechaasig;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Deunitbl getDeunitbl() {
        return deunitbl;
    }

    public void setDeunitbl(Deunitbl deunitbl) {
        this.deunitbl = deunitbl;
    }

    public Unidmedtbl getUnidmedtbl() {
        return unidmedtbl;
    }

    public void setUnidmedtbl(Unidmedtbl unidmedtbl) {
        this.unidmedtbl = unidmedtbl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unimdeptblPK != null ? unimdeptblPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unimdeptbl)) {
            return false;
        }
        Unimdeptbl other = (Unimdeptbl) object;
        if ((this.unimdeptblPK == null && other.unimdeptblPK != null) || (this.unimdeptblPK != null && !this.unimdeptblPK.equals(other.unimdeptblPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Unimdeptbl[ unimdeptblPK=" + unimdeptblPK + " ]";
    }
    
}

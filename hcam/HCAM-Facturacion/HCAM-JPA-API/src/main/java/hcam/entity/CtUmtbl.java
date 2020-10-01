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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "CT_UMTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtUmtbl.findAll", query = "SELECT c FROM CtUmtbl c"),
    @NamedQuery(name = "CtUmtbl.findByCtumidpk", query = "SELECT c FROM CtUmtbl c WHERE c.ctUmtblPK.ctumidpk = :ctumidpk"),
    @NamedQuery(name = "CtUmtbl.findByCtumctfk", query = "SELECT c FROM CtUmtbl c WHERE c.ctUmtblPK.ctumctfk = :ctumctfk"),
    @NamedQuery(name = "CtUmtbl.findByCtumumfk", query = "SELECT c FROM CtUmtbl c WHERE c.ctUmtblPK.ctumumfk = :ctumumfk"),
    @NamedQuery(name = "CtUmtbl.findByCtumfecini", query = "SELECT c FROM CtUmtbl c WHERE c.ctumfecini = :ctumfecini"),
    @NamedQuery(name = "CtUmtbl.findByCtumfecfin", query = "SELECT c FROM CtUmtbl c WHERE c.ctumfecfin = :ctumfecfin")})
public class CtUmtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CtUmtblPK ctUmtblPK;
    @Column(name = "CTUMFECINI")
    @Temporal(TemporalType.DATE)
    private Date ctumfecini;
    @Column(name = "CTUMFECFIN")
    @Temporal(TemporalType.DATE)
    private Date ctumfecfin;
    @JoinColumn(name = "CTUMUMFK", referencedColumnName = "UNIDPK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidmedtbl unidmedtbl;
    @JoinColumn(name = "CTUMCTFK", referencedColumnName = "CTIDPK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cabtaritbl cabtaritbl;

    public CtUmtbl() {
    }

    public CtUmtbl(CtUmtblPK ctUmtblPK) {
        this.ctUmtblPK = ctUmtblPK;
    }

    public CtUmtbl(int ctumidpk, int ctumctfk, int ctumumfk) {
        this.ctUmtblPK = new CtUmtblPK(ctumidpk, ctumctfk, ctumumfk);
    }

    public CtUmtblPK getCtUmtblPK() {
        return ctUmtblPK;
    }

    public void setCtUmtblPK(CtUmtblPK ctUmtblPK) {
        this.ctUmtblPK = ctUmtblPK;
    }

    public Date getCtumfecini() {
        return ctumfecini;
    }

    public void setCtumfecini(Date ctumfecini) {
        this.ctumfecini = ctumfecini;
    }

    public Date getCtumfecfin() {
        return ctumfecfin;
    }

    public void setCtumfecfin(Date ctumfecfin) {
        this.ctumfecfin = ctumfecfin;
    }

    public Unidmedtbl getUnidmedtbl() {
        return unidmedtbl;
    }

    public void setUnidmedtbl(Unidmedtbl unidmedtbl) {
        this.unidmedtbl = unidmedtbl;
    }

    public Cabtaritbl getCabtaritbl() {
        return cabtaritbl;
    }

    public void setCabtaritbl(Cabtaritbl cabtaritbl) {
        this.cabtaritbl = cabtaritbl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctUmtblPK != null ? ctUmtblPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtUmtbl)) {
            return false;
        }
        CtUmtbl other = (CtUmtbl) object;
        if ((this.ctUmtblPK == null && other.ctUmtblPK != null) || (this.ctUmtblPK != null && !this.ctUmtblPK.equals(other.ctUmtblPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.CtUmtbl[ ctUmtblPK=" + ctUmtblPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "ESTTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esttbl.findAll", query = "SELECT e FROM Esttbl e"),
    @NamedQuery(name = "Esttbl.findByEstpk", query = "SELECT e FROM Esttbl e WHERE e.estpk = :estpk"),
    @NamedQuery(name = "Esttbl.findByEstact", query = "SELECT e FROM Esttbl e WHERE e.estact = :estact"),
    @NamedQuery(name = "Esttbl.findByEstinact", query = "SELECT e FROM Esttbl e WHERE e.estinact = :estinact")})
public class Esttbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTPK")
    private Integer estpk;
    @Size(max = 4)
    @Column(name = "ESTACT")
    private String estact;
    @Size(max = 4)
    @Column(name = "ESTINACT")
    private String estinact;

    public Esttbl() {
    }

    public Esttbl(Integer estpk) {
        this.estpk = estpk;
    }

    public Integer getEstpk() {
        return estpk;
    }

    public void setEstpk(Integer estpk) {
        this.estpk = estpk;
    }

    public String getEstact() {
        return estact;
    }

    public void setEstact(String estact) {
        this.estact = estact;
    }

    public String getEstinact() {
        return estinact;
    }

    public void setEstinact(String estinact) {
        this.estinact = estinact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estpk != null ? estpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esttbl)) {
            return false;
        }
        Esttbl other = (Esttbl) object;
        if ((this.estpk == null && other.estpk != null) || (this.estpk != null && !this.estpk.equals(other.estpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Esttbl[ estpk=" + estpk + " ]";
    }
    
}

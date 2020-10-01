/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "TIPOACRTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoacrtbl.findAll", query = "SELECT t FROM Tipoacrtbl t"),
    @NamedQuery(name = "Tipoacrtbl.findByTaidpk", query = "SELECT t FROM Tipoacrtbl t WHERE t.taidpk = :taidpk"),
    @NamedQuery(name = "Tipoacrtbl.findByTanombre", query = "SELECT t FROM Tipoacrtbl t WHERE t.tanombre = :tanombre"),
    @NamedQuery(name = "Tipoacrtbl.findByTaestado", query = "SELECT t FROM Tipoacrtbl t WHERE t.taestado = :taestado")})
public class Tipoacrtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAIDPK")
    private Integer taidpk;
    @Size(max = 50)
    @Column(name = "TANOMBRE")
    private String tanombre;
    @Size(max = 30)
    @Column(name = "TAESTADO")
    private String taestado;
    @OneToMany(mappedBy = "taidpk")
    private List<Reglastbl> reglastblList;

    public Tipoacrtbl() {
    }

    public Tipoacrtbl(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public Integer getTaidpk() {
        return taidpk;
    }

    public void setTaidpk(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public String getTanombre() {
        return tanombre;
    }

    public void setTanombre(String tanombre) {
        this.tanombre = tanombre;
    }

    public String getTaestado() {
        return taestado;
    }

    public void setTaestado(String taestado) {
        this.taestado = taestado;
    }

    @XmlTransient
    public List<Reglastbl> getReglastblList() {
        return reglastblList;
    }

    public void setReglastblList(List<Reglastbl> reglastblList) {
        this.reglastblList = reglastblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taidpk != null ? taidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoacrtbl)) {
            return false;
        }
        Tipoacrtbl other = (Tipoacrtbl) object;
        if ((this.taidpk == null && other.taidpk != null) || (this.taidpk != null && !this.taidpk.equals(other.taidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Tipoacrtbl[ taidpk=" + taidpk + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DEUNITBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deunitbl.findAll", query = "SELECT d FROM Deunitbl d"),
    @NamedQuery(name = "Deunitbl.findByDepunpk", query = "SELECT d FROM Deunitbl d WHERE d.depunpk = :depunpk"),
    @NamedQuery(name = "Deunitbl.findByDedepend", query = "SELECT d FROM Deunitbl d WHERE d.dedepend = :dedepend"),
    @NamedQuery(name = "Deunitbl.findByDenombre", query = "SELECT d FROM Deunitbl d WHERE d.denombre = :denombre"),
    @NamedQuery(name = "Deunitbl.findByDeestado", query = "SELECT d FROM Deunitbl d WHERE d.deestado = :deestado")})
public class Deunitbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPUNPK")
    private Integer depunpk;
    @Size(max = 30)
    @Column(name = "DEDEPEND")
    private String dedepend;
    @Size(max = 100)
    @Column(name = "DENOMBRE")
    private String denombre;
    @Size(max = 30)
    @Column(name = "DEESTADO")
    private String deestado;
    @JoinColumn(name = "DETIPOFK", referencedColumnName = "TDIDPK")
    @ManyToOne(optional = false)
    private Tipostbl detipofk;
    @JoinColumn(name = "DEAREAFK", referencedColumnName = "AREAPK")
    @ManyToOne(optional = false)
    private Areatbl deareafk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deunitbl")
    private List<Unimdeptbl> unimdeptblList;

    public Deunitbl() {
    }

    public Deunitbl(Integer depunpk) {
        this.depunpk = depunpk;
    }

    public Integer getDepunpk() {
        return depunpk;
    }

    public void setDepunpk(Integer depunpk) {
        this.depunpk = depunpk;
    }

    public String getDedepend() {
        return dedepend;
    }

    public void setDedepend(String dedepend) {
        this.dedepend = dedepend;
    }

    public String getDenombre() {
        return denombre;
    }

    public void setDenombre(String denombre) {
        this.denombre = denombre;
    }

    public String getDeestado() {
        return deestado;
    }

    public void setDeestado(String deestado) {
        this.deestado = deestado;
    }

    public Tipostbl getDetipofk() {
        return detipofk;
    }

    public void setDetipofk(Tipostbl detipofk) {
        this.detipofk = detipofk;
    }

    public Areatbl getDeareafk() {
        return deareafk;
    }

    public void setDeareafk(Areatbl deareafk) {
        this.deareafk = deareafk;
    }

    @XmlTransient
    public List<Unimdeptbl> getUnimdeptblList() {
        return unimdeptblList;
    }

    public void setUnimdeptblList(List<Unimdeptbl> unimdeptblList) {
        this.unimdeptblList = unimdeptblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depunpk != null ? depunpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deunitbl)) {
            return false;
        }
        Deunitbl other = (Deunitbl) object;
        if ((this.depunpk == null && other.depunpk != null) || (this.depunpk != null && !this.depunpk.equals(other.depunpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Deunitbl[ depunpk=" + depunpk + " ]";
    }
    
}

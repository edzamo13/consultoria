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
@Table(name = "ESQUEMATBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esquematbl.findAll", query = "SELECT e FROM Esquematbl e"),
    @NamedQuery(name = "Esquematbl.findByEsidpk", query = "SELECT e FROM Esquematbl e WHERE e.esidpk = :esidpk"),
    @NamedQuery(name = "Esquematbl.findByEsnombre", query = "SELECT e FROM Esquematbl e WHERE e.esnombre = :esnombre"),
    @NamedQuery(name = "Esquematbl.findByEsmapeoesq", query = "SELECT e FROM Esquematbl e WHERE e.esmapeoesq = :esmapeoesq"),
    @NamedQuery(name = "Esquematbl.findByEsmapeotab", query = "SELECT e FROM Esquematbl e WHERE e.esmapeotab = :esmapeotab"),
    @NamedQuery(name = "Esquematbl.findByEsestado", query = "SELECT e FROM Esquematbl e WHERE e.esestado = :esestado")})
public class Esquematbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESIDPK")
    private Integer esidpk;
    @Size(max = 50)
    @Column(name = "ESNOMBRE")
    private String esnombre;
    @Size(max = 50)
    @Column(name = "ESMAPEOESQ")
    private String esmapeoesq;
    @Size(max = 50)
    @Column(name = "ESMAPEOTAB")
    private String esmapeotab;
    @Size(max = 30)
    @Column(name = "ESESTADO")
    private String esestado;
    @OneToMany(mappedBy = "esidpk")
    private List<Proceditbl> proceditblList;

    public Esquematbl() {
    }

    public Esquematbl(Integer esidpk) {
        this.esidpk = esidpk;
    }

    public Integer getEsidpk() {
        return esidpk;
    }

    public void setEsidpk(Integer esidpk) {
        this.esidpk = esidpk;
    }

    public String getEsnombre() {
        return esnombre;
    }

    public void setEsnombre(String esnombre) {
        this.esnombre = esnombre;
    }

    public String getEsmapeoesq() {
        return esmapeoesq;
    }

    public void setEsmapeoesq(String esmapeoesq) {
        this.esmapeoesq = esmapeoesq;
    }

    public String getEsmapeotab() {
        return esmapeotab;
    }

    public void setEsmapeotab(String esmapeotab) {
        this.esmapeotab = esmapeotab;
    }

    public String getEsestado() {
        return esestado;
    }

    public void setEsestado(String esestado) {
        this.esestado = esestado;
    }

    @XmlTransient
    public List<Proceditbl> getProceditblList() {
        return proceditblList;
    }

    public void setProceditblList(List<Proceditbl> proceditblList) {
        this.proceditblList = proceditblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esidpk != null ? esidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esquematbl)) {
            return false;
        }
        Esquematbl other = (Esquematbl) object;
        if ((this.esidpk == null && other.esidpk != null) || (this.esidpk != null && !this.esidpk.equals(other.esidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Esquematbl[ esidpk=" + esidpk + " ]";
    }
    
}

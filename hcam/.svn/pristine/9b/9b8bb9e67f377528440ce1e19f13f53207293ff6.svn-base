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
@Table(name = "TIPOSTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostbl.findAll", query = "SELECT t FROM Tipostbl t"),
    @NamedQuery(name = "Tipostbl.findByTdidpk", query = "SELECT t FROM Tipostbl t WHERE t.tdidpk = :tdidpk"),
    @NamedQuery(name = "Tipostbl.findByTdnombre", query = "SELECT t FROM Tipostbl t WHERE t.tdnombre = :tdnombre"),
    @NamedQuery(name = "Tipostbl.findByTdcodigo", query = "SELECT t FROM Tipostbl t WHERE t.tdcodigo = :tdcodigo"),
    @NamedQuery(name = "Tipostbl.findByTddescripcion", query = "SELECT t FROM Tipostbl t WHERE t.tddescripcion = :tddescripcion"),
    @NamedQuery(name = "Tipostbl.findByTdestado", query = "SELECT t FROM Tipostbl t WHERE t.tdestado = :tdestado")})
public class Tipostbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TDIDPK")
    private Integer tdidpk;
    @Size(max = 50)
    @Column(name = "TDNOMBRE")
    private String tdnombre;
    @Size(max = 30)
    @Column(name = "TDCODIGO")
    private String tdcodigo;
    @Size(max = 200)
    @Column(name = "TDDESCRIPCION")
    private String tddescripcion;
    @Size(max = 30)
    @Column(name = "TDESTADO")
    private String tdestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detipofk")
    private List<Deunitbl> deunitblList;

    public Tipostbl() {
    }

    public Tipostbl(Integer tdidpk) {
        this.tdidpk = tdidpk;
    }

    public Integer getTdidpk() {
        return tdidpk;
    }

    public void setTdidpk(Integer tdidpk) {
        this.tdidpk = tdidpk;
    }

    public String getTdnombre() {
        return tdnombre;
    }

    public void setTdnombre(String tdnombre) {
        this.tdnombre = tdnombre;
    }

    public String getTdcodigo() {
        return tdcodigo;
    }

    public void setTdcodigo(String tdcodigo) {
        this.tdcodigo = tdcodigo;
    }

    public String getTddescripcion() {
        return tddescripcion;
    }

    public void setTddescripcion(String tddescripcion) {
        this.tddescripcion = tddescripcion;
    }

    public String getTdestado() {
        return tdestado;
    }

    public void setTdestado(String tdestado) {
        this.tdestado = tdestado;
    }

    @XmlTransient
    public List<Deunitbl> getDeunitblList() {
        return deunitblList;
    }

    public void setDeunitblList(List<Deunitbl> deunitblList) {
        this.deunitblList = deunitblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdidpk != null ? tdidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipostbl)) {
            return false;
        }
        Tipostbl other = (Tipostbl) object;
        if ((this.tdidpk == null && other.tdidpk != null) || (this.tdidpk != null && !this.tdidpk.equals(other.tdidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Tipostbl[ tdidpk=" + tdidpk + " ]";
    }
    
}

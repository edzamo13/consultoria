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
@Table(name = "AREATBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areatbl.findAll", query = "SELECT a FROM Areatbl a"),
    @NamedQuery(name = "Areatbl.findByAreapk", query = "SELECT a FROM Areatbl a WHERE a.areapk = :areapk"),
    @NamedQuery(name = "Areatbl.findByUbnombre", query = "SELECT a FROM Areatbl a WHERE a.ubnombre = :ubnombre"),
    @NamedQuery(name = "Areatbl.findByArcodigo", query = "SELECT a FROM Areatbl a WHERE a.arcodigo = :arcodigo"),
    @NamedQuery(name = "Areatbl.findByArestado", query = "SELECT a FROM Areatbl a WHERE a.arestado = :arestado")})
public class Areatbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREAPK")
    private Integer areapk;
    @Size(max = 50)
    @Column(name = "UBNOMBRE")
    private String ubnombre;
    @Column(name = "ARCODIGO")
    private Integer arcodigo;
    @Size(max = 30)
    @Column(name = "ARESTADO")
    private String arestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deareafk")
    private List<Deunitbl> deunitblList;

    public Areatbl() {
    }

    public Areatbl(Integer areapk) {
        this.areapk = areapk;
    }

    public Integer getAreapk() {
        return areapk;
    }

    public void setAreapk(Integer areapk) {
        this.areapk = areapk;
    }

    public String getUbnombre() {
        return ubnombre;
    }

    public void setUbnombre(String ubnombre) {
        this.ubnombre = ubnombre;
    }

    public Integer getArcodigo() {
        return arcodigo;
    }

    public void setArcodigo(Integer arcodigo) {
        this.arcodigo = arcodigo;
    }

    public String getArestado() {
        return arestado;
    }

    public void setArestado(String arestado) {
        this.arestado = arestado;
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
        hash += (areapk != null ? areapk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areatbl)) {
            return false;
        }
        Areatbl other = (Areatbl) object;
        if ((this.areapk == null && other.areapk != null) || (this.areapk != null && !this.areapk.equals(other.areapk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Areatbl[ areapk=" + areapk + " ]";
    }
    
}

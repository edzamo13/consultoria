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
@Table(name = "UBICATBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicatbl.findAll", query = "SELECT u FROM Ubicatbl u"),
    @NamedQuery(name = "Ubicatbl.findByUbicpk", query = "SELECT u FROM Ubicatbl u WHERE u.ubicpk = :ubicpk"),
    @NamedQuery(name = "Ubicatbl.findByUbcodigo", query = "SELECT u FROM Ubicatbl u WHERE u.ubcodigo = :ubcodigo"),
    @NamedQuery(name = "Ubicatbl.findByUbnombre", query = "SELECT u FROM Ubicatbl u WHERE u.ubnombre = :ubnombre"),
    @NamedQuery(name = "Ubicatbl.findByUbestado", query = "SELECT u FROM Ubicatbl u WHERE u.ubestado = :ubestado")})
public class Ubicatbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UBICPK")
    private Integer ubicpk;
    @Column(name = "UBCODIGO")
    private Integer ubcodigo;
    @Size(max = 50)
    @Column(name = "UBNOMBRE")
    private String ubnombre;
    @Size(max = 30)
    @Column(name = "UBESTADO")
    private String ubestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ububicfk")
    private List<Unidmedtbl> unidmedtblList;
    @JoinColumn(name = "UBZOMSPFK", referencedColumnName = "ZONAPK")
    @ManyToOne
    private Zonastbl ubzomspfk;
    @JoinColumn(name = "UBZOIEFK", referencedColumnName = "ZONAPK")
    @ManyToOne
    private Zonastbl ubzoiefk;
    @OneToMany(mappedBy = "ububicfk")
    private List<Ubicatbl> ubicatblList;
    @JoinColumn(name = "UBUBICFK", referencedColumnName = "UBICPK")
    @ManyToOne
    private Ubicatbl ububicfk;

    public Ubicatbl() {
    }

    public Ubicatbl(Integer ubicpk) {
        this.ubicpk = ubicpk;
    }

    public Integer getUbicpk() {
        return ubicpk;
    }

    public void setUbicpk(Integer ubicpk) {
        this.ubicpk = ubicpk;
    }

    public Integer getUbcodigo() {
        return ubcodigo;
    }

    public void setUbcodigo(Integer ubcodigo) {
        this.ubcodigo = ubcodigo;
    }

    public String getUbnombre() {
        return ubnombre;
    }

    public void setUbnombre(String ubnombre) {
        this.ubnombre = ubnombre;
    }

    public String getUbestado() {
        return ubestado;
    }

    public void setUbestado(String ubestado) {
        this.ubestado = ubestado;
    }

    @XmlTransient
    public List<Unidmedtbl> getUnidmedtblList() {
        return unidmedtblList;
    }

    public void setUnidmedtblList(List<Unidmedtbl> unidmedtblList) {
        this.unidmedtblList = unidmedtblList;
    }

    public Zonastbl getUbzomspfk() {
        return ubzomspfk;
    }

    public void setUbzomspfk(Zonastbl ubzomspfk) {
        this.ubzomspfk = ubzomspfk;
    }

    public Zonastbl getUbzoiefk() {
        return ubzoiefk;
    }

    public void setUbzoiefk(Zonastbl ubzoiefk) {
        this.ubzoiefk = ubzoiefk;
    }

    @XmlTransient
    public List<Ubicatbl> getUbicatblList() {
        return ubicatblList;
    }

    public void setUbicatblList(List<Ubicatbl> ubicatblList) {
        this.ubicatblList = ubicatblList;
    }

    public Ubicatbl getUbubicfk() {
        return ububicfk;
    }

    public void setUbubicfk(Ubicatbl ububicfk) {
        this.ububicfk = ububicfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubicpk != null ? ubicpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicatbl)) {
            return false;
        }
        Ubicatbl other = (Ubicatbl) object;
        if ((this.ubicpk == null && other.ubicpk != null) || (this.ubicpk != null && !this.ubicpk.equals(other.ubicpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Ubicatbl[ ubicpk=" + ubicpk + " ]";
    }
    
}

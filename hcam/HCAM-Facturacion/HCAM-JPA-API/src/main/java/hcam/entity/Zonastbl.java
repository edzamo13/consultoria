/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "ZONASTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zonastbl.findAll", query = "SELECT z FROM Zonastbl z"),
    @NamedQuery(name = "Zonastbl.findByZonapk", query = "SELECT z FROM Zonastbl z WHERE z.zonapk = :zonapk"),
    @NamedQuery(name = "Zonastbl.findByZocodigo", query = "SELECT z FROM Zonastbl z WHERE z.zocodigo = :zocodigo"),
    @NamedQuery(name = "Zonastbl.findByZonombre", query = "SELECT z FROM Zonastbl z WHERE z.zonombre = :zonombre"),
    @NamedQuery(name = "Zonastbl.findByZoestado", query = "SELECT z FROM Zonastbl z WHERE z.zoestado = :zoestado")})
public class Zonastbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZONAPK")
    private Integer zonapk;
    @Column(name = "ZOCODIGO")
    private Integer zocodigo;
    @Size(max = 50)
    @Column(name = "ZONOMBRE")
    private String zonombre;
    @Size(max = 30)
    @Column(name = "ZOESTADO")
    private String zoestado;
    @OneToMany(mappedBy = "ubzomspfk")
    private List<Ubicatbl> ubicatblList;
    @OneToMany(mappedBy = "ubzoiefk")
    private List<Ubicatbl> ubicatblList1;
    @OneToMany(mappedBy = "zozonafk")
    private List<Zonastbl> zonastblList;
    @JoinColumn(name = "ZOZONAFK", referencedColumnName = "ZONAPK")
    @ManyToOne
    private Zonastbl zozonafk;

    public Zonastbl() {
    }

    public Zonastbl(Integer zonapk) {
        this.zonapk = zonapk;
    }

    public Integer getZonapk() {
        return zonapk;
    }

    public void setZonapk(Integer zonapk) {
        this.zonapk = zonapk;
    }

    public Integer getZocodigo() {
        return zocodigo;
    }

    public void setZocodigo(Integer zocodigo) {
        this.zocodigo = zocodigo;
    }

    public String getZonombre() {
        return zonombre;
    }

    public void setZonombre(String zonombre) {
        this.zonombre = zonombre;
    }

    public String getZoestado() {
        return zoestado;
    }

    public void setZoestado(String zoestado) {
        this.zoestado = zoestado;
    }

    @XmlTransient
    public List<Ubicatbl> getUbicatblList() {
        return ubicatblList;
    }

    public void setUbicatblList(List<Ubicatbl> ubicatblList) {
        this.ubicatblList = ubicatblList;
    }

    @XmlTransient
    public List<Ubicatbl> getUbicatblList1() {
        return ubicatblList1;
    }

    public void setUbicatblList1(List<Ubicatbl> ubicatblList1) {
        this.ubicatblList1 = ubicatblList1;
    }

    @XmlTransient
    public List<Zonastbl> getZonastblList() {
        return zonastblList;
    }

    public void setZonastblList(List<Zonastbl> zonastblList) {
        this.zonastblList = zonastblList;
    }

    public Zonastbl getZozonafk() {
        return zozonafk;
    }

    public void setZozonafk(Zonastbl zozonafk) {
        this.zozonafk = zozonafk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonapk != null ? zonapk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonastbl)) {
            return false;
        }
        Zonastbl other = (Zonastbl) object;
        if ((this.zonapk == null && other.zonapk != null) || (this.zonapk != null && !this.zonapk.equals(other.zonapk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Zonastbl[ zonapk=" + zonapk + " ]";
    }
    
}

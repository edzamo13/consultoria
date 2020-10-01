/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HISTCLITBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Histclitbl.findAll", query = "SELECT h FROM Histclitbl h"),
    @NamedQuery(name = "Histclitbl.findByHiidpk", query = "SELECT h FROM Histclitbl h WHERE h.hiidpk = :hiidpk"),
    @NamedQuery(name = "Histclitbl.findByHinombrepa", query = "SELECT h FROM Histclitbl h WHERE h.hinombrepa = :hinombrepa"),
    @NamedQuery(name = "Histclitbl.findByHiumfk", query = "SELECT h FROM Histclitbl h WHERE h.hiumfk = :hiumfk"),
    @NamedQuery(name = "Histclitbl.findByHicedula", query = "SELECT h FROM Histclitbl h WHERE h.hicedula = :hicedula")})
public class Histclitbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIIDPK")
    private Integer hiidpk;
    @Size(max = 100)
    @Column(name = "HINOMBREPA")
    private String hinombrepa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIUMFK")
    private int hiumfk;
    @Column(name = "HICEDULA")
    private Integer hicedula;
    @JoinColumn(name = "HIUMIDFK", referencedColumnName = "UNIDPK")
    @ManyToOne(optional = false)
    private Unidmedtbl hiumidfk;

    public Histclitbl() {
    }

    public Histclitbl(Integer hiidpk) {
        this.hiidpk = hiidpk;
    }

    public Histclitbl(Integer hiidpk, int hiumfk) {
        this.hiidpk = hiidpk;
        this.hiumfk = hiumfk;
    }

    public Integer getHiidpk() {
        return hiidpk;
    }

    public void setHiidpk(Integer hiidpk) {
        this.hiidpk = hiidpk;
    }

    public String getHinombrepa() {
        return hinombrepa;
    }

    public void setHinombrepa(String hinombrepa) {
        this.hinombrepa = hinombrepa;
    }

    public int getHiumfk() {
        return hiumfk;
    }

    public void setHiumfk(int hiumfk) {
        this.hiumfk = hiumfk;
    }

    public Integer getHicedula() {
        return hicedula;
    }

    public void setHicedula(Integer hicedula) {
        this.hicedula = hicedula;
    }

    public Unidmedtbl getHiumidfk() {
        return hiumidfk;
    }

    public void setHiumidfk(Unidmedtbl hiumidfk) {
        this.hiumidfk = hiumidfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hiidpk != null ? hiidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Histclitbl)) {
            return false;
        }
        Histclitbl other = (Histclitbl) object;
        if ((this.hiidpk == null && other.hiidpk != null) || (this.hiidpk != null && !this.hiidpk.equals(other.hiidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Histclitbl[ hiidpk=" + hiidpk + " ]";
    }
    
}

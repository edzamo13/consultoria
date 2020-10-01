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
 * @author jochoa
 */
@Entity
@Table(name = "PARANIVETBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paranivetbl.findAll", query = "SELECT p FROM Paranivetbl p"),
    @NamedQuery(name = "Paranivetbl.findByPanidpk", query = "SELECT p FROM Paranivetbl p WHERE p.panidpk = :panidpk"),
    @NamedQuery(name = "Paranivetbl.findByPanidh", query = "SELECT p FROM Paranivetbl p WHERE p.panidh = :panidh"),
    @NamedQuery(name = "Paranivetbl.findByPadescri", query = "SELECT p FROM Paranivetbl p WHERE p.padescri = :padescri"),
    @NamedQuery(name = "Paranivetbl.findByPadet1", query = "SELECT p FROM Paranivetbl p WHERE p.padet1 = :padet1"),
    @NamedQuery(name = "Paranivetbl.findByPadet2", query = "SELECT p FROM Paranivetbl p WHERE p.padet2 = :padet2"),
    @NamedQuery(name = "Paranivetbl.findByPacodtar", query = "SELECT p FROM Paranivetbl p WHERE p.pacodtar = :pacodtar")})
public class Paranivetbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PANIDPK")
    private Integer panidpk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PANIDH")
    private int panidh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PADESCRI")
    private String padescri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PADET1")
    private int padet1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PADET2")
    private int padet2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PACODTAR")
    private String pacodtar;

    public Paranivetbl() {
    }

    public Paranivetbl(Integer panidpk) {
        this.panidpk = panidpk;
    }

    public Paranivetbl(Integer panidpk, int panidh, String padescri, int padet1, int padet2, String pacodtar) {
        this.panidpk = panidpk;
        this.panidh = panidh;
        this.padescri = padescri;
        this.padet1 = padet1;
        this.padet2 = padet2;
        this.pacodtar = pacodtar;
    }

    public Integer getPanidpk() {
        return panidpk;
    }

    public void setPanidpk(Integer panidpk) {
        this.panidpk = panidpk;
    }

    public int getPanidh() {
        return panidh;
    }

    public void setPanidh(int panidh) {
        this.panidh = panidh;
    }

    public String getPadescri() {
        return padescri;
    }

    public void setPadescri(String padescri) {
        this.padescri = padescri;
    }

    public int getPadet1() {
        return padet1;
    }

    public void setPadet1(int padet1) {
        this.padet1 = padet1;
    }

    public int getPadet2() {
        return padet2;
    }

    public void setPadet2(int padet2) {
        this.padet2 = padet2;
    }

    public String getPacodtar() {
        return pacodtar;
    }

    public void setPacodtar(String pacodtar) {
        this.pacodtar = pacodtar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (panidpk != null ? panidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paranivetbl)) {
            return false;
        }
        Paranivetbl other = (Paranivetbl) object;
        if ((this.panidpk == null && other.panidpk != null) || (this.panidpk != null && !this.panidpk.equals(other.panidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entity.Paranivetbl[ panidpk=" + panidpk + " ]";
    }
    
}

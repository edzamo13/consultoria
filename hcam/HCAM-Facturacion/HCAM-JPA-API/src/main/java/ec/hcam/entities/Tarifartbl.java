/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jochoa
 */
@Entity
@Table(name = "TARIFARTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifartbl.findAll", query = "SELECT t FROM Tarifartbl t"),
    @NamedQuery(name = "Tarifartbl.findByTaidpk", query = "SELECT t FROM Tarifartbl t WHERE t.taidpk = :taidpk"),
    @NamedQuery(name = "Tarifartbl.findByTacodigo", query = "SELECT t FROM Tarifartbl t WHERE t.tacodigo = :tacodigo"),
    @NamedQuery(name = "Tarifartbl.findByTadescripc", query = "SELECT t FROM Tarifartbl t WHERE t.tadescripc = :tadescripc"),
    @NamedQuery(name = "Tarifartbl.findByTanivelum", query = "SELECT t FROM Tarifartbl t WHERE t.tanivelum = :tanivelum"),
    @NamedQuery(name = "Tarifartbl.findByTafechaini", query = "SELECT t FROM Tarifartbl t WHERE t.tafechaini = :tafechaini"),
    @NamedQuery(name = "Tarifartbl.findByTafechafin", query = "SELECT t FROM Tarifartbl t WHERE t.tafechafin = :tafechafin"),
    @NamedQuery(name = "Tarifartbl.findByTavalor", query = "SELECT t FROM Tarifartbl t WHERE t.tavalor = :tavalor"),
    @NamedQuery(name = "Tarifartbl.findByTauvr", query = "SELECT t FROM Tarifartbl t WHERE t.tauvr = :tauvr"),
    @NamedQuery(name = "Tarifartbl.findByTaval2", query = "SELECT t FROM Tarifartbl t WHERE t.taval2 = :taval2"),
    @NamedQuery(name = "Tarifartbl.findByTaobservac", query = "SELECT t FROM Tarifartbl t WHERE t.taobservac = :taobservac")})
public class Tarifartbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAIDPK")
    private Integer taidpk;
    @Column(name = "TACODIGO")
    private String tacodigo;
    @Column(name = "TADESCRIPC")
    private String tadescripc;
    @Column(name = "TANIVELUM")
    private Integer tanivelum;
    @Column(name = "TAFECHAINI")
    @Temporal(TemporalType.DATE)
    private Date tafechaini;
    @Column(name = "TAFECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date tafechafin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAVALOR")
    private Float tavalor;
    @Column(name = "TAUVR")
    private Float tauvr;
    @Column(name = "TAVAL2")
    private Float taval2;
    @Column(name = "TAOBSERVAC")
    private String taobservac;
    @JoinColumn(name = "TACABTARFK", referencedColumnName = "CTIDPK")
    @ManyToOne(optional = false)
    private Cabtaritbl tacabtarfk;

    public Tarifartbl() {
    }

    public Tarifartbl(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public Integer getTaidpk() {
        return taidpk;
    }

    public void setTaidpk(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public String getTacodigo() {
        return tacodigo;
    }

    public void setTacodigo(String tacodigo) {
        this.tacodigo = tacodigo;
    }

    public String getTadescripc() {
        return tadescripc;
    }

    public void setTadescripc(String tadescripc) {
        this.tadescripc = tadescripc;
    }

    public Integer getTanivelum() {
        return tanivelum;
    }

    public void setTanivelum(Integer tanivelum) {
        this.tanivelum = tanivelum;
    }

    public Date getTafechaini() {
        return tafechaini;
    }

    public void setTafechaini(Date tafechaini) {
        this.tafechaini = tafechaini;
    }

    public Date getTafechafin() {
        return tafechafin;
    }

    public void setTafechafin(Date tafechafin) {
        this.tafechafin = tafechafin;
    }

    public Float getTavalor() {
        return tavalor;
    }

    public void setTavalor(Float tavalor) {
        this.tavalor = tavalor;
    }

    public Float getTauvr() {
        return tauvr;
    }

    public void setTauvr(Float tauvr) {
        this.tauvr = tauvr;
    }

    public Float getTaval2() {
        return taval2;
    }

    public void setTaval2(Float taval2) {
        this.taval2 = taval2;
    }

    public String getTaobservac() {
        return taobservac;
    }

    public void setTaobservac(String taobservac) {
        this.taobservac = taobservac;
    }

    public Cabtaritbl getTacabtarfk() {
        return tacabtarfk;
    }

    public void setTacabtarfk(Cabtaritbl tacabtarfk) {
        this.tacabtarfk = tacabtarfk;
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
        if (!(object instanceof Tarifartbl)) {
            return false;
        }
        Tarifartbl other = (Tarifartbl) object;
        if ((this.taidpk == null && other.taidpk != null) || (this.taidpk != null && !this.taidpk.equals(other.taidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Tarifartbl[ taidpk=" + taidpk + " ]";
    }
    
}

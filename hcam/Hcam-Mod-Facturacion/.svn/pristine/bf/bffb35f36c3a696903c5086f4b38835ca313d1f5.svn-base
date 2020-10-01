/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "REGLASTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reglastbl.findAll", query = "SELECT r FROM Reglastbl r"),
    @NamedQuery(name = "Reglastbl.findByReidpk", query = "SELECT r FROM Reglastbl r WHERE r.reidpk = :reidpk"),
    @NamedQuery(name = "Reglastbl.findByRenombre", query = "SELECT r FROM Reglastbl r WHERE r.renombre = :renombre"),
    @NamedQuery(name = "Reglastbl.findByRetipo", query = "SELECT r FROM Reglastbl r WHERE r.retipo = :retipo"),
    @NamedQuery(name = "Reglastbl.findByRecalculo", query = "SELECT r FROM Reglastbl r WHERE r.recalculo = :recalculo"),
    @NamedQuery(name = "Reglastbl.findByReformula", query = "SELECT r FROM Reglastbl r WHERE r.reformula = :reformula"),
    @NamedQuery(name = "Reglastbl.findByRedescripc", query = "SELECT r FROM Reglastbl r WHERE r.redescripc = :redescripc"),
    @NamedQuery(name = "Reglastbl.findByRefechacre", query = "SELECT r FROM Reglastbl r WHERE r.refechacre = :refechacre"),
    @NamedQuery(name = "Reglastbl.findByRefechamod", query = "SELECT r FROM Reglastbl r WHERE r.refechamod = :refechamod"),
    @NamedQuery(name = "Reglastbl.findByReestado", query = "SELECT r FROM Reglastbl r WHERE r.reestado = :reestado"),
    @NamedQuery(name = "Reglastbl.findByReformula1", query = "SELECT r FROM Reglastbl r WHERE r.reformula1 = :reformula1")})
public class Reglastbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REIDPK")
    private Integer reidpk;
    @Size(max = 50)
    @Column(name = "RENOMBRE")
    private String renombre;
    @Size(max = 100)
    @Column(name = "RETIPO")
    private String retipo;
    @Size(max = 100)
    @Column(name = "RECALCULO")
    private String recalculo;
    @Size(max = 200)
    @Column(name = "REFORMULA")
    private String reformula;
    @Size(max = 500)
    @Column(name = "REDESCRIPC")
    private String redescripc;
    @Column(name = "REFECHACRE")
    @Temporal(TemporalType.DATE)
    private Date refechacre;
    @Column(name = "REFECHAMOD")
    @Temporal(TemporalType.DATE)
    private Date refechamod;
    @Size(max = 30)
    @Column(name = "REESTADO")
    private String reestado;
    @Size(max = 1000)
    @Column(name = "REFORMULA1")
    private String reformula1;
    @JoinColumn(name = "TAIDPK", referencedColumnName = "TAIDPK")
    @ManyToOne
    private Tipoacrtbl taidpk;
    @OneToMany(mappedBy = "regReidpk")
    private List<Reglastbl> reglastblList;
    @JoinColumn(name = "REG_REIDPK", referencedColumnName = "REIDPK")
    @ManyToOne
    private Reglastbl regReidpk;
    @JoinColumn(name = "PAIDPK", referencedColumnName = "PAIDPK")
    @ManyToOne
    private Parmfactbl paidpk;
    @OneToMany(mappedBy = "reidpk")
    private List<Formutbl> formutblList;

    public Reglastbl() {
    }

    public Reglastbl(Integer reidpk) {
        this.reidpk = reidpk;
    }

    public Integer getReidpk() {
        return reidpk;
    }

    public void setReidpk(Integer reidpk) {
        this.reidpk = reidpk;
    }

    public String getRenombre() {
        return renombre;
    }

    public void setRenombre(String renombre) {
        this.renombre = renombre;
    }

    public String getRetipo() {
        return retipo;
    }

    public void setRetipo(String retipo) {
        this.retipo = retipo;
    }

    public String getRecalculo() {
        return recalculo;
    }

    public void setRecalculo(String recalculo) {
        this.recalculo = recalculo;
    }

    public String getReformula() {
        return reformula;
    }

    public void setReformula(String reformula) {
        this.reformula = reformula;
    }

    public String getRedescripc() {
        return redescripc;
    }

    public void setRedescripc(String redescripc) {
        this.redescripc = redescripc;
    }

    public Date getRefechacre() {
        return refechacre;
    }

    public void setRefechacre(Date refechacre) {
        this.refechacre = refechacre;
    }

    public Date getRefechamod() {
        return refechamod;
    }

    public void setRefechamod(Date refechamod) {
        this.refechamod = refechamod;
    }

    public String getReestado() {
        return reestado;
    }

    public void setReestado(String reestado) {
        this.reestado = reestado;
    }

    public String getReformula1() {
        return reformula1;
    }

    public void setReformula1(String reformula1) {
        this.reformula1 = reformula1;
    }

    public Tipoacrtbl getTaidpk() {
        return taidpk;
    }

    public void setTaidpk(Tipoacrtbl taidpk) {
        this.taidpk = taidpk;
    }

    @XmlTransient
    public List<Reglastbl> getReglastblList() {
        return reglastblList;
    }

    public void setReglastblList(List<Reglastbl> reglastblList) {
        this.reglastblList = reglastblList;
    }

    public Reglastbl getRegReidpk() {
        return regReidpk;
    }

    public void setRegReidpk(Reglastbl regReidpk) {
        this.regReidpk = regReidpk;
    }

    public Parmfactbl getPaidpk() {
        return paidpk;
    }

    public void setPaidpk(Parmfactbl paidpk) {
        this.paidpk = paidpk;
    }

    @XmlTransient
    public List<Formutbl> getFormutblList() {
        return formutblList;
    }

    public void setFormutblList(List<Formutbl> formutblList) {
        this.formutblList = formutblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reidpk != null ? reidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglastbl)) {
            return false;
        }
        Reglastbl other = (Reglastbl) object;
        if ((this.reidpk == null && other.reidpk != null) || (this.reidpk != null && !this.reidpk.equals(other.reidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Reglastbl[ reidpk=" + reidpk + " ]";
    }
    
}

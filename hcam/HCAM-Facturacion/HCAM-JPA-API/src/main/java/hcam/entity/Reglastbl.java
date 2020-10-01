/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "REGLASTBL")
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
    @NamedQuery(name = "Reglastbl.findByReparam1", query = "SELECT r FROM Reglastbl r WHERE r.reparam1 = :reparam1"),
    @NamedQuery(name = "Reglastbl.findByReparam2", query = "SELECT r FROM Reglastbl r WHERE r.reparam2 = :reparam2"),
    @NamedQuery(name = "Reglastbl.findByReparam3", query = "SELECT r FROM Reglastbl r WHERE r.reparam3 = :reparam3"),
    @NamedQuery(name = "Reglastbl.findByReparam4", query = "SELECT r FROM Reglastbl r WHERE r.reparam4 = :reparam4"),
    @NamedQuery(name = "Reglastbl.findByReparam5", query = "SELECT r FROM Reglastbl r WHERE r.reparam5 = :reparam5")})
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
    @Size(max = 50)
    @Column(name = "REPARAM1")
    private String reparam1;
    @Size(max = 50)
    @Column(name = "REPARAM2")
    private String reparam2;
    @Size(max = 50)
    @Column(name = "REPARAM3")
    private String reparam3;
    @Size(max = 50)
    @Column(name = "REPARAM4")
    private String reparam4;
    @Size(max = 50)
    @Column(name = "REPARAM5")
    private String reparam5;
    @JoinColumn(name = "REPARIDFK", referencedColumnName = "PAIDPK")
    @ManyToOne(optional = false)
    private Parmfactbl reparidfk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esreglidfk")
    private List<Esquematbl> esquematblList;

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

    public String getReparam1() {
        return reparam1;
    }

    public void setReparam1(String reparam1) {
        this.reparam1 = reparam1;
    }

    public String getReparam2() {
        return reparam2;
    }

    public void setReparam2(String reparam2) {
        this.reparam2 = reparam2;
    }

    public String getReparam3() {
        return reparam3;
    }

    public void setReparam3(String reparam3) {
        this.reparam3 = reparam3;
    }

    public String getReparam4() {
        return reparam4;
    }

    public void setReparam4(String reparam4) {
        this.reparam4 = reparam4;
    }

    public String getReparam5() {
        return reparam5;
    }

    public void setReparam5(String reparam5) {
        this.reparam5 = reparam5;
    }

    public Parmfactbl getReparidfk() {
        return reparidfk;
    }

    public void setReparidfk(Parmfactbl reparidfk) {
        this.reparidfk = reparidfk;
    }

    @XmlTransient
    public List<Esquematbl> getEsquematblList() {
        return esquematblList;
    }

    public void setEsquematblList(List<Esquematbl> esquematblList) {
        this.esquematblList = esquematblList;
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
        return "hcam.entity.Reglastbl[ reidpk=" + reidpk + " ]";
    }
    
}

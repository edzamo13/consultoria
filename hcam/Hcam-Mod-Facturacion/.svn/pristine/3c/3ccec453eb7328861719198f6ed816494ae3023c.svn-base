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
@Table(name = "PARAMTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paramtbl.findAll", query = "SELECT p FROM Paramtbl p"),
    @NamedQuery(name = "Paramtbl.findByPamidpk", query = "SELECT p FROM Paramtbl p WHERE p.pamidpk = :pamidpk"),
    @NamedQuery(name = "Paramtbl.findByPamnombre", query = "SELECT p FROM Paramtbl p WHERE p.pamnombre = :pamnombre"),
    @NamedQuery(name = "Paramtbl.findByPamvalor", query = "SELECT p FROM Paramtbl p WHERE p.pamvalor = :pamvalor"),
    @NamedQuery(name = "Paramtbl.findByPamtipoval", query = "SELECT p FROM Paramtbl p WHERE p.pamtipoval = :pamtipoval"),
    @NamedQuery(name = "Paramtbl.findByPamestado", query = "SELECT p FROM Paramtbl p WHERE p.pamestado = :pamestado")})
public class Paramtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAMIDPK")
    private Integer pamidpk;
    @Size(max = 50)
    @Column(name = "PAMNOMBRE")
    private String pamnombre;
    @Size(max = 50)
    @Column(name = "PAMVALOR")
    private String pamvalor;
    @Size(max = 50)
    @Column(name = "PAMTIPOVAL")
    private String pamtipoval;
    @Size(max = 30)
    @Column(name = "PAMESTADO")
    private String pamestado;
    @OneToMany(mappedBy = "pamidpk")
    private List<Repatbl> repatblList;
    @JoinColumn(name = "PRPROCEDPK", referencedColumnName = "PRPROCEDPK")
    @ManyToOne
    private Proceditbl prprocedpk;

    public Paramtbl() {
    }

    public Paramtbl(Integer pamidpk) {
        this.pamidpk = pamidpk;
    }

    public Integer getPamidpk() {
        return pamidpk;
    }

    public void setPamidpk(Integer pamidpk) {
        this.pamidpk = pamidpk;
    }

    public String getPamnombre() {
        return pamnombre;
    }

    public void setPamnombre(String pamnombre) {
        this.pamnombre = pamnombre;
    }

    public String getPamvalor() {
        return pamvalor;
    }

    public void setPamvalor(String pamvalor) {
        this.pamvalor = pamvalor;
    }

    public String getPamtipoval() {
        return pamtipoval;
    }

    public void setPamtipoval(String pamtipoval) {
        this.pamtipoval = pamtipoval;
    }

    public String getPamestado() {
        return pamestado;
    }

    public void setPamestado(String pamestado) {
        this.pamestado = pamestado;
    }

    @XmlTransient
    public List<Repatbl> getRepatblList() {
        return repatblList;
    }

    public void setRepatblList(List<Repatbl> repatblList) {
        this.repatblList = repatblList;
    }

    public Proceditbl getPrprocedpk() {
        return prprocedpk;
    }

    public void setPrprocedpk(Proceditbl prprocedpk) {
        this.prprocedpk = prprocedpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pamidpk != null ? pamidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paramtbl)) {
            return false;
        }
        Paramtbl other = (Paramtbl) object;
        if ((this.pamidpk == null && other.pamidpk != null) || (this.pamidpk != null && !this.pamidpk.equals(other.pamidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Paramtbl[ pamidpk=" + pamidpk + " ]";
    }
    
}

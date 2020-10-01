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
@Table(name = "SERVTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servtbl.findAll", query = "SELECT s FROM Servtbl s"),
    @NamedQuery(name = "Servtbl.findBySeidpk", query = "SELECT s FROM Servtbl s WHERE s.seidpk = :seidpk"),
    @NamedQuery(name = "Servtbl.findBySecodigo", query = "SELECT s FROM Servtbl s WHERE s.secodigo = :secodigo"),
    @NamedQuery(name = "Servtbl.findBySenombre", query = "SELECT s FROM Servtbl s WHERE s.senombre = :senombre"),
    @NamedQuery(name = "Servtbl.findBySeobserv", query = "SELECT s FROM Servtbl s WHERE s.seobserv = :seobserv"),
    @NamedQuery(name = "Servtbl.findBySeestado", query = "SELECT s FROM Servtbl s WHERE s.seestado = :seestado")})
public class Servtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEIDPK")
    private Integer seidpk;
    @Size(max = 50)
    @Column(name = "SECODIGO")
    private String secodigo;
    @Size(max = 50)
    @Column(name = "SENOMBRE")
    private String senombre;
    @Size(max = 300)
    @Column(name = "SEOBSERV")
    private String seobserv;
    @Size(max = 30)
    @Column(name = "SEESTADO")
    private String seestado;
    @OneToMany(mappedBy = "seidpk")
    private List<Parmfactbl> parmfactblList;
    @OneToMany(mappedBy = "seidpk")
    private List<Consultbl> consultblList;
    @JoinColumn(name = "UNIMPK", referencedColumnName = "UNIMPK")
    @ManyToOne
    private Unimdeptbl unimpk;

    public Servtbl() {
    }

    public Servtbl(Integer seidpk) {
        this.seidpk = seidpk;
    }

    public Integer getSeidpk() {
        return seidpk;
    }

    public void setSeidpk(Integer seidpk) {
        this.seidpk = seidpk;
    }

    public String getSecodigo() {
        return secodigo;
    }

    public void setSecodigo(String secodigo) {
        this.secodigo = secodigo;
    }

    public String getSenombre() {
        return senombre;
    }

    public void setSenombre(String senombre) {
        this.senombre = senombre;
    }

    public String getSeobserv() {
        return seobserv;
    }

    public void setSeobserv(String seobserv) {
        this.seobserv = seobserv;
    }

    public String getSeestado() {
        return seestado;
    }

    public void setSeestado(String seestado) {
        this.seestado = seestado;
    }

    @XmlTransient
    public List<Parmfactbl> getParmfactblList() {
        return parmfactblList;
    }

    public void setParmfactblList(List<Parmfactbl> parmfactblList) {
        this.parmfactblList = parmfactblList;
    }

    @XmlTransient
    public List<Consultbl> getConsultblList() {
        return consultblList;
    }

    public void setConsultblList(List<Consultbl> consultblList) {
        this.consultblList = consultblList;
    }

    public Unimdeptbl getUnimpk() {
        return unimpk;
    }

    public void setUnimpk(Unimdeptbl unimpk) {
        this.unimpk = unimpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seidpk != null ? seidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servtbl)) {
            return false;
        }
        Servtbl other = (Servtbl) object;
        if ((this.seidpk == null && other.seidpk != null) || (this.seidpk != null && !this.seidpk.equals(other.seidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Servtbl[ seidpk=" + seidpk + " ]";
    }
    
}

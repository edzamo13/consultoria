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
import javax.persistence.JoinColumns;
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
@Table(name = "UNIMDEPTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unimdeptbl.findAll", query = "SELECT u FROM Unimdeptbl u"),
    @NamedQuery(name = "Unimdeptbl.findByUnimpk", query = "SELECT u FROM Unimdeptbl u WHERE u.unimpk = :unimpk"),
    @NamedQuery(name = "Unimdeptbl.findByFechaasig", query = "SELECT u FROM Unimdeptbl u WHERE u.fechaasig = :fechaasig"),
    @NamedQuery(name = "Unimdeptbl.findByEstado", query = "SELECT u FROM Unimdeptbl u WHERE u.estado = :estado")})
public class Unimdeptbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIMPK")
    private Integer unimpk;
    @Column(name = "FECHAASIG")
    @Temporal(TemporalType.DATE)
    private Date fechaasig;
    @Size(max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "UNIDPK", referencedColumnName = "UNIDPK"),
        @JoinColumn(name = "UBICAPK", referencedColumnName = "UBICAPK")})
    @ManyToOne
    private Unidmedtbl unidmedtbl;
    @JoinColumn(name = "DEPUNPK", referencedColumnName = "DEPUNPK")
    @ManyToOne
    private Deunitbl depunpk;
    @OneToMany(mappedBy = "unimpk")
    private List<Servtbl> servtblList;

    public Unimdeptbl() {
    }

    public Unimdeptbl(Integer unimpk) {
        this.unimpk = unimpk;
    }

    public Integer getUnimpk() {
        return unimpk;
    }

    public void setUnimpk(Integer unimpk) {
        this.unimpk = unimpk;
    }

    public Date getFechaasig() {
        return fechaasig;
    }

    public void setFechaasig(Date fechaasig) {
        this.fechaasig = fechaasig;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Unidmedtbl getUnidmedtbl() {
        return unidmedtbl;
    }

    public void setUnidmedtbl(Unidmedtbl unidmedtbl) {
        this.unidmedtbl = unidmedtbl;
    }

    public Deunitbl getDepunpk() {
        return depunpk;
    }

    public void setDepunpk(Deunitbl depunpk) {
        this.depunpk = depunpk;
    }

    @XmlTransient
    public List<Servtbl> getServtblList() {
        return servtblList;
    }

    public void setServtblList(List<Servtbl> servtblList) {
        this.servtblList = servtblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unimpk != null ? unimpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unimdeptbl)) {
            return false;
        }
        Unimdeptbl other = (Unimdeptbl) object;
        if ((this.unimpk == null && other.unimpk != null) || (this.unimpk != null && !this.unimpk.equals(other.unimpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Unimdeptbl[ unimpk=" + unimpk + " ]";
    }
    
}

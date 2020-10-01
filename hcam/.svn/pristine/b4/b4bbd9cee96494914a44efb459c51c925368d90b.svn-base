/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jochoa
 */
@Entity
@Table(name = "SERVICIOTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviciotbl.findAll", query = "SELECT s FROM Serviciotbl s"),
    @NamedQuery(name = "Serviciotbl.findBySeidpk", query = "SELECT s FROM Serviciotbl s WHERE s.seidpk = :seidpk"),
    @NamedQuery(name = "Serviciotbl.findBySecodigo", query = "SELECT s FROM Serviciotbl s WHERE s.secodigo = :secodigo"),
    @NamedQuery(name = "Serviciotbl.findBySenombre", query = "SELECT s FROM Serviciotbl s WHERE s.senombre = :senombre"),
    @NamedQuery(name = "Serviciotbl.findBySeobservac", query = "SELECT s FROM Serviciotbl s WHERE s.seobservac = :seobservac"),
    @NamedQuery(name = "Serviciotbl.findBySeestado", query = "SELECT s FROM Serviciotbl s WHERE s.seestado = :seestado")})
public class Serviciotbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SEIDPK")
    private Integer seidpk;
    @Column(name = "SECODIGO")
    private String secodigo;
    @Column(name = "SENOMBRE")
    private String senombre;
    @Column(name = "SEOBSERVAC")
    private String seobservac;
    @Column(name = "SEESTADO")
    private String seestado;
    @JoinColumn(name = "SEUNMEDFK", referencedColumnName = "UNIDPK")
    @ManyToOne(optional = false)
    private Unidmedtbl seunmedfk;

    public Serviciotbl() {
    }

    public Serviciotbl(Integer seidpk) {
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

    public String getSeobservac() {
        return seobservac;
    }

    public void setSeobservac(String seobservac) {
        this.seobservac = seobservac;
    }

    public String getSeestado() {
        return seestado;
    }

    public void setSeestado(String seestado) {
        this.seestado = seestado;
    }

    public Unidmedtbl getSeunmedfk() {
        return seunmedfk;
    }

    public void setSeunmedfk(Unidmedtbl seunmedfk) {
        this.seunmedfk = seunmedfk;
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
        if (!(object instanceof Serviciotbl)) {
            return false;
        }
        Serviciotbl other = (Serviciotbl) object;
        if ((this.seidpk == null && other.seidpk != null) || (this.seidpk != null && !this.seidpk.equals(other.seidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Serviciotbl[ seidpk=" + seidpk + " ]";
    }
    
}

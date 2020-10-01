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
@Table(name = "REPATBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repatbl.findAll", query = "SELECT r FROM Repatbl r"),
    @NamedQuery(name = "Repatbl.findByTaidpk", query = "SELECT r FROM Repatbl r WHERE r.taidpk = :taidpk"),
    @NamedQuery(name = "Repatbl.findByEstadore", query = "SELECT r FROM Repatbl r WHERE r.estadore = :estadore")})
public class Repatbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAIDPK")
    private Integer taidpk;
    @Size(max = 30)
    @Column(name = "ESTADORE")
    private String estadore;
    @JoinColumn(name = "PAMIDPK", referencedColumnName = "PAMIDPK")
    @ManyToOne
    private Paramtbl pamidpk;
    @JoinColumn(name = "FORMUPK", referencedColumnName = "FORMUPK")
    @ManyToOne
    private Formutbl formupk;

    public Repatbl() {
    }

    public Repatbl(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public Integer getTaidpk() {
        return taidpk;
    }

    public void setTaidpk(Integer taidpk) {
        this.taidpk = taidpk;
    }

    public String getEstadore() {
        return estadore;
    }

    public void setEstadore(String estadore) {
        this.estadore = estadore;
    }

    public Paramtbl getPamidpk() {
        return pamidpk;
    }

    public void setPamidpk(Paramtbl pamidpk) {
        this.pamidpk = pamidpk;
    }

    public Formutbl getFormupk() {
        return formupk;
    }

    public void setFormupk(Formutbl formupk) {
        this.formupk = formupk;
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
        if (!(object instanceof Repatbl)) {
            return false;
        }
        Repatbl other = (Repatbl) object;
        if ((this.taidpk == null && other.taidpk != null) || (this.taidpk != null && !this.taidpk.equals(other.taidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Repatbl[ taidpk=" + taidpk + " ]";
    }
    
}

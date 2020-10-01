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
@Table(name = "CONSULTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultbl.findAll", query = "SELECT c FROM Consultbl c"),
    @NamedQuery(name = "Consultbl.findByCopk", query = "SELECT c FROM Consultbl c WHERE c.copk = :copk"),
    @NamedQuery(name = "Consultbl.findByCosql", query = "SELECT c FROM Consultbl c WHERE c.cosql = :cosql"),
    @NamedQuery(name = "Consultbl.findByCoestado", query = "SELECT c FROM Consultbl c WHERE c.coestado = :coestado")})
public class Consultbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COPK")
    private Integer copk;
    @Size(max = 300)
    @Column(name = "COSQL")
    private String cosql;
    @Size(max = 30)
    @Column(name = "COESTADO")
    private String coestado;
    @JoinColumn(name = "SEIDPK", referencedColumnName = "SEIDPK")
    @ManyToOne
    private Servtbl seidpk;

    public Consultbl() {
    }

    public Consultbl(Integer copk) {
        this.copk = copk;
    }

    public Integer getCopk() {
        return copk;
    }

    public void setCopk(Integer copk) {
        this.copk = copk;
    }

    public String getCosql() {
        return cosql;
    }

    public void setCosql(String cosql) {
        this.cosql = cosql;
    }

    public String getCoestado() {
        return coestado;
    }

    public void setCoestado(String coestado) {
        this.coestado = coestado;
    }

    public Servtbl getSeidpk() {
        return seidpk;
    }

    public void setSeidpk(Servtbl seidpk) {
        this.seidpk = seidpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (copk != null ? copk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultbl)) {
            return false;
        }
        Consultbl other = (Consultbl) object;
        if ((this.copk == null && other.copk != null) || (this.copk != null && !this.copk.equals(other.copk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Consultbl[ copk=" + copk + " ]";
    }
    
}

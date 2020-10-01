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
@Table(name = "FORMUTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formutbl.findAll", query = "SELECT f FROM Formutbl f"),
    @NamedQuery(name = "Formutbl.findByFormupk", query = "SELECT f FROM Formutbl f WHERE f.formupk = :formupk"),
    @NamedQuery(name = "Formutbl.findByNombform", query = "SELECT f FROM Formutbl f WHERE f.nombform = :nombform"),
    @NamedQuery(name = "Formutbl.findByValorform", query = "SELECT f FROM Formutbl f WHERE f.valorform = :valorform"),
    @NamedQuery(name = "Formutbl.findByEstdform", query = "SELECT f FROM Formutbl f WHERE f.estdform = :estdform"),
    @NamedQuery(name = "Formutbl.findByCalcuform", query = "SELECT f FROM Formutbl f WHERE f.calcuform = :calcuform")})
public class Formutbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMUPK")
    private Integer formupk;
    @Size(max = 30)
    @Column(name = "NOMBFORM")
    private String nombform;
    @Size(max = 400)
    @Column(name = "VALORFORM")
    private String valorform;
    @Size(max = 30)
    @Column(name = "ESTDFORM")
    private String estdform;
    @Size(max = 10)
    @Column(name = "CALCUFORM")
    private String calcuform;
    @JoinColumn(name = "REIDPK", referencedColumnName = "REIDPK")
    @ManyToOne
    private Reglastbl reidpk;
    @OneToMany(mappedBy = "formupk")
    private List<Repatbl> repatblList;

    public Formutbl() {
    }

    public Formutbl(Integer formupk) {
        this.formupk = formupk;
    }

    public Integer getFormupk() {
        return formupk;
    }

    public void setFormupk(Integer formupk) {
        this.formupk = formupk;
    }

    public String getNombform() {
        return nombform;
    }

    public void setNombform(String nombform) {
        this.nombform = nombform;
    }

    public String getValorform() {
        return valorform;
    }

    public void setValorform(String valorform) {
        this.valorform = valorform;
    }

    public String getEstdform() {
        return estdform;
    }

    public void setEstdform(String estdform) {
        this.estdform = estdform;
    }

    public String getCalcuform() {
        return calcuform;
    }

    public void setCalcuform(String calcuform) {
        this.calcuform = calcuform;
    }

    public Reglastbl getReidpk() {
        return reidpk;
    }

    public void setReidpk(Reglastbl reidpk) {
        this.reidpk = reidpk;
    }

    @XmlTransient
    public List<Repatbl> getRepatblList() {
        return repatblList;
    }

    public void setRepatblList(List<Repatbl> repatblList) {
        this.repatblList = repatblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formupk != null ? formupk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formutbl)) {
            return false;
        }
        Formutbl other = (Formutbl) object;
        if ((this.formupk == null && other.formupk != null) || (this.formupk != null && !this.formupk.equals(other.formupk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Formutbl[ formupk=" + formupk + " ]";
    }
    
}

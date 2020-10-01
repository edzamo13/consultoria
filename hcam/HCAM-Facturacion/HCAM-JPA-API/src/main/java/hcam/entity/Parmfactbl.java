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
@Table(name = "PARMFACTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parmfactbl.findAll", query = "SELECT p FROM Parmfactbl p"),
    @NamedQuery(name = "Parmfactbl.findByPaidpk", query = "SELECT p FROM Parmfactbl p WHERE p.paidpk = :paidpk"),
    @NamedQuery(name = "Parmfactbl.findByPacodigo", query = "SELECT p FROM Parmfactbl p WHERE p.pacodigo = :pacodigo"),
    @NamedQuery(name = "Parmfactbl.findByPanombre", query = "SELECT p FROM Parmfactbl p WHERE p.panombre = :panombre"),
    @NamedQuery(name = "Parmfactbl.findByPadescripc", query = "SELECT p FROM Parmfactbl p WHERE p.padescripc = :padescripc"),
    @NamedQuery(name = "Parmfactbl.findByPatipcobro", query = "SELECT p FROM Parmfactbl p WHERE p.patipcobro = :patipcobro"),
    @NamedQuery(name = "Parmfactbl.findByPadetalle", query = "SELECT p FROM Parmfactbl p WHERE p.padetalle = :padetalle"),
    @NamedQuery(name = "Parmfactbl.findByPafechaini", query = "SELECT p FROM Parmfactbl p WHERE p.pafechaini = :pafechaini"),
    @NamedQuery(name = "Parmfactbl.findByPafechafin", query = "SELECT p FROM Parmfactbl p WHERE p.pafechafin = :pafechafin"),
    @NamedQuery(name = "Parmfactbl.findByPaestado", query = "SELECT p FROM Parmfactbl p WHERE p.paestado = :paestado")})
public class Parmfactbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAIDPK")
    private Integer paidpk;
    @Size(max = 50)
    @Column(name = "PACODIGO")
    private String pacodigo;
    @Size(max = 100)
    @Column(name = "PANOMBRE")
    private String panombre;
    @Size(max = 500)
    @Column(name = "PADESCRIPC")
    private String padescripc;
    @Size(max = 50)
    @Column(name = "PATIPCOBRO")
    private String patipcobro;
    @Size(max = 50)
    @Column(name = "PADETALLE")
    private String padetalle;
    @Column(name = "PAFECHAINI")
    @Temporal(TemporalType.DATE)
    private Date pafechaini;
    @Column(name = "PAFECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date pafechafin;
    @Size(max = 30)
    @Column(name = "PAESTADO")
    private String paestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reparidfk")
    private List<Reglastbl> reglastblList;
    @JoinColumn(name = "PASERIDFK", referencedColumnName = "SEIDPK")
    @ManyToOne(optional = false)
    private Serviciotbl paseridfk;

    public Parmfactbl() {
    }

    public Parmfactbl(Integer paidpk) {
        this.paidpk = paidpk;
    }

    public Integer getPaidpk() {
        return paidpk;
    }

    public void setPaidpk(Integer paidpk) {
        this.paidpk = paidpk;
    }

    public String getPacodigo() {
        return pacodigo;
    }

    public void setPacodigo(String pacodigo) {
        this.pacodigo = pacodigo;
    }

    public String getPanombre() {
        return panombre;
    }

    public void setPanombre(String panombre) {
        this.panombre = panombre;
    }

    public String getPadescripc() {
        return padescripc;
    }

    public void setPadescripc(String padescripc) {
        this.padescripc = padescripc;
    }

    public String getPatipcobro() {
        return patipcobro;
    }

    public void setPatipcobro(String patipcobro) {
        this.patipcobro = patipcobro;
    }

    public String getPadetalle() {
        return padetalle;
    }

    public void setPadetalle(String padetalle) {
        this.padetalle = padetalle;
    }

    public Date getPafechaini() {
        return pafechaini;
    }

    public void setPafechaini(Date pafechaini) {
        this.pafechaini = pafechaini;
    }

    public Date getPafechafin() {
        return pafechafin;
    }

    public void setPafechafin(Date pafechafin) {
        this.pafechafin = pafechafin;
    }

    public String getPaestado() {
        return paestado;
    }

    public void setPaestado(String paestado) {
        this.paestado = paestado;
    }

    @XmlTransient
    public List<Reglastbl> getReglastblList() {
        return reglastblList;
    }

    public void setReglastblList(List<Reglastbl> reglastblList) {
        this.reglastblList = reglastblList;
    }

    public Serviciotbl getPaseridfk() {
        return paseridfk;
    }

    public void setPaseridfk(Serviciotbl paseridfk) {
        this.paseridfk = paseridfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paidpk != null ? paidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parmfactbl)) {
            return false;
        }
        Parmfactbl other = (Parmfactbl) object;
        if ((this.paidpk == null && other.paidpk != null) || (this.paidpk != null && !this.paidpk.equals(other.paidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Parmfactbl[ paidpk=" + paidpk + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programacion
 */
@Entity
@Table(name = "UNIDMEDTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidmedtbl.findAll", query = "SELECT u FROM Unidmedtbl u"),
    @NamedQuery(name = "Unidmedtbl.findByUnidpk", query = "SELECT u FROM Unidmedtbl u WHERE u.unidmedtblPK.unidpk = :unidpk"),
    @NamedQuery(name = "Unidmedtbl.findByUnnombre", query = "SELECT u FROM Unidmedtbl u WHERE u.unnombre = :unnombre"),
    @NamedQuery(name = "Unidmedtbl.findByUncodigo", query = "SELECT u FROM Unidmedtbl u WHERE u.uncodigo = :uncodigo"),
    @NamedQuery(name = "Unidmedtbl.findByUnnivel", query = "SELECT u FROM Unidmedtbl u WHERE u.unnivel = :unnivel"),
    @NamedQuery(name = "Unidmedtbl.findByUnfeccre", query = "SELECT u FROM Unidmedtbl u WHERE u.unfeccre = :unfeccre"),
    @NamedQuery(name = "Unidmedtbl.findByUnfecmod", query = "SELECT u FROM Unidmedtbl u WHERE u.unfecmod = :unfecmod"),
    @NamedQuery(name = "Unidmedtbl.findByUndirec", query = "SELECT u FROM Unidmedtbl u WHERE u.undirec = :undirec"),
    @NamedQuery(name = "Unidmedtbl.findByUbicapk", query = "SELECT u FROM Unidmedtbl u WHERE u.unidmedtblPK.ubicapk = :ubicapk"),
    @NamedQuery(name = "Unidmedtbl.findByUnicom", query = "SELECT u FROM Unidmedtbl u WHERE u.unicom = :unicom"),
    @NamedQuery(name = "Unidmedtbl.findByUnestado", query = "SELECT u FROM Unidmedtbl u WHERE u.unestado = :unestado")})
public class Unidmedtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnidmedtblPK unidmedtblPK;
    @Size(max = 200)
    @Column(name = "UNNOMBRE")
    private String unnombre;
    @Size(max = 30)
    @Column(name = "UNCODIGO")
    private String uncodigo;
    @Column(name = "UNNIVEL")
    private Integer unnivel;
    @Column(name = "UNFECCRE")
    @Temporal(TemporalType.DATE)
    private Date unfeccre;
    @Column(name = "UNFECMOD")
    @Temporal(TemporalType.DATE)
    private Date unfecmod;
    @Size(max = 200)
    @Column(name = "UNDIREC")
    private String undirec;
    @Size(max = 2)
    @Column(name = "UNICOM")
    private String unicom;
    @Size(max = 30)
    @Column(name = "UNESTADO")
    private String unestado;
    @OneToMany(mappedBy = "unidmedtbl")
    private List<Unimdeptbl> unimdeptblList;
    @OneToMany(mappedBy = "unidmedtbl")
    private List<Histclitbl> histclitblList;
    @OneToMany(mappedBy = "unidmedtbl")
    private List<Cabplantbl> cabplantblList;
    @JoinColumn(name = "UBICPK", referencedColumnName = "UBICPK")
    @ManyToOne
    private Ubicatbl ubicpk;

    public Unidmedtbl() {
    }

    public Unidmedtbl(UnidmedtblPK unidmedtblPK) {
        this.unidmedtblPK = unidmedtblPK;
    }

    public Unidmedtbl(int unidpk, int ubicapk) {
        this.unidmedtblPK = new UnidmedtblPK(unidpk, ubicapk);
    }

    public UnidmedtblPK getUnidmedtblPK() {
        return unidmedtblPK;
    }

    public void setUnidmedtblPK(UnidmedtblPK unidmedtblPK) {
        this.unidmedtblPK = unidmedtblPK;
    }

    public String getUnnombre() {
        return unnombre;
    }

    public void setUnnombre(String unnombre) {
        this.unnombre = unnombre;
    }

    public String getUncodigo() {
        return uncodigo;
    }

    public void setUncodigo(String uncodigo) {
        this.uncodigo = uncodigo;
    }

    public Integer getUnnivel() {
        return unnivel;
    }

    public void setUnnivel(Integer unnivel) {
        this.unnivel = unnivel;
    }

    public Date getUnfeccre() {
        return unfeccre;
    }

    public void setUnfeccre(Date unfeccre) {
        this.unfeccre = unfeccre;
    }

    public Date getUnfecmod() {
        return unfecmod;
    }

    public void setUnfecmod(Date unfecmod) {
        this.unfecmod = unfecmod;
    }

    public String getUndirec() {
        return undirec;
    }

    public void setUndirec(String undirec) {
        this.undirec = undirec;
    }

    public String getUnicom() {
        return unicom;
    }

    public void setUnicom(String unicom) {
        this.unicom = unicom;
    }

    public String getUnestado() {
        return unestado;
    }

    public void setUnestado(String unestado) {
        this.unestado = unestado;
    }

    @XmlTransient
    public List<Unimdeptbl> getUnimdeptblList() {
        return unimdeptblList;
    }

    public void setUnimdeptblList(List<Unimdeptbl> unimdeptblList) {
        this.unimdeptblList = unimdeptblList;
    }

    @XmlTransient
    public List<Histclitbl> getHistclitblList() {
        return histclitblList;
    }

    public void setHistclitblList(List<Histclitbl> histclitblList) {
        this.histclitblList = histclitblList;
    }

    @XmlTransient
    public List<Cabplantbl> getCabplantblList() {
        return cabplantblList;
    }

    public void setCabplantblList(List<Cabplantbl> cabplantblList) {
        this.cabplantblList = cabplantblList;
    }

    public Ubicatbl getUbicpk() {
        return ubicpk;
    }

    public void setUbicpk(Ubicatbl ubicpk) {
        this.ubicpk = ubicpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidmedtblPK != null ? unidmedtblPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidmedtbl)) {
            return false;
        }
        Unidmedtbl other = (Unidmedtbl) object;
        if ((this.unidmedtblPK == null && other.unidmedtblPK != null) || (this.unidmedtblPK != null && !this.unidmedtblPK.equals(other.unidmedtblPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Unidmedtbl[ unidmedtblPK=" + unidmedtblPK + " ]";
    }
    
}

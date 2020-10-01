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
@Table(name = "UNIDMEDTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidmedtbl.findAll", query = "SELECT u FROM Unidmedtbl u"),
    @NamedQuery(name = "Unidmedtbl.findByUnidpk", query = "SELECT u FROM Unidmedtbl u WHERE u.unidpk = :unidpk"),
    @NamedQuery(name = "Unidmedtbl.findByUnnombre", query = "SELECT u FROM Unidmedtbl u WHERE u.unnombre = :unnombre"),
    @NamedQuery(name = "Unidmedtbl.findByUncodigo", query = "SELECT u FROM Unidmedtbl u WHERE u.uncodigo = :uncodigo"),
    @NamedQuery(name = "Unidmedtbl.findByUnnivel", query = "SELECT u FROM Unidmedtbl u WHERE u.unnivel = :unnivel"),
    @NamedQuery(name = "Unidmedtbl.findByUnfechacre", query = "SELECT u FROM Unidmedtbl u WHERE u.unfechacre = :unfechacre"),
    @NamedQuery(name = "Unidmedtbl.findByUnfechamod", query = "SELECT u FROM Unidmedtbl u WHERE u.unfechamod = :unfechamod"),
    @NamedQuery(name = "Unidmedtbl.findByUndireccion", query = "SELECT u FROM Unidmedtbl u WHERE u.undireccion = :undireccion"),
    @NamedQuery(name = "Unidmedtbl.findByUbicatblubicpk", query = "SELECT u FROM Unidmedtbl u WHERE u.ubicatblubicpk = :ubicatblubicpk"),
    @NamedQuery(name = "Unidmedtbl.findByUnicom", query = "SELECT u FROM Unidmedtbl u WHERE u.unicom = :unicom"),
    @NamedQuery(name = "Unidmedtbl.findByUnestado", query = "SELECT u FROM Unidmedtbl u WHERE u.unestado = :unestado")})
public class Unidmedtbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDPK")
    private Integer unidpk;
    @Size(max = 200)
    @Column(name = "UNNOMBRE")
    private String unnombre;
    @Size(max = 30)
    @Column(name = "UNCODIGO")
    private String uncodigo;
    @Column(name = "UNNIVEL")
    private Integer unnivel;
    @Column(name = "UNFECHACRE")
    @Temporal(TemporalType.DATE)
    private Date unfechacre;
    @Column(name = "UNFECHAMOD")
    @Temporal(TemporalType.DATE)
    private Date unfechamod;
    @Size(max = 200)
    @Column(name = "UNDIRECCION")
    private String undireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UBICATBLUBICPK")
    private int ubicatblubicpk;
    @Size(max = 2)
    @Column(name = "UNICOM")
    private String unicom;
    @Size(max = 30)
    @Column(name = "UNESTADO")
    private String unestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidmedtbl")
    private List<Unimdeptbl> unimdeptblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hiumidfk")
    private List<Histclitbl> histclitblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidmedtbl")
    private List<CtUmtbl> ctUmtblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plumidkfk")
    private List<Cabplantbl> cabplantblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seunmedfk")
    private List<Serviciotbl> serviciotblList;
    @JoinColumn(name = "UBUBICFK", referencedColumnName = "UBICPK")
    @ManyToOne(optional = false)
    private Ubicatbl ububicfk;

    public Unidmedtbl() {
    }

    public Unidmedtbl(Integer unidpk) {
        this.unidpk = unidpk;
    }

    public Unidmedtbl(Integer unidpk, int ubicatblubicpk) {
        this.unidpk = unidpk;
        this.ubicatblubicpk = ubicatblubicpk;
    }

    public Integer getUnidpk() {
        return unidpk;
    }

    public void setUnidpk(Integer unidpk) {
        this.unidpk = unidpk;
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

    public Date getUnfechacre() {
        return unfechacre;
    }

    public void setUnfechacre(Date unfechacre) {
        this.unfechacre = unfechacre;
    }

    public Date getUnfechamod() {
        return unfechamod;
    }

    public void setUnfechamod(Date unfechamod) {
        this.unfechamod = unfechamod;
    }

    public String getUndireccion() {
        return undireccion;
    }

    public void setUndireccion(String undireccion) {
        this.undireccion = undireccion;
    }

    public int getUbicatblubicpk() {
        return ubicatblubicpk;
    }

    public void setUbicatblubicpk(int ubicatblubicpk) {
        this.ubicatblubicpk = ubicatblubicpk;
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
    public List<CtUmtbl> getCtUmtblList() {
        return ctUmtblList;
    }

    public void setCtUmtblList(List<CtUmtbl> ctUmtblList) {
        this.ctUmtblList = ctUmtblList;
    }

    @XmlTransient
    public List<Cabplantbl> getCabplantblList() {
        return cabplantblList;
    }

    public void setCabplantblList(List<Cabplantbl> cabplantblList) {
        this.cabplantblList = cabplantblList;
    }

    @XmlTransient
    public List<Serviciotbl> getServiciotblList() {
        return serviciotblList;
    }

    public void setServiciotblList(List<Serviciotbl> serviciotblList) {
        this.serviciotblList = serviciotblList;
    }

    public Ubicatbl getUbubicfk() {
        return ububicfk;
    }

    public void setUbubicfk(Ubicatbl ububicfk) {
        this.ububicfk = ububicfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidpk != null ? unidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidmedtbl)) {
            return false;
        }
        Unidmedtbl other = (Unidmedtbl) object;
        if ((this.unidpk == null && other.unidpk != null) || (this.unidpk != null && !this.unidpk.equals(other.unidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Unidmedtbl[ unidpk=" + unidpk + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "CABPLANTBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabplantbl.findAll", query = "SELECT c FROM Cabplantbl c"),
    @NamedQuery(name = "Cabplantbl.findByCpidpk", query = "SELECT c FROM Cabplantbl c WHERE c.cpidpk = :cpidpk"),
    //@NamedQuery(name = "Cabplantbl.findByUnidpk", query = "SELECT c FROM Cabplantbl c WHERE c.unidpk = :unidpk"),
    @NamedQuery(name = "Cabplantbl.findByUbicapk", query = "SELECT c FROM Cabplantbl c WHERE c.ubicapk = :ubicapk"),
    @NamedQuery(name = "Cabplantbl.findByNumplanilla", query = "SELECT c FROM Cabplantbl c WHERE c.numplanilla = :numplanilla"),
    @NamedQuery(name = "Cabplantbl.findByFechaReg", query = "SELECT c FROM Cabplantbl c WHERE c.fechaReg = :fechaReg"),
    @NamedQuery(name = "Cabplantbl.findByUsuarioreg", query = "SELECT c FROM Cabplantbl c WHERE c.usuarioreg = :usuarioreg"),
    @NamedQuery(name = "Cabplantbl.findByMesplanilla", query = "SELECT c FROM Cabplantbl c WHERE c.mesplanilla = :mesplanilla"),
    @NamedQuery(name = "Cabplantbl.findByAnioplanilla", query = "SELECT c FROM Cabplantbl c WHERE c.anioplanilla = :anioplanilla"),
    @NamedQuery(name = "Cabplantbl.findByEstadoplanilla", query = "SELECT c FROM Cabplantbl c WHERE c.estadoplanilla = :estadoplanilla"),
    @NamedQuery(name = "Cabplantbl.findByDiaplanilla", query = "SELECT c FROM Cabplantbl c WHERE c.diaplanilla = :diaplanilla"),
    @NamedQuery(name = "Cabplantbl.findByDiaregistro", query = "SELECT c FROM Cabplantbl c WHERE c.diaregistro = :diaregistro"),
    @NamedQuery(name = "Cabplantbl.findByMesregistro", query = "SELECT c FROM Cabplantbl c WHERE c.mesregistro = :mesregistro"),
    @NamedQuery(name = "Cabplantbl.findByAnioregistro", query = "SELECT c FROM Cabplantbl c WHERE c.anioregistro = :anioregistro"),
    @NamedQuery(name = "Cabplantbl.findByNumpland", query = "SELECT c FROM Cabplantbl c WHERE c.numpland = :numpland"),
    @NamedQuery(name = "Cabplantbl.findByMesDia", query = "SELECT c FROM Cabplantbl c WHERE c.diaplanilla = :diaplanilla and c.mesplanilla = :mesplanilla and c.anioplanilla =:anoplanilla and c.unidpk=:unimedpk")})
public class Cabplantbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CPIDPK")
    private Integer cpidpk;
    @Column(name = "UNIDPK")
    private Integer unidpk;
    @Column(name = "UBICAPK")
    private Integer ubicapk;
    @Column(name = "NUMPLANILLA")
    private Integer numplanilla;
    @Column(name = "FECHA_REG")
    private Integer fechaReg;
    @Size(max = 10)
    @Column(name = "USUARIOREG")
    private String usuarioreg;
    @Column(name = "MESPLANILLA")
    private Integer mesplanilla;
    @Column(name = "ANIOPLANILLA")
    private Integer anioplanilla;
    @Column(name = "ESTADOPLANILLA")
    private Character estadoplanilla;
    @Column(name = "DIAPLANILLA")
    private Integer diaplanilla;
    @Column(name = "DIAREGISTRO")
    private Integer diaregistro;
    @Column(name = "MESREGISTRO")
    private Integer mesregistro;
    @Column(name = "ANIOREGISTRO")
    private Integer anioregistro;
    @Column(name = "NUMPLAND")
    private Integer numpland;    
    @OneToMany(mappedBy = "cpidpk", cascade = CascadeType.PERSIST)
    private List<Detplantbl> detplantblList;    
    @PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "UNIDPK",referencedColumnName = "UNIDPK")
    })
    @ManyToOne
    private Unidmedtbl unidmedtbl;
    
    public Cabplantbl() {
    }

    public Cabplantbl(Integer cpidpk, Integer ubicapk, Integer numplanilla, Integer fechaReg, String usuarioreg, Integer mesplanilla, Integer anioplanilla, Character estadoplanilla, Integer diaplanilla, Integer diaregistro, Integer mesregistro, Integer anioregistro, Integer numpland, List<Detplantbl> detplantblList) {
        this.cpidpk = cpidpk;
        this.ubicapk = ubicapk;
        this.numplanilla = numplanilla;
        this.fechaReg = fechaReg;
        this.usuarioreg = usuarioreg;
        this.mesplanilla = mesplanilla;
        this.anioplanilla = anioplanilla;
        this.estadoplanilla = estadoplanilla;
        this.diaplanilla = diaplanilla;
        this.diaregistro = diaregistro;
        this.mesregistro = mesregistro;
        this.anioregistro = anioregistro;
        this.numpland = numpland;
        this.detplantblList = detplantblList;
    }       

    public Cabplantbl(Integer cpidpk) {
        this.cpidpk = cpidpk;
    }

    @XmlTransient
    public List<Detplantbl> getDetplantblList() {
        return detplantblList;
    }

    public Unidmedtbl getUnidmedtbl() {
        return unidmedtbl;
    }

    public void setUnidmedtbl(Unidmedtbl unidmedtbl) {
        this.unidmedtbl = unidmedtbl;
    }

    public void setDetplantblList(List<Detplantbl> detplantblList) {
        this.detplantblList = detplantblList;
    }

    public Integer getCpidpk() {
        return cpidpk;
    }

    public void setCpidpk(Integer cpidpk) {
        this.cpidpk = cpidpk;
    }

    public Integer getUnidpk() {
        return unidpk;
    }

    public void setUnidpk(Integer unidpk) {
        this.unidpk = unidpk;
    }

    public Integer getUbicapk() {
        return ubicapk;
    }

    public void setUbicapk(Integer ubicapk) {
        this.ubicapk = ubicapk;
    }

    public Integer getNumplanilla() {
        return numplanilla;
    }

    public void setNumplanilla(Integer numplanilla) {
        this.numplanilla = numplanilla;
    }

    public Integer getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Integer fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getUsuarioreg() {
        return usuarioreg;
    }

    public void setUsuarioreg(String usuarioreg) {
        this.usuarioreg = usuarioreg;
    }

    public Integer getMesplanilla() {
        return mesplanilla;
    }

    public void setMesplanilla(Integer mesplanilla) {
        this.mesplanilla = mesplanilla;
    }

    public Integer getAnioplanilla() {
        return anioplanilla;
    }

    public void setAnioplanilla(Integer anioplanilla) {
        this.anioplanilla = anioplanilla;
    }

    public Character getEstadoplanilla() {
        return estadoplanilla;
    }

    public void setEstadoplanilla(Character estadoplanilla) {
        this.estadoplanilla = estadoplanilla;
    }

    public Integer getDiaplanilla() {
        return diaplanilla;
    }

    public void setDiaplanilla(Integer diaplanilla) {
        this.diaplanilla = diaplanilla;
    }

    public Integer getDiaregistro() {
        return diaregistro;
    }

    public void setDiaregistro(Integer diaregistro) {
        this.diaregistro = diaregistro;
    }

    public Integer getMesregistro() {
        return mesregistro;
    }

    public void setMesregistro(Integer mesregistro) {
        this.mesregistro = mesregistro;
    }

    public Integer getAnioregistro() {
        return anioregistro;
    }

    public void setAnioregistro(Integer anioregistro) {
        this.anioregistro = anioregistro;
    }

    public Integer getNumpland() {
        return numpland;
    }

    public void setNumpland(Integer numpland) {
        this.numpland = numpland;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpidpk != null ? cpidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabplantbl)) {
            return false;
        }
        Cabplantbl other = (Cabplantbl) object;
        if ((this.cpidpk == null && other.cpidpk != null) || (this.cpidpk != null && !this.cpidpk.equals(other.cpidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entity.Cabplantbl[ cpidpk=" + cpidpk + " ]";
    }
    
}

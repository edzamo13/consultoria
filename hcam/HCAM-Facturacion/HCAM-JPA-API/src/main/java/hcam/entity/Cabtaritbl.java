/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CABTARITBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabtaritbl.findAll", query = "SELECT c FROM Cabtaritbl c"),
    @NamedQuery(name = "Cabtaritbl.findByCtidpk", query = "SELECT c FROM Cabtaritbl c WHERE c.ctidpk = :ctidpk"),
    @NamedQuery(name = "Cabtaritbl.findByTanombre", query = "SELECT c FROM Cabtaritbl c WHERE c.tanombre = :tanombre"),
    @NamedQuery(name = "Cabtaritbl.findByTaano", query = "SELECT c FROM Cabtaritbl c WHERE c.taano = :taano"),
    @NamedQuery(name = "Cabtaritbl.findByTaestado", query = "SELECT c FROM Cabtaritbl c WHERE c.taestado = :taestado"),
    @NamedQuery(name = "Cabtaritbl.findByTadescripc", query = "SELECT c FROM Cabtaritbl c WHERE c.tadescripc = :tadescripc")})
public class Cabtaritbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTIDPK")
    private Integer ctidpk;
    @Size(max = 100)
    @Column(name = "TANOMBRE")
    private String tanombre;
    @Column(name = "TAANO")
    private Integer taano;
    @Size(max = 30)
    @Column(name = "TAESTADO")
    private String taestado;
    @Size(max = 200)
    @Column(name = "TADESCRIPC")
    private String tadescripc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabtaritbl")
    private List<CtUmtbl> ctUmtblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tacabtarfk")
    private List<Tarifartbl> tarifartblList;

    public Cabtaritbl() {
    }

    public Cabtaritbl(Integer ctidpk) {
        this.ctidpk = ctidpk;
    }

    public Integer getCtidpk() {
        return ctidpk;
    }

    public void setCtidpk(Integer ctidpk) {
        this.ctidpk = ctidpk;
    }

    public String getTanombre() {
        return tanombre;
    }

    public void setTanombre(String tanombre) {
        this.tanombre = tanombre;
    }

    public Integer getTaano() {
        return taano;
    }

    public void setTaano(Integer taano) {
        this.taano = taano;
    }

    public String getTaestado() {
        return taestado;
    }

    public void setTaestado(String taestado) {
        this.taestado = taestado;
    }

    public String getTadescripc() {
        return tadescripc;
    }

    public void setTadescripc(String tadescripc) {
        this.tadescripc = tadescripc;
    }

    @XmlTransient
    public List<CtUmtbl> getCtUmtblList() {
        return ctUmtblList;
    }

    public void setCtUmtblList(List<CtUmtbl> ctUmtblList) {
        this.ctUmtblList = ctUmtblList;
    }

    @XmlTransient
    public List<Tarifartbl> getTarifartblList() {
        return tarifartblList;
    }

    public void setTarifartblList(List<Tarifartbl> tarifartblList) {
        this.tarifartblList = tarifartblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctidpk != null ? ctidpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabtaritbl)) {
            return false;
        }
        Cabtaritbl other = (Cabtaritbl) object;
        if ((this.ctidpk == null && other.ctidpk != null) || (this.ctidpk != null && !this.ctidpk.equals(other.ctidpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hcam.entity.Cabtaritbl[ ctidpk=" + ctidpk + " ]";
    }
    
}

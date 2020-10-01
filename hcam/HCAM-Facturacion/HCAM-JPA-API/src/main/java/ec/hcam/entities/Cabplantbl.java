/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jochoa
 */
@Entity
@Table(name = "CABPLANTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabplantbl.findAll", query = "SELECT c FROM Cabplantbl c"),
    @NamedQuery(name = "Cabplantbl.findByCpidpk", query = "SELECT c FROM Cabplantbl c WHERE c.cpidpk = :cpidpk"),
    @NamedQuery(name = "Cabplantbl.findByPlanum", query = "SELECT c FROM Cabplantbl c WHERE c.planum = :planum"),
    @NamedQuery(name = "Cabplantbl.findByPlafec", query = "SELECT c FROM Cabplantbl c WHERE c.plafec = :plafec"),
    @NamedQuery(name = "Cabplantbl.findByPlauor", query = "SELECT c FROM Cabplantbl c WHERE c.plauor = :plauor"),
    @NamedQuery(name = "Cabplantbl.findByPladep", query = "SELECT c FROM Cabplantbl c WHERE c.pladep = :pladep"),
    @NamedQuery(name = "Cabplantbl.findByPladps", query = "SELECT c FROM Cabplantbl c WHERE c.pladps = :pladps"),
    @NamedQuery(name = "Cabplantbl.findByPlamed", query = "SELECT c FROM Cabplantbl c WHERE c.plamed = :plamed"),
    @NamedQuery(name = "Cabplantbl.findByPlamet", query = "SELECT c FROM Cabplantbl c WHERE c.plamet = :plamet"),
    @NamedQuery(name = "Cabplantbl.findByPladia", query = "SELECT c FROM Cabplantbl c WHERE c.pladia = :pladia"),
    @NamedQuery(name = "Cabplantbl.findByPlacid", query = "SELECT c FROM Cabplantbl c WHERE c.placid = :placid"),
    @NamedQuery(name = "Cabplantbl.findByPlasts", query = "SELECT c FROM Cabplantbl c WHERE c.plasts = :plasts"),
    @NamedQuery(name = "Cabplantbl.findByPlastp", query = "SELECT c FROM Cabplantbl c WHERE c.plastp = :plastp"),
    @NamedQuery(name = "Cabplantbl.findByPlacax", query = "SELECT c FROM Cabplantbl c WHERE c.placax = :placax"),
    @NamedQuery(name = "Cabplantbl.findByPlanux", query = "SELECT c FROM Cabplantbl c WHERE c.planux = :planux"),
    @NamedQuery(name = "Cabplantbl.findByPlausr", query = "SELECT c FROM Cabplantbl c WHERE c.plausr = :plausr"),
    @NamedQuery(name = "Cabplantbl.findByPlafeh", query = "SELECT c FROM Cabplantbl c WHERE c.plafeh = :plafeh"),
    @NamedQuery(name = "Cabplantbl.findByPlawst", query = "SELECT c FROM Cabplantbl c WHERE c.plawst = :plawst")})
public class Cabplantbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPIDPK")
    private Integer cpidpk;
    @Basic(optional = false)
    @Column(name = "PLANUM")
    private int planum;
    @Basic(optional = false)
    @Column(name = "PLAFEC")
    private int plafec;
    @Basic(optional = false)
    @Column(name = "PLAUOR")
    private int plauor;
    @Basic(optional = false)
    @Column(name = "PLADEP")
    private int pladep;
    @Basic(optional = false)
    @Column(name = "PLADPS")
    private int pladps;
    @Basic(optional = false)
    @Column(name = "PLAMED")
    private int plamed;
    @Basic(optional = false)
    @Column(name = "PLAMET")
    private int plamet;
    @Basic(optional = false)
    @Column(name = "PLADIA")
    private String pladia;
    @Basic(optional = false)
    @Column(name = "PLACID")
    private String placid;
    @Basic(optional = false)
    @Column(name = "PLASTS")
    private String plasts;
    @Basic(optional = false)
    @Column(name = "PLASTP")
    private String plastp;
    @Basic(optional = false)
    @Column(name = "PLACAX")
    private String placax;
    @Basic(optional = false)
    @Column(name = "PLANUX")
    private int planux;
    @Basic(optional = false)
    @Column(name = "PLAUSR")
    private String plausr;
    @Basic(optional = false)
    @Column(name = "PLAFEH")
    private int plafeh;
    @Basic(optional = false)
    @Column(name = "PLAWST")
    private String plawst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plcabplafk")
    private List<Detplantbl> detplantblList;
    @JoinColumn(name = "PLUMIDKFK", referencedColumnName = "UNIDPK")
    @ManyToOne(optional = false)
    private Unidmedtbl plumidkfk;

    public Cabplantbl() {
    }

    public Cabplantbl(Integer cpidpk) {
        this.cpidpk = cpidpk;
    }

    public Cabplantbl(Integer cpidpk, int planum, int plafec, int plauor, int pladep, int pladps, int plamed, int plamet, String pladia, String placid, String plasts, String plastp, String placax, int planux, String plausr, int plafeh, String plawst) {
        this.cpidpk = cpidpk;
        this.planum = planum;
        this.plafec = plafec;
        this.plauor = plauor;
        this.pladep = pladep;
        this.pladps = pladps;
        this.plamed = plamed;
        this.plamet = plamet;
        this.pladia = pladia;
        this.placid = placid;
        this.plasts = plasts;
        this.plastp = plastp;
        this.placax = placax;
        this.planux = planux;
        this.plausr = plausr;
        this.plafeh = plafeh;
        this.plawst = plawst;
    }

    public Integer getCpidpk() {
        return cpidpk;
    }

    public void setCpidpk(Integer cpidpk) {
        this.cpidpk = cpidpk;
    }

    public int getPlanum() {
        return planum;
    }

    public void setPlanum(int planum) {
        this.planum = planum;
    }

    public int getPlafec() {
        return plafec;
    }

    public void setPlafec(int plafec) {
        this.plafec = plafec;
    }

    public int getPlauor() {
        return plauor;
    }

    public void setPlauor(int plauor) {
        this.plauor = plauor;
    }

    public int getPladep() {
        return pladep;
    }

    public void setPladep(int pladep) {
        this.pladep = pladep;
    }

    public int getPladps() {
        return pladps;
    }

    public void setPladps(int pladps) {
        this.pladps = pladps;
    }

    public int getPlamed() {
        return plamed;
    }

    public void setPlamed(int plamed) {
        this.plamed = plamed;
    }

    public int getPlamet() {
        return plamet;
    }

    public void setPlamet(int plamet) {
        this.plamet = plamet;
    }

    public String getPladia() {
        return pladia;
    }

    public void setPladia(String pladia) {
        this.pladia = pladia;
    }

    public String getPlacid() {
        return placid;
    }

    public void setPlacid(String placid) {
        this.placid = placid;
    }

    public String getPlasts() {
        return plasts;
    }

    public void setPlasts(String plasts) {
        this.plasts = plasts;
    }

    public String getPlastp() {
        return plastp;
    }

    public void setPlastp(String plastp) {
        this.plastp = plastp;
    }

    public String getPlacax() {
        return placax;
    }

    public void setPlacax(String placax) {
        this.placax = placax;
    }

    public int getPlanux() {
        return planux;
    }

    public void setPlanux(int planux) {
        this.planux = planux;
    }

    public String getPlausr() {
        return plausr;
    }

    public void setPlausr(String plausr) {
        this.plausr = plausr;
    }

    public int getPlafeh() {
        return plafeh;
    }

    public void setPlafeh(int plafeh) {
        this.plafeh = plafeh;
    }

    public String getPlawst() {
        return plawst;
    }

    public void setPlawst(String plawst) {
        this.plawst = plawst;
    }

    @XmlTransient
    public List<Detplantbl> getDetplantblList() {
        return detplantblList;
    }

    public void setDetplantblList(List<Detplantbl> detplantblList) {
        this.detplantblList = detplantblList;
    }

    public Unidmedtbl getPlumidkfk() {
        return plumidkfk;
    }

    public void setPlumidkfk(Unidmedtbl plumidkfk) {
        this.plumidkfk = plumidkfk;
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
        return "ec.hcam.entities.Cabplantbl[ cpidpk=" + cpidpk + " ]";
    }
    
}

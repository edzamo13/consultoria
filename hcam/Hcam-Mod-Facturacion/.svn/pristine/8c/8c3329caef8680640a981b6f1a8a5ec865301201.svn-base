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
@Table(name = "PROCEDITBL", catalog = "S101719R", schema = "FACWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceditbl.findAll", query = "SELECT p FROM Proceditbl p"),
    @NamedQuery(name = "Proceditbl.findByPrprocedpk", query = "SELECT p FROM Proceditbl p WHERE p.prprocedpk = :prprocedpk"),
    @NamedQuery(name = "Proceditbl.findByPrnombre", query = "SELECT p FROM Proceditbl p WHERE p.prnombre = :prnombre"),
    @NamedQuery(name = "Proceditbl.findByPrcampo", query = "SELECT p FROM Proceditbl p WHERE p.prcampo = :prcampo"),
    @NamedQuery(name = "Proceditbl.findByPrsql", query = "SELECT p FROM Proceditbl p WHERE p.prsql = :prsql"),
    @NamedQuery(name = "Proceditbl.findByPrdescripc", query = "SELECT p FROM Proceditbl p WHERE p.prdescripc = :prdescripc"),
    @NamedQuery(name = "Proceditbl.findByPrestado", query = "SELECT p FROM Proceditbl p WHERE p.prestado = :prestado")})
public class Proceditbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRPROCEDPK")
    private Integer prprocedpk;
    @Size(max = 50)
    @Column(name = "PRNOMBRE")
    private String prnombre;
    @Size(max = 50)
    @Column(name = "PRCAMPO")
    private String prcampo;
    @Size(max = 1000)
    @Column(name = "PRSQL")
    private String prsql;
    @Size(max = 200)
    @Column(name = "PRDESCRIPC")
    private String prdescripc;
    @Size(max = 30)
    @Column(name = "PRESTADO")
    private String prestado;
    @OneToMany(mappedBy = "prprocedpk")
    private List<Paramtbl> paramtblList;
    @JoinColumn(name = "ESIDPK", referencedColumnName = "ESIDPK")
    @ManyToOne
    private Esquematbl esidpk;

    public Proceditbl() {
    }

    public Proceditbl(Integer prprocedpk) {
        this.prprocedpk = prprocedpk;
    }

    public Integer getPrprocedpk() {
        return prprocedpk;
    }

    public void setPrprocedpk(Integer prprocedpk) {
        this.prprocedpk = prprocedpk;
    }

    public String getPrnombre() {
        return prnombre;
    }

    public void setPrnombre(String prnombre) {
        this.prnombre = prnombre;
    }

    public String getPrcampo() {
        return prcampo;
    }

    public void setPrcampo(String prcampo) {
        this.prcampo = prcampo;
    }

    public String getPrsql() {
        return prsql;
    }

    public void setPrsql(String prsql) {
        this.prsql = prsql;
    }

    public String getPrdescripc() {
        return prdescripc;
    }

    public void setPrdescripc(String prdescripc) {
        this.prdescripc = prdescripc;
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }

    @XmlTransient
    public List<Paramtbl> getParamtblList() {
        return paramtblList;
    }

    public void setParamtblList(List<Paramtbl> paramtblList) {
        this.paramtblList = paramtblList;
    }

    public Esquematbl getEsidpk() {
        return esidpk;
    }

    public void setEsidpk(Esquematbl esidpk) {
        this.esidpk = esidpk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prprocedpk != null ? prprocedpk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceditbl)) {
            return false;
        }
        Proceditbl other = (Proceditbl) object;
        if ((this.prprocedpk == null && other.prprocedpk != null) || (this.prprocedpk != null && !this.prprocedpk.equals(other.prprocedpk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.hcam.entities.Proceditbl[ prprocedpk=" + prprocedpk + " ]";
    }
    
}

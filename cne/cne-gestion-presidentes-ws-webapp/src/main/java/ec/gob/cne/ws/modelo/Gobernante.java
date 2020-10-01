/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author edwin
 */
@Entity
@Table(name =  "gobernante", catalog = "presidentes", schema = "presidentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Gobernante.GET_ALL_GOBERNATES, query = "SELECT g FROM Gobernante g WHERE g.estado = true")
    , @NamedQuery(name = "Gobernante.findByIdGobernate", query = "SELECT g FROM Gobernante g WHERE g.idGobernate = :idGobernate"),
})
public class Gobernante implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String GET_ALL_GOBERNATES = "Gobernante.GET_ALL_GOBERNATES";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gobernate", nullable = false)
    private Integer idGobernate;
    @Column(name = "ctg_id_tipogobierno")
    private Integer ctgIdTipogobierno;
    @Size(max = 255)
    @Column(name = "titulo_mandato", length = 255)
    private String tituloMandato;
    @Size(max = 255)
    @Column(name = "tipo_periodo", length = 255)
    private String tipoPeriodo;
    @Size(max = 255)
    @Column(name = "partido_politico", length = 255)
    private String partidoPolitico;
    @Column(name = "fecha_mandatoinicio")
    @Temporal(TemporalType.DATE)
    private Date fechaMandatoinicio;
    @Column(name = "fecha_mandatofin")
    @Temporal(TemporalType.DATE)
    private Date fechaMandatofin;
    @Column(name = "fecha_creacionr")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_usr", nullable = false, length = 2147483647)
    private String idUsr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGobernate")
    private List<DetalleGobernante> detalleGobernanteList;

    public Gobernante() {
    }

    public Gobernante(Integer idGobernate) {
        this.idGobernate = idGobernate;
    }

    public Gobernante(Integer idGobernate, String idUsr, boolean estado) {
        this.idGobernate = idGobernate;
        this.idUsr = idUsr;
        this.estado = estado;
    }

    public Integer getIdGobernate() {
        return idGobernate;
    }

    public void setIdGobernate(Integer idGobernate) {
        this.idGobernate = idGobernate;
    }

    public Integer getCtgIdTipogobierno() {
        return ctgIdTipogobierno;
    }

    public void setCtgIdTipogobierno(Integer ctgIdTipogobierno) {
        this.ctgIdTipogobierno = ctgIdTipogobierno;
    }

    public String getTituloMandato() {
        return tituloMandato;
    }

    public void setTituloMandato(String tituloMandato) {
        this.tituloMandato = tituloMandato;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public Date getFechaMandatoinicio() {
        return fechaMandatoinicio;
    }

    public void setFechaMandatoinicio(Date fechaMandatoinicio) {
        this.fechaMandatoinicio = fechaMandatoinicio;
    }

    public Date getFechaMandatofin() {
        return fechaMandatofin;
    }

    public void setFechaMandatofin(Date fechaMandatofin) {
        this.fechaMandatofin = fechaMandatofin;
    }

    public Date getFechaCreacionr() {
        return fechaCreacionr;
    }

    public void setFechaCreacionr(Date fechaCreacionr) {
        this.fechaCreacionr = fechaCreacionr;
    }

    public String getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(String idUsr) {
        this.idUsr = idUsr;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<DetalleGobernante> getDetalleGobernanteList() {
        return detalleGobernanteList;
    }

    public void setDetalleGobernanteList(List<DetalleGobernante> detalleGobernanteList) {
        this.detalleGobernanteList = detalleGobernanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGobernate != null ? idGobernate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gobernante)) {
            return false;
        }
        Gobernante other = (Gobernante) object;
        if ((this.idGobernate == null && other.idGobernate != null) || (this.idGobernate != null && !this.idGobernate.equals(other.idGobernate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.cne.ws.modelo.Gobernante[ idGobernate=" + idGobernate + " ]";
    }

}

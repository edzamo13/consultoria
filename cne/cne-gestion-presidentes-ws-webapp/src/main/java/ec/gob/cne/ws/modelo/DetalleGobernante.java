/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "detalle_gobernante", catalog = "presidentes", schema = "presidentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleGobernante.findAll", query = "SELECT d FROM DetalleGobernante d")
    , @NamedQuery(name = "DetalleGobernante.findByIdDetalle", query = "SELECT d FROM DetalleGobernante d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetalleGobernante.findByCtgIdTipogobierno", query = "SELECT d FROM DetalleGobernante d WHERE d.ctgIdTipogobierno = :ctgIdTipogobierno")
    , @NamedQuery(name = "DetalleGobernante.findByIdctgIdTipogobierno", query = "SELECT d FROM DetalleGobernante d WHERE d.idctgIdTipogobierno = :idctgIdTipogobierno")
    , @NamedQuery(name = "DetalleGobernante.findByNombre", query = "SELECT d FROM DetalleGobernante d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DetalleGobernante.findByIdUsr", query = "SELECT d FROM DetalleGobernante d WHERE d.idUsr = :idUsr")
    , @NamedQuery(name = "DetalleGobernante.findByFechaCreacionr", query = "SELECT d FROM DetalleGobernante d WHERE d.fechaCreacionr = :fechaCreacionr")
    , @NamedQuery(name = "DetalleGobernante.findByDetalle", query = "SELECT d FROM DetalleGobernante d WHERE d.detalle = :detalle")
    , @NamedQuery(name = "DetalleGobernante.findByEstado", query = "SELECT d FROM DetalleGobernante d WHERE d.estado = :estado")})
public class DetalleGobernante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle", nullable = false)
    private Integer idDetalle;
    @Column(name = "ctg_id_tipogobierno")
    private Integer ctgIdTipogobierno;
    @Column(name = "idctg_id_tipogobierno")
    private Integer idctgIdTipogobierno;
    @Size(max = 255)
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_usr", nullable = false, length = 2147483647)
    private String idUsr;
    @Column(name = "fecha_creacionr")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionr;
    @Column(name = "detalle")
    private Integer detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "id_gobernate", referencedColumnName = "id_gobernate", nullable = false)
    @ManyToOne(optional = false)
    private Gobernante idGobernate;

    public DetalleGobernante() {
    }

    public DetalleGobernante(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleGobernante(Integer idDetalle, String idUsr, boolean estado) {
        this.idDetalle = idDetalle;
        this.idUsr = idUsr;
        this.estado = estado;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCtgIdTipogobierno() {
        return ctgIdTipogobierno;
    }

    public void setCtgIdTipogobierno(Integer ctgIdTipogobierno) {
        this.ctgIdTipogobierno = ctgIdTipogobierno;
    }

    public Integer getIdctgIdTipogobierno() {
        return idctgIdTipogobierno;
    }

    public void setIdctgIdTipogobierno(Integer idctgIdTipogobierno) {
        this.idctgIdTipogobierno = idctgIdTipogobierno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(String idUsr) {
        this.idUsr = idUsr;
    }

    public Date getFechaCreacionr() {
        return fechaCreacionr;
    }

    public void setFechaCreacionr(Date fechaCreacionr) {
        this.fechaCreacionr = fechaCreacionr;
    }

    public Integer getDetalle() {
        return detalle;
    }

    public void setDetalle(Integer detalle) {
        this.detalle = detalle;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Gobernante getIdGobernate() {
        return idGobernate;
    }

    public void setIdGobernate(Gobernante idGobernate) {
        this.idGobernate = idGobernate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleGobernante)) {
            return false;
        }
        DetalleGobernante other = (DetalleGobernante) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.cne.ws.modelo.DetalleGobernante[ idDetalle=" + idDetalle + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "catalogo", catalog = "presidentes", schema = "presidentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findByIdCatalogo", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo = :idCatalogo")
    , @NamedQuery(name = "Catalogo.findByIdIdcatalogo", query = "SELECT c FROM Catalogo c WHERE c.idIdcatalogo = :idIdcatalogo")
    , @NamedQuery(name = "Catalogo.findByNombre", query = "SELECT c FROM Catalogo c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Catalogo.findByDetalle", query = "SELECT c FROM Catalogo c WHERE c.detalle = :detalle")
    , @NamedQuery(name = "Catalogo.findByEstado", query = "SELECT c FROM Catalogo c WHERE c.estado = :estado")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_catalogo", nullable = false)
    private Integer idCatalogo;
    @Column(name = "id_idcatalogo")
    private Integer idIdcatalogo;
    @Size(max = 255)
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Size(max = 255)
    @Column(name = "detalle", length = 255)
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Catalogo() {
    }

    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Catalogo(Integer idCatalogo, boolean estado) {
        this.idCatalogo = idCatalogo;
        this.estado = estado;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Integer getIdIdcatalogo() {
        return idIdcatalogo;
    }

    public void setIdIdcatalogo(Integer idIdcatalogo) {
        this.idIdcatalogo = idIdcatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogo != null ? idCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.idCatalogo == null && other.idCatalogo != null) || (this.idCatalogo != null && !this.idCatalogo.equals(other.idCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.cne.ws.modelo.Catalogo[ idCatalogo=" + idCatalogo + " ]";
    }
    
}

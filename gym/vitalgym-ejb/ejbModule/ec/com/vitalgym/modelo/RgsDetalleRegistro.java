
package ec.com.vitalgym.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 *  <b>
 * Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author ezamora
 * <p>[$Author:  ezamora  $, $Date: 23-ago-2017]</p>
 */
@Entity
@Table(name = "rgs_detalle_registro", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RgsDetalleRegistro.findAll", query = "SELECT r FROM RgsDetalleRegistro r")
    , @NamedQuery(name = "RgsDetalleRegistro.findByDtIdDetalleRegistro", query = "SELECT r FROM RgsDetalleRegistro r WHERE r.dtIdDetalleRegistro = :dtIdDetalleRegistro")
    , @NamedQuery(name = "RgsDetalleRegistro.findByDtFechaRegistro", query = "SELECT r FROM RgsDetalleRegistro r WHERE r.dtFechaRegistro = :dtFechaRegistro")
    , @NamedQuery(name = "RgsDetalleRegistro.findByDtUsrRegitro", query = "SELECT r FROM RgsDetalleRegistro r WHERE r.dtUsrRegitro = :dtUsrRegitro")})
public class RgsDetalleRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 2147483647)
    @Column(name = "dt_id_detalle_registro", nullable = false, length = 2147483647)
    private String dtIdDetalleRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_usr_regitro", nullable = false)
    private int dtUsrRegitro;
    @JoinColumn(name = "rg_id_registro", referencedColumnName = "rg_id_registro", nullable = false)
    @ManyToOne(optional = false)
    private RgsRegistro rgIdRegistro;

    public RgsDetalleRegistro() {
    }

    public RgsDetalleRegistro(String dtIdDetalleRegistro) {
        this.dtIdDetalleRegistro = dtIdDetalleRegistro;
    }

    public RgsDetalleRegistro(String dtIdDetalleRegistro, Date dtFechaRegistro, int dtUsrRegitro) {
        this.dtIdDetalleRegistro = dtIdDetalleRegistro;
        this.dtFechaRegistro = dtFechaRegistro;
        this.dtUsrRegitro = dtUsrRegitro;
    }

    public String getDtIdDetalleRegistro() {
        return dtIdDetalleRegistro;
    }

    public void setDtIdDetalleRegistro(String dtIdDetalleRegistro) {
        this.dtIdDetalleRegistro = dtIdDetalleRegistro;
    }

    public Date getDtFechaRegistro() {
        return dtFechaRegistro;
    }

    public void setDtFechaRegistro(Date dtFechaRegistro) {
        this.dtFechaRegistro = dtFechaRegistro;
    }

    public int getDtUsrRegitro() {
        return dtUsrRegitro;
    }

    public void setDtUsrRegitro(int dtUsrRegitro) {
        this.dtUsrRegitro = dtUsrRegitro;
    }

    public RgsRegistro getRgIdRegistro() {
        return rgIdRegistro;
    }

    public void setRgIdRegistro(RgsRegistro rgIdRegistro) {
        this.rgIdRegistro = rgIdRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtIdDetalleRegistro != null ? dtIdDetalleRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RgsDetalleRegistro)) {
            return false;
        }
        RgsDetalleRegistro other = (RgsDetalleRegistro) object;
        if ((this.dtIdDetalleRegistro == null && other.dtIdDetalleRegistro != null) || (this.dtIdDetalleRegistro != null && !this.dtIdDetalleRegistro.equals(other.dtIdDetalleRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vitalgym.gestion.modelo.RgsDetalleRegistro[ dtIdDetalleRegistro=" + dtIdDetalleRegistro + " ]";
    }

}

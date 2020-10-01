

package ec.com.vitalgym.modelo;

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
 *  <b>
 * Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author ezamora
 * <p>[$Author:  ezamora  $, $Date: 23-ago-2017]</p>
 */
@Entity
@Table(name = "rgs_registro", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RgsRegistro.findAll", query = "SELECT r FROM RgsRegistro r")
    , @NamedQuery(name = "RgsRegistro.findByRgIdRegistro", query = "SELECT r FROM RgsRegistro r WHERE r.rgIdRegistro = :rgIdRegistro")
    , @NamedQuery(name = "RgsRegistro.findByRgIdPersona", query = "SELECT r FROM RgsRegistro r WHERE r.rgIdPersona = :rgIdPersona")
    , @NamedQuery(name = "RgsRegistro.findByRgDiasConsumo", query = "SELECT r FROM RgsRegistro r WHERE r.rgDiasConsumo = :rgDiasConsumo")
    , @NamedQuery(name = "RgsRegistro.findByRgFechaInico", query = "SELECT r FROM RgsRegistro r WHERE r.rgFechaInico = :rgFechaInico")
    , @NamedQuery(name = "RgsRegistro.findByRgFechaFin", query = "SELECT r FROM RgsRegistro r WHERE r.rgFechaFin = :rgFechaFin")
    , @NamedQuery(name = "RgsRegistro.findByRgTipoPago", query = "SELECT r FROM RgsRegistro r WHERE r.rgTipoPago = :rgTipoPago")
    , @NamedQuery(name = "RgsRegistro.findByRgEstado", query = "SELECT r FROM RgsRegistro r WHERE r.rgEstado = :rgEstado")})
public class RgsRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rg_id_registro", nullable = false)
    private Integer rgIdRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg_id_persona", nullable = false)
    private int rgIdPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg_dias_consumo", nullable = false)
    private int rgDiasConsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg_fecha_inico", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rgFechaInico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg_fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rgFechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rg_tipo_pago", nullable = false, length = 2147483647)
    private String rgTipoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg_estado", nullable = false)
    private boolean rgEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rgIdRegistro")
    private List<RgsDetalleRegistro> rgsDetalleRegistroList;

    public RgsRegistro() {
    }

    public RgsRegistro(Integer rgIdRegistro) {
        this.rgIdRegistro = rgIdRegistro;
    }

    public RgsRegistro(Integer rgIdRegistro, int rgIdPersona, int rgDiasConsumo, Date rgFechaInico, Date rgFechaFin, String rgTipoPago, boolean rgEstado) {
        this.rgIdRegistro = rgIdRegistro;
        this.rgIdPersona = rgIdPersona;
        this.rgDiasConsumo = rgDiasConsumo;
        this.rgFechaInico = rgFechaInico;
        this.rgFechaFin = rgFechaFin;
        this.rgTipoPago = rgTipoPago;
        this.rgEstado = rgEstado;
    }

    public Integer getRgIdRegistro() {
        return rgIdRegistro;
    }

    public void setRgIdRegistro(Integer rgIdRegistro) {
        this.rgIdRegistro = rgIdRegistro;
    }

    public int getRgIdPersona() {
        return rgIdPersona;
    }

    public void setRgIdPersona(int rgIdPersona) {
        this.rgIdPersona = rgIdPersona;
    }

    public int getRgDiasConsumo() {
        return rgDiasConsumo;
    }

    public void setRgDiasConsumo(int rgDiasConsumo) {
        this.rgDiasConsumo = rgDiasConsumo;
    }

    public Date getRgFechaInico() {
        return rgFechaInico;
    }

    public void setRgFechaInico(Date rgFechaInico) {
        this.rgFechaInico = rgFechaInico;
    }

    public Date getRgFechaFin() {
        return rgFechaFin;
    }

    public void setRgFechaFin(Date rgFechaFin) {
        this.rgFechaFin = rgFechaFin;
    }

    public String getRgTipoPago() {
        return rgTipoPago;
    }

    public void setRgTipoPago(String rgTipoPago) {
        this.rgTipoPago = rgTipoPago;
    }

    public boolean getRgEstado() {
        return rgEstado;
    }

    public void setRgEstado(boolean rgEstado) {
        this.rgEstado = rgEstado;
    }

    @XmlTransient
    public List<RgsDetalleRegistro> getRgsDetalleRegistroList() {
        return rgsDetalleRegistroList;
    }

    public void setRgsDetalleRegistroList(List<RgsDetalleRegistro> rgsDetalleRegistroList) {
        this.rgsDetalleRegistroList = rgsDetalleRegistroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgIdRegistro != null ? rgIdRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RgsRegistro)) {
            return false;
        }
        RgsRegistro other = (RgsRegistro) object;
        if ((this.rgIdRegistro == null && other.rgIdRegistro != null) || (this.rgIdRegistro != null && !this.rgIdRegistro.equals(other.rgIdRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vitalgym.gestion.modelo.RgsRegistro[ rgIdRegistro=" + rgIdRegistro + " ]";
    }

}

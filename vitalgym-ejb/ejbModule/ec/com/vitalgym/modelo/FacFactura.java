
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 *         [$Author: ezamora $, $Date: 23-ago-2017]
 *         </p>
 */
@Entity
@Table(name = "fac_factura", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = FacFactura.OBTENER_FACTURA_ACTIVA_FECHA_INICIO_FIN, query = "SELECT f FROM FacFactura f where f.facFechaCreacion between :inicio AND :fin") })
public class FacFactura implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_FACTURA_ACTIVA_FECHA_INICIO_FIN = "FacFactura.OBTENER_FACTURA_ACTIVA_FECHA_INICIO_FIN";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "fac_id_factura", nullable = false)
	private Integer facIdFactura;
	@Column(name = "fac_codigo", length = 255)
	private String facCodigo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "fac_fecha_creacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date facFechaCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "fac_usr_creacion", nullable = false)
	private int facUsrCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "fac_estado", nullable = false)
	private boolean facEstado;
	@JoinColumn(name = "per_id_persona", referencedColumnName = "per_id_persona", nullable = false)
	@ManyToOne(optional = false)
	private RgPersona perIdPersona;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facIdFactura")
	private List<FacDetalleFactura> facDetalleFacturaList;

	public FacFactura() {
	}

	public FacFactura(Integer facIdFactura) {
		this.facIdFactura = facIdFactura;
	}

	public FacFactura(Integer facIdFactura, String facCodigo, Date facFechaCreacion, int facUsrCreacion, boolean facEstado) {
		this.facIdFactura = facIdFactura;
		this.facCodigo = facCodigo;
		this.facFechaCreacion = facFechaCreacion;
		this.facUsrCreacion = facUsrCreacion;
		this.facEstado = facEstado;
	}

	public Integer getFacIdFactura() {
		return facIdFactura;
	}

	public void setFacIdFactura(Integer facIdFactura) {
		this.facIdFactura = facIdFactura;
	}

	public String getFacCodigo() {
		return facCodigo;
	}

	public void setFacCodigo(String facCodigo) {
		this.facCodigo = facCodigo;
	}

	public Date getFacFechaCreacion() {
		return facFechaCreacion;
	}

	public void setFacFechaCreacion(Date facFechaCreacion) {
		this.facFechaCreacion = facFechaCreacion;
	}

	public int getFacUsrCreacion() {
		return facUsrCreacion;
	}

	public void setFacUsrCreacion(int facUsrCreacion) {
		this.facUsrCreacion = facUsrCreacion;
	}

	public boolean getFacEstado() {
		return facEstado;
	}

	public void setFacEstado(boolean facEstado) {
		this.facEstado = facEstado;
	}

	public RgPersona getPerIdPersona() {
		return perIdPersona;
	}

	public void setPerIdPersona(RgPersona perIdPersona) {
		this.perIdPersona = perIdPersona;
	}

	@XmlTransient
	public List<FacDetalleFactura> getFacDetalleFacturaList() {
		return facDetalleFacturaList;
	}

	public void setFacDetalleFacturaList(List<FacDetalleFactura> facDetalleFacturaList) {
		this.facDetalleFacturaList = facDetalleFacturaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (facIdFactura != null ? facIdFactura.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FacFactura)) {
			return false;
		}
		FacFactura other = (FacFactura) object;
		if ((this.facIdFactura == null && other.facIdFactura != null) || (this.facIdFactura != null && !this.facIdFactura.equals(other.facIdFactura))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.FacFactura[ facIdFactura=" + facIdFactura + " ]";
	}

}

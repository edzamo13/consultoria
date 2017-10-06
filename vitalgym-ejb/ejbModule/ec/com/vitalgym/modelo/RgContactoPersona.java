
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
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 *         [$Author: ezamora $, $Date: 23-ago-2017]
 *         </p>
 */
@Entity
@Table(name = "rg_contacto_persona", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = RgContactoPersona.OBTENER_CONTACTO_PERSONA_ACTIVO, query = "SELECT r FROM RgContactoPersona r WHERE r.ctcEstado= true") ,
		@NamedQuery(name = RgContactoPersona.OBTENER_CONTACTO_PERSONA_ACTIVO_IDPERSONA, query = "SELECT r FROM RgContactoPersona r WHERE r.perIdPersona = :rgPersona AND r.ctcEstado= true") })
public class RgContactoPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_CONTACTO_PERSONA_ACTIVO = "RgContactoPersona.OBTENER_CONTACTO_PERSONA_ACTIVO";
	public static final String OBTENER_CONTACTO_PERSONA_ACTIVO_IDPERSONA = "RgContactoPersona.OBTENER_CONTACTO_PERSONA_ACTIVO_IDPERSONA";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ctc_id_contacto_persona", nullable = false)
	private Integer ctcIdContactoPersona;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctg_id_catalogo", nullable = false)
	private int ctgIdCatalogo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "ctc_detalle_contacto", nullable = false, length = 255)
	private String ctcDetalleContacto;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctc_fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date ctcFechaCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctc_usr_creacion", nullable = false)
	private int ctcUsrCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctc_estado", nullable = false)
	private boolean ctcEstado;
	@JoinColumn(name = "per_id_persona", referencedColumnName = "per_id_persona", nullable = false)
	@ManyToOne(optional = false)
	private RgPersona perIdPersona;

	public RgContactoPersona() {
	}

	public RgContactoPersona(Integer ctcIdContactoPersona) {
		this.ctcIdContactoPersona = ctcIdContactoPersona;
	}

	public RgContactoPersona(Integer ctcIdContactoPersona, int ctgIdCatalogo, String ctcDetalleContacto,
			Date ctcFechaCreacion, int ctcUsrCreacion, boolean ctcEstado) {
		this.ctcIdContactoPersona = ctcIdContactoPersona;
		this.ctgIdCatalogo = ctgIdCatalogo;
		this.ctcDetalleContacto = ctcDetalleContacto;
		this.ctcFechaCreacion = ctcFechaCreacion;
		this.ctcUsrCreacion = ctcUsrCreacion;
		this.ctcEstado = ctcEstado;
	}

	public Integer getCtcIdContactoPersona() {
		return ctcIdContactoPersona;
	}

	public void setCtcIdContactoPersona(Integer ctcIdContactoPersona) {
		this.ctcIdContactoPersona = ctcIdContactoPersona;
	}

	public int getCtgIdCatalogo() {
		return ctgIdCatalogo;
	}

	public void setCtgIdCatalogo(int ctgIdCatalogo) {
		this.ctgIdCatalogo = ctgIdCatalogo;
	}

	public String getCtcDetalleContacto() {
		return ctcDetalleContacto;
	}

	public void setCtcDetalleContacto(String ctcDetalleContacto) {
		this.ctcDetalleContacto = ctcDetalleContacto;
	}

	public Date getCtcFechaCreacion() {
		return ctcFechaCreacion;
	}

	public void setCtcFechaCreacion(Date ctcFechaCreacion) {
		this.ctcFechaCreacion = ctcFechaCreacion;
	}

	public int getCtcUsrCreacion() {
		return ctcUsrCreacion;
	}

	public void setCtcUsrCreacion(int ctcUsrCreacion) {
		this.ctcUsrCreacion = ctcUsrCreacion;
	}

	public boolean getCtcEstado() {
		return ctcEstado;
	}

	public void setCtcEstado(boolean ctcEstado) {
		this.ctcEstado = ctcEstado;
	}

	public RgPersona getPerIdPersona() {
		return perIdPersona;
	}

	public void setPerIdPersona(RgPersona perIdPersona) {
		this.perIdPersona = perIdPersona;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ctcIdContactoPersona != null ? ctcIdContactoPersona.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RgContactoPersona)) {
			return false;
		}
		RgContactoPersona other = (RgContactoPersona) object;
		if ((this.ctcIdContactoPersona == null && other.ctcIdContactoPersona != null)
				|| (this.ctcIdContactoPersona != null
						&& !this.ctcIdContactoPersona.equals(other.ctcIdContactoPersona))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.RgContactoPersona[ ctcIdContactoPersona=" + ctcIdContactoPersona + " ]";
	}

}

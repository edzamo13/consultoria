
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
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 *         [$Author: ezamora $, $Date: 14-ago-2017]
 *         </p>
 */
@Entity
@Table(name = "rg_persona", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = RgPersona.OBTENER_RGPERSONA_TODO, query = "SELECT r FROM RgPersona r"), @NamedQuery(name = RgPersona.OBTENER_RGPERSONA_TODO_ACTIVO, query = "SELECT r FROM RgPersona r where r.perEstado= true"), })
public class RgPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_RGPERSONA_TODO = "RgPersona.OBTENER_RGPERSONA_TODO";
	public static final String OBTENER_RGPERSONA_TODO_ACTIVO = "RgPersona.OBTENER_RGPERSONA_TODO_ACTIVO";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "per_id_persona", nullable = false)
	private Integer perIdPersona;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "per_cedula", nullable = false, length = 10)
	private String perCedula;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "per_nombres", nullable = false, length = 255)
	private String perNombres;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "per_apellidos", nullable = false, length = 255)
	private String perApellidos;
	@Basic(optional = false)
	@NotNull
	@Column(name = "per_fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date perFechaNacimiento;
	@Size(max = 255)
	@Column(name = "per_lugar_nacimiento", length = 255)
	private String perLugarNacimiento;
	@Size(max = 255)
	@Column(name = "per_nacionalidad", length = 255)
	private String perNacionalidad;
	@Size(max = 100)
	@Column(name = "per_sexo", length = 100)
	private String perSexo;
	@Size(max = 100)
	@Column(name = "per_estado_civil", length = 100)
	private String perEstadoCivil;
	@Basic(optional = false)
	@NotNull
	@Column(name = "per_fecha_creacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date perFechaCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "per_usr_crea", nullable = false)
	private int perUsrCrea;
	@Column(name = "per_fecha_actualiza")
	@Temporal(TemporalType.DATE)
	private Date perFechaActualiza;
	@Column(name = "per_usr_actualiza")
	private Integer perUsrActualiza;
	@Basic(optional = false)
	@NotNull
	@Column(name = "per_estado", nullable = false)
	private boolean perEstado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdPersona")
	private List<RgContactoPersona> rgContactoPersonaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdPersona")
	private List<FacFactura> facFacturaList;

	public RgPersona() {
	}

	public RgPersona(Integer perIdPersona) {
		this.perIdPersona = perIdPersona;
	}

	public RgPersona(Integer perIdPersona, String perCedula, String perNombres, String perApellidos, Date perFechaNacimiento, Date perFechaCreacion, int perUsrCrea, boolean perEstado) {
		this.perIdPersona = perIdPersona;
		this.perCedula = perCedula;
		this.perNombres = perNombres;
		this.perApellidos = perApellidos;
		this.perFechaNacimiento = perFechaNacimiento;
		this.perFechaCreacion = perFechaCreacion;
		this.perUsrCrea = perUsrCrea;
		this.perEstado = perEstado;
	}

	public Integer getPerIdPersona() {
		return perIdPersona;
	}

	public void setPerIdPersona(Integer perIdPersona) {
		this.perIdPersona = perIdPersona;
	}

	public String getPerCedula() {
		return perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerNombres() {
		return perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	public String getPerApellidos() {
		return perApellidos;
	}

	public void setPerApellidos(String perApellidos) {
		this.perApellidos = perApellidos;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public String getPerLugarNacimiento() {
		return perLugarNacimiento;
	}

	public void setPerLugarNacimiento(String perLugarNacimiento) {
		this.perLugarNacimiento = perLugarNacimiento;
	}

	public String getPerNacionalidad() {
		return perNacionalidad;
	}

	public void setPerNacionalidad(String perNacionalidad) {
		this.perNacionalidad = perNacionalidad;
	}

	public String getPerSexo() {
		return perSexo;
	}

	public void setPerSexo(String perSexo) {
		this.perSexo = perSexo;
	}

	public String getPerEstadoCivil() {
		return perEstadoCivil;
	}

	public void setPerEstadoCivil(String perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
	}

	public Date getPerFechaCreacion() {
		return perFechaCreacion;
	}

	public void setPerFechaCreacion(Date perFechaCreacion) {
		this.perFechaCreacion = perFechaCreacion;
	}

	public int getPerUsrCrea() {
		return perUsrCrea;
	}

	public void setPerUsrCrea(int perUsrCrea) {
		this.perUsrCrea = perUsrCrea;
	}

	public Date getPerFechaActualiza() {
		return perFechaActualiza;
	}

	public void setPerFechaActualiza(Date perFechaActualiza) {
		this.perFechaActualiza = perFechaActualiza;
	}

	public Integer getPerUsrActualiza() {
		return perUsrActualiza;
	}

	public void setPerUsrActualiza(Integer perUsrActualiza) {
		this.perUsrActualiza = perUsrActualiza;
	}

	public boolean getPerEstado() {
		return perEstado;
	}

	public void setPerEstado(boolean perEstado) {
		this.perEstado = perEstado;
	}

	@XmlTransient
	public List<RgContactoPersona> getRgContactoPersonaList() {
		return rgContactoPersonaList;
	}

	public void setRgContactoPersonaList(List<RgContactoPersona> rgContactoPersonaList) {
		this.rgContactoPersonaList = rgContactoPersonaList;
	}

	@XmlTransient
	public List<FacFactura> getFacFacturaList() {
		return facFacturaList;
	}

	public void setFacFacturaList(List<FacFactura> facFacturaList) {
		this.facFacturaList = facFacturaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (perIdPersona != null ? perIdPersona.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RgPersona)) {
			return false;
		}
		RgPersona other = (RgPersona) object;
		if ((this.perIdPersona == null && other.perIdPersona != null) || (this.perIdPersona != null && !this.perIdPersona.equals(other.perIdPersona))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.RgPersona[ perIdPersona=" + perIdPersona + " ]";
	}

}



package ec.com.vitalgym.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 * 		[$Author: ezamora $, $Date: 14-ago-2017]
 *         </p>
 */
@Entity
@Table(name = "sys_catalogo", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = SysCatalogo.OBTENER_SYSCATALOGO, query = "SELECT s FROM SysCatalogo s where s.ctgEstado=true") })
public class SysCatalogo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_SYSCATALOGO = "SysCatalogo.OBTENER_SYSCATALOGO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ctg_id_catalogo", nullable = false)
	@Getter
	@Setter
	private Integer ctgIdCatalogo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctg_id_padre")
	@Getter
	@Setter
	private Integer ctgIdPadre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "ctg_descripcion", nullable = false, length = 255)
	@Getter
	@Setter
	private String ctgDescripcion;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "ctg_nemonico", length = 255)
	@Getter
	@Setter
	private String ctgNemonico;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctg_fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	@Getter
	@Setter
	private Date ctgFechaCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctg_usr_creacion")
	@Getter
	@Setter
	private int ctgUsrCreacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ctg_estado", nullable = false)
	@Getter
	@Setter
	private boolean ctgEstado;

	public SysCatalogo() {
	}

	public SysCatalogo(Integer ctgIdCatalogo) {
		this.ctgIdCatalogo = ctgIdCatalogo;
	}

	

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ctgIdCatalogo != null ? ctgIdCatalogo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SysCatalogo)) {
			return false;
		}
		SysCatalogo other = (SysCatalogo) object;
		if ((this.ctgIdCatalogo == null && other.ctgIdCatalogo != null)
						|| (this.ctgIdCatalogo != null && !this.ctgIdCatalogo.equals(other.ctgIdCatalogo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.SysCatalogo[ ctgIdCatalogo=" + ctgIdCatalogo + " ]";
	}

	public SysCatalogo(Integer ctgIdCatalogo, Integer ctgIdPadre, String ctgDescripcion, String ctgNemonico, Date ctgFechaCreacion,
					int ctgUsrCreacion, boolean ctgEstado) {
		super();
		this.ctgIdCatalogo = ctgIdCatalogo;
		this.ctgIdPadre = ctgIdPadre;
		this.ctgDescripcion = ctgDescripcion;
		this.ctgNemonico = ctgNemonico;
		this.ctgFechaCreacion = ctgFechaCreacion;
		this.ctgUsrCreacion = ctgUsrCreacion;
		this.ctgEstado = ctgEstado;
	}

}

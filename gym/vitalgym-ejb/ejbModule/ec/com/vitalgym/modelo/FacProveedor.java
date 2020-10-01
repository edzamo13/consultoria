
package ec.com.vitalgym.modelo;

import java.io.Serializable;
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
 *         [$Author: ezamora $, $Date: 01-sep-2017]
 *         </p>
 */
@Entity
@Table(name = "fac_proveedor", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = FacProveedor.OBTENER_PROVEEDOR_ACTIVO, query = "SELECT f FROM FacProveedor f where f.prEstado=true") })
public class FacProveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_PROVEEDOR_ACTIVO = "FacProveedor.OBTENER_PROVEEDOR_ACTIVO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "pr_id_proveedor", nullable = false)
	@Getter
	@Setter
	private Integer prIdProveedor;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "pr_nombre", nullable = false, length = 255)
	@Getter
	@Setter
	private String prNombre;
	@Column(name = "pr_ruc", length = 25)
	@Getter
	@Setter
	private String prRuc;
	@Size(max = 255)
	@Column(name = "pr_direccion", length = 255)
	@Getter
	@Setter
	private String prDireccion;
	@Size(max = 255)
	@Column(name = "pr_ciudad", length = 255)
	@Getter
	@Setter
	private String prCiudad;
	@Size(max = 255)
	@Column(name = "pr_provincia", length = 255)
	@Getter
	@Setter
	private String prProvincia;
	@Size(max = 255)
	@Column(name = "pr_telefono", length = 255)
	@Getter
	@Setter
	private String prTelefono;
	@Size(max = 255)
	@Column(name = "pr_celular", length = 255)
	@Getter
	@Setter
	private String prCelular;
	@Size(max = 255)
	@Column(name = "pr_email", length = 255)
	@Getter
	@Setter
	private String prEmail;
	@Size(max = 255)
	@Column(name = "pr_observacion", length = 255)
	@Getter
	@Setter
	private String prObservacion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "pr_estado", nullable = false)
	@Getter
	@Setter
	private Boolean prEstado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prIdProveedor")
	@Getter
	@Setter
	private List<FacProducto> facProductoList;

	public FacProveedor() {
	}

	public FacProveedor(Integer prIdProveedor) {
		this.prIdProveedor = prIdProveedor;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prIdProveedor != null ? prIdProveedor.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FacProveedor)) {
			return false;
		}
		FacProveedor other = (FacProveedor) object;
		if ((this.prIdProveedor == null && other.prIdProveedor != null) || (this.prIdProveedor != null && !this.prIdProveedor.equals(other.prIdProveedor))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.FacProveedor[ prIdProveedor=" + prIdProveedor + " ]";
	}

	public FacProveedor(Integer prIdProveedor, String prNombre, String prRuc, String prDireccion, String prCiudad, String prProvincia, String prTelefono, String prCelular, String prEmail, String prObservacion, Boolean prEstado, List<FacProducto> facProductoList) {
		super();
		this.prIdProveedor = prIdProveedor;
		this.prNombre = prNombre;
		this.prRuc = prRuc;
		this.prDireccion = prDireccion;
		this.prCiudad = prCiudad;
		this.prProvincia = prProvincia;
		this.prTelefono = prTelefono;
		this.prCelular = prCelular;
		this.prEmail = prEmail;
		this.prObservacion = prObservacion;
		this.prEstado = prEstado;
		this.facProductoList = facProductoList;
	}

}

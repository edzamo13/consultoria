
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 *         [$Author: ezamora $, $Date: 23-ago-2017]
 *         </p>
 */
@Entity
@Table(name = "fac_producto", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = FacProducto.OBTENER_PRODUCTO_ACTIVO, query = "SELECT f FROM FacProducto f where f.prdEstado=true") })
public class FacProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBTENER_PRODUCTO_ACTIVO = "FacProducto.OBTENER_PRODUCTO_ACTIVO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "prd_id_producto", nullable = false)
	@Getter
	@Setter
	private Integer prdIdProducto;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "prd_nombre", nullable = false, length = 255)
	@Getter
	@Setter
	private String prdNombre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "prd_detalle_producto", nullable = false, length = 255)
	@Getter
	@Setter
	private String prdDetalleProducto;
	@Column(name = "prd_dias_duracion")
	@Getter
	@Setter
	private Integer prdDiasDuracion;
	@Column(name = "prd_dias_consumo")
	@Getter
	@Setter
	private Integer prdDiasConsumo;
	@Size(max = 2147483647)
	@Column(name = "prd_nemonico_producto", length = 2147483647)
	@Getter
	@Setter
	private String prdNemonicoProducto;
	@Basic(optional = false)
	@NotNull
	@Column(name = "prd_estado", nullable = false)
	@Getter
	@Setter
	private boolean prdEstado;
	@Size(max = 2147483647)
	@Column(name = "prd_tipo_pago", length = 2147483647)
	@Getter
	@Setter
	private String prdTipoPago;
	@Basic(optional = false)
	@NotNull
	@Column(name = "prd_precio_venta", nullable = false)
	@Getter
	@Setter
	private Double prdPrecioVenta;
	@Column(name = "prd_tipo_producto")
	@Getter
	@Setter
	private Integer prdTipoProducto;	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prdIdProducto")
	@Getter
	@Setter
	private List<FacDetalleFactura> facDetalleFacturaList;
	@JoinColumn(name = "pr_id_proveedor", referencedColumnName = "pr_id_proveedor", nullable = false)
	@ManyToOne(optional = false)
	@Getter
	@Setter
	private FacProveedor prIdProveedor;

	public FacProducto() {
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prdIdProducto != null ? prdIdProducto.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FacProducto)) {
			return false;
		}
		FacProducto other = (FacProducto) object;
		if ((this.prdIdProducto == null && other.prdIdProducto != null) || (this.prdIdProducto != null && !this.prdIdProducto.equals(other.prdIdProducto))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.FacProducto[ prdIdProducto=" + prdIdProducto + " ]";
	}

	public FacProducto(Integer prdIdProducto, String prdNombre, String prdDetalleProducto, Integer prdDiasDuracion, Integer prdDiasConsumo, String prdNemonicoProducto, boolean prdEstado, String prdTipoPago, Double prdPrecioVenta, Integer prdTipoProducto,
			List<FacDetalleFactura> facDetalleFacturaList, FacProveedor prIdProveedor) {
		super();
		this.prdIdProducto = prdIdProducto;
		this.prdNombre = prdNombre;
		this.prdDetalleProducto = prdDetalleProducto;
		this.prdDiasDuracion = prdDiasDuracion;
		this.prdDiasConsumo = prdDiasConsumo;
		this.prdNemonicoProducto = prdNemonicoProducto;
		this.prdEstado = prdEstado;
		this.prdTipoPago = prdTipoPago;
		this.prdPrecioVenta = prdPrecioVenta;
		this.prdTipoProducto = prdTipoProducto;
		this.facDetalleFacturaList = facDetalleFacturaList;
		this.prIdProveedor = prIdProveedor;
	}

	
	
	


}


package ec.com.vitalgym.modelo;

import java.io.Serializable;

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
@Table(name = "fac_detalle_factura", catalog = "ec_singlepymes", schema = "vitalgym")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FacDetalleFactura.findAll", query = "SELECT f FROM FacDetalleFactura f") })
public class FacDetalleFactura implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "det_id_detalle_factura", nullable = false)
	@Getter
	@Setter
	private Integer detIdDetalleFactura;
	@Column(name = "det_cantidad")
	@Getter
	@Setter
	private Integer detCantidad;
	@Column(name = "det_precio_unitario")
	@Getter
	@Setter
	private Double detPrecioUnitario;
	@Column(name = "det_descuento")
	@Getter
	@Setter
	private Double detDescuento;
	@Column(name = "det_sub_total")
	@Getter
	@Setter
	private Double detSubTotal;
	@JoinColumn(name = "fac_id_factura", referencedColumnName = "fac_id_factura", nullable = false)
	@ManyToOne(optional = false)
	@Getter
	@Setter
	private FacFactura facIdFactura;
	@JoinColumn(name = "prd_id_producto", referencedColumnName = "prd_id_producto", nullable = false)
	@ManyToOne(optional = false)
	@Getter
	@Setter
	private FacProducto prdIdProducto;

	public FacDetalleFactura() {
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (detIdDetalleFactura != null ? detIdDetalleFactura.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FacDetalleFactura)) {
			return false;
		}
		FacDetalleFactura other = (FacDetalleFactura) object;
		if ((this.detIdDetalleFactura == null && other.detIdDetalleFactura != null) || (this.detIdDetalleFactura != null && !this.detIdDetalleFactura.equals(other.detIdDetalleFactura))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ec.com.vitalgym.gestion.modelo.FacDetalleFactura[ detIdDetalleFactura=" + detIdDetalleFactura + " ]";
	}

	public FacDetalleFactura(Integer detIdDetalleFactura, Integer detCantidad, Double detPrecioUnitario, Double detDescuento, Double detSubTotal, FacFactura facIdFactura, FacProducto prdIdProducto) {
		super();
		this.detIdDetalleFactura = detIdDetalleFactura;
		this.detCantidad = detCantidad;
		this.detPrecioUnitario = detPrecioUnitario;
		this.detDescuento = detDescuento;
		this.detSubTotal = detSubTotal;
		this.facIdFactura = facIdFactura;
		this.prdIdProducto = prdIdProducto;
	}
	
	
	

}

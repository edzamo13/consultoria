package ec.com.vitalgym.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;

import ec.com.vitalgym.local.FacDetalleFacturaLocal;
import ec.com.vitalgym.local.FacFacturaLocal;
import ec.com.vitalgym.local.FacProductoLocal;
import ec.com.vitalgym.local.RgPersonaLocal;
import ec.com.vitalgym.modelo.FacDetalleFactura;
import ec.com.vitalgym.modelo.FacFactura;
import ec.com.vitalgym.modelo.FacProducto;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class FacturaControlador extends UtilitarioJsf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(FacturaControlador.class);

	@Getter
	@Setter
	private RgPersona rgPersona;
	@Getter
	@Setter
	private List<RgPersona> rgPersonas;
	@Getter
	@Setter
	private FacFactura facFactura;
	@Getter
	@Setter
	private FacDetalleFactura facDetalleFactura;
	@Getter
	@Setter
	private List<FacDetalleFactura> facDetalleFacturaProductos;
	@Getter
	@Setter
	private List<FacDetalleFactura> facDetalleFacturas;

	@Getter
	@Setter
	private Double valorIva;
	@Getter
	@Setter
	private Double valorTotal;
	@Getter
	@Setter
	private Boolean flagCliente;

	@EJB
	@Getter
	private RgPersonaLocal rgPersonaLocal;

	@EJB
	@Getter
	private FacProductoLocal facProductoLocal;
	@EJB
	@Getter
	private FacFacturaLocal facFacturaLocal;
	@EJB
	@Getter
	private FacDetalleFacturaLocal facDetalleFacturaLocal;

	@PostConstruct
	public void init() {
		setRgPersona(new RgPersona());
		setRgPersonas(new ArrayList<RgPersona>());
		setFacFactura(new FacFactura());
		setFacDetalleFactura(new FacDetalleFactura());
		setFacDetalleFacturaProductos(new ArrayList<FacDetalleFactura>());
		setFacDetalleFacturas(new ArrayList<FacDetalleFactura>());
		setValorIva(new Double(0));
		setValorTotal(new Double(0));
		setFlagCliente(false);
	}

	/**
	 * <b>buscarCliente </b>
	 * <p>
	 * [Author: ezamora, Date: 8 sep. 2017]
	 * </p>
	 */
	public void buscarTodoCliente() {
		setValorIva(new Double(0));
		setValorTotal(new Double(0));
		setRgPersona(new RgPersona());
		setRgPersonas(getRgPersonaLocal().obtenerTodoActivo());
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgCliente').show();");

	}

	/**
	 * <b>buscarCliente </b>
	 * <p>
	 * [Author: ezamora, Date: 8 sep. 2017]
	 * </p>
	 */
	public void buscarTodoProducto() {
		FacDetalleFactura facDetalleFactura = new FacDetalleFactura();
		setFacDetalleFactura(new FacDetalleFactura());
		setFacDetalleFacturaProductos(new ArrayList<FacDetalleFactura>());
		for (FacProducto p : getFacProductoLocal().obtenerProductosActivos()) {
			facDetalleFactura.setPrdIdProducto(p);
			getFacDetalleFacturaProductos().add(facDetalleFactura);
			facDetalleFactura = new FacDetalleFactura();
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgProducto').show();");

	}

	/**
	 * <b>obtieneCliente. </b>
	 * <p>
	 * [Author: ezamora, Date: 8 sep. 2017]
	 * </p>
	 */
	public void obtieneCliente(RgPersona persona) {
		setRgPersona(persona);
		setFlagCliente(true);
		setFacFactura(new FacFactura());
		getFacFactura().setFacEstado(true);
		getFacFactura().setFacFechaCreacion(new Date());
		getFacFactura().setFacUsrCreacion(1);
		getFacFactura().setPerIdPersona(persona);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgCliente').hide();");
	}

	public void obtieneProducto(FacDetalleFactura facDetalleFactura) {
		setFacDetalleFactura(facDetalleFactura);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgProducto').hide();");
	}

	public void calcularProductos() {
		if (validarCatidad(getFacDetalleFacturas())) {
			ponerMensajeError("Ingrese la cantidad a facturar");
		} else {
			calcularFactura(getFacDetalleFacturas());
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgProducto').hide();");

		}

	}

	private Boolean validarCatidad(List<FacDetalleFactura> facDetalleFacturas) {
		Boolean flag = new Boolean(false);
		for (FacDetalleFactura dt : facDetalleFacturas) {
			if (dt.getDetCantidad() == 0) {
				flag = true;
				break;
			}

		}
		return flag;
	}

	private void calcularFactura(List<FacDetalleFactura> facDetalleFacturas) {
		Double valor = new Double(0);
		for (FacDetalleFactura dt : facDetalleFacturas) {
			dt.setDetPrecioUnitario(dt.getPrdIdProducto().getPrdPrecioVenta());
			dt.setDetSubTotal(dt.getDetCantidad() * dt.getDetPrecioUnitario());
			valor += dt.getDetSubTotal();
		}
		/*
		 * for (FacDetalleFactura dt : facDetalleFacturas) { valor +=
		 * dt.getDetSubTotal(); }
		 */
		setValorTotal(valor);
		setValorIva(valor * 0.12);
		double roundOff = Math.round(getValorIva() * 100) / 100;

		System.out.println(roundOff);

	}

	public void guardarFactura() {
		try {
			setFacFactura(getFacFacturaLocal().makePersistent(getFacFactura()));
			guardarDetalleFactura(getFacFactura());
			ponerMensajeInfo("Registro Guardado.");
			init();
		} catch (Exception e) {
			ponerMensajeAlerta("Error no se guardo el registro ...");
		}

	}

	private void guardarDetalleFactura(FacFactura factura) {
		List<FacDetalleFactura> tmp = new ArrayList<FacDetalleFactura>();
		for (FacDetalleFactura detalle : getFacDetalleFacturas()) {
			detalle.setFacIdFactura(factura);
		}
		for (FacDetalleFactura facDetalle : getFacDetalleFacturas()) {
			facDetalle = getFacDetalleFacturaLocal().makePersistent(facDetalle);
			tmp.add(facDetalle);
		}
		setFacDetalleFacturas(tmp);

	}

}

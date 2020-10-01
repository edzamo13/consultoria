package ec.com.vitalgym.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

import ec.com.vitalgym.local.FacProductoLocal;
import ec.com.vitalgym.local.FacProveedorLocal;
import ec.com.vitalgym.local.SysCatalogoLocal;
import ec.com.vitalgym.modelo.FacProducto;
import ec.com.vitalgym.modelo.FacProveedor;
import ec.com.vitalgym.modelo.SysCatalogo;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ProductoControlador extends UtilitarioJsf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(ProductoControlador.class);

	@Getter
	@Setter
	private boolean skip;
	@Getter
	@Setter
	private FacProveedor facProveedor;
	@Getter
	@Setter
	private List<FacProveedor> facProveedorLst;
	@Getter
	@Setter
	private FacProducto facProducto;
	@Getter
	@Setter
	private List<FacProducto> facProductoLst;
	@Getter
	@Setter
	private List<SysCatalogo> sysCatalogos;
	@Getter
	@Setter
	private SysCatalogo sysCatalogo;
	@Getter
	@Setter
	private Integer idProductoGeneral;

	@EJB
	@Getter
	private FacProveedorLocal facProveedorLocal;
	@EJB
	@Getter
	private FacProductoLocal facProductoLocal;
	@EJB
	@Getter
	private SysCatalogoLocal sysCatalogoLocal;

	@PostConstruct
	public void init() {
		setFacProveedor(new FacProveedor());
		setFacProveedorLst(new ArrayList<FacProveedor>());
		setFacProducto(new FacProducto());
		getFacProducto().setPrIdProveedor(new FacProveedor());
		setFacProductoLst(new ArrayList<FacProducto>());
		setSysCatalogo(new SysCatalogo());
		setSysCatalogos(new ArrayList<SysCatalogo>());
		setSysCatalogos(getSysCatalogoLocal().getAll());

		setFacProductoLst(getFacProductoLocal().obtenerProductosActivos());
		setFacProveedorLst(getFacProveedorLocal().obtenerProveedoresActivos());
		cargarCombos(getSysCatalogos());
		setIdProductoGeneral(idProductoGeneral(getSysCatalogos()));

	}

	/**
	 * <b>Obtienes el id de Producto General. </b>
	 * <p>
	 * [Author: ezamora, Date: 1 sep. 2017]
	 * </p>
	 */
	private Integer idProductoGeneral(List<SysCatalogo> catalogos) {
		Integer id = 0;
		for (SysCatalogo c : catalogos) {
			if (!(c.getCtgNemonico() == null)) {
				if (c.getCtgNemonico().equals("PRDG"))
					id = c.getCtgIdCatalogo();
			}
		}
		return id;

	}

	/**
	 * <b>onFlowProcess. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	/**
	 * <b>nuevoRegistroPersona. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public void nuevoProducto() {
		setFacProducto(new FacProducto());
		getFacProducto().setPrIdProveedor(new FacProveedor());
		getFacProducto().setPrdEstado(true);
		getFacProducto().setPrdTipoProducto(getIdProductoGeneral());
		setFacProveedorLst(getFacProveedorLocal().obtenerProveedoresActivos());
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistro').show();");

	}

	/**
	 * <b>cargarCombos. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	private void cargarCombos(List<SysCatalogo> catalogos) {
		setSysCatalogos(new ArrayList<SysCatalogo>());
		for (SysCatalogo c : catalogos) {
			if (!(c.getCtgNemonico() == null)) {
				if (c.getCtgNemonico().equals("PRD")) {
					for (SysCatalogo c1 : catalogos) {
						if (!(c1.getCtgIdPadre() == null)) {
							if (c.getCtgIdCatalogo().equals(c1.getCtgIdPadre())) {
								getSysCatalogos().add(c1);
							}
						}
					}

				}
			}
		}

	}

	/**
	 *
	 * <b> Guardar Persona </b>
	 * <p>
	 * [Author: ezamora , Date:22 ago. 2017]
	 * </p>
	 */
	public void guardarRegistro() {
		try {
			setFacProducto(getFacProductoLocal().makePersistent(getFacProducto()));
			ponerMensajeInfo("Registro Guardado");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgRegistro').hide();");
			init();
		} catch (Exception e) {
			ponerMensajeAlerta("Error no se guardo el registro ...");
		}

	}

	/**
	 * <b>Recupera la informacion . </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public void recuperarRegistro(FacProducto producto) {
		setFacProducto(producto);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistro').show();");

	}

	/**
	 * <b>cancelarPersona. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public void cancelarPersona() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistro').hide();");
	}

}

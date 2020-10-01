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

import ec.com.vitalgym.local.FacProveedorLocal;
import ec.com.vitalgym.local.SysCatalogoLocal;
import ec.com.vitalgym.modelo.FacProveedor;
import ec.com.vitalgym.modelo.SysCatalogo;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ProveedorControlador extends UtilitarioJsf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(ProveedorControlador.class);

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
	private List<SysCatalogo> sysCatalogos;
	@Getter
	@Setter
	private SysCatalogo sysCatalogo;

	@EJB
	@Getter
	private FacProveedorLocal facProveedorLocal;
	@EJB
	@Getter
	private SysCatalogoLocal sysCatalogoLocal;

	@PostConstruct
	public void init() {
		setFacProveedor(new FacProveedor());
		setFacProveedorLst(new ArrayList<FacProveedor>());
		setSysCatalogo(new SysCatalogo());
		setSysCatalogos(new ArrayList<SysCatalogo>());
		setSysCatalogos(getSysCatalogoLocal().getAll());
		setFacProveedorLst(getFacProveedorLocal().obtenerProveedoresActivos());
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
	public void nuevoProveedor() {
		setFacProveedor(new FacProveedor());
		getFacProveedor().setPrEstado(true);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistro').show();");

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
			setFacProveedor(getFacProveedorLocal().makePersistent(getFacProveedor()));
			ponerMensajeInfo("Registro Guardado");
			setFacProveedorLst(getFacProveedorLocal().obtenerProveedoresActivos());
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
	public void recuperarRegistro(FacProveedor proveedor) {
		setFacProveedor(proveedor);
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

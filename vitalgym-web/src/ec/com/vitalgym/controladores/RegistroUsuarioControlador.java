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
import org.primefaces.event.FlowEvent;

import ec.com.vitalgym.local.RgContactoPersonaLocal;
import ec.com.vitalgym.local.RgPersonaLocal;
import ec.com.vitalgym.local.SysCatalogoLocal;
import ec.com.vitalgym.modelo.RgContactoPersona;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.modelo.SysCatalogo;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class RegistroUsuarioControlador extends UtilitarioJsf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(RegistroUsuarioControlador.class);

	@Getter
	@Setter
	private boolean skip;
	@Getter
	@Setter
	private RgPersona rgPersona;
	@Getter
	@Setter
	private List<RgPersona> rgPersonas;
	@Getter
	@Setter
	private List<SysCatalogo> sysCatalogos;
	@Getter
	@Setter
	private List<SysCatalogo> sysCatalogoSexos;
	@Getter
	@Setter
	private List<SysCatalogo> sysCatalogoEstasoCivils;
	@Getter
	@Setter
	private List<SysCatalogo> sysCatalogoTipoContactos;
	@Getter
	@Setter
	private SysCatalogo sysCatalogo;
	@Getter
	@Setter
	private List<RgContactoPersona> rgContactoPersonas;
	@Getter
	@Setter
	private RgContactoPersona rgContactoPersona;

	@EJB
	@Getter
	private RgPersonaLocal rgPersonaLocal;
	@EJB
	@Getter
	private SysCatalogoLocal sysCatalogoLocal;
	@EJB
	@Getter
	private RgContactoPersonaLocal rgContactoPersonaLocal;

	@PostConstruct
	public void init() {
		setRgPersonas(new ArrayList<RgPersona>());
		setRgPersona(new RgPersona());

		setSysCatalogos(new ArrayList<SysCatalogo>());
		setSysCatalogoEstasoCivils(new ArrayList<SysCatalogo>());
		setSysCatalogoSexos(new ArrayList<SysCatalogo>());
		setSysCatalogoTipoContactos(new ArrayList<SysCatalogo>());
		setSysCatalogo(new SysCatalogo());
		setRgContactoPersonas(new ArrayList<RgContactoPersona>());
		setRgPersonas(getRgPersonaLocal().obtenerTodoActivo());
		setSysCatalogos(getSysCatalogoLocal().getAll());
		cargarCombos(getSysCatalogos());

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
	public void nuevoRegistroPersona() {
		setRgPersona(new RgPersona());
		getRgPersona().setPerLugarNacimiento(" ");
		getRgPersona().setPerNacionalidad(" ");
		getRgPersona().setPerSexo(" ");
		getRgPersona().setPerEstadoCivil(" ");
		getRgPersona().setPerUsrCrea(1);
		getRgPersona().setPerFechaCreacion(new Date());
		getRgPersona().setPerEstado(true);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistroUsuario').show();");
		setRgContactoPersonas(new ArrayList<RgContactoPersona>());
	}

	/**
	 * <b>cargarCombos. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	private void cargarCombos(List<SysCatalogo> catalogos) {
		for (SysCatalogo c : catalogos) {
			if (!(c.getCtgNemonico() == null)) {

				if (c.getCtgNemonico().equals("SX")) {
					for (SysCatalogo c1 : catalogos) {
						if (!(c1.getCtgIdPadre() == null)) {
							if (c.getCtgIdCatalogo().equals(c1.getCtgIdPadre())) {
								getSysCatalogoSexos().add(c1);
							}
						}
					}

				} else if (c.getCtgNemonico().equals("ECV")) {
					for (SysCatalogo c1 : catalogos) {
						if (!(c1.getCtgIdPadre() == null)) {
							if (c.getCtgIdCatalogo().equals(c1.getCtgIdPadre())) {
								getSysCatalogoEstasoCivils().add(c1);
							}
						}
					}

				} else if (c.getCtgNemonico().equals("TCT")) {
					for (SysCatalogo c1 : catalogos) {
						if (!(c1.getCtgIdPadre() == null)) {
							if (c.getCtgIdCatalogo().equals(c1.getCtgIdPadre())) {
								getSysCatalogoTipoContactos().add(c1);
							}
						}
					}

				}
			}
		}

	}

	/**
	 *
	 * <b> Incluye una Nuevo tipo de Contacto. </b>
	 * <p>
	 * [Author: ezamora , Date:20 ago. 2017]
	 * </p>
	 */
	public void agregarOtroTipoContacto() {
		setRgContactoPersona(new RgContactoPersona());
		getRgContactoPersona().setCtcUsrCreacion(1);
		getRgContactoPersona().setCtcFechaCreacion(new Date());
		getRgContactoPersona().setCtcEstado(true);
		getRgContactoPersonas().add(getRgContactoPersona());

	}

	/**
	 *
	 * <b> Guardar Persona </b>
	 * <p>
	 * [Author: ezamora , Date:22 ago. 2017]
	 * </p>
	 */
	public void guardarRegistro() {
		Boolean valida = false;
		try {

			if (!getRgContactoPersonas().isEmpty()) {
				for (RgContactoPersona c : getRgContactoPersonas()) {
					c.setPerIdPersona(getRgPersona());
					valida = validarCampos(c);
				}
				if (valida) {
					ponerMensajeAlerta("Complete la información..");
				} else {
					setRgPersona(getRgPersonaLocal().makePersistent(getRgPersona()));
					for (RgContactoPersona cp : getRgContactoPersonas()) {
						cp = getRgContactoPersonaLocal().makePersistent(cp);

					}

					ponerMensajeInfo("Registro Guardado..");
					init();
				}

			} else {
				setRgPersona(getRgPersonaLocal().makePersistent(getRgPersona()));
				ponerMensajeInfo("Registro Guardado..");
				init();

			}

		} catch (Exception e) {
			ponerMensajeAlerta("Error no se guardo el registro ...");
		}

	}

	private Boolean validarCampos(RgContactoPersona contactoPersona) {
		if (contactoPersona.getCtgIdCatalogo() == 0 || contactoPersona.getCtcDetalleContacto().isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * <b>Recupera la informacion de persona y contactos. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public void recuperarPersona(RgPersona persona) {
		setRgPersona(persona);
		setRgContactoPersonas(new ArrayList<RgContactoPersona>());
		setRgContactoPersonas(getRgContactoPersonaLocal().obtenerContactoPersonasPorIdPersona(persona));
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistroUsuario').show();");

	}

	/**
	 * <b>cancelarPersona. </b>
	 * <p>
	 * [Author: ezamora, Date: 23 ago. 2017]
	 * </p>
	 */
	public void cancelarPersona() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgRegistroUsuario').hide();");
		init();

	}

	public Boolean cedulaRepetida() {

		return null;

	}

}

package ec.com.vitalgym.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import ec.com.vitalgym.local.FacDetalleFacturaLocal;
import ec.com.vitalgym.local.FacFacturaLocal;
import ec.com.vitalgym.local.FacProductoLocal;
import ec.com.vitalgym.local.RgPersonaLocal;
import ec.com.vitalgym.modelo.FacDetalleFactura;
import ec.com.vitalgym.modelo.FacFactura;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.UtilitarioJsf;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class FacturaEdicionControlador extends UtilitarioJsf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(FacturaEdicionControlador.class);

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
	private List<FacFactura> facFacturas;
	@Getter
	@Setter
	private FacDetalleFactura facDetalleFactura;
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
	private Boolean flagFactura;
	@Getter
	@Setter
	private Date fechaInicio;
	@Getter
	@Setter
	private Date fechaFin;

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
		setFechaInicio(new Date());
		setFechaFin(new Date());
		setFacFacturas(new ArrayList<FacFactura>());
		setFacDetalleFacturas(new ArrayList<FacDetalleFactura>());
		setFlagFactura(false);

	}

	public void buscarFacturaCliente() {
		removeTime(getFechaInicio(), getFechaFin());
		setFacFacturas(getFacFacturaLocal().obtenerFacturasActivasFechaInicioFin(getFechaInicio(), getFechaFin()));
		if (getFacFacturas().isEmpty()) {
			ponerMensajeInfo("No existe facturas en las fechas ingresadas");
			setFlagFactura(false);
		} else {
			setFlagFactura(true);

		}

	}

	private void removeTime(Date inicio, Date fin) {
		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(inicio);
		calendarInicio.set(Calendar.HOUR_OF_DAY, 0);
		calendarInicio.set(Calendar.MINUTE, 0);
		calendarInicio.set(Calendar.SECOND, 0);
		setFechaInicio(calendarInicio.getTime());
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(fin);
		calendarFin.set(Calendar.HOUR_OF_DAY, 23);
		calendarFin.set(Calendar.MINUTE, 59);
		calendarFin.set(Calendar.SECOND, 59);
		setFechaFin(calendarFin.getTime());

	}

}

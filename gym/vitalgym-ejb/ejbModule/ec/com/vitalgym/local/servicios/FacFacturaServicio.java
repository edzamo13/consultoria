package ec.com.vitalgym.local.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.FacFacturaLocal;
import ec.com.vitalgym.modelo.FacFactura;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgContactoPersona
 */
@Stateless
@LocalBean
public class FacFacturaServicio extends EJBGenericoDAO<FacFactura, Integer> implements FacFacturaLocal {
	/**
	 * Default constructor.
	 */
	public FacFacturaServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacFactura> obtenerFacturasActivasFechaInicioFin(Date inicio, Date Fin) {
		Query query= em.createNamedQuery(FacFactura.OBTENER_FACTURA_ACTIVA_FECHA_INICIO_FIN, FacFactura.class);
		query.setParameter("inicio", inicio);
		query.setParameter("fin",Fin);
		return query.getResultList();
	}


	

}
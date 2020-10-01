package ec.com.vitalgym.local.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.com.vitalgym.local.FacDetalleFacturaLocal;
import ec.com.vitalgym.modelo.FacDetalleFactura;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgContactoPersona
 */
@Stateless
@LocalBean
public class FacDetalleFacturaServicio extends EJBGenericoDAO<FacDetalleFactura, Integer> implements FacDetalleFacturaLocal {
	/**
	 * Default constructor.
	 */
	public FacDetalleFacturaServicio() {

	}


	

}
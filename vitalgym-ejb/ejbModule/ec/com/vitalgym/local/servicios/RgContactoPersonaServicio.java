package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.RgContactoPersonaLocal;
import ec.com.vitalgym.modelo.RgContactoPersona;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgContactoPersona
 */
@Stateless
@LocalBean
public class RgContactoPersonaServicio extends EJBGenericoDAO<RgContactoPersona, Integer> implements RgContactoPersonaLocal {
	/**
	 * Default constructor.
	 */
	public RgContactoPersonaServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RgContactoPersona> obtenerContactoPersonasPorIdPersona(RgPersona rgPersona) {
		Query query = em.createNamedQuery(RgContactoPersona.OBTENER_CONTACTO_PERSONA_ACTIVO_IDPERSONA, RgContactoPersona.class);
		query.setParameter("rgPersona", rgPersona);
		return query.getResultList();
	}

}
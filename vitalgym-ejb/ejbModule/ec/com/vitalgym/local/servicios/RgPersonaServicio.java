package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.RgPersonaLocal;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgPersonaServicio
 */
@Stateless
@LocalBean
public class RgPersonaServicio extends EJBGenericoDAO<RgPersona, Integer> implements RgPersonaLocal {
	/**
	 * Default constructor.
	 */
	public RgPersonaServicio() {

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<RgPersona> getAll() {
		Query query = em.createNamedQuery(RgPersona.OBTENER_RGPERSONA_TODO,RgPersona.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RgPersona> obtenerTodoActivo() {
		Query query = em.createNamedQuery(RgPersona.OBTENER_RGPERSONA_TODO_ACTIVO,RgPersona.class);
		return query.getResultList();
	}


}
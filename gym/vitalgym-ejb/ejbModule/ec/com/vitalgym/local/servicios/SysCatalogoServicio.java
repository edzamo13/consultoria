package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.SysCatalogoLocal;
import ec.com.vitalgym.modelo.SysCatalogo;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgPersonaServicio
 */
@Stateless
@LocalBean
public class SysCatalogoServicio extends EJBGenericoDAO<SysCatalogo, Integer> implements SysCatalogoLocal {
	/**
	 * Default constructor.
	 */
	public SysCatalogoServicio() {

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<SysCatalogo> getAll() {
		Query query = em.createNamedQuery(SysCatalogo.OBTENER_SYSCATALOGO,SysCatalogo.class);
		return query.getResultList();
	}

}
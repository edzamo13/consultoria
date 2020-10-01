package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.RhGlbUsuarioLocal;
import ec.com.vitalgym.modelo.RhGlbUsuario;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbUsuarioServicio
 */
@Stateless
@LocalBean
public class RhGlbUsuarioServicio extends EJBGenericoDAO<RhGlbUsuario, Integer> implements RhGlbUsuarioLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbUsuarioServicio() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RhGlbUsuario buscarUsuario(String usuario) {
		Query query = em.createNamedQuery(RhGlbUsuario.OBTENER_USUARIOS_POR_USR, RhGlbUsuario.class);
		query.setParameter("usuario", usuario);
		if (query.getResultList().isEmpty()) {
			return new RhGlbUsuario();
		} else {
			return (RhGlbUsuario) query.getResultList().get(0);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbUsuario> buscarUsuarioOrdenadoxId() {
		Query query = em.createQuery("from RhGlbUsuario u ORDER BY u.usuCodigo ");
		return query.getResultList();
	}

}
package ec.com.vitalgym.local.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.RhGlbUsuPefLocal;
import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.modelo.RhGlbUsuPef;
import ec.com.vitalgym.modelo.RhGlbUsuario;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbDemarcacionServicio
 */
@Stateless
@LocalBean
public class RhGlbUsuPefServicio extends EJBGenericoDAO<RhGlbUsuPef, Integer>
		implements RhGlbUsuPefLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbUsuPefServicio() {

	}

	@Override
	public RhGlbPerfil buscarPerfilxUsuario(RhGlbUsuario usuario) {
		Query query = em
				.createQuery("select p.rhGlbPerfile  from RhGlbUsuPef p where p.rhGlbUsuario = ?");
		query.setParameter(1, usuario);
		return (RhGlbPerfil) query.getSingleResult();
	}

	@Override
	public RhGlbUsuPef buscarUsuPef(RhGlbUsuario usuario) {
		RhGlbUsuPef rhGlbUsuPef = new RhGlbUsuPef();
		try {
			Query query = em
					.createQuery("from RhGlbUsuPef p where p.rhGlbUsuario = ?");
			query.setParameter(1, usuario);
			rhGlbUsuPef = (RhGlbUsuPef) query.getSingleResult();
		} catch (Exception e) {
			rhGlbUsuPef = new RhGlbUsuPef();
		}
		return rhGlbUsuPef;
	}

}
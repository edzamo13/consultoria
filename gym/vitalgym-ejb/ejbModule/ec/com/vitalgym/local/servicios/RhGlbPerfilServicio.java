package ec.com.vitalgym.local.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.com.vitalgym.local.RhGlbPerfilLocal;
import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbPerfilServicio
 */
@Stateless
@LocalBean
public class RhGlbPerfilServicio extends EJBGenericoDAO<RhGlbPerfil, Integer> implements RhGlbPerfilLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbPerfilServicio() {

	}

	

}
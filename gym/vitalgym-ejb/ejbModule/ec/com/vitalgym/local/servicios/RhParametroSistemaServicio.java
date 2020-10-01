package ec.com.vitalgym.local.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.com.vitalgym.local.RhParametroSistemaLocal;
import ec.com.vitalgym.modelo.RhParametroSistema;
import ec.com.vitalgym.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhParametroSistemaServicio extends EJBGenericoDAO<RhParametroSistema, Integer> implements RhParametroSistemaLocal {
	/**
	 * Default constructor.
	 */
	public RhParametroSistemaServicio() {

	}

	
}
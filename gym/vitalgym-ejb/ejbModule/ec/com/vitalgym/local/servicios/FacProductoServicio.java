package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.FacProductoLocal;
import ec.com.vitalgym.modelo.FacProducto;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgContactoPersona
 */
@Stateless
@LocalBean
public class FacProductoServicio extends EJBGenericoDAO<FacProducto, Integer> implements FacProductoLocal {
	/**
	 * Default constructor.
	 */
	public FacProductoServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacProducto> obtenerProductosActivos() {
		// TODO Auto-generated method stub
		Query query = em.createNamedQuery(FacProducto.OBTENER_PRODUCTO_ACTIVO, FacProducto.class);
		return query.getResultList();
	}


}
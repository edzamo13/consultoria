package ec.com.vitalgym.local.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.vitalgym.local.FacProveedorLocal;
import ec.com.vitalgym.modelo.FacProveedor;
import ec.com.vitalgym.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RgContactoPersona
 */
@Stateless
@LocalBean
public class FacProveedorServicio extends EJBGenericoDAO<FacProveedor, Integer> implements FacProveedorLocal {
	/**
	 * Default constructor.
	 */
	public FacProveedorServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacProveedor> obtenerProveedoresActivos() {
		// TODO Auto-generated method stub
		Query query= em.createNamedQuery(FacProveedor.OBTENER_PROVEEDOR_ACTIVO,FacProveedor.class);
		return query.getResultList();
	}

}
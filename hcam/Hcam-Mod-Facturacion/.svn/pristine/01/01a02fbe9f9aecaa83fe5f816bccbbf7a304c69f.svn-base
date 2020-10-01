package ec.hcam.data;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDaoImpl<T, I extends Serializable> implements GenericDao<T, I> {

	@PersistenceContext(unitName = "hcam_HCAM-JPA-API_jar_1.0.0PU")
       // @Resource
	protected EntityManager em;
	private final Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	public T obtenerPorCodigo(I codigo) {
		T o = (T) em.find(type, codigo);
		if (o == null) {
			return null;
		}
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		String sql = "select o from " + type.getSimpleName() + " o";
		Query q = em.createQuery(sql);
		return (List<T>) q.getResultList();
	}

	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}

}

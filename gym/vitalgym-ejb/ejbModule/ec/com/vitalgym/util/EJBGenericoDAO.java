package ec.com.vitalgym.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.poi.util.SystemOutLogger;

import ec.com.vitalgym.dto.AuditRead;

public abstract class EJBGenericoDAO<E, ID extends Serializable> implements GenericoDAO<E, ID> {

	@PersistenceContext
	protected EntityManager em;
	private Class<E> entidadTipo;

	@SuppressWarnings("unchecked")
	public EJBGenericoDAO() {
		this.entidadTipo = (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public E buscarId(ID id) {
		return em.find(this.entidadTipo, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		Query query = em.createQuery("from " + this.entidadTipo.getName());
		return query.getResultList();
	}

	@Override
	public E makePersistent(E entidad) {
		AuditRead auditRead = new AuditRead(entidad.getClass().getSimpleName(), entidad.toString());
		System.out.println("auditRead.getId() :" + auditRead.getId() + " ---- auditRead.getNameTable" + auditRead.getNameTable());
	//	System.out.println("em.merge(entidad)"+em.merge(entidad));
		return em.merge(entidad);
	}

	@Override
	public void makeTransient(E entidad) {
		E entityTemp = em.merge(entidad);
		em.remove(entityTemp);
	}

}

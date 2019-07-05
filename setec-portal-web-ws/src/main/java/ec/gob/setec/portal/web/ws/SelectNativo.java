package ec.gob.setec.portal.web.ws;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class SelectNativo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> listarPorSentenciaNativaSql(final Query query, final Class claseRetorno)
			throws Throwable {
		try {
			return (List<T>) retornarDatos(query.getResultList(), claseRetorno);
		} catch (RuntimeException e) {
			throw new Throwable(e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> retornarDatos(List<Object[]> listaSql, Class clase) throws Throwable {
		List listaRetorno = new ArrayList();
		for (Object[] o : listaSql) {
			listaRetorno.add(retornarObjetoReflexion(o, clase));
		}
		return listaRetorno;
	}

	@SuppressWarnings("rawtypes")
	private static Object retornarObjetoReflexion(Object[] o, Class clase) throws Throwable {
		try {

			Object[] oAux = new Object[o.length];
			Class[] clases = new Class[o.length];
			for (int i = 0; i < o.length; i++) {
				clases[i] = String.class;
				String elemento = "";
				if (o[i] != null) {
					elemento = String.valueOf(o[i]);
				}
				oAux[i] = String.valueOf(elemento.trim());
			}
			@SuppressWarnings("unchecked")
			Constructor c = clase.getConstructor(clases);
			return c.newInstance(oAux);
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new Throwable(e);
		}
	}

}

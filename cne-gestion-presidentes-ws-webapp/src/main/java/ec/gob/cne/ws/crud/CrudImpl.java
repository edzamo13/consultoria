/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class CrudImpl<T> implements Crud<T> {

    @Setter
    @Getter
    private EntityManager entityManager;
    @Getter
    @Setter
    private Class<T> entity;

    public CrudImpl() {
    }

    @Override
    public void guardar(T t) throws Exception {
        try {
            getEntityManager().merge(t);
            getEntityManager().flush();
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    public T guardarRetorno(T t) throws Exception {
        try {
            T tipo = getEntityManager().merge(t);
            getEntityManager().flush();
            return tipo;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<T> listarPorConsultaNativa(String consultaSql, Class clase) throws Exception {
        try {
            Query query = getEntityManager().createNativeQuery(consultaSql, clase);
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Object> listarPorConsultaNativa(String consultaSql, Map<String, Object> parametros) throws Exception {
        return listarPorConsultaNativaGenerica(consultaSql, parametros, null);
    }

    private List<Object> listarPorConsultaNativaGenerica(Query query, Map<String, Object> parametros) throws Exception {
        try {
            if (null != parametros && !parametros.isEmpty()) {

                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }

            }
            List<Object> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }

        } catch (RuntimeException e) {
            throw new Exception(e);
        }
    }

    private List<Object> listarPorConsultaNativaGenerica(final String consultaSql, final Map<String, Object> parametros, String resulSet) throws Exception {
        Query query = null;
        try {
            if (null != resulSet) {
                query = getEntityManager().createNativeQuery(consultaSql, resulSet);
            } else {

                query = getEntityManager().createNativeQuery(consultaSql);
            }
            return listarPorConsultaNativaGenerica(query, parametros);
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<T> listarPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros) throws Exception {

        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
            if (null != parametros) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}

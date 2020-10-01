/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.crud;

import ec.gob.iessHcam.componente.comun.dto.servicio.AuditoriaServicio;
import ec.gob.iessHcam.componente.comun.dto.AuditoriaDetalle;
import ec.gob.iessHcam.componente.comun.dto.Auditoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Getter;
import lombok.Setter;
import ec.gob.iessHcam.componente.comun.dto.AuditoriaDto;
import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.FechasUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * <b> Clase que representa el crud y llamada a los métodos de consulta sobre la
 * BD. </b>
 *
 * @author christian
 * <p>
 * [$Author: christian $, $Date: 06/07/2015]
 * </p>
 * @param <T> entidad
 */
public class GenericoDao<T>    implements CrudGenerico<T>{

    //@EJB
    private AuditoriaServicio<T, T, Serializable> auditoriaServicio = new AuditoriaServicio<T,T,Serializable>();
    
    @Setter
    @Getter
    private EntityManager entityManager;
    @Getter
    @Setter
    private Class<T> entity;

    public GenericoDao() {
    }

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: christian, Date: 10/9/2015]
     * </p>
     *
     * @param entity a utilizar
     */
    public GenericoDao(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public void guardar(T t) throws ServicioExcepcion {
        try {
            registrarAuditoria(t);
            
            T tipo = null;
            if(t.hashCode()==0){
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();
                registrarAuditoriaBdd(tipo,t);
                
            }else{
                registrarAuditoriaBdd(t,t);
                getEntityManager().merge(t);
                getEntityManager().flush();
                
            }
            //registrarAuditoria(t);            
            //getEntityManager().merge(t);
            //getEntityManager().flush();
        } catch (RuntimeException | IllegalAccessException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T guardarRetorno(T t) throws ServicioExcepcion {
        try {
            registrarAuditoria(t);
            
               
            T tipo = null;
            if(t.hashCode()==0){
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();
                registrarAuditoriaBdd(tipo,t);                
            }else{
                registrarAuditoriaBdd(t,t);
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();                
            }
            
            return tipo;
        } catch (RuntimeException | IllegalAccessException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public void guardarLote(List<T> lista) throws ServicioExcepcion {
        try {
            for (T en : lista) {
                registrarAuditoria(en);
                getEntityManager().merge(en);
            }
        } catch (RuntimeException | IllegalAccessException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorLlavePrimaria(Object id) throws ServicioExcepcion {
        try {
            return getEntityManager().find(getEntity(), id);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
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
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> listarPorConsultaJpaNombradaObjeto(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
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
        } catch (Exception e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
            return obtenerPorConsultaGenerico(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorJpaConsulta(String consulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createQuery(consulta);
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

        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorJpaConsulta(String consulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createQuery(consulta);
            return obtenerPorConsultaGenerico(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorConsultaNativa(String consultaSql, Class clase) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNativeQuery(consultaSql, clase);
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros) throws ServicioExcepcion {

        return listarPorConsultaNativaGenerica(consultaSql, parametros, null);

    }

    @Override
    public List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros, String nombreSetResultado) throws ServicioExcepcion {

        return listarPorConsultaNativaGenerica(consultaSql, parametros, nombreSetResultado);

    }

    @Override
    public Object obtenerPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros) throws ServicioExcepcion {

        List<Object> resultado = listarPorConsultaNativaGenerica(consultaSql, parametros, null);
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Object llamarProcedimientoOFuncion(String nombreConsulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(nombreConsulta);
            if (null != parametros && !parametros.isEmpty()) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<Object> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> llamarProcedimientoOFuncionLista(String nombreConsulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(nombreConsulta);
            if (null != parametros && !parametros.isEmpty()) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<Object> lista = query.getResultList();
            if (null != lista) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public void remover(T t) throws ServicioExcepcion {
        try {
            getEntityManager().remove(t);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }

    }

    private T obtenerPorConsultaGenerico(Query query, Map<String, Object> parametros) {
        if (null != parametros) {
            for (Map.Entry en : parametros.entrySet()) {
                query.setParameter(en.getKey().toString(), en.getValue());
            }
        }
        List<T> lista = query.getResultList();
        if (null != lista && !lista.isEmpty()) {
            return lista.get(0);
        } else {
            return null;
        }

    }

    private List<Object> listarPorConsultaNativaGenerica(Query query, Map<String, Object> parametros) throws ServicioExcepcion {
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
            throw new ServicioExcepcion(e);
        }
    }

    private List<Object> listarPorConsultaNativaGenerica(final String consultaSql, final Map<String, Object> parametros, String resulSet) throws ServicioExcepcion {
        Query query = null;
        try {
            if (null != resulSet) {
                query = getEntityManager().createNativeQuery(consultaSql, resulSet);
            } else {

                query = getEntityManager().createNativeQuery(consultaSql);
            }
            return listarPorConsultaNativaGenerica(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see ec.gob.iess.componente.comun.crud.CrudGenerico#ejecutarActualizacion(java.lang.String, java.util.Map)
     */
    @Override
    public boolean ejecutarActualizacion(String consultaNativa, Map<String, Object> parametros) throws ServicioExcepcion {

        try {
            Query query = getEntityManager().createNativeQuery(consultaNativa);
            if (null != parametros && !parametros.isEmpty()) {

                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }

            }
            int filasActualizadas = query.executeUpdate();
            if (filasActualizadas > 0) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }

        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    /**
     * <b> Metodo para asignar las variables de auditoria para una entidad. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param auditoria pojo
     */
    private void asignarVariablesAuditoria(AuditoriaDto auditoria) {
        Query queryIdUsuario = getEntityManager().createNativeQuery("{call gen_variablesesion_pkg.set_idusuario_prc(?)}");
        queryIdUsuario.setParameter("ai_usuarioid", auditoria.getNumeroDocumento());
        queryIdUsuario.executeUpdate();

        Query queryIpMaquina = getEntityManager().createNativeQuery("{call gen_variablesesion_pkg.set_ipmaquina_prc(?)}");
        queryIpMaquina.setParameter("ipMaquina", auditoria.getIpMaquinaAuditoria());
        queryIpMaquina.executeUpdate();

        Query queryObservacion = getEntityManager().createNativeQuery("{call gen_variablesesion_pkg.set_observaciones_prc(?)}");
        queryObservacion.setParameter("observacion", auditoria.getObservacion());
        queryObservacion.executeUpdate();
    }

    /**
     * <b> Metodo para registrar la auditoria. </b>
     * <p>
     * [Author: jpatino, Date: 21/8/2015]
     * </p>
     *
     * @param entity a registrar
     * @throws ServicioExcepcion en caso de haber alguna
     * @throws IllegalAccessException en caso de objetos ilegales
     */
    private void registrarAuditoria(T entity) throws ServicioExcepcion, IllegalAccessException {
        try {
            if (entity instanceof AuditoriaDto) {
                AuditoriaDto auditoriaDto = (AuditoriaDto) entity;
                asignarVariablesAuditoria(auditoriaDto);
            }
        } catch (Exception ex) {
            Logger.getLogger(GenericoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void registrarAuditoriaBdd(T t, T ta) throws ServicioExcepcion, IllegalAccessException {
        try {
            
            Auditoria a = new Auditoria();
            if (ta.hashCode()==0){
                a = this.auditoriaServicio.nuevoObjeto(t, String.valueOf(t.hashCode()));
            }else{
                T origen = null;
                String tipo="";
                //aqui debe ir una validacion en la cual se indique si el id de la clase generica es long, integer, string, etc etc etc
                
                Field fields[] = t.getClass().getDeclaredFields();
                for (Field f: fields){
                    Annotation an[] = f.getDeclaredAnnotations();
                    for (Annotation aa : an){
                        if (aa.toString().equals("@javax.persistence.Id()")){
                            tipo=f.getType().getName();
                            break;
                        }
                    }
                }
                
                if (tipo.equals("java.lang.Long")){
                    origen = this.obtenerPorLlavePrimaria((long)t.hashCode());
                }else if (tipo.equals("java.lang.Integer")){
                    origen = this.obtenerPorLlavePrimaria(t.hashCode());
                }else if (tipo.equals("java.lang.String")){
                    origen = this.obtenerPorLlavePrimaria(String.valueOf(t.hashCode()));
                }else if(tipo.equals("java.lang.Short")){
                    origen = this.obtenerPorLlavePrimaria((short)t.hashCode());
                }
                
                a = this.auditoriaServicio.actualizarObjeto(origen, t, String.valueOf(t.hashCode()));
            }
            
            
            String fecha = FechasUtil.transformarFechaACadena(a.getAudFecha());
            Query query = getEntityManager().createNativeQuery("INSERT INTO seguridad.seg_auditoria_tbl(aud_esquema, aud_tabla, aud_fecha, aud_usuario, aud_codunme, aud_id_entidad, aud_tipo_transaccion) " +
                                                " VALUES ('"+a.getAudEsquema()+"', '"+ a.getAudTabla() +"', '"+ fecha +"', '"+ a.getAudUsuario() +"','"+ a.getAudCodunme() +"' ,'"+ a.getAudIdEntidad() +"', '"+ a.getAudTipoTransaccion() +"');");            
            query.executeUpdate();            
            getEntityManager().flush();
            
            
            
            Query consulta = getEntityManager().createNativeQuery("SELECT aud_id_auditoria FROM seguridad.seg_auditoria_tbl "
                    + " WHERE aud_esquema = '"+a.getAudEsquema()+"' and aud_tabla = '"+ a.getAudTabla()+"' and aud_fecha = '"+ fecha +"' and aud_usuario = '"+ a.getAudUsuario() +"' and aud_codunme = '"+ a.getAudCodunme() +"' and aud_id_entidad = '"+ a.getAudIdEntidad() +"' and aud_tipo_transaccion = '"+ a.getAudTipoTransaccion() +"';"); 
            
            Long id = (Long)consulta.getSingleResult();
            
            
            for (AuditoriaDetalle d : a.getLista()){
                Query queryDetalle = getEntityManager().createNativeQuery("INSERT INTO seguridad.seg_auditoria_detalle_tbl(adt_campo_afectado, adt_valor_anterior,adt_valor_actual, aud_id_auditoria) " +
                                                " VALUES ('"+d.getAdtCampoAfectado()+"', '"+ d.getAdtValorAnterior() +"', '"+ d.getAdtValorActual() +"',"+ id +");");            
                queryDetalle.executeUpdate();            
                getEntityManager().flush();
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(GenericoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

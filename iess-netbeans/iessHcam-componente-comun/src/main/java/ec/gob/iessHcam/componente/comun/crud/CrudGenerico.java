/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.crud;

import java.util.List;
import java.util.Map;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;

/**
 * <b> Interfaz que representa todos los métodos de crud sobre la base de datos. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 06/07/2015]
 *         </p>
 * @param <T>
 *            entidad
 */
public interface CrudGenerico<T> {

    /**
     * <b> Método que guarda, actualiza registros en la base de datos. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param t
     *            objeto a persistir o actualizar
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    void guardar(final T t) throws ServicioExcepcion;

    /**
     * <b> Método que guarda, actualiza registros en la base de datos y devuelve el objeto persistido en la misma BD.
     * </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param t
     *            objeto a persistir o actualizar
     * @return objeto persistido
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    T guardarRetorno(final T t) throws ServicioExcepcion;

    /**
     * <b> Método que guarda por lotes recibiendo una lista de datos. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param lista
     *            lista de objetos a persistir o actualizar
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    void guardarLote(final List<T> lista) throws ServicioExcepcion;

    /**
     * <b> Método que trae un solo registro por llave primaria. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param id
     *            id del objeto de base
     * @return objeto consultado
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    T obtenerPorLlavePrimaria(final Object id) throws ServicioExcepcion;

    /**
     * <b> Método que trae una lista de registros por NamedQuerys que deben estar declarados en las clases entity. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param consultaNombrada
     *            nombre de la consulta nombrada
     * @param parametros
     *            de la consulta
     * @return lista de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    List<T> listarPorConsultaJpaNombrada(final String consultaNombrada, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Método que trae un solo registro por consulta NamedQuery que deben estar declarados en las clases entity.
     * </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param consultaNombrada
     *            de la entidad
     * @param parametros
     *            a consultar
     * @return entidad
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    T obtenerPorConsultaJpaNombrada(final String consultaNombrada, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Método que trae una lista de registros por consulta jpaQL. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param consulta
     *            cadena a consultar
     * @param parametros
     *            de la consulta
     * @return lista de objetos
     * @throws ServicioExcepcion
     *             excepcion generada en caso de haber algun error
     */
    List<T> listarPorJpaConsulta(final String consulta, final Map<String, Object> parametros) throws ServicioExcepcion;

    /**
     * <b> Método que trae un solo registro por consulta jpaQL. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param consulta
     *            query a consultar
     * @param parametros
     *            de la consulta
     * @return objeto consultado
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    T obtenerPorJpaConsulta(final String consulta, final Map<String, Object> parametros) throws ServicioExcepcion;

    /**
     * <b> Método que trae una lista de registros por una consulta nativa y retorna objetos de tipo clase. </b>
     * <p>
     * [$Author: christian $, $Date: 06/07/2015]
     * </p>
     *
     * @param consultaSql
     *            cadena de consulta
     * @param clase
     *            pojo a utilizar para la conversion de resultados
     * @return lista de objetos del tipo clase
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    List<T> listarPorConsultaNativa(final String consultaSql, final Class clase) throws ServicioExcepcion;

    /**
     * <b> Método que trae una lista de registros por una consulta nativa y mapa de parametros </b>
     * <p>
     * Ejemplo: Select * from tabla where tabla.campo1 = ?1 and tabla.campo2 = ?2 and tabla.campo3 = ?1
     * </p>
     * <p>
     * Los parametros se deberan ingresar con el signo de interrogacion acompañado del orden (?orden) y en el mapa de
     * parametros se debera ingresar como llave solo el numero de orden: parametrs.put(orden,valor)
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Iterator iterador = listarPorConsultaNativa(consulta, parametros).iterator();
     * </p>
     * <p>
     * String resultado = null;
     * </p>
     * <p>
     * while (iterador.hasNext()) {
     * </p>
     * <p>
     * Object[] result = (Object[]) iterador.next();
     * </p>
     * <p>
     * resultado = (String) result[0];
     * </p>
     * <p>
     * respuesta.add(resultado);
     * </p>
     * 
     * 
     *
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     *
     * @param consultaSql
     *            cadena de consulta
     * @param parametros
     *            de la consulta
     * @return lista de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Método que trae una lista de registros por una consulta nativa y mapa de parametros </b>
     * <p>
     * Ejemplo: Select * from tabla where tabla.campo1 = ?1 and tabla.campo2 = ?2 and tabla.campo3 = ?1
     * </p>
     * <p>
     * Los parametros se deberan ingresar con el signo de interrogacion acompañado del orden (?orden) y en el mapa de
     * parametros se debera ingresar como llave solo el numero de orden:
     * </p>
     * <p>
     * parametrs.put("1",valor)
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Iterator iterador = listarPorConsultaNativa(consulta, parametros).iterator();
     * </p>
     * <p>
     * String resultado = null;
     * </p>
     * <p>
     * while (iterador.hasNext()) {
     * </p>
     * <p>
     * Object[] result = (Object[]) iterador.next();
     * </p>
     * <p>
     * resultado = (String) result[0];
     * </p>
     * <p>
     * respuesta.add(resultado);
     * </p>
     * 
     * <p>
     * [$Author: fochoac $, $Date: 22/07/2015]
     * </p>
     * 
     * @param consultaSql
     *            cadena de consulta
     * @param parametros
     *            de la consulta
     * @return objeto consultado
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    Object obtenerPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Método que trae un objeto de registros por una procedimiento almacenado </b>
     * 
     * <p>
     * [$Author: jpatino $, $Date: 22/07/2015]
     * </p>
     *
     * @param nombreConsulta
     *            cadena con el nombre de funcion o procedimiento
     * @param parametros
     *            de la consulta
     * @return valor o arreglo de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    Object llamarProcedimientoOFuncion(final String nombreConsulta, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Método que trae un objeto de registros por una procedimiento almacenado </b>
     * 
     * <p>
     * [$Author: jpatino $, $Date: 22/07/2015]
     * </p>
     *
     * @param nombreConsulta
     *            cadena con el nombre de funcion o procedimiento
     * @param parametros
     *            de la consulta
     * @return valor o arreglo de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    Object llamarProcedimientoOFuncionLista(final String nombreConsulta, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    /**
     * <b> Metodo para eliminar un registro de la tabla. </b>
     * <p>
     * [Author: fochoac, Date: 22/7/2015]
     * </p>
     *
     * @param t
     *            entidad objeto a remover
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    void remover(final T t) throws ServicioExcepcion;

    /**
     * <b> Metodo para ejecutar una consulta nativa y obtener el resultado en un resultset definido a la entidad </b>
     * <p>
     * Ejemplo: Select * from tabla where tabla.campo1 = ?1 and tabla.campo2 = ?2 and tabla.campo3 = ?1
     * </p>
     * <p>
     * Los parametros se deberan ingresar con el signo de interrogacion acompañado del orden (?orden) y en el mapa de
     * parametros se debera ingresar como llave solo el numero de orden:
     * </p>
     * <p>
     * parametrs.put("1",valor)
     * </p>
     * 
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Iterator iterador = listarPorConsultaNativa(consulta, parametros).iterator();
     * </p>
     * <p>
     * String resultado = null;
     * </p>
     * <p>
     * while (iterador.hasNext()) {
     * </p>
     * <p>
     * Object[] result = (Object[]) iterador.next();
     * </p>
     * <p>
     * resultado = (String) result[0];
     * </p>
     * <p>
     * respuesta.add(resultado);
     * </p>
     * 
     * <p>
     * [Author: fochoac, Date: 23/7/2015]
     * </p>
     *
     * @param consultaSql
     *            query de consulta
     * @param parametros
     *            de la consulta
     * @param nombreSetResultado
     *            funcion resultado
     * @return lista de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros,
            final String nombreSetResultado) throws ServicioExcepcion;

    /**
     * <b> Metodo para retornar una lista personalizada a partir de un named query </b>
     * <p>
     * Ejemplo: Select * from tabla where tabla.campo1 = ?1 and tabla.campo2 = ?2 and tabla.campo3 = ?1
     * </p>
     * <p>
     * Los parametros se deberan ingresar con el signo de interrogacion acompañado del orden (?orden) y en el mapa de
     * parametros se debera ingresar como llave solo el numero de orden:
     * </p>
     * <p>
     * parametrs.put("1",valor)
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Para recuperar los objetos resultados de la consulta se procedera de la siguiente manera:
     * </p>
     * <p>
     * Iterator iterador = listarPorConsultaNativa(consulta, parametros).iterator();
     * </p>
     * <p>
     * String resultado = null;
     * </p>
     * <p>
     * while (iterador.hasNext()) {
     * </p>
     * <p>
     * Object[] result = (Object[]) iterador.next();
     * </p>
     * <p>
     * resultado = (String) result[0];
     * </p>
     * <p>
     * respuesta.add(resultado);
     * </p>
     * 
     * <p>
     * [Author: fochoac, Date: 24/7/2015]
     * </p>
     *
     * @param consultaNombrada
     *            a realizar la busqueda
     * @param parametros
     *            de consulta
     * @return lista de objetos
     * @throws ServicioExcepcion
     *             en caso de haber algun error
     */
    public List<Object> listarPorConsultaJpaNombradaObjeto(final String consultaNombrada,
            final Map<String, Object> parametros) throws ServicioExcepcion;

    /**
     * <b> Metodo para realizar un executeupdate a tablas mediante una consulta nativa </b>
     * <p>
     * [Author: fochoac, Date: 20/8/2015]
     * </p>
     *
     * @param consultaNativa
     *            query a enviar
     * @param parametros
     *            a actualziar
     * @return true si se actualizo correctamente
     * @throws ServicioExcepcion
     *             en caso de haber alguna
     */
    public boolean ejecutarActualizacion(final String consultaNativa, final Map<String, Object> parametros)
            throws ServicioExcepcion;
}

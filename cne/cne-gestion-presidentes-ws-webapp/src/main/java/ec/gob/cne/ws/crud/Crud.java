/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.crud;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ezamora
 */
public interface Crud<T> {

    void guardar(final T t) throws Exception;

    T guardarRetorno(final T t) throws Exception;

    List<T> listarPorConsultaNativa(final String consultaSql, final Class clase) throws Exception;

    List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros)
            throws Exception;

 public List<T> listarPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros)throws Exception ;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.executor;

import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author pestupinan
 */
@Remote
public interface IQueryExecutor {

    /**
     * Ejecuta una sentencia SQL
     * <pre>
     * {@code List<Centers> list = queryExecutor.executeQuery("SELECT * FROM CENTERS where id_cet=:id_cet", params, Centers.class);}
     * </pre>
     *
     * @param query Sentencia SQL a ser ejecutada
     * @param params Mapa clave - valor, en el cual se definen los parámetros
     * con los que se ejecutara la sentencia SQL
     * @param returnType Clase a la cual se va a mapear el resulset devuelto por
     * la sentencia SQL
     * @return List Lista de Objetos de tipo returnType
     *
     */
    public List executeQuery(String query, Map<String, Object> params, Class returnType);
    public void executeQueryInsert(String query, Map<String, Object> params);
}

/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.utilitario.base.datos;

import java.util.List;

import javax.persistence.Query;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 15/07/2015]
 *         </p>
 */
public class EjecutaSelectNativos {
    
    private EjecutaSelectNativos() {
        super();
    }

    /**
     * <b>
     * Metodo para lsitar por sentencia sql nativa a un pojo por reflexion.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     * @param query a consultar
     * @param claseRetorno pojo de retorno
     * @return pojo
     * @throws ServicioExcepcion en caso de error
     */ 
    public static <T> List<T> listarPorSentenciaSql(final Query query, final Class claseRetorno)
            throws ServicioExcepcion {
        try {
            return (List<T>) RetornoListaSql.retornar(query.getResultList(), claseRetorno);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

}

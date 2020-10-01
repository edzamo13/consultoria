/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.utilitario.base.datos;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 14/07/2015]
 *         </p>
 */
public class RetornoListaSql {
   
    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     */ 
    private RetornoListaSql() {
        super();
    }

    /**
     * <b>
     * Incluir aqui­ la descripcion del metodo.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     * @param listaSql a validar
     * @param clase pojo
     * @return lista de pojos
     * @throws ServicioExcepcion en caso de error
     */ 
    public static <T> List<T> retornar(List<Object[]> listaSql, Class clase) throws ServicioExcepcion {
        List listaRetorno = new ArrayList();
        for (Object[] o : listaSql) {
            listaRetorno.add(retornarInstancia(o, clase));
        }
        return listaRetorno;
    }

    /**
     * <b>
     * Incluir aqui­ la descripcion del metodo.
     * </b>
     * <p>[Author: fochoac, Date: 1/9/2015]</p>
     *
     * @param o a valdiar
     * @param clase pojo
     * @return pojo
     * @throws ServicioExcepcion en caso de error
     */ 
    private static Object retornarInstancia(Object[] o, Class clase) throws ServicioExcepcion {
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
            Constructor c = clase.getConstructor(clases);
            return c.newInstance(oAux);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new ServicioExcepcion(e);
        }
    }
}

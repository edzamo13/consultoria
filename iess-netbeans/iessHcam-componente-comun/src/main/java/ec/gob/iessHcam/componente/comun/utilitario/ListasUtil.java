/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ec.gob.iessHcam.componente.comun.logs.Log;

/**
 * <b> Clase utilitaria para trabajar con Colecciones </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 31/7/2015 $]
 *          </p>
 */
public class ListasUtil {
    /**
     * 
     */
    private ListasUtil() {
        super();
    }

    /**
     * <b> Metodo para convertir una lista a una cadena de texto. </b>
     * <p>
     * <b>Nota:</b> La coleccion deberia estar conformada de objetos simples como por ejemplo: Integer, String, Character, etc
     * </p>
     * <p>
     * [Author: fochoac, Date: 31/7/2015]
     * </p>
     *
     * @param lista
     *            a convertir
     * @return vacio si no tiene que una lista a convertir
     */
    public static final String convertirListaACadena(Collection lista) {
        String cadena = "";
        for (Object obj : lista) {
            cadena += obj;
        }
        return cadena;
    }

    /**
     * <b> Metodo para randomizar tipos de datos básicos como Integer, String, etc </b>
     * <p>
     * [Author: fochoac, Date: 31/7/2015]
     * </p>
     *
     * @param lista
     *            a randomizar
     * @return coleccion randomizada
     */
    public static final Collection randomizarColeccion(Collection lista) {
        Collections.shuffle((List) lista);
        return lista;
    }

    /**
     * <b> Metodo para convertir una cadena a una lista de caracteres</b>
     * <p>
     * [Author: fochoac, Date: 31/7/2015]
     * </p>
     *
     * @param cadena
     *            a convertir a lista de caracteres
     * @return coleccion de caracteres
     */
    public static final Collection convertirCadenaLista(String cadena) {
        Collection<String> lista = null;
        if (!cadena.isEmpty()) {
            lista = new ArrayList<String>();
            for (Character a : cadena.toCharArray()) {
                lista.add(a.toString());
            }
        }
        return lista;
    }

    /**
     * <b> Metodo utilitario para ordenar listas en base a alguna propiedad. </b>
     * <p>
     * [Author: csantillan, Date: 10/11/2015]
     * </p>
     *
     * @param lista
     *            {@link List} de objetos a ordenar
     * @param propiedad
     *            del objeto de la lista a comparar para ordenar
     * @param ascendente
     *            true para ordenar de manera ascendente, false lo contrario
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final void ordenarLista(List lista, final String propiedad, final boolean ascendente) {
        Collections.sort(lista, new Comparator() {

            public int compare(Object obj1, Object obj2) {

                Class clase = obj1.getClass();
                String getter = "get" + Character.toUpperCase(propiedad.charAt(0)) + propiedad.substring(1);
                try {

                    Method getPropiedad = clase.getMethod(getter);

                    Object propiedad1 = getPropiedad.invoke(obj1);
                    Object propiedad2 = getPropiedad.invoke(obj2);

                    if (propiedad1 instanceof Comparable && propiedad2 instanceof Comparable) {
                        Comparable prop1 = (Comparable) propiedad1;
                        Comparable prop2 = (Comparable) propiedad2;
                        return prop1.compareTo(prop2);
                    }// CASO DE QUE NO SEA COMPARABLE
                    else {
                        if (propiedad1.equals(propiedad2)) {
                            return 0;
                        } else {
                            return 1;
                        }

                    }

                } catch (Exception e) {
                    Log.error(getClass().getName(), "no se ordena", e);
                }
                return 0;
            }
        });
        if (!ascendente) {
            Collections.reverse(lista);
        }
    }

}

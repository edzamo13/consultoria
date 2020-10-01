/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario.enumeraciones;

import java.lang.reflect.Field;

import ec.gob.iessHcam.componente.comun.logs.Log;



/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 11/8/2015 $]
 *          </p>
 */
public class GenericoEnum<E> {

    /**
     * <b> Metodo utilitario para obtener una enumeracion a partir de una propiedad privada de una enumeracion. </b>
     * <p>
     * Ejemplo de uso:
     * </p>
     * <p>
     * EstadoEnum e= obtenerEnumeracionPorCampo(EstadoEnum.class, "estado", "A")
     * </p>
     * <p>
     * [Author: fochoac, Date: 11/8/2015]
     * </p>
     *
     * @param enumeracion
     *            Clase de tipo enum
     * @param campoPrivado
     *            a obtener para la validacion
     * @param valorAValidar
     *            de la enumeracion a comparar
     * @return null si no encuentra una enumeracion valida.
     */
    public static <E extends Enum<?>> E obtenerEnumeracionPorCampo(Class<E> enumeracion, String campoPrivado,
            String valorAValidar) {
        E e = null;
        for (E o : enumeracion.getEnumConstants()) {
            Field field;
            try {
                field = o.getClass().getDeclaredField(campoPrivado);
                field.setAccessible(true);
                if (valorAValidar.equals(field.get(o).toString())) {
                    e = o;
                    break;

                }
            } catch (NoSuchFieldException | SecurityException e1) {
                Log.error(GenericoEnum.class.getName(), "No existe la etiqueta", e1);
            } catch (IllegalArgumentException e1) {
                Log.error(GenericoEnum.class.getName(), "Argumentos ilegales al acceder a la propiedad", e1);
            } catch (IllegalAccessException e1) {
                Log.error(GenericoEnum.class.getName(), "No se tiene acceso a la propiedad", e1);
            }

        }
        return e;
    }

}

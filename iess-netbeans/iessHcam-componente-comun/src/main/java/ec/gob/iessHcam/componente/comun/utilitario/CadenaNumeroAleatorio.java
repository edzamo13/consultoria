/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.util.Random;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 14/09/2016]</p>
 */
public class CadenaNumeroAleatorio {

    /**
     *
     * <b>
     * cadenaAlfanumAleatoria con tamaño.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 14/09/2016]</p>
     * @param longitud longitud
     * @return cadena
     */
    public static String cadenaAlfanumAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    /**
     *
     * <b>
     * cadenaAlfanumAleatoria con 8 valor ingresado.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 14/09/2016]</p>
     * @return cadena
     */
    public static String cadenaAlfanumAleatoria() {
        int longitud = 8;
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

}

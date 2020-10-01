/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum;
import static ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum.ALFA;
import static ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum.ALFA_NUMERICO;
import static ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum.CARACTERES_EXPECIALES;
import static ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum.NUMERICO;

/**
 * <b> Clase utilitaria para generar secuencias randomicas de caracteres </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 19/8/2015 $]
 *          </p>
 */
public class RandomicoUtil {

    /**
     * <b> Metodo utilitario para generar una secuencia randomica. </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param longitud
     *            de la secuencia
     * @param modoGeneracion
     *            {@link ModoGeneracionEnum}
     * @return secuencia randomica
     */
    public static final String generarRandomico(final int longitud, ModoGeneracionEnum modoGeneracion) {

        StringBuffer buffer = new StringBuffer();
        String caracteres = "";

        switch (modoGeneracion) {

        case ALFA:
            caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            break;

        case ALFA_NUMERICO:
            caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_.@&$/%";
            break;

        case NUMERICO:
            caracteres = "1234567890";
            break;
        case CARACTERES_EXPECIALES:
            caracteres = "_.@&$/%";
            break;
        }

        int longitudCaracteres = caracteres.length();

        for (int i = 0; i < longitud; i++) {
            double index = Math.random() * longitudCaracteres;
            buffer.append(caracteres.charAt((int) index));
        }
        return buffer.toString();
    }

    /**
     * <b> Metodo utilitario para generar un teclado numerico randomico. </b>
     * <p>
     * [Author: fochoac, Date: 23/10/2015]
     * </p>
     *
     * @return cadena de texto lista para el componente p:keyboard
     */
    public static final String generarTecladoRandomico() {
        return ListasUtil.convertirListaACadena(ListasUtil.randomizarColeccion(ListasUtil.convertirCadenaLista(ComunEnum.ALFABETO_NUMERICO.getDescripcion()))) + "-clear";

    }
}

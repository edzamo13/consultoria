/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import ec.gob.iessHcam.componente.comun.logs.Log;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 21/8/2015 $]
 *          </p>
 */
public class ValidacionServicioHttpUtil {

    /**
     * <b> Metodo utilitario para validar si esta arriba un servicio </b>
     * <p>
     * [Author: fochoac, Date: 21/8/2015]
     * </p>
     *
     * @param url
     *            a comprobar
     * @param timeout
     *            en milisegundos (3 segundos es minimo)
     * @return true si el servicio esta arriba
     */
    public static final boolean ping(String url, int timeout) {
        url = url.replaceFirst("https", "http");

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            Log.error(ValidacionServicioHttpUtil.class.getName(), "Error en el servicio", exception);
            return false;
        }
    }

    /**
     * <b> Metodo utilitario para validar servicios json. </b>
     * <p>
     * [Author: fochoac, Date: 14/12/2015]
     * </p>
     *
     * @param url
     *            del servicio
     * @param timeout
     *            en milisegundos
     * @return true si esta disponible
     */
    public static final boolean pingJson(String url, int timeout) {
        url = url.replaceFirst("https", "http");

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return 405 == responseCode;
        } catch (IOException exception) {

            return false;
        }

    }

}

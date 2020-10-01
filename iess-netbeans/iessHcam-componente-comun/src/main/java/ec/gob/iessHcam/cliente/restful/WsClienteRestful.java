/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.cliente.restful;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;




/**
 *
 * @author christian
 */
public class WsClienteRestful {

    private static final String METODO = "POST";
    private static final String TIPO_CONTENIDO = "Content-Type";
    private static final String CONTENIDO = "application/json";
    private static final String ERROR = "error";

    public String invocaWsCrud(final String urlServicio, final Object pojo) {
        String retorno = "";
        try {
            Gson gson = new Gson();
            URL url = new URL(urlServicio);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod(METODO);
            conn.setRequestProperty(TIPO_CONTENIDO, CONTENIDO);
            OutputStream os = conn.getOutputStream();
            os.write(gson.toJson(pojo).getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                retorno = output;
            }
            conn.disconnect();
        } catch (IOException e) {
            Utilitario.error(getClass().getName(), ERROR, e);
            retorno = null;
        }
        return retorno;
    }

    public <T> T invocaWs(final String urlServicio, final Object pojo, final Class clase) {
        String retorno = "";
        int tamanio = 1315050;
        try {
            Gson gson = new Gson();
            int llegada = gson.toJson(pojo).getBytes().length;

            if (llegada <= tamanio) {

                URL url = new URL(urlServicio);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setConnectTimeout(5000);
                conn.setRequestMethod(METODO);
                conn.setRequestProperty(TIPO_CONTENIDO, CONTENIDO);
                if (pojo != null) {
                    OutputStream os = conn.getOutputStream();

                    os.write(gson.toJson(pojo).getBytes());
                    os.flush();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream()), "UTF-8"));
                String output;
                while ((output = br.readLine()) != null) {
                    retorno = output;
                }
                conn.disconnect();

                return (T) gson.fromJson(retorno, clase);
            } else {
                return null;
            }
        } catch (IOException e) {
            Utilitario.error(getClass().getName(), ERROR, e);
            return null;
        }
    }
}

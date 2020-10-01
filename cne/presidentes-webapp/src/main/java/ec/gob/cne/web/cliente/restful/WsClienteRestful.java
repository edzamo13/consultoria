/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.cne.web.cliente.restful;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 *
 * @author ezamora
 */
public class WsClienteRestful {

    private static final String TIPO_CONTENIDO = "Content-Type";
    private static final String CONTENIDO = "application/json";
    private static final String ERROR = "error";
    private static final String OS_NAME = "os.name";
    private static final String UTF_8 = "UTF-8";
    private static final String WIN = "WIN";
    private static final String FAILED = "Failed : HTTP error code : ";

    private static final int TIMEOUT = 360000;

    public <T> T invocaWs(final String urlServicio, final Object pojo, final Class clase) {
        return (T) devolverT(obtenerRetorno(urlServicio, pojo, null, false), clase);
    }

    private <T> T devolverT(final String retorno, final Class clase) {
        Gson gson = new Gson();
        if (retorno != null) {
            return (T) gson.fromJson(retorno, clase);
         
        }
        return null;
    }

    private String obtenerRetorno(final String urlServicio, final Object pojo, RequestConfig requestConfig, boolean gzip) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(TIMEOUT)
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig == null
                ? defaultRequestConfig : requestConfig).build()) {
            Gson gson = new Gson();
            HttpPost request = new HttpPost(urlServicio);
            StringEntity params;
            if (System.getProperty(OS_NAME).toUpperCase().contains(WIN)) {
                params = new StringEntity(gson.toJson(pojo), UTF_8);
            } else {
                params = new StringEntity(gson.toJson(pojo), StandardCharsets.UTF_8);
            }
            //request.addHeader(TIPO_CONTENIDO, CONTENIDO);
            params.setContentType(CONTENIDO);
            request.addHeader(params.getContentType().getName(), params.getContentType().getValue());
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            if (result.getStatusLine().getStatusCode() != 200) {
                throw new IOException(FAILED
                        + result.getStatusLine().getStatusCode());
            }

            if (gzip) {
                return EntityUtils.toString(new GzipDecompressingEntity(result.getEntity()), StandardCharsets.UTF_8);
            } else {
                return EntityUtils.toString(result.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (IOException ex) {
            Logger.getLogger(WsClienteRestful.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
   /* private String obtenerRetorno(final String urlServicio, final Object pojo, RequestConfig requestConfig, boolean gzip) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(TIMEOUT)
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig == null
                ? defaultRequestConfig : requestConfig).build()) {
            Gson gson = new Gson();
            HttpPost request = new HttpPost(urlServicio);
            StringEntity params;
            if (System.getProperty(OS_NAME).toUpperCase().contains(WIN)) {
                params = new StringEntity(gson.toJson(pojo), UTF_8);
            } else {
                params = new StringEntity(gson.toJson(pojo), StandardCharsets.UTF_8);
            }
            request.addHeader(TIPO_CONTENIDO, CONTENIDO);
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            if (result.getStatusLine().getStatusCode() != 200) {
                throw new IOException(FAILED
                        + result.getStatusLine().getStatusCode());
            }

            if (gzip) {
                return EntityUtils.toString(new GzipDecompressingEntity(result.getEntity()), StandardCharsets.UTF_8);
            } else {
                return EntityUtils.toString(result.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (IOException ex) {
            Logger.getLogger(WsClienteRestful.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }*/

}

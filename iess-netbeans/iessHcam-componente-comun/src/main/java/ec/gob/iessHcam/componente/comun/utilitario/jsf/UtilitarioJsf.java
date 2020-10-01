/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.utilitario.jsf;

import ec.gob.iessHcam.componente.comun.encriptaciones.EncriptacionBase64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import javax.servlet.ServletOutputStream;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author christian
 * <p>
 * [$Author: christian $, $Date: 08/07/2015]
 * </p>
 */
public class UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 4837181833528660429L;

    public static final SelectItem SELECCIONE = new SelectItem(null, ComunEnum.SELECCIONE.getDescripcion());

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     */
    public UtilitarioJsf() {
        super();
    }

    /**
     * <b> Metodo para poner un mensaje de informacion. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param mensaje de informacion
     */
    protected void ponerMensajeInfo(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
    }

    /**
     * <b> Metodo para redireccionar. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param url a redirigir
     */
    protected void redirect(String url) {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + url);
        } catch (IOException e) {
            Log.error(getClass().getName(), ComunEnum.ERROR_REDIRECCION.getDescripcion(), e);
        }
    }

    /**
     * <b> Metodo para redireccionar encriptar la URL para Modulos App </b>
     * <p>
     * [Author: ezamora, Date: 05/06/2017]
     * </p>
     *
     * @param url a redirigir
     */
    protected void redirectCodificado(String url) {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + "/app/" + EncriptacionBase64.cifrarCadena(url));
        } catch (IOException e) {
            Log.error(getClass().getName(), ComunEnum.ERROR_REDIRECCION.getDescripcion(), e);
        }

    }

    /**
     * <b> Metodo utilitario para validar la clave de usuario en base a un
     * patron. </b>
     * <p>
     * [Author: fochoac, Date: 28/7/2015]
     * </p>
     *
     * @param clave cadena de texto
     * @param patron patron de validacion
     * @return
     */
    protected static boolean validarClavePorPatron(String clave, String patron) {
        boolean valido = false;
        Pattern patronClave = Pattern.compile(patron);
        Matcher mClave = patronClave.matcher(clave);
        if (mClave.matches()) {
            valido = true;
        }
        return valido;
    }

    /**
     * <b> Metodo para cerrar la sesion. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     */
    protected void cerrarSesion() {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + "/index.xhtml");
            HttpSession session = getSession();
            session.invalidate();
        } catch (Exception e) {
            Log.error(getClass().getName(), ComunEnum.ERROR_CERRAR_SESION.getDescripcion(), e);
        }
    }

    /**
     * <b> Metodo para optener la session. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @return
     */
    protected static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    /**
     * <b> Metodo para poner mensaje de informacion en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param listaMensaje a poner en el jsf
     */
    protected void ponerMensajeInfo(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
        }
    }

    /**
     * <b> Metodo para poner un mensaje de alerta en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param mensaje
     */
    protected void ponerMensajeAlerta(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
    }

    /**
     * <b> Metodo para poner un mensaje de alerta en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param listaMensaje del jsf
     */
    protected void ponerMensajeAlerta(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
        }
    }

    /**
     * <b> Metodo para poner los mensajes de error en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param mensaje a poner
     */
    protected void ponerMensajeError(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));
    }

    /**
     * <b> Metodo para poner un mensaje de error con excepcion en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param mensaje
     * @param excepcion
     */
    protected void ponerMensajeErrorExcepcion(final String mensaje, final String excepcion) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, excepcion));
    }

    /**
     * <b> Metodo para ṕoner un mensaje de error por lista en el jsf. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param listaMensaje a poner en jsf
     */
    protected void ponerMensajeError(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));
        }
    }

    /**
     *  * <b>
     *  *   Agregar mensaje de error para un componente especifico de la pagina
     * web.  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     */
    protected void ponerMensajeErrorComponente(final String componente, final String mensaje) {
        getContext().addMessage(componente, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
    }

    /**
     * <b> Metodo para devolver atributos de session. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @param nombre del objeto de session
     * @return objeto
     */
    protected Object devolverObjetosSesion(String nombre) {
        return getRequest().getSession().getAttribute(nombre);
    }

    /**
     * <b> Metodo para devolver la ip del host. </b>
     * <p>
     * [Author: fochoac, Date: 1/9/2015]
     * </p>
     *
     * @return ip
     */
    protected String obtenerIpHost() {

        String direccionIp = getRequest().getHeader("X-FORWARDED-FOR");
        if (direccionIp == null) {
            direccionIp = getRequest().getRemoteAddr();
        }

        return direccionIp;
    }

    /**
     *
     * @return the context
     */
    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Retorna un objeto external context
     *
     * @return {@link ExternalContext}
     */
    protected ExternalContext getExternalContext() {
        return getContext().getExternalContext();
    }

    /**
     * Retorna un objeto elcontext
     *
     * @return {@link ELContext}
     */
    protected ELContext getElContext() {
        return getContext().getELContext();
    }

    /**
     * Retorna un objeto aplicacion
     *
     * @return {@link Application}
     */
    protected Application getApplication() {
        return getContext().getApplication();
    }

    /**
     * Retorna un objeto request
     *
     * @return {@link HttpServletRequest}
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    /**
     * Retorna un objeto response
     *
     * @return {@link HttpServletResponse}
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getContext().getExternalContext().getResponse();

    }

    /**
     * <b> Metodo utilitario para cargar un archivo </b>
     * <p>
     * [Author: fochoac, Date: 15/9/2015]
     * </p>
     *
     * @param contenido arreglo de bytes
     * @param extension tipo de extension del archivo
     * @param nombreArchivo nombre
     * @return {@link File}
     */
    protected File cargarArchivoUpload(byte[] contenido, String extension, String nombreArchivo) {
        try {
            File file = new File(getContext().getExternalContext().getRealPath("upload") + "/" + nombreArchivo + "." + extension);
            FileOutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            return file;
        } catch (IOException e) {
            Log.error(getClass().getName(), "Error al cargar el archivo", e);
            return null;
        }
    }

    /**
     * <b> Metodo utilitario para cargar un archivo </b>
     * <p>
     * [Author: fochoac, Date: 15/9/2015]
     * </p>
     *
     * @param contenido arreglo de bytes
     * @param extension tipo de extension del archivo
     * @return {@link File}
     */
    protected File cargarArchivoUpload(byte[] contenido, String extension) {
        try {
            String nombreArchivo = "reporte_" + new Date().getTime();
            File file = new File(getContext().getExternalContext().getRealPath("upload") + "/" + nombreArchivo + "." + extension);
            FileOutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            return file;
        } catch (IOException e) {
            Log.error(getClass().getName(), "Error al cargar el archivo", e);
            return null;
        }
    }

    protected void reversaByte(byte[] dato, String nombre, String contentType) {
        try {
            FacesContext ctx = getContext();
            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "attachment;filename=" + nombre + ".pdf");
            ServletOutputStream out = response.getOutputStream();
            out.write(dato);
            out.flush();
            out.close();
            ctx.responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * <b> Obtiene el nombre del navegador. </b>
     * <p>
     * [$Author: pganan $, $Date: 12/09/2015]
     * </p>
     *
     * @return Nombre de navegador
     */
    public String obtenerNavegador() {
        String userAgent = getExternalContext().getRequestHeaderMap().get("User-Agent");

        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            return "Internet Explorer";
        }

        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera")) {
            return "Opera";
        }
        if (userAgent.contains("Safari")) {
            return "Safari";
        }
        return "Desconocido";
    }

    /**
     *
     * <b> Obtiene el nombre del navegador. </b>
     * <p>
     * [$Author: pganan $, $Date: 12/09/2015]
     * </p>
     *
     * @param request
     * @return Nombre de navegador
     */
    public String obtenerNavegador(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            return "Internet Explorer";
        }

        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera")) {
            return "Opera";
        }
        if (userAgent.contains("Safari")) {
            return "Safari";
        }
        return "Desconocido";
    }

}

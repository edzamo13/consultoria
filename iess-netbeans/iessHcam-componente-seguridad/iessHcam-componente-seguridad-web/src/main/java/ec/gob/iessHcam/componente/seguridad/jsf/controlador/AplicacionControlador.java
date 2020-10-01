/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.jsf.controlador;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.componente.seguridad.jsf.bb.AplicacionBb;
import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.servicio.AplicacionServicio;
import ec.gob.iessHcam.ws.autentificacion.UsuarioRespuesta;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Clase AplicacionControl clase controladora que maneja la información con JSF.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 27/01/2016]</p>
 */
@Named
@ViewScoped
public class AplicacionControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 2580131167717991136L;

    @Inject
    @Getter
    @Setter
    private AplicacionBb aplicacionBb;
    @EJB
    @Getter
    private AplicacionServicio aplicacionServicio;

    @PostConstruct
    public void inicializar() {
        getAplicacionBb().setRespuesta(new UsuarioRespuesta());
        getAplicacionBb().setAplicacion(new Aplicacion());
        getAplicacionBb().setAplicacions(new ArrayList<Aplicacion>());
        if (validarSession()) {
            try {
                getAplicacionBb().setAplicacions(cargarAplicacionUsuarioSession(obtenerAplicaciones()));
                getAplicacionBb().setDependenciasApp(presentarApp(getAplicacionBb().getAplicacions()));

            } catch (ServicioExcepcion ex) {
                Logger.getLogger(AplicacionControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     *
     * <b>
     * Valida Session y Recupera a Usuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 15/02/2016]</p>
     *
     * @return
     */
    private Boolean validarSession() {
        if (getSession().getAttribute("usuarioRespuesta") != null) {;
            getAplicacionBb().setRespuesta((UsuarioRespuesta) devolverObjetosSesion("usuarioRespuesta"));
            return true;
        } else {
            redirect("/index.jsf");
            return false;
        }
    }

    /**
     *
     * <b>
     * Incluir aqui­ la descripcion del metodo.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 08/02/2016]</p>
     *
     * @return list<aplicacion>
     * @throws ec.gob.iess.componente.comun.excepciones.ServicioExcepcion
     * expecion
     */
    private List<Aplicacion> obtenerAplicaciones() throws ServicioExcepcion {
        getAplicacionBb().setAplicacions(getAplicacionServicio().obtenerUsuarioAplicaciones(Integer.parseInt(getAplicacionBb().getRespuesta().getCuerpo().getIdUsuario())));
        return getAplicacionBb().getAplicacions();
    }

    /**
     *
     * <b>
     * Carga a Lista de Aplicaciones Datos de Usuario en Session.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 16/02/2016]</p>
     */
    private List<Aplicacion> cargarAplicacionUsuarioSession(List<Aplicacion> aplicacions) {
        for (Aplicacion app : aplicacions) {
            app.setIdUsuario(getAplicacionBb().getRespuesta().getCuerpo().getIdUsuario());
            app.setUsuario(getAplicacionBb().getRespuesta().getCuerpo().getUsuario());
            app.setNumeroDocumento(getAplicacionBb().getRespuesta().getCuerpo().getNumDocumento());
            app.setIpUsuario(getAplicacionBb().getRespuesta().getCuerpo().getIpUsuario());
            app.setCodUnme(getAplicacionBb().getRespuesta().getCuerpo().getCodUnme());
            app.setNombrePersona(getAplicacionBb().getRespuesta().getCuerpo().getNombrePersona());
        }

        return aplicacions;
    }

    /**
     *
     * <b>
     * Direcciona a Pagina que contiene APP.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2015]</p>
     *
     * @param a Aplicacion
     * @throws java.io.IOException excepcion
     */
    public void cargarApp(Aplicacion a) throws IOException {
        getAplicacionBb().setAplicacion(a);
        System.out.println("Dir : " + getAplicacionBb().getAplicacion().getApUrl());
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.setRequest(context);
        externalContext.redirect(getAplicacionBb().getAplicacion().getApUrl());

        //  redirect(getAplicacionBb().getAplicacion().getApUrl());
    }

    /**
     *
     * <b>
     * Redirecciona la página a la url seleccionada del menú.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     */
    public void cerrarSession() {
        cerrarSesion();
    }

    private List<Dependencias> presentarApp(List<Aplicacion> aplicacions) {
        List<Dependencias> dependenciasList = new ArrayList<>();
        Map<Integer, Dependencias> unicaDependencia = new HashMap<>();
        for (Aplicacion a : aplicacions) {
            dependenciasList.add(a.getDeIdDependencia());
        }
        for (Dependencias d : dependenciasList) {
            System.out.println("nombre" + d.getDeNombre() + "id" + d.getDeIdDependencia() + "id Padre" + d.getDeIdDependenciaPadre());

           
                unicaDependencia.put(d.getDeIdDependencia(), d);
            

        }
        dependenciasList = new ArrayList<>();
        dependenciasList = new ArrayList<>(unicaDependencia.values());
        for (Dependencias dependencias : dependenciasList) {
            System.out.println("id" + dependencias.getDeIdDependencia() + "id Padre" + dependencias.getDeIdDependenciaPadre());
        }
        return dependenciasList;
    }
 
}

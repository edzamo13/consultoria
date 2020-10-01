/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package iesshcam.plantilla.jsf.controlador;

import ec.gob.iessHcam.componente.comun.encriptaciones.EncriptacionBase64;
import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.EscuchaEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;

import ec.gob.iessHcam.ws.autentificacion.MenuSalida;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import iesshcam.plantilla.jsf.bb.PlantillaBb;
import java.io.IOException;

import java.io.Serializable;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author root
 */
@Named
@ViewScoped
public class PlantillaControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private PlantillaBb plantillaBb;
    @Getter
    @Setter
    private int tiempoSession;

    @PostConstruct
    public void inicializar() {

        getPlantillaBb().setSalida(new UsuarioSalida());
        getPlantillaBb().setMenusH(new ArrayList<MenuSalida>());
        getPlantillaBb().setMenusN(new ArrayList<MenuSalida>());
        try {

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            getPlantillaBb().setUrl(ec.getRequestContextPath());

            if (validarSession()) {
                cargarMenu();
                escondeDialogEspera();
                this.tiempoSession = getSession().getMaxInactiveInterval();
            }

        } catch (RuntimeException e) {
            Log.error(PlantillaControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        } catch (ServicioExcepcion ex) {
            Logger.getLogger(PlantillaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * <b>
     * Valida Session y Recupera a Usuario, Unidad medica.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 15/02/2016]</p>
     *
     * @return
     */
    private Boolean validarSession() {

        if (getSession().getAttribute(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()) != null) {
            getPlantillaBb().setSalida((UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()));
            getPlantillaBb().setDescripcionUnme(getPlantillaBb().getSalida().getUnidadMedicaSalida().getNombreUnme());

            Object bread = devolverObjetosSesion("breadCrumbModel");
            if (bread != null) {
                getPlantillaBb().setBreadcrumbmodel((MenuModel) bread);
            }

            return true;
        } else {
            redirect("/index.jsf");
            return false;
        }
    }

    /**
     *
     * <b>
     * Trae el menú del webService.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     */
    private void cargarMenu() throws ServicioExcepcion {
        getPlantillaBb().setRoot(new DefaultTreeNode(new MenuSalida(), null));
//        getPlantillaBb().setListaMenu(respuesta.getCuerpoLista());
        getPlantillaBb().setListaMenu(getPlantillaBb().getSalida().getMenuSalidas());

        for (MenuSalida item : getPlantillaBb().getListaMenu()) {

            if (item.getMeidOpcion_padre().equals("")) {
                TreeNode newNode = new DefaultTreeNode(item, getPlantillaBb().getRoot());
                newNode.setExpanded(true);
                for (MenuSalida subItem : listaHijos(item.getMeIdOpcion())) {
                    TreeNode childNode = cargaSubItems(subItem, newNode);
                }
            }
        }
    }

    /**
     *
     * <b>
     * Carga los subItems del item padre para el menú
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     *
     * @param item
     * @param padre
     * @return
     */
    public TreeNode cargaSubItems(MenuSalida item, TreeNode padre) {

        TreeNode newNode = new DefaultTreeNode(item, padre);

        newNode.setExpanded(true);
        for (MenuSalida k : listaHijos(item.getMeIdOpcion())) {
            TreeNode childNode = cargaSubItems(k, newNode);
        }

        return newNode;
    }

    /**
     *
     * <b>
     * Devuelve la lista de hijos dependiendo del id padre para el menú
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     *
     * @param idPadre
     * @return
     */
    public List<MenuSalida> listaHijos(String idPadre) {
        List<MenuSalida> hijosList = new ArrayList<>();
        for (MenuSalida k : getPlantillaBb().getListaMenu()) {
            if (k.getMeidOpcion_padre().equals(idPadre)) {
                hijosList.add(k);
            }
        }
        return hijosList;
    }

    /**
     *
     * <b>
     * Muestra la ventana de espera.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     */
    public void muestraDialogEspera() {
        getPlantillaBb().setDialogEspera(true);
        RequestContext.getCurrentInstance().execute("PF('dialogEspera').show();");
        RequestContext.getCurrentInstance().update("dialogEspera");
    }

    /**
     *
     * <b>
     * Esconde la ventana de espera.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     */
    public void escondeDialogEspera() {
        getPlantillaBb().setDialogEspera(false);
        RequestContext.getCurrentInstance().execute("PF('dialogEspera').hide();");
        RequestContext.getCurrentInstance().update("dialogEspera");
    }

    /**
     *
     * <b>
     * Redirecciona la página a la url seleccionada del menú.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 18/02/2016]</p>
     *
     * @param salida
     */
    public void redirect(MenuSalida salida) {
        getPlantillaBb().setEtiquetas(new ArrayList<String>());
        breadCrumb(salida);
        getPlantillaBb().getEtiquetas().add(0, salida.getMeEtiqueta());
        getPlantillaBb().setBreadCrumb(breadCrumb(getPlantillaBb().getEtiquetas()));
        redirect("/app/" + EncriptacionBase64.cifrarCadena(salida.getMeUrl()));
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

    /**
     *
     * <b>
     * breadCrumb Miga de Pan Ubicación Navegacion Usuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 07/04/2015]</p>
     */
    private void breadCrumb(MenuSalida salida) {
        MenuSalida menuSalida = new MenuSalida();
        if (salida.getMeidOpcion_padre() == null) {
        } else {
            for (MenuSalida m : getPlantillaBb().getListaMenu()) {
                if (salida.getMeidOpcion_padre().equals(m.getMeIdOpcion())) {
                    getPlantillaBb().getEtiquetas().add(m.getMeEtiqueta());
                    breadCrumb(m);
                }
            }
        }

    }

    /**
     * <b>Escriba la descripción del método</b>
     * <p>
     * [Autor: Daniel Tapia, Fecha: 14/07/2016]
     * </p>
     *
     * @throws java.io.IOException
     * @since 1.0
     */
    public void volverInicio() throws IOException {
        if (getPlantillaBb().getSalida() != null) {
            getExternalContext().redirect("/iessHcam-componente-seguridad-web/pages/private/default.jsf");
        } else {
            getExternalContext().redirect(getRequest().getContextPath() + "/error/404.jsf");
        }
    }

    /**
     *
     * <b>
     * breadCrumb Miga de pan Final Usuario.
     * </b>
     * <p>
     * [$Author: ezamoram $, $Date: 18/11/2015]</p>
     */
    private String breadCrumb(List<String> etiquetas) {
        String etiqueta = "";
        getPlantillaBb().setBreadcrumbmodel(new DefaultMenuModel());

        this.addItem("Inicio", "inicio");
        this.addItem("Menú", "menu");
        for (int i = etiquetas.size() - 1; i >= 0; i--) {
            etiqueta += "/" + etiquetas.get(i);

            this.addItem(etiquetas.get(i).replace("<br/>", " "), "m" + String.valueOf(i));
        }

        getSession().setAttribute("breadCrumbModel", getPlantillaBb().getBreadcrumbmodel());
        return etiqueta;
    }

    /**
     *  * <b>
     *  *   Metodo para crear dinamicamente los breadcrumb.  * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @param value valor
     * @param id id
     */
    public void addItem(String value, String id) {

        DefaultMenuItem item = new DefaultMenuItem();
        item.setValue(value);
        item.setId(id);
        if (id.equals("inicio")) {
            item.setCommand("#{plantillaControlador.limpiar}");
        }
        getPlantillaBb().getBreadcrumbmodel().addElement(item);

    }

    /**
     *  * <b>
     *  *   Metodo para limpiar el breadcrumb del sistema e inicializarlo.  
     *
     * </b>
     *  *
     *  * @author user  
     * <p>
     * [$Author: fquisiguina $, $Date: date]</p>  
     *
     * @return devuelve la direccion de la pagina principal
     */
    public String limpiar() {
        //System.out.print(("limpiar"));        
        getPlantillaBb().setBreadcrumbmodel(null);
        getSession().setAttribute("breadCrumbModel", null);
        return "/pages/private/principal.jsf";

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/
package ec.gob.iessHcam.gestion.seguridad.jsf.controlador;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.MenuForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Menu;
import ec.gob.iessHcam.gestion.seguridad.servicio.InstitucionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.MenuServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * <b>
 * Clase que controla la página de gestión de dependencias.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 08-mar-2016]</p>
 */
@Named
@ViewScoped
public class MenuControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private MenuForm menuForm;

    @EJB
    @Getter
    @Setter
    private InstitucionServicio institucionDaoObj;

    @EJB
    @Getter
    @Setter
    private MenuServicio menuDaoObj;

    
     
    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargaInstituciones();

        } catch (ServicioExcepcion e) {
            Log.error(MenuControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    private void cargaComponentes() {
        getMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));
        getMenuForm().setSelectedNode(new DefaultTreeNode(new Menu(), null));
        
        getMenuForm().setInstituciones(new ArrayList<Institucion>());
        getMenuForm().setInstitucion(new Institucion());
        getMenuForm().setDependencias(new ArrayList<Dependencia>());
        getMenuForm().setDependencia(new Dependencia());
        getMenuForm().setAplicaciones(new ArrayList<Aplicacion>());
        getMenuForm().setAplicacion(new Aplicacion());
        getMenuForm().setMenus(new ArrayList<Menu>());
        getMenuForm().setMenu(new Menu());

        getMenuForm().setIdPadre(new Integer("0"));
        getMenuForm().setNombre(new String());
        getMenuForm().setOrden(new Integer("0"));
        getMenuForm().setUrl(new String());
        getMenuForm().setIsFinal(new Integer("0"));
        getMenuForm().setEstado(new String());

        getMenuForm().setMuestraPanel(false);
        
    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de instituciones.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaInstituciones() throws ServicioExcepcion {
        getMenuForm().setInstituciones(getInstitucionDaoObj().obtenerListaInstituciones());
    }

    
     /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de dependencias de la institución seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    public void cargaDependencias() {
        
        getMenuForm().setDependencia(new Dependencia());
        getMenuForm().setDependencias(new ArrayList<Dependencia>());
        
        for (Institucion i : getMenuForm().getInstituciones()) {
            if (Objects.equals(getMenuForm().getInstitucion().getInIdInstitucion(), i.getInIdInstitucion())) {
                getMenuForm().setDependencias(i.getSegDependenciasTblList());
            }
        }
        
        List<Dependencia> depeAux = new ArrayList<>();
        
        for(Dependencia depe : getMenuForm().getDependencias()){
            if(depe.getDeEstado().equals("A")){
                depeAux.add(depe);
            }
        }
        
        getMenuForm().setDependencias(depeAux);
        
        getMenuForm().setAplicaciones(new ArrayList<Aplicacion>());
        getMenuForm().setMenus(new ArrayList<Menu>());
        getMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));

        getMenuForm().setMuestraPanel(false);
    }
    
    public void cargaAplicaciones() {
        
        getMenuForm().setAplicacion(new Aplicacion());
        getMenuForm().setAplicaciones(new ArrayList<Aplicacion>());
        for(Dependencia d: getMenuForm().getDependencias()){
            if(Objects.equals(getMenuForm().getDependencia().getDeIdDependencia(), d.getDeIdDependencia())){
                getMenuForm().setAplicaciones(d.getSegAplicacionesTblList());
            }
        }
        
        List<Aplicacion> apliAux = new ArrayList<>();
        
        for(Aplicacion apli : getMenuForm().getAplicaciones()){
            if(apli.getApEstado().equals("A")){
                apliAux.add(apli);
            }
        }
        
        getMenuForm().setAplicaciones(apliAux);
        
        getMenuForm().setMenus(new ArrayList<Menu>());
        getMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));
        
        getMenuForm().setMuestraPanel(false);
    }
    
    
    /**
     *
     * <b>
     * Carga un treeNode con la lista de dependencias de la institución seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    public void cargaMenus() {
        
        getMenuForm().setMenu(new Menu());
        getMenuForm().setMenus(new ArrayList<Menu>());
        for (Aplicacion a : getMenuForm().getAplicaciones()) {
            if (Objects.equals(getMenuForm().getAplicacion().getApIdAplicacion(), a.getApIdAplicacion())) {
                try {
                    getMenuForm().setMenus(menuDaoObj.obtenerMenuxAplicacion(a.getApIdAplicacion()));
                    break;
                    
                } catch (ServicioExcepcion e) {
                    Log.error(MenuControlador.class.getName(), "Error al cargar datos", e);
                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
                }
            }
        }
        
        getMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));
        
        for(Menu item : getMenuForm().getMenus()){
            
            if(item.getMeIdOpcionPadre() == null){
                TreeNode newNode= new DefaultTreeNode(item, getMenuForm().getRoot());
           
                for (Menu subItem : listaHijos(item.getMeIdOpcion())) {
                    TreeNode childNode = cargaSubItems(subItem, newNode);
                }
            }
        }

        getMenuForm().setMuestraPanel(true);
    }

    
    /**
    *
    * <b>
    * Carga los subItems del item padre para el menú
    * </b>
    * <p>[$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     * @param item
     * @param padre
     * @return 
    */
    public TreeNode cargaSubItems(Menu item, TreeNode padre) {
      
        TreeNode newNode= new DefaultTreeNode(item, padre);
        
        for (Menu k : listaHijos(item.getMeIdOpcion())) {
            TreeNode childNode = cargaSubItems(k, newNode);
        }
        
        return newNode;
    }
    
     /**
    *
    * <b>
    * Devuelve la lista de hijos dependiendo del id padre para el menú
    * </b>
    * <p>[$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     * @param idPadre
     * @return 
    */
    public List<Menu> listaHijos(int idPadre)
    {
        List<Menu> hijosList=new ArrayList<>();
        for(Menu k: getMenuForm().getMenus()){
            if(k.getMeIdOpcionPadre() != null ){
                if(k.getMeIdOpcionPadre().equals(idPadre)){
                    hijosList.add(k);
                }
            }
        }
        return hijosList;
    }
    
    
    
    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * Llena el objeto dependencia de la base de datos con la información que se encuentra en el objeto dependencia de la vista
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    public void guardaFormularioIngreso() {

        try {

            getMenuForm().getMenu().setApIdAplicacion(getMenuForm().getAplicacion());
            getMenuForm().getMenu().setMeIdOpcionPadre(getMenuForm().getIdPadre());
            getMenuForm().getMenu().setMeEtiqueta(getMenuForm().getNombre());
            getMenuForm().getMenu().setMeOrden(getMenuForm().getOrden());
            getMenuForm().getMenu().setMeUrl(getMenuForm().getUrl());
            getMenuForm().getMenu().setMeEstado(getMenuForm().getEstado());

            if(getMenuForm().getMenu().getMeIdOpcion() == null){
                getMenuForm().getMenu().setMeNodoFinal(1);
            }
            
            boolean respuesta = getMenuDaoObj().guardarMenu(getMenuForm().getMenu());

            if (respuesta) {
                cargaInstituciones();
                Dependencia auxDepe=getMenuForm().getDependencia();
                cargaDependencias();
                getMenuForm().setDependencia(auxDepe);
                Aplicacion auxApli=getMenuForm().getAplicacion();
                cargaAplicaciones();
                getMenuForm().setAplicacion(auxApli);
                cargaMenus();
                RequestContext.getCurrentInstance().execute("PF('dialogMenu').hide();");
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
        } catch (Exception e) {
            Log.error(AplicacionControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }
    }
    
    
    /**
     *
     * <b>
     * Carga el objeto dependencia que se utiliza para la vista con el objeto dependencia de la base de datos.
     * Actualiza el componente formulario de la pantalla para mostrar los valores del objeto dependencia cargado.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    public void cargaFormularioIngreso() {

        getMenuForm().setIdPadre(getMenuForm().getMenu().getMeIdOpcionPadre());
        getMenuForm().setNombre(getMenuForm().getMenu().getMeEtiqueta());
        getMenuForm().setOrden(getMenuForm().getMenu().getMeOrden());
        getMenuForm().setUrl(getMenuForm().getMenu().getMeUrl());
        getMenuForm().setIsFinal(getMenuForm().getMenu().getMeNodoFinal());
        getMenuForm().setEstado(getMenuForm().getMenu().getMeEstado());
       
        RequestContext.getCurrentInstance().update("formMenu:formulario");
    }

    
    /**
     *
     * <b>
     * Llena la variable dependencia que es una entidad de la base de datos con la dependencia seleccionada del treeNode
     * Muestra el formulario con los datos cargados para ser editados
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    public void editarDependenciaSeleccionada() {

        if (getMenuForm().getSelectedNode() != null) {
           
            getMenuForm().setMenu((Menu) getMenuForm().getSelectedNode().getData());
            
            cargaFormularioIngreso();

            RequestContext.getCurrentInstance().execute("PF('dialogMenu').show();");
        } else {
            ponerMensajeError("Seleccione un Item del Menú");
        }

    }
    
    /**
     *
     * <b>
     * Método que es llamado al momento de añadir una nueva dependencia.
     * Inicializa el formulario de ingreso.
     * Si se encuentra selecionada una dependencia en el treeNode. esta se tomará como dependencia padre y la dependencia que se añada será hijo
     * caso contrario se añade sin dependencia padre
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 08/03/2016]</p>
     */
    public void muestraFormulario() {
        
        if(getMenuForm().getAplicacion().getApIdAplicacion()==null){
            ponerMensajeError("Seleccione una Aplicación");
        }
        else{
            getMenuForm().setMenu(new Menu());

            if (getMenuForm().getSelectedNode() != null) {
                getMenuForm().getMenu().setMeIdOpcionPadre(((Menu) getMenuForm().getSelectedNode().getData()).getMeIdOpcion());
            }
            
            cargaFormularioIngreso();
            
            RequestContext.getCurrentInstance().execute("PF('dialogMenu').show();");
        }
    }
    
  
    
    /**
     *
     * <b>
     * Muestra el dialog de confirmación al guardar un registro.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga$, $Date: 05-abr-2016]</p>
     */
    public void muestraConfirmacion() {
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmacion').show();");
    }
    
   
}

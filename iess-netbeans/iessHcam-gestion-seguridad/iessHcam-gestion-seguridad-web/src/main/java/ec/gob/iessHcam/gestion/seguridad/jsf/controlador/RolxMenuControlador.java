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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.RolxMenuForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Menu;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxdependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxmenu;
import ec.gob.iessHcam.gestion.seguridad.servicio.AplicacionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.InstitucionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.MenuServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolxMenuServicio;
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
 * Clase que controla la pÃ¡gina de gestiÃ³n de aplicaciones.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 22-feb-2016]</p>
 */
@Named
@ViewScoped
public class RolxMenuControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;
    
    @Inject
    @Getter
    @Setter
    private RolxMenuForm rolxMenuForm;
    
    @EJB
    @Getter
    @Setter
    private RolServicio rolDaoObj;

    @EJB
    @Getter
    @Setter
    private InstitucionServicio institucionDaoObj;
    
    @EJB
    @Getter
    @Setter
    private AplicacionServicio aplicacionDaoObj;
    
    @EJB
    @Getter
    @Setter
    private MenuServicio menuDaoObj;
    
    @EJB
    @Getter
    @Setter
    private RolxMenuServicio rolxMenuDaoObj;
    
    
    
    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargaRoles();

        } catch (ServicioExcepcion e) {
            Log.error(RolxMenuControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    private void cargaComponentes() {
        getRolxMenuForm().setRolesxDependencias(new ArrayList<Rolxdependencia>());
        getRolxMenuForm().setDependencia(new Dependencia());
        getRolxMenuForm().setRoles(new ArrayList<Rol>());
        getRolxMenuForm().setRol(new Rol());
        
        getRolxMenuForm().setMuestraPanel(false);
        getRolxMenuForm().setInactivaComponente(false);

    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de instituciones.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaRoles() throws ServicioExcepcion {
        getRolxMenuForm().setRoles(getRolDaoObj().obtenerListaRoles());
        
        List<Rol> rolesAux = new ArrayList<>();

        for(Rol rolAux : getRolxMenuForm().getRoles()){
            if(rolAux.getRoEstado().equals("A")){
                rolesAux.add(rolAux);
            }
        }
        
        getRolxMenuForm().setRoles(rolesAux);
    }

    
     /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de dependencias de la instituciÃ³n seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void cargaDependenciasxRol() {
        
        getRolxMenuForm().setDependencia(new Dependencia());
        getRolxMenuForm().setRolesxDependencias(new ArrayList<Rolxdependencia>());
        
        for (Rol r : getRolxMenuForm().getRoles()) {
            if (Objects.equals(getRolxMenuForm().getRol().getRoIdRol(), r.getRoIdRol())) {
                
                List<Rolxdependencia> rolesxDependencias = new ArrayList<>();
                
                for (Rolxdependencia rd : r.getSegRolxdependenciasTblList()) {
                    if(rd.getRdEstado().equals("A")){
                        rolesxDependencias.add(rd);
                    }
                }
                getRolxMenuForm().setRolesxDependencias(rolesxDependencias);
            }
        }
        
        getRolxMenuForm().setMuestraPanel(false);
       
        getRolxMenuForm().setAplicacion(new Aplicacion());
        getRolxMenuForm().setAplicaciones(new ArrayList<Aplicacion>());
        getRolxMenuForm().setMenus(new ArrayList<Menu>());
    }
     
    public void cargaListaAplicaciones() {

        getRolxMenuForm().setAplicacion(new Aplicacion());
        getRolxMenuForm().setAplicaciones(new ArrayList<Aplicacion>());
       
        for (Rolxdependencia rd : getRolxMenuForm().getRolesxDependencias()) {
            if (Objects.equals(getRolxMenuForm().getDependencia().getDeIdDependencia(), rd.getDeIdDependencia().getDeIdDependencia())) {
                getRolxMenuForm().setAplicaciones(rd.getDeIdDependencia().getSegAplicacionesTblList());
            }
        }
        
        List<Aplicacion> apliAux = new ArrayList<>();

        for(Aplicacion apli : getRolxMenuForm().getAplicaciones()){
            if(apli.getApEstado().equals("A")){
                apliAux.add(apli);
            }
        }

        getRolxMenuForm().setAplicaciones(apliAux);

        getRolxMenuForm().setMuestraPanel(false);
        
        getRolxMenuForm().setMenus(new ArrayList<Menu>());
        
    }
     
    
    
    public void cargaListaMenus() {

        getRolxMenuForm().setMenus(new ArrayList<Menu>());
        getRolxMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));

        try{

            Rol rolAux=new Rol();
        
            for (Rol r : getRolxMenuForm().getRoles()) {
                if (Objects.equals(getRolxMenuForm().getRol().getRoIdRol(), r.getRoIdRol())) {
                    rolAux=r;
                    break;
                }
            }

            List<Menu> menusAsignados = new ArrayList<>();
            for (Rolxmenu rm : rolAux.getSegRolxmenuTblList()){

                if(rm.getMeIdOpcion().getApIdAplicacion().getApIdAplicacion().equals(getRolxMenuForm().getAplicacion().getApIdAplicacion()) && rm.getRmEstado().equals("A")){
                    menusAsignados.add(rm.getMeIdOpcion());
                }
            }
            
            
            List<Menu> menusCompletos = new ArrayList<>();
            menusCompletos = menuDaoObj.obtenerMenuxAplicacion(getRolxMenuForm().getAplicacion().getApIdAplicacion());

            
            for(Menu m1 : menusCompletos){
                for(Menu m2 : menusAsignados){
                    if(Objects.equals(m2.getMeIdOpcion(), m1.getMeIdOpcion())){
                        m1.setHabilitado(true);
                    }
                }
            }
           
            
            //armaListaMenu(menusCompletos, getRolxMenuForm().getRoot());
            cargaTreeNode(menusCompletos, getRolxMenuForm().getRoot());

            getRolxMenuForm().setMenus(menusCompletos);
            
            getRolxMenuForm().setMuestraPanel(true);

        }
        catch (ServicioExcepcion e) {
            Log.error(RolxMenuControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }
    

    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * Llena el objeto aplicaciÃ³n de la base de datos con la informaciÃ³n que se encuentra en el objeto aplicaciÃ³n de la vista
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void guardaMenuAsignado() {
        try {

            Rol rolAux=new Rol();
        
            for (Rol r : getRolxMenuForm().getRoles()) {
                if (Objects.equals(getRolxMenuForm().getRol().getRoIdRol(), r.getRoIdRol())) {
                    rolAux=r;
                    break;
                }
            }
            
            List<Rolxmenu> menusAsignado = new ArrayList<>();
            
            for(Menu m : getRolxMenuForm().getMenus()){
                
                if(m.isHabilitado()){
                    Rolxmenu rolxMenu = new Rolxmenu();
                
                    rolxMenu.setMeIdOpcion(m);
                    rolxMenu.setRoIdRol(rolAux);
                    rolxMenu.setRmEstado("A");

                    menusAsignado.add(rolxMenu);
                }
            }
            
            boolean respuesta = getRolxMenuDaoObj().inactivarRolxMenu(getRolxMenuForm().getAplicacion().getApIdAplicacion(), getRolxMenuForm().getRol().getRoIdRol());
            
            if (respuesta) {
                getRolxMenuDaoObj().guardarRolxMenu(menusAsignado);
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
          
        } catch (Exception e) {
            Log.error(RolxMenuControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
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
 
    
    
    public void validarArbolCheck(Menu menu){
        
        getRolxMenuForm().setRoot(new DefaultTreeNode(new Menu(), null));
        
        if(menu.getMeIdOpcionPadre() == null){
            
            for(Menu m : getRolxMenuForm().getMenus()){
                if(m.getMeIdOpcionPadre() != null ){
                    if(m.getMeIdOpcionPadre().equals(menu.getMeIdOpcion())){
                        m.setHabilitado(menu.isHabilitado());
                    }
                }
            }
        }else if(!menu.isHabilitado()){
            for(Menu m : getRolxMenuForm().getMenus()){
                if(m.getMeIdOpcion().equals(menu.getMeIdOpcionPadre())){
                    m.setHabilitado(menu.isHabilitado());
                }
            }
        }else if(menu.isHabilitado()){

            int ind =0;

            for(Menu m : getRolxMenuForm().getMenus()){
                if(m.getMeIdOpcionPadre() != null ){
                    if(m.getMeIdOpcionPadre().equals(menu.getMeIdOpcionPadre())){

                        if(!m.isHabilitado()){
                            ind = 1;
                            break;
                        }
                    }
                }
            }
            

            for(Menu m : getRolxMenuForm().getMenus()){
                if(m.getMeIdOpcion().equals(menu.getMeIdOpcionPadre()) ){
                    m.setHabilitado(ind == 0);
                }
            }

        }
        
        cargaTreeNode(getRolxMenuForm().getMenus(), getRolxMenuForm().getRoot());
    }
    
    
    
     private void cargaTreeNode(List<Menu> menusCompletos, TreeNode root) {
        
        for(Menu item : menusCompletos){
            
            if(item.getMeIdOpcionPadre() == null){
                TreeNode newNode= new DefaultTreeNode(item, root);
                newNode.setExpanded(true);
                for (Menu subItem : listaHijos(item.getMeIdOpcion(), menusCompletos)) {
                    TreeNode childNode = cargaSubItems(subItem, newNode, menusCompletos);
                }
            }
        }

    }
    
    public TreeNode cargaSubItems(Menu item, TreeNode padre, List<Menu> menusCompletos) {
      
        TreeNode newNode= new DefaultTreeNode(item, padre);
        newNode.setExpanded(true);
        for (Menu k : listaHijos(item.getMeIdOpcion(), menusCompletos)) {
            TreeNode childNode = cargaSubItems(k, newNode, menusCompletos);
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
     * @param menusCompletos
     * @return 
    */
    public List<Menu> listaHijos(int idPadre, List<Menu> menusCompletos)
    {
        List<Menu> hijosList=new ArrayList<>();
        for(Menu k: menusCompletos){
            if(k.getMeIdOpcionPadre() != null ){
                if(k.getMeIdOpcionPadre().equals(idPadre)){
                    hijosList.add(k);
                }
            }
        }
        return hijosList;
    }

   
}

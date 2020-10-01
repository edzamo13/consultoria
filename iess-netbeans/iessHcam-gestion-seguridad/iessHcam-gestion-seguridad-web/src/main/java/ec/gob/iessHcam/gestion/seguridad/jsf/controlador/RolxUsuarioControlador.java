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
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.EscuchaEnum;
import ec.gob.iessHcam.componente.comun.utilitario.jsf.UtilitarioJsf;
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.RolxUsuarioForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxusuario;
import ec.gob.iessHcam.gestion.seguridad.modelo.Usuario;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.UsuarioServicio;
import ec.gob.iessHcam.ws.autentificacion.MenuSalida;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import iesshcam.plantilla.jsf.bb.PlantillaBb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;


/**
 * <b>
 * Clase que controla la pÃ¡gina de gestiÃ³n de aplicaciones.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
 */
@Named
@ViewScoped
public class RolxUsuarioControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;
    
    @Inject
    @Getter
    @Setter
    private PlantillaBb principalBb;
    
    @Inject
    @Getter
    @Setter
    private RolxUsuarioForm rolxUsuarioForm;
    
    @EJB
    @Getter
    @Setter
    private UsuarioServicio usuarioDaoObj;
    
    @EJB
    @Getter
    @Setter
    private RolServicio rolDaoObj;
    
   
    
    @PostConstruct
    public void inicializar() {
        
        cargaComponentes();

    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29/mar/2016]</p>
     */
    private void cargaComponentes() {
        getRolxUsuarioForm().setUsuarios(new ArrayList<Usuario>());
        getRolxUsuarioForm().setUsuario(new Usuario());
        
        getRolxUsuarioForm().setRoles(new ArrayList<Rol>());
        getRolxUsuarioForm().setRolxUsuario(new Rolxusuario());
        getRolxUsuarioForm().getRolxUsuario().setRoIdRol(new Rol());
        
        getPrincipalBb().setSalida(new UsuarioSalida());
        getPrincipalBb().setMenusH(new ArrayList<MenuSalida>());
        getPrincipalBb().setMenusN(new ArrayList<MenuSalida>());
        getPrincipalBb().setSalida((UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()));
              
        getRolxUsuarioForm().setMuestraPanel(false);
        getRolxUsuarioForm().setDisabledSelectRol(true);
        
        getRolxUsuarioForm().setTipoBusqueda("C");
        getRolxUsuarioForm().setBusqueda("");
    }


    
    public void buscarUsuario() {
        getRolxUsuarioForm().setMuestraPanel(false);
        if(!getRolxUsuarioForm().getBusqueda().trim().equals("")){
            try {
                switch (getRolxUsuarioForm().getTipoBusqueda()) {
                    case "C":
                        getRolxUsuarioForm().setUsuarios(getUsuarioDaoObj().obtenerUsuarioPorIdentificacion(getRolxUsuarioForm().getBusqueda()));

                        RequestContext.getCurrentInstance().execute("PF('dialogUsuarios').show();");
                        break;
                    case "U":
                        getRolxUsuarioForm().setUsuario(getUsuarioDaoObj().obtenerUsuarioPorNombre(getRolxUsuarioForm().getBusqueda()));
                        
                        if(getRolxUsuarioForm().getUsuario() != null){
                           cargaFormularioUsuario(); 
                        }else{
                            ponerMensajeError("Nombre de Usuario no Encontrado");
                        }
                        
                        break;
                }
            } catch (Exception e) {
                Log.error(AplicacionControlador.class.getName(), "Error al Cargar Datos", e);
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
        }
    }
    
    
     /**
     *
     * <b>
     * Carga el formulario con los datos del usuario seleccionado del p:selectOneMenu.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
     */
    public void cargaFormularioUsuario() {
        
        if(getRolxUsuarioForm().getUsuario().getUsIdUsuario() == null){
            getRolxUsuarioForm().setMuestraPanel(false);
        }
        else{
            
            try {
                
                RequestContext.getCurrentInstance().update("formEditaUsuario:pnlPrincipal");
                
                getRolxUsuarioForm().setMuestraPanel(true);
            } catch (Exception e) {
                Log.error(AplicacionControlador.class.getName(), "Error al Cargar Datos", e);
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
        }
    }
     
    
    
    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 01-abri-2016]</p>
     */
    public void guardaAsignacionRol() {
        try {
            
            getRolxUsuarioForm().getRolxUsuario().setUsIdUsuario(getRolxUsuarioForm().getUsuario());
            getRolxUsuarioForm().getRolxUsuario().setIdUsuCreacion(Integer.parseInt(getPrincipalBb().getSalida().getIdUsuario()));
            getRolxUsuarioForm().getRolxUsuario().setFecCreacion(new Date());
            
            getRolxUsuarioForm().getUsuario().getSegRolxusuarioTblList().add(getRolxUsuarioForm().getRolxUsuario());
            
            boolean respuesta = getUsuarioDaoObj().guardaUsuario(getRolxUsuarioForm().getUsuario());
            
            if (respuesta) {
                getRolxUsuarioForm().setUsuario(getUsuarioDaoObj().obtenerUsuarioPorClavePrimaria(getRolxUsuarioForm().getUsuario().getUsIdUsuario()));
                RequestContext.getCurrentInstance().execute("PF('dialogRol').hide();");
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }

        } catch (Exception e) {
            Log.error(RolxUsuarioControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }

    }
    
    
    
    /**
     *
     * <b>
     * Método que es llamado para cerrar la ventana modal con la lista de usuarios.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30-mar-2016]</p>
     */
    public void cierraFormulario() {
       
        RequestContext.getCurrentInstance().execute("PF('dialogUsuarios').hide();");
        RequestContext.getCurrentInstance().execute("PF('dialogRol').hide();");
    }
    
    /**
     *
     * <b>
     * Método que limpia la pantalla al buscar un nuevo usuario.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 01-abri-2016]</p>
     */
    public void limpiaBusqueda() {
        getRolxUsuarioForm().setBusqueda("");
        getRolxUsuarioForm().setMuestraPanel(false);
    }
    
     
    
    public void nuevoRol() {

        if (this.rolxUsuarioForm.getUsuario().getUsUsuario().equals("")){
            ponerMensajeError("Primero debe realizar la búsqueda de un usuario");
            return;
        }else{
            if (this.rolxUsuarioForm.getUsuario().getUsUsuario()==null){
                ponerMensajeError("Primero debe realizar la búsqueda de un usuario");
                return;
            }        
        }
            
        RequestContext.getCurrentInstance().execute("PF('dialogRol').show();");
        
        
        try {
            getRolxUsuarioForm().setDisabledSelectRol(false);

            getRolxUsuarioForm().setRoles(getRolDaoObj().obtenerListaRolesnoAsignados(getRolxUsuarioForm().getUsuario().getUsIdUsuario()));

            getRolxUsuarioForm().setRolxUsuario(new Rolxusuario());
            getRolxUsuarioForm().getRolxUsuario().setRoIdRol(new Rol());
            getRolxUsuarioForm().getRolxUsuario().getRoIdRol().setRoIdRol(new Integer("0"));
            getRolxUsuarioForm().getRolxUsuario().getRoIdRol().setRoNombre("");
            getRolxUsuarioForm().getRolxUsuario().getRoIdRol().setRoDescripcion("");
            getRolxUsuarioForm().getRolxUsuario().setRuEstado("");

            RequestContext.getCurrentInstance().update(":formRol:formularioRol");
            
        } catch (ServicioExcepcion e) {
            Log.error(RolxUsuarioControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    
    public void cargaFormulario() {
        try {
            getRolxUsuarioForm().setRoles(getRolDaoObj().obtenerListaRolesnoAsignados(getRolxUsuarioForm().getUsuario().getUsIdUsuario()));

            for(Rol rolaux : getRolxUsuarioForm().getRoles()){
                if(rolaux.getRoIdRol().equals(getRolxUsuarioForm().getRolxUsuario().getRoIdRol().getRoIdRol())){

                    getRolxUsuarioForm().getRolxUsuario().setRoIdRol(rolaux);

                    break;
                }
            }
        } catch (ServicioExcepcion e) {
            Log.error(RolxUsuarioControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }
    /**
     *
     * <b>
     * Método que es llamado al momento de añadir una nueva aplicación.
     * Inicializa el formulario de ingreso.
     * Si actualmente se encuentra seleccionada una dependencia, se muestra el formulario de ingreso, caso contrario muestra un mensaje de error
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void muestraFormularioRol() {
        try {
            
            if(getRolxUsuarioForm().getRolxUsuario().getRoIdRol().getRoIdRol() != null){
                getRolxUsuarioForm().setDisabledSelectRol(true);
            
                getRolxUsuarioForm().setRoles(getRolDaoObj().obtenerListaRolesnoAsignados(getRolxUsuarioForm().getUsuario().getUsIdUsuario()));
                getRolxUsuarioForm().getRoles().add(getRolxUsuarioForm().getRolxUsuario().getRoIdRol());
            }
            
        } catch (ServicioExcepcion e) {
            Log.error(RolxUsuarioControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
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

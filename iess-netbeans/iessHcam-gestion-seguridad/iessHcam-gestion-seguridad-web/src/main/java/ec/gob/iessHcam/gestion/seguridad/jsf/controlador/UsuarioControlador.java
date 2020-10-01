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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.UsuarioForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Usuario;
import ec.gob.iessHcam.gestion.seguridad.servicio.ClienteRestServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.UsuarioServicio;
import ec.gob.iessHcam.ws.autentificacion.MenuSalida;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import ec.gob.iessHcam.ws.gestionAs400.UnidadMedicaSalida;
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
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
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
public class UsuarioControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;
    
    @Inject
    @Getter
    @Setter
    private UsuarioForm usuarioForm;
    
    @Inject
    @Getter
    @Setter
    private PlantillaBb principalBb;
    
    @EJB
    @Getter
    @Setter
    private UsuarioServicio usuarioDaoObj;
    
    @EJB
    @Getter
    @Setter
    private ClienteRestServicio restDaoObj;
    
    
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
        getUsuarioForm().setUsuarios(new ArrayList<Usuario>());
        getUsuarioForm().setUsuario(new Usuario());
        
        getUsuarioForm().setUnidadesMedicas(new ArrayList<UnidadMedicaSalida>());
        
        getPrincipalBb().setSalida(new UsuarioSalida());
        getPrincipalBb().setMenusH(new ArrayList<MenuSalida>());
        getPrincipalBb().setMenusN(new ArrayList<MenuSalida>());
        getPrincipalBb().setSalida((UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()));
        
        getUsuarioForm().setIdUsuario(new Integer("0"));
        getUsuarioForm().setNombrePersona(new String());
        getUsuarioForm().setNombreUsuario(new String());
        getUsuarioForm().setIdentificacion(new String());
        getUsuarioForm().setEmail(new String());
        getUsuarioForm().setUnme(new String());
        getUsuarioForm().setTelefono(new String());
        getUsuarioForm().setEstado(new Integer("0"));
       
        getUsuarioForm().setImagen(null);
        getUsuarioForm().setMuestraPanel(false);
        
        getUsuarioForm().setTipoBusqueda("C");
        getUsuarioForm().setBusqueda("");
    }

    
    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de unidades médicas.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 29-mar-2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaUnidadesMedicas() throws ServicioExcepcion {
        
        if(getUsuarioForm().getUnidadesMedicas().isEmpty()){
            getUsuarioForm().setUnidadesMedicas(getRestDaoObj().obtenerUnidadesMedicas());
        }
        
    }
    
    
    public void buscarUsuario() {
        getUsuarioForm().setMuestraPanel(false);
        if(!getUsuarioForm().getBusqueda().trim().equals("")){
            try {
                switch (getUsuarioForm().getTipoBusqueda()) {
                    case "C":
                        getUsuarioForm().setUsuarios(getUsuarioDaoObj().obtenerUsuarioPorIdentificacion(getUsuarioForm().getBusqueda()));

                        RequestContext.getCurrentInstance().execute("PF('dialogUsuarios').show();");
                        break;
                    case "U":
                        getUsuarioForm().setUsuario(getUsuarioDaoObj().obtenerUsuarioPorNombre(getUsuarioForm().getBusqueda()));
                        
                        if(getUsuarioForm().getUsuario() != null){
                           cargaFormulario(); 
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
    public void cargaFormulario() {
        
        if(getUsuarioForm().getUsuario().getUsIdUsuario() == null){
            getUsuarioForm().setMuestraPanel(false);
        }
        else{
            
            try {
                
                cargaUnidadesMedicas();

                getUsuarioForm().setIdUsuario(getUsuarioForm().getUsuario().getUsIdUsuario());
                getUsuarioForm().setNombrePersona(getUsuarioForm().getUsuario().getUsNombrePersona());
                getUsuarioForm().setNombreUsuario(getUsuarioForm().getUsuario().getUsUsuario());
                getUsuarioForm().setIdentificacion(getUsuarioForm().getUsuario().getUsNumDocumento());
                getUsuarioForm().setEmail(getUsuarioForm().getUsuario().getUsCorreo());
                getUsuarioForm().setUnme(getUsuarioForm().getUsuario().getUsCodUnme());
                getUsuarioForm().setTelefono(getUsuarioForm().getUsuario().getUsTelefono());
                getUsuarioForm().setEstado(getUsuarioForm().getUsuario().getCatEstado());
                
                getUsuarioForm().setMuestraPanel(true);
                
                RequestContext.getCurrentInstance().update("formEditaUsuario:pnlPrincipal");
                
            } catch (Exception e) {
                Log.error(AplicacionControlador.class.getName(), "Error al Cargar Datos", e);
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
        }
    }
     
    
    
    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30/03/2016]</p>
     */
    public void guardaUsuario() {
        try {
           
            getUsuarioForm().getUsuario().setUsNombrePersona(getUsuarioForm().getNombrePersona());
            getUsuarioForm().getUsuario().setUsNumDocumento(getUsuarioForm().getIdentificacion());
            getUsuarioForm().getUsuario().setUsCorreo(getUsuarioForm().getEmail());
            getUsuarioForm().getUsuario().setUsTelefono(getUsuarioForm().getTelefono());
            getUsuarioForm().getUsuario().setUsCodUnme(getUsuarioForm().getUnme());
            getUsuarioForm().getUsuario().setCatEstado(getUsuarioForm().getEstado());
            getUsuarioForm().getUsuario().setUsIdUsuarioAct(Integer.parseInt(getPrincipalBb().getSalida().getIdUsuario()));
            getUsuarioForm().getUsuario().setUsFecActualizacion(new Date());
            
            boolean respuesta = getUsuarioDaoObj().guardaUsuario(getUsuarioForm().getUsuario());
            
            if (respuesta) {
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
                this.inicializar();
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
          
        } catch (Exception e) {
            Log.error(UsuarioControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }

    }
    
    /**
     *
     * <b>
     * Guarda en la base de datos la imagen seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 30-mar-2016]</p>
     * @param event
     */
    public void handleFileUpload(FileUploadEvent event) {
        try {
            getUsuarioForm().setImagen(event.getFile());
            
            if(getUsuarioForm().getImagen() != null){
                byte[] bytes = IOUtils.toByteArray(getUsuarioForm().getImagen().getInputstream());
            
                getUsuarioForm().getUsuario().setUsFoto(bytes);

                boolean respuesta = getUsuarioDaoObj().guardaImagenUsuario(getUsuarioForm().getUsuario());

                if (respuesta) {
                    ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
                } else {
                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                }
            }
        } catch (Exception e) {
            Log.error(AplicacionControlador.class.getName(), "Error al Cambiar la Imagen", e);
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
        getUsuarioForm().setBusqueda("");
        getUsuarioForm().setMuestraPanel(false);
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
        if (this.usuarioForm.getIdentificacion()== null){
            ponerMensajeError("Primero debe realizar la búsqueda de un usuario");
            return;
        }
        else{
            if (this.usuarioForm.getIdentificacion().equals("")){
                ponerMensajeError("Primero debe realizar la búsqueda de un usuario");
                return;
            }
        
        }
        
        if (this.usuarioForm.getNombrePersona()== null){
            ponerMensajeErrorComponente("formBusquedaUsuario:txtNombre", "Campo Requerido");
            return;
        }
        else{
            if (this.usuarioForm.getNombrePersona().equals("")){
               ponerMensajeErrorComponente("formBusquedaUsuario:txtNombre", "Campo Requerido");
                return;
            }
        
        }
        
        if (this.usuarioForm.getIdentificacion()== null){
            ponerMensajeErrorComponente("formBusquedaUsuario:txtCedula", "Campo Requerido");
            return;
        }
        else{
            if (this.usuarioForm.getIdentificacion().equals("")){
               ponerMensajeErrorComponente("formBusquedaUsuario:txtCedula", "Campo Requerido");
                return;
            }
        
        }
        
        if (this.usuarioForm.getEmail()== null){
            ponerMensajeErrorComponente("formBusquedaUsuario:txtMail", "Campo Requerido");
            return;
        }
        else{
            if (this.usuarioForm.getEmail().equals("")){
               ponerMensajeErrorComponente("formBusquedaUsuario:txtMail", "Campo Requerido");
                return;
            }
        
        }
        
        if (this.usuarioForm.getTelefono()== null){
            ponerMensajeErrorComponente("formBusquedaUsuario:txtTelefono", "Campo Requerido");
            return;
        }
        else{
            if (this.usuarioForm.getTelefono().equals("")){
               ponerMensajeErrorComponente("formBusquedaUsuario:txtTelefono", "Campo Requerido");
                return;
            }
        
        }
        
        
        if (this.usuarioForm.getUnme().equals("0")){
            ponerMensajeErrorComponente("formBusquedaUsuario:somUnidades", "Campo Requerido");
            return;
        }

       
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmacion').show();");
    }
    
}

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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.AsignacionImpresoraForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.AsignacionTbl;
import ec.gob.iessHcam.gestion.seguridad.modelo.ImpresoraTbl;
import ec.gob.iessHcam.gestion.seguridad.servicio.AsignacionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.ImpresoraServicio;
import ec.gob.iessHcam.ws.autentificacion.UsuarioSalida;
import iesshcam.plantilla.jsf.bb.PlantillaBb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
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
 * Clase que controla la página de gestión de instituciones.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 03-mar-2016]</p>
 */
@Named
@ViewScoped
public class AsignacionImpresoraControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private AsignacionImpresoraForm asignacionImpresoraForm;

    @Inject
    @Getter
    @Setter
    private PlantillaBb principalBb;
    
    @EJB
    @Getter
    private ImpresoraServicio impresoraServicio;
    
    @EJB
    @Getter
    private AsignacionServicio asignacionServicio;

    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargarImpresoras();

        } catch (ServicioExcepcion e) {
            Log.error(AsignacionImpresoraControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 03/03/2016]</p>
     */
    private void cargaComponentes() {
        getAsignacionImpresoraForm().setImpresoras(new ArrayList<ImpresoraTbl>());
        
        getPrincipalBb().setSalida((UsuarioSalida) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()));
        
    }

    /**
     *
     * <b>
     * Carga lista de impresoras por unidad médica.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 01-jul-2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargarImpresoras() throws ServicioExcepcion {
        
        for(ImpresoraTbl imp : getImpresoraServicio().obtenerListaImpresoras(getPrincipalBb().getSalida().getCodUnme())){
            if(imp.getImEstado() == 'A'){
                getAsignacionImpresoraForm().getImpresoras().add(imp);
            }
        }
        
        
    }

    

   

    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * Llena el objeto aplicación de la base de datos con la información que se encuentra en el objeto institucion de la vista
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 03/03/2016]</p>
     */
    public void guardaFormularioIngreso() {

        try {
            
            if(validaAsignaionImpresora()){
                
            getAsignacionImpresoraForm().getAsignacion().setAsUsuarioCrea(getPrincipalBb().getSalida().getUsuario());
            getAsignacionImpresoraForm().getAsignacion().setAsFechaCrea(new Date());

            AsignacionTbl asignacion = getAsignacionServicio().guardarImpresoraAsignada(getAsignacionImpresoraForm().getAsignacion());

            if (asignacion != null) {
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
            }
            else{
                ponerMensajeError("El usuario ya cuenta con una impresora con la misma dirección IP Asignada");
            }
          
            cargaComponentes();
            cargarImpresoras();
            
            for(ImpresoraTbl imp : getAsignacionImpresoraForm().getImpresoras()){
                if(imp.getImIdImpresora().equals(getAsignacionImpresoraForm().getImpresora().getImIdImpresora())){
                    getAsignacionImpresoraForm().setImpresora(imp);
                }
            }
        } catch (Exception e) {
            Log.error(AsignacionImpresoraControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
        }
        
        
    }
    
  
    public Boolean validaAsignaionImpresora() throws ServicioExcepcion{
    
        AsignacionTbl asignacion = getAsignacionServicio().obtenerAsignacionImpresora(getAsignacionImpresoraForm().getImpresora().getImCodUnme(), 
                                                                                            getAsignacionImpresoraForm().getAsignacion().getAsDirecIpUsua(), 
                                                                                            getAsignacionImpresoraForm().getImpresora().getImDirecIpImpre(),
                                                                                            getAsignacionImpresoraForm().getImpresora().getTiIdTipoManilla().getTiIdTipoManilla());
        
        if(asignacion == null){
            return true;
        }else{
            if(Objects.equals(asignacion.getAsIdAsignacion(), getAsignacionImpresoraForm().getAsignacion().getAsIdAsignacion())){
                return true;
            }
        }
        
        return false;
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
    public void muestraFormulario() {
        getAsignacionImpresoraForm().setAsignacion(new AsignacionTbl());
        getAsignacionImpresoraForm().getAsignacion().setImIdImpresora(getAsignacionImpresoraForm().getImpresora());
                
        RequestContext.getCurrentInstance().execute("PF('dlgImpresora').show();");
    }
    
    public void cargaFormulario(AsignacionTbl asignacion) {
        getAsignacionImpresoraForm().setAsignacion(asignacion);
        
        RequestContext.getCurrentInstance().reset("formImpresora:formulario");
        RequestContext.getCurrentInstance().execute("PF('dlgImpresora').show();");
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
    
    public void cargarelemento(ImpresoraTbl impresora) throws ServicioExcepcion {
        getAsignacionImpresoraForm().setImpresora(impresora);
            
    }
 
}

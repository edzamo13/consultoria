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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.RolxDependenciaForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rolxdependencia;
import ec.gob.iessHcam.gestion.seguridad.servicio.DependenciaServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.InstitucionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolxDependenciaServicio;
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

/**
 * <b>
 * Clase que controla la página de gestión de aplicaciones.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 22-feb-2016]</p>
 */
@Named
@ViewScoped
public class RolxDependenciaControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;
    
    @Inject
    @Getter
    @Setter
    private RolxDependenciaForm rolxDependenciaForm;
    
    @EJB
    @Getter
    @Setter
    private RolServicio rolDaoObj;

    @EJB
    @Getter
    @Setter
    private RolxDependenciaServicio rolxDependenciaDaoObj;

    @EJB
    @Getter
    @Setter
    private InstitucionServicio institucionDaoObj;
    
    @EJB
    @Getter
    @Setter
    private DependenciaServicio dependenciaDaoObj;
   
    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargaRoles();

        } catch (ServicioExcepcion e) {
            Log.error(RolxDependenciaControlador.class.getName(), "Error al inicilizar datos", e);
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
        getRolxDependenciaForm().setInstituciones(new ArrayList<Institucion>());
        getRolxDependenciaForm().setInstitucion(new Institucion());
        
        getRolxDependenciaForm().setDependenciasxRol(new ArrayList<Rolxdependencia>());
        getRolxDependenciaForm().setDependenciaxRol(new Rolxdependencia());
        
        getRolxDependenciaForm().setDependencias(new ArrayList<Dependencia>());
        getRolxDependenciaForm().setDependencia(new Dependencia());
        
        getRolxDependenciaForm().setRoles(new ArrayList<Rol>());
        getRolxDependenciaForm().setRol(new Rol());

        getRolxDependenciaForm().setMuestraPanel(false);
        getRolxDependenciaForm().setInactivaComponente(false);
        
        getRolxDependenciaForm().setEstado("");
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
        getRolxDependenciaForm().setRoles(getRolDaoObj().obtenerListaRoles());
        
        List<Rol> rolesAux = new ArrayList<>();

        for(Rol rolAux : getRolxDependenciaForm().getRoles()){
            if(rolAux.getRoEstado().equals("A")){
                rolesAux.add(rolAux);
            }
        }
        
        getRolxDependenciaForm().setRoles(rolesAux);
    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de dependencias de la institución seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void cargaDependenciasxRol() {
        
        getRolxDependenciaForm().setDependenciasxRol(new ArrayList<Rolxdependencia>());
        
        for (Rol r : getRolxDependenciaForm().getRoles()) {
            if (Objects.equals(getRolxDependenciaForm().getRol().getRoIdRol(), r.getRoIdRol())) {
                getRolxDependenciaForm().setDependenciasxRol(r.getSegRolxdependenciasTblList());
            }
        }
        
        if(getRolxDependenciaForm().getDependenciasxRol().isEmpty()){
            getRolxDependenciaForm().setMuestraPanel(false);
        }
        else{
            getRolxDependenciaForm().setMuestraPanel(true);
        }
    }

    
    public void cargaInstituciones() throws ServicioExcepcion {
        getRolxDependenciaForm().setInstituciones(getInstitucionDaoObj().obtenerListaInstituciones());
        
        List<Institucion> instAux = new ArrayList<>();
        
        for(Institucion inst : getRolxDependenciaForm().getInstituciones()){
            if(inst.getInEstado().equals("A")){
                instAux.add(inst);
            }
        }
        
        getRolxDependenciaForm().setInstituciones(instAux);
    }

    
    public void cargaDependencias() throws ServicioExcepcion {
        
        getRolxDependenciaForm().setDependencia(new Dependencia());
        getRolxDependenciaForm().setDependencias(new ArrayList<Dependencia>());
        
        getRolxDependenciaForm().setDependencias(getDependenciaDaoObj().obtenerListaDependenciasNoAsignadas(getRolxDependenciaForm().getRol().getRoIdRol(), getRolxDependenciaForm().getInstitucion().getInIdInstitucion()));
           
    }
     
    /**
     *
     * <b>
     * Carga el objeto Aplicación que se utiliza para la vista con el objeto aplicación de la base de datos.
     * Actualiza el componente formulario de la pantalla para mostrar los valores del objeto aplicación cargado.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void cargaFormularioIngreso() {

        try {
            cargaInstituciones();
            getRolxDependenciaForm().getInstitucion().setInIdInstitucion(getRolxDependenciaForm().getDependenciaxRol().getDeIdDependencia().getInIdInstitucion().getInIdInstitucion());
            
            cargaDependencias();
            getRolxDependenciaForm().getDependencias().add(getRolxDependenciaForm().getDependenciaxRol().getDeIdDependencia());
            getRolxDependenciaForm().getDependencia().setDeIdDependencia(getRolxDependenciaForm().getDependenciaxRol().getDeIdDependencia().getDeIdDependencia());

            getRolxDependenciaForm().setEstado(getRolxDependenciaForm().getDependenciaxRol().getRdEstado());
            
            getRolxDependenciaForm().setInactivaComponente(true);
            
            RequestContext.getCurrentInstance().update("formRolxDependencia:formulario");
        } catch (ServicioExcepcion e) {
            Log.error(RolxDependenciaControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
       
    }

    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * Llena el objeto aplicación de la base de datos con la información que se encuentra en el objeto aplicación de la vista
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void guardaFormularioIngreso() {

        try {

            getRolxDependenciaForm().getDependenciaxRol().setDeIdDependencia(getRolxDependenciaForm().getDependencia());
            getRolxDependenciaForm().getDependenciaxRol().setRoIdRol(getRolxDependenciaForm().getRol());
            getRolxDependenciaForm().getDependenciaxRol().setRdEstado(getRolxDependenciaForm().getEstado());

            boolean valida=false;
            if(getRolxDependenciaForm().getDependenciaxRol().getRdIdRolxdep() == null){
                valida=getRolxDependenciaDaoObj().validaRolxDependencia(getRolxDependenciaForm().getDependenciaxRol());
            }
            else{
                valida=true;
            }

            if(valida){
                boolean respuesta = getRolxDependenciaDaoObj().guardarRolxDependencia(getRolxDependenciaForm().getDependenciaxRol());
                if (respuesta) {
                    cargaRoles();
                    cargaDependenciasxRol();
                    RequestContext.getCurrentInstance().execute("PF('dialogAsignacion').hide();");
                    ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
                } else {
                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                }
            }
            else{
                ponerMensajeError("La Dependencia ya se encuentra asignada al Rol");
            }
        } catch (Exception e) {
            Log.error(RolxDependenciaControlador.class.getName(), "Error al guardar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
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
    public void muestraFormulario() {
        if(getRolxDependenciaForm().getRol().getRoIdRol()==null){
            ponerMensajeError("Seleccione un Rol");
        }
        else{
            
            try {
                getRolxDependenciaForm().setInstituciones(new ArrayList<Institucion>());
                getRolxDependenciaForm().setInstitucion(new Institucion());
                
                getRolxDependenciaForm().setDependencias(new ArrayList<Dependencia>());
                getRolxDependenciaForm().setDependencia(new Dependencia());
                getRolxDependenciaForm().getDependencia().setDeIdDependencia(new Integer("0"));
                getRolxDependenciaForm().setEstado("A");
                
                getRolxDependenciaForm().setDependenciaxRol(new Rolxdependencia());
                
                getRolxDependenciaForm().setInactivaComponente(false);
                
                RequestContext.getCurrentInstance().reset("formRolxDependencia:formulario");
        
                cargaInstituciones();
                                
                RequestContext.getCurrentInstance().execute("PF('dialogAsignacion').show();");
            } catch (ServicioExcepcion e) {
                Log.error(AplicacionControlador.class.getName(), "Error al inicilizar datos", e);
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
            }
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

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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.RolForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Rol;
import ec.gob.iessHcam.gestion.seguridad.modelo.Tiporol;
import ec.gob.iessHcam.gestion.seguridad.servicio.RolServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.TipoRolServicio;
import java.io.Serializable;
import java.util.ArrayList;
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
 * Clase que controla la página de gestión de tipos de roles.
 * /pages/private/gestionAplicaciones.xhtml
 * </b>
 *
 * @author Jorge Zúñiga
 * <p>
 * [$Author: Jorge Zúñiga $, $Date: 07-mar-2016]</p>
 */
@Named
@ViewScoped
public class RolControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private RolForm rolForm;

    @EJB
    @Getter
    @Setter
    private RolServicio rolDaoObj;

    @EJB
    @Getter
    @Setter
    private TipoRolServicio tipoRolDaoObj;

    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargaRoles();
            cargaTiposRoles();
        } catch (ServicioExcepcion e) {
            Log.error(RolControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/03/2016]</p>
     */
    private void cargaComponentes() {
        getRolForm().setRoles(new ArrayList<Rol>());
        getRolForm().setRol(new Rol());

        getRolForm().setTiposRoles(new ArrayList<Tiporol>());
        getRolForm().setTipoRol(new Tiporol());
        
        getRolForm().setIdTipoRol(new Integer("0"));
        getRolForm().setNombre(new String());
        getRolForm().setDescripcion(new String());
        getRolForm().setEstado(new String());
       
    }

    /**
     *
     * <b>
     * Carga la tabla con la lista de tipos de roles Activos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/03/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaRoles() throws ServicioExcepcion {
        getRolForm().setRoles(getRolDaoObj().obtenerListaRoles());
    }

    
    /**
     *
     * <b>
     * Carga la tabla con la lista de tipos de roles Activos.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/03/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaTiposRoles() throws ServicioExcepcion {
        getRolForm().setTiposRoles(getTipoRolDaoObj().obtenerListaTiposRoles());
    }
    
    

    /**
     *
     * <b>
     * Carga el objeto Tipo Rol que se utiliza para la vista con el objeto Tipo Rol de la base de datos.
     * Actualiza el componente formulario de la pantalla para mostrar los valores del objeto Tipo Rol cargado.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/03/2016]</p>
     */
    public void cargaFormularioIngreso() {

        getRolForm().setIdTipoRol(getRolForm().getRol().getTrIdTiporol().getTrIdTiporol());
        getRolForm().setNombre(getRolForm().getRol().getRoNombre());
        getRolForm().setDescripcion(getRolForm().getRol().getRoDescripcion());
        getRolForm().setEstado(getRolForm().getRol().getRoEstado());
        
        RequestContext.getCurrentInstance().update("formRoles:formulario");
    }

    /**
     *
     * <b>
     * Guarda en la base de datos la información ingresada en el formulario.
     * Llena el objeto aplicación de la base de datos con la información que se encuentra en el objeto institucion de la vista
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 07/03/2016]</p>
     */
    public void guardaFormularioIngreso() {

        try {

            getRolForm().getTipoRol().setTrIdTiporol(getRolForm().getIdTipoRol());
            getRolForm().getRol().setTrIdTiporol(getRolForm().getTipoRol());
            getRolForm().getRol().setRoNombre(getRolForm().getNombre());
            getRolForm().getRol().setRoDescripcion(getRolForm().getDescripcion());
            getRolForm().getRol().setRoEstado(getRolForm().getEstado());
            
            boolean respuesta = getRolDaoObj().guardaRol(getRolForm().getRol());

            if (respuesta) {
                cargaRoles();
                RequestContext.getCurrentInstance().execute("PF('dialogRol').hide();");
                ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
            } else {
                ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
            }
        } catch (Exception e) {
            Log.error(RolControlador.class.getName(), "Error al guardar datos", e);
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
        getRolForm().setRol(new Rol());
        getRolForm().getTipoRol().setTrIdTiporol(getRolForm().getIdTipoRol());
        getRolForm().getRol().setTrIdTiporol(getRolForm().getTipoRol());
        cargaFormularioIngreso();

        RequestContext.getCurrentInstance().execute("PF('dialogRol').show();");
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

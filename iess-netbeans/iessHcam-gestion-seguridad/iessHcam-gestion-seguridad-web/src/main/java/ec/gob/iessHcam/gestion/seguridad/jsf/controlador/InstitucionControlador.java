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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.InstitucionForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.servicio.InstitucionServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class InstitucionControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private InstitucionForm institucionForm;

    @EJB
    @Getter
    @Setter
    private InstitucionServicio institucionDaoObj;

    @PostConstruct
    public void inicializar() {
        try {
            cargaComponentes();
            cargaInstituciones();

        } catch (ServicioExcepcion e) {
            Log.error(InstitucionControlador.class.getName(), "Error al inicilizar datos", e);
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
        getInstitucionForm().setInstituciones(new ArrayList<Institucion>());
        getInstitucionForm().setInstitucion(new Institucion());

        getInstitucionForm().setNombre(new String());
        getInstitucionForm().setEstado(new String());
       
    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de instituciones.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 03/03/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaInstituciones() throws ServicioExcepcion {
        getInstitucionForm().setInstituciones(getInstitucionDaoObj().obtenerListaInstituciones());
    }

    

    /**
     *
     * <b>
     * Carga el objeto institución que se utiliza para la vista con el objeto institución de la base de datos.
     * Actualiza el componente formulario de la pantalla para mostrar los valores del objeto institución cargado.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 03/03/2016]</p>
     */
    public void cargaFormularioIngreso() {

        getInstitucionForm().setNombre(getInstitucionForm().getInstitucion().getInNombre());
        getInstitucionForm().setEstado(getInstitucionForm().getInstitucion().getInEstado());
        
        RequestContext.getCurrentInstance().update("formInstituciones:formulario");

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

            getInstitucionForm().getInstitucion().setInNombre(getInstitucionForm().getNombre());
            getInstitucionForm().getInstitucion().setInEstado(getInstitucionForm().getEstado());
            
            boolean respuesta = getInstitucionDaoObj().validaInstitucion(getInstitucionForm().getInstitucion());
            
            if(respuesta){
                respuesta = getInstitucionDaoObj().guardarInstitucion(getInstitucionForm().getInstitucion());

                if (respuesta) {
                    ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
                } else {
                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                }
            }
            else{
                ponerMensajeError("La institución ingresada ya Existe");
            }

            cargaInstituciones();
        } catch (Exception e) {
            Log.error(InstitucionControlador.class.getName(), "Error al guardar datos", e);
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
        getInstitucionForm().setInstitucion(new Institucion());

        cargaFormularioIngreso();

        RequestContext.getCurrentInstance().execute("PF('dialogInstitucion').show();");
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

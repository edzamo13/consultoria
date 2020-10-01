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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.AplicacionForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.servicio.AplicacionServicio;
import ec.gob.iessHcam.gestion.seguridad.servicio.InstitucionServicio;
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
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

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
public class AplicacionControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private AplicacionForm aplicacionForm;

    @EJB
    @Getter
    @Setter
    private AplicacionServicio aplicacionDaoObj;

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
            Log.error(AplicacionControlador.class.getName(), "Error al inicilizar datos", e);
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
        getAplicacionForm().setInstituciones(new ArrayList<Institucion>());
        getAplicacionForm().setInstitucion(new Institucion());
        getAplicacionForm().setDependencias(new ArrayList<Dependencia>());
        getAplicacionForm().setDependencia(new Dependencia());
        getAplicacionForm().setAplicaciones(new ArrayList<Aplicacion>());
        getAplicacionForm().setAplicacion(new Aplicacion());

        getAplicacionForm().setNombre(new String());
        getAplicacionForm().setDescripcion(new String());
        getAplicacionForm().setUrl(new String());
        getAplicacionForm().setTipoAplicacion(new String());
        getAplicacionForm().setEstado(new String());
        getAplicacionForm().setVisible(new String());
        getAplicacionForm().setCodAplicacion(new String());

        getAplicacionForm().setMuestraPanel(false);
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
    public void cargaInstituciones() throws ServicioExcepcion {
        getAplicacionForm().setInstituciones(getInstitucionDaoObj().obtenerListaInstituciones());
        
        List<Institucion> instAux = new ArrayList<>();
        
        for(Institucion inst : getAplicacionForm().getInstituciones()){
            if(inst.getInEstado().equals("A")){
                instAux.add(inst);
            }
        }
        
        getAplicacionForm().setInstituciones(instAux);
    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de dependencias de la institución seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 22/02/2016]</p>
     */
    public void cargaDependencias() {
        
        getAplicacionForm().setDependencia(new Dependencia());
        getAplicacionForm().setDependencias(new ArrayList<Dependencia>());
        for (Institucion i : getAplicacionForm().getInstituciones()) {
            if (Objects.equals(getAplicacionForm().getInstitucion().getInIdInstitucion(), i.getInIdInstitucion())) {
                getAplicacionForm().setDependencias(i.getSegDependenciasTblList());
            }
        }
        
        List<Dependencia> depeAux = new ArrayList<>();
        
        for(Dependencia depe : getAplicacionForm().getDependencias()){
            if(depe.getDeEstado().equals("A")){
                depeAux.add(depe);
            }
        }
        
        getAplicacionForm().setDependencias(depeAux);
        
        getAplicacionForm().setAplicaciones(new ArrayList<Aplicacion>());
        
        getAplicacionForm().setMuestraPanel(false);
    }

    public void cargaListaAplicaciones() {
        try {
            getAplicacionForm().setAplicaciones(getAplicacionDaoObj().obtenerListaAplicaciones(getAplicacionForm().getDependencia().getDeIdDependencia()));
            
            if(getAplicacionForm().getDependencia().getDeIdDependencia() == null){
                getAplicacionForm().setMuestraPanel(false);
            }
            else{
                getAplicacionForm().setMuestraPanel(true);
            }
        } catch (ServicioExcepcion e) {
            Log.error(AplicacionControlador.class.getName(), "Error al cargar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
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

        getAplicacionForm().setNombre(getAplicacionForm().getAplicacion().getApNombre());
        getAplicacionForm().setDescripcion(getAplicacionForm().getAplicacion().getApDescripcion());
        getAplicacionForm().setTipoAplicacion(getAplicacionForm().getAplicacion().getApTipo());
        getAplicacionForm().setEstado(getAplicacionForm().getAplicacion().getApEstado());
        getAplicacionForm().setVisible("" + getAplicacionForm().getAplicacion().getApVisible());
        getAplicacionForm().setUrl(getAplicacionForm().getAplicacion().getApUrl());
        getAplicacionForm().setCodAplicacion(getAplicacionForm().getAplicacion().getApCodAplicacion());

        RequestContext.getCurrentInstance().update("formAplicacion:formulario");
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

            if (getAplicacionForm().getImagen() != null) {

                String[] nombreImagen = getAplicacionForm().getImagen().getFileName().split("\\.");

                byte[] bytes = IOUtils.toByteArray(getAplicacionForm().getImagen().getInputstream());

                getAplicacionForm().getAplicacion().setApImagen(bytes);
                getAplicacionForm().getAplicacion().setApExtImg(nombreImagen[1]);
                getAplicacionForm().getAplicacion().setApNomImg(nombreImagen[0]);

            }

            getAplicacionForm().getAplicacion().setApNombre(getAplicacionForm().getNombre());
            getAplicacionForm().getAplicacion().setApDescripcion(getAplicacionForm().getDescripcion());
            getAplicacionForm().getAplicacion().setApCodAplicacion(getAplicacionForm().getCodAplicacion());
            getAplicacionForm().getAplicacion().setApUrl(getAplicacionForm().getUrl());
            getAplicacionForm().getAplicacion().setApTipo(getAplicacionForm().getTipoAplicacion());
            getAplicacionForm().getAplicacion().setApEstado(getAplicacionForm().getEstado());
            getAplicacionForm().getAplicacion().setApVisible(Integer.parseInt(getAplicacionForm().getVisible()));
            getAplicacionForm().getAplicacion().setDeIdDependencia(getAplicacionForm().getDependencia());
            getAplicacionForm().getAplicacion().setCaIdCategoria(1);

            boolean respuesta = getAplicacionDaoObj().guardarAplicacion(getAplicacionForm().getAplicacion());

            if (respuesta) {
                cargaListaAplicaciones();
                RequestContext.getCurrentInstance().execute("PF('dialogAplicacion').hide();");
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
     * Método que es llamado al momento de seleccionar una imagen para ser guardada.
     * Carga la imagen que se obtiene del evento a la variable imagen
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 24/02/2016]</p>
     * @param event
     */
    public void handleFileUpload(FileUploadEvent event) {
        getAplicacionForm().setImagen(event.getFile());
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
        getAplicacionForm().setAplicacion(new Aplicacion());

        cargaFormularioIngreso();
        
        if(getAplicacionForm().getDependencia().getDeIdDependencia()==null){
            ponerMensajeError("Seleccione una Dependencia");
        }
        else{
            RequestContext.getCurrentInstance().execute("PF('dialogAplicacion').show();");
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

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
import ec.gob.iessHcam.gestion.seguridad.jsf.bb.DependenciaForm;
import ec.gob.iessHcam.gestion.seguridad.modelo.Dependencia;
import ec.gob.iessHcam.gestion.seguridad.modelo.Institucion;
import ec.gob.iessHcam.gestion.seguridad.servicio.DependenciaServicio;
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
 * [$Author: Jorge Zúñiga $, $Date: 04-mar-2016]</p>
 */
@Named
@ViewScoped
public class DependenciaControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private DependenciaForm dependenciaForm;

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
            cargaInstituciones();

        } catch (ServicioExcepcion e) {
            Log.error(DependenciaControlador.class.getName(), "Error al inicilizar datos", e);
            ponerMensajeError(ComunEnum.MENSAJE_ERROR_INICIALIZACION.getDescripcion());
        }
    }

    /**
     *
     * <b>
     * Inicializa los componentes de pantalla.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    private void cargaComponentes() {
        getDependenciaForm().setRoot(new DefaultTreeNode(new Dependencia(), null));
        getDependenciaForm().setSelectedNode(new DefaultTreeNode(new Dependencia(), null));
        getDependenciaForm().setInstituciones(new ArrayList<Institucion>());
        getDependenciaForm().setInstitucion(new Institucion());
        getDependenciaForm().setDependencias(new ArrayList<Dependencia>());
        getDependenciaForm().setDependencia(new Dependencia());

        getDependenciaForm().setNombre(new String());
        getDependenciaForm().setTipoDependencia(new String());
        getDependenciaForm().setIdPadre(new Integer("0"));
        getDependenciaForm().setEstado(new String());

        getDependenciaForm().setMuestraPanel(false);
    }

    /**
     *
     * <b>
     * Carga un selectOneMenu con la lista de instituciones.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     * @throws ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion
     */
    public void cargaInstituciones() throws ServicioExcepcion {
        getDependenciaForm().setInstituciones(getInstitucionDaoObj().obtenerListaInstituciones());
        
        List<Institucion> instAux = new ArrayList<>();
        
        for(Institucion inst : getDependenciaForm().getInstituciones()){
            if(inst.getInEstado().equals("A")){
                instAux.add(inst);
            }
        }
        
        getDependenciaForm().setInstituciones(instAux);
    }

    /**
     *
     * <b>
     * Carga un treeNode con la lista de dependencias de la institución seleccionada.
     * </b>
     * <p>
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    public void cargaDependencias() {
        
        getDependenciaForm().setDependencia(new Dependencia());
        getDependenciaForm().setDependencias(new ArrayList<Dependencia>());
        
        for (Institucion i : getDependenciaForm().getInstituciones()) {
            if (Objects.equals(getDependenciaForm().getInstitucion().getInIdInstitucion(), i.getInIdInstitucion())) {
                getDependenciaForm().setDependencias(i.getSegDependenciasTblList());
            }
        }
        
        getDependenciaForm().setRoot(new DefaultTreeNode(new Dependencia(), null));
        
        for(Dependencia item : getDependenciaForm().getDependencias()){
            
            if(item.getDeIdDependenciaPadre() == null){
                TreeNode newNode= new DefaultTreeNode(item, getDependenciaForm().getRoot());
           
                for (Dependencia subItem : listaHijos(item.getDeIdDependencia())) {
                    TreeNode childNode = cargaSubItems(subItem, newNode);
                }
            }
        }
        
        if(getDependenciaForm().getInstitucion().getInIdInstitucion() != null){
            getDependenciaForm().setMuestraPanel(true);
        }
        else{
            getDependenciaForm().setMuestraPanel(false);
        }
    }

    
    /**
    *
    * <b>
    * Carga los subItems del item padre para el menú
    * </b>
    * <p>[$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     * @param item
     * @param padre
     * @return 
    */
    public TreeNode cargaSubItems(Dependencia item, TreeNode padre) {
      
        TreeNode newNode= new DefaultTreeNode(item, padre);
        
        for (Dependencia k : listaHijos(item.getDeIdDependencia())) {
            TreeNode childNode = cargaSubItems(k, newNode);
        }
        
        return newNode;
    }
    
     /**
    *
    * <b>
    * Devuelve la lista de hijos dependiendo del id padre para el menú
    * </b>
    * <p>[$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     * @param idPadre
     * @return 
    */
    public List<Dependencia> listaHijos(int idPadre)
    {
        List<Dependencia> hijosList=new ArrayList<>();
        for(Dependencia k: getDependenciaForm().getDependencias()){
            if(k.getDeIdDependenciaPadre() != null ){
                if(k.getDeIdDependenciaPadre().equals(idPadre)){
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
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    public void guardaFormularioIngreso() {

        try {

            getDependenciaForm().getDependencia().setDeNombre(getDependenciaForm().getNombre());
            getDependenciaForm().getDependencia().setDeTipoDependencia(getDependenciaForm().getTipoDependencia());
            getDependenciaForm().getDependencia().setDeIdDependenciaPadre(getDependenciaForm().getIdPadre());
            getDependenciaForm().getDependencia().setDeEstado(getDependenciaForm().getEstado());
            getDependenciaForm().getDependencia().setInIdInstitucion(getDependenciaForm().getInstitucion());

            boolean respuesta = getDependenciaDaoObj().validaDependencia(getDependenciaForm().getDependencia());
            
            if(respuesta){

                respuesta = getDependenciaDaoObj().guardarDependencia(getDependenciaForm().getDependencia());

                if (respuesta) {
                    RequestContext.getCurrentInstance().execute("PF('dialogDependencia').hide();");
                    ponerMensajeInfo(ComunEnum.MENSAJE_INFO_OPERACION_EXITOSA.getDescripcion());
                } else {
                    ponerMensajeError(ComunEnum.MENSAJE_ERROR_FALLO_OPERACION.getDescripcion());
                }
            }
            else{
                ponerMensajeError("La Dependencia ingresada ya Existe");
            }

            cargaInstituciones();
            cargaDependencias();
            
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
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    public void cargaFormularioIngreso() {

        getDependenciaForm().setNombre(getDependenciaForm().getDependencia().getDeNombre());
        getDependenciaForm().setTipoDependencia(getDependenciaForm().getDependencia().getDeTipoDependencia());
        getDependenciaForm().setIdPadre(getDependenciaForm().getDependencia().getDeIdDependenciaPadre());
        getDependenciaForm().setEstado(getDependenciaForm().getDependencia().getDeEstado());
       
        RequestContext.getCurrentInstance().update("formDependencia:formulario");
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

        if (getDependenciaForm().getSelectedNode() != null) {
           
            getDependenciaForm().setDependencia((Dependencia) getDependenciaForm().getSelectedNode().getData());
            
            cargaFormularioIngreso();

            RequestContext.getCurrentInstance().execute("PF('dialogDependencia').show();");
        } else {
            ponerMensajeError("Seleccione una Dependencia");
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
     * [$Author: Jorge Zúñiga $, $Date: 04/03/2016]</p>
     */
    public void muestraFormulario() {
        
        if(getDependenciaForm().getInstitucion().getInIdInstitucion()==null){
            ponerMensajeError("Seleccione una Institución");
        }
        else{
            getDependenciaForm().setDependencia(new Dependencia());

            if (getDependenciaForm().getSelectedNode() != null) {
                getDependenciaForm().getDependencia().setDeIdDependenciaPadre(((Dependencia) getDependenciaForm().getSelectedNode().getData()).getDeIdDependencia());
            }
            
            cargaFormularioIngreso();
            
            RequestContext.getCurrentInstance().execute("PF('dialogDependencia').show();");
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

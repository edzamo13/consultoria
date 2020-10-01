/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.resources;

import ec.hcam.DeunitblServiceRemote;
import ec.hcam.TipostblServiceRemote;
import ec.hcam.entity.Deunitbl;
import ec.hcam.entity.Tipostbl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Programacion
 */
@ManagedBean
@RequestScoped
public class DependenciaView {

    @EJB
    private DeunitblServiceRemote dependenciaService;
    @EJB
    private TipostblServiceRemote tiposDependenciaService;
    /**
     * Creates a new instance of DependenciaView
     */

    private Deunitbl dependencia;
    private List<Deunitbl> listDependencia;
    private Deunitbl selectedDependencia;

    /**
     * List constructor to use
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        listDependencia = dependenciaService.findAllDeunitbl();        
    }
    public List<Tipostbl> obtenerNombresTipoDependencia(){
       List<Tipostbl> TiposDepe= tiposDependenciaService.findAllTipostbl();
       return TiposDepe;
    }

    public Deunitbl getDependencia() {
        if (dependencia == null) {
            dependencia = new Deunitbl();
        }
        return dependencia;
    }

    public void setDependencia(Deunitbl dependencia) {
        this.dependencia = dependencia;
    }

    public List<Deunitbl> getListDependencia() {
        return listDependencia;
    }

    public void setListDependencia(List<Deunitbl> listDependencia) {
        this.listDependencia = listDependencia;
    }

    public DependenciaView() {
        selectedDependencia = new Deunitbl();
    }

    /**
     * Method to save the information of the objects of the class Tipostbl
     *
     * @param dependencia
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String save(Deunitbl dependencia) {
        dependenciaService.createDeunitbl(dependencia);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Guardado"));
        listDependencia.add(dependencia);
        this.dependencia = null;
        return "adminDependencia?faces-redirect=true";
    }

    /**
     * Method for editing the selection of bjetos Class Tipostbl
     *
     * @param dependencia
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String edit(Deunitbl dependencia) {
        dependenciaService.editDeunitbl(dependencia);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
        listDependencia.remove(dependencia);
        listDependencia.add(dependencia);
        return "adminDependencia?faces-redirect=true";
    }

    /**
     * Method for remove the selection of bjetos Class Tipostbl
     *
     * @param dependencia
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String remove(Deunitbl dependencia) {
        try {
            dependenciaService.removeDeunitbl(dependencia);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado"));
            listDependencia.remove(dependencia);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede eliminar este registro (Esta siendo usado por otro Catalogó)", ""));
        }
        return "adminDependencia?faces-redirect=true";
    }

    /**
     * Set the method for selecting an object of class Tipostbl
     *
     * @param dependencia
     * @since 1.0.0
     */
    public void setSelected(Deunitbl dependencia) {
        setSelectedDependencia(dependencia);
        RequestContext.getCurrentInstance().update("form-edit:gridEdit");
    }

    public Deunitbl getSelectedDependencia() {
        return selectedDependencia;
    }

    public void setSelectedDependencia(Deunitbl selectedDependencia) {
        this.selectedDependencia = selectedDependencia;
    }
}

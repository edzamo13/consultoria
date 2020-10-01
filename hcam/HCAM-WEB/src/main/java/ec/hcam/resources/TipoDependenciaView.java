/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.resources;

import ec.hcam.TipostblServiceRemote;
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
public class TipoDependenciaView {

    @EJB
    private TipostblServiceRemote tiposService;
    /**
     * Creates a new instance of CenterView
     */

    private Tipostbl tipos;
    private List<Tipostbl> listTipos;
    private Tipostbl selectedTipo;

    /**
     * List constructor to use
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        listTipos = tiposService.findAllTipostbl();
    }

    public Tipostbl getTipos() {
        if (tipos == null) {
            tipos = new Tipostbl();
        }
        return tipos;
    }

    public void setTipos(Tipostbl tipos) {
        this.tipos = tipos;
    }

    public List<Tipostbl> getListTipos() {
        return listTipos;
    }

    public void setListTipos(List<Tipostbl> listTipos) {
        this.listTipos = listTipos;
    }

    public TipoDependenciaView() {
        selectedTipo = new Tipostbl();
    }

    /**
     * Method to save the information of the objects of the class Tipostbl
     *
     * @param tipos
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String save(Tipostbl tipos) {
        tiposService.createTipostbl(tipos);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Guardado"));
        listTipos.add(tipos);
        this.tipos = null;
        return "adminTipoDependencia?faces-redirect=true";
    }

    /**
     * Method for editing the selection of bjetos Class Tipostbl
     *
     * @param tipos
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String edit(Tipostbl tipos) {
        tiposService.editTipostbl(tipos);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
        listTipos.remove(tipos);
        listTipos.add(tipos);
        return "adminTipoDependencia?faces-redirect=true";
    }

    /**
     * Method for remove the selection of bjetos Class Tipostbl
     *
     * @param tipos
     * @return a string with a navigation rule
     * @since 1.0.0
     */
    public String remove(Tipostbl tipos) {
        try {
            tiposService.removeTipostbl(tipos);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado"));
            listTipos.remove(tipos);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede eliminar este registro (Esta siendo usado por otro Catalogó)", ""));
        }
        return "adminTipoDependencia?faces-redirect=true";
    }

    /**
     * Set the method for selecting an object of class Tipostbl
     *
     * @param tipos
     * @since 1.0.0
     */
    public void setSelected(Tipostbl tipos) {
        setSelectedTipo(tipos);
        RequestContext.getCurrentInstance().update("form-edit:gridEdit");
    }

    public Tipostbl getSelectedTipo() {
        return selectedTipo;
    }

    public void setSelectedTipo(Tipostbl selectedTipo) {
        this.selectedTipo = selectedTipo;
    }
}

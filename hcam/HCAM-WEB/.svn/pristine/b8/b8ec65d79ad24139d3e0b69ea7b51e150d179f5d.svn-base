//
//package ec.hcam.resources;
//
////import ec.gob.ecu911.entity.Centers;
////import ec.gob.ecu911.service.CentersServiceRemote;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import org.primefaces.context.RequestContext;
//
//
//@ManagedBean
//@RequestScoped
//public class ServiciosView {
//    
//    @EJB
//    private CentersServiceRemote centersService;   
//    /**
//     * Creates a new instance of CenterView
//     */
//    
//    private Centers centers;
//    private List<Centers> listCenters;
//    private Centers selectedCenter;
//   /**
//   * List constructor to use
//   * @since 1.0.0
//   */
//    @PostConstruct
//    public void init() {
//        listCenters = centersService.findAllCenters();
//    }
//
//    public Centers getCenters() {
//        if (centers == null) {
//            centers = new Centers();
//        }        
//        return centers;
//    }
//
//    public void setCenters(Centers centers) {
//        this.centers = centers;
//    }
//
//    public List<Centers> getListCenters() {
//        return listCenters;
//    }
//
//    public void setListCenters(List<Centers> listCenters) {
//        this.listCenters = listCenters;
//    }       
//
//    public ServiciosView() { 
//        selectedCenter = new Centers();
//    }
//    /**
//     * Method to save the information of the objects of the class Centers
//     * @param centers an object of class Centers
//     * @return a string with a navigation rule
//     * @since 1.0.0
//     */
//    public String save(Centers centers) {
//        centersService.createCenter(centers);   
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Guardado"));
//        listCenters.add(centers);
//        this.centers = null;    
//        return "adminCenter?faces-redirect=true";
//    }
//    /**
//     * Method for editing the selection of bjetos Class Centers
//     * @param center an object of class Centers
//     * @return a string with a navigation rule
//     * @since 1.0.0
//     */
//    public String edit(Centers center){     
//        centersService.editCenter(center);
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
//        listCenters.remove(center);
//        listCenters.add(center);
//        return "adminCenter?faces-redirect=true";
//    }
//    /**
//     * Method for remove the selection of bjetos Class Centers
//     * @param center an object of class Centers
//     * @return a string with a navigation rule
//     * @since 1.0.0
//     */
//    public String remove(Centers center){
//        try{
//        centersService.removeCenter(center);
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado"));
//        listCenters.remove(center); 
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede eliminar este registro (Esta siendo usado por otro Catalogó)", ""));
//        }
//        return "adminCenter?faces-redirect=true";
//    }
//    /**
//     * Set the method for selecting an object of class Centers
//     * @param centers an object of class Centers
//     * @since 1.0.0
//     */    
//    public void setSelected(Centers centers){     
//        setSelectedCenter(centers);
//        RequestContext.getCurrentInstance().update("form-edit:gridEdit");     
//    }
//
//    public Centers getSelectedCenter() {
//        return selectedCenter;
//    }
//
//    public void setSelectedCenter(Centers selectedCenter) {
//        this.selectedCenter = selectedCenter;
//    }   
//}

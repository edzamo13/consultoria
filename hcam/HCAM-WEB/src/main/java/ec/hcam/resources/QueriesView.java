package ec.hcam.resources;

import ec.hcam.entity.Consultbl;
import ec.hcam.entity.Servtbl;
import ec.hcam.ConsultblServiceRemote;
import ec.hcam.ServtblServiceRemote;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class QueriesView implements Serializable {

    @EJB
    private ConsultblServiceRemote queryService;

    @EJB
    private ServtblServiceRemote serviceService;
    
    
    public QueriesView() {
        selectedQuery = new Consultbl();
    }

    @PostConstruct
    public void init() {
        
        // CONSULTAS
        setLstQueries(queryService.findAllConsultbl());

        System.out.println("lstqueries.size(): " + lstQueries.size());
        for (Consultbl query : lstQueries) {
            System.out.println("Consulta: " + query.getCosql());
        }

        //SERVICIOS
        setLstServicios(serviceService.findAllServtbl());
        System.out.println("services.size(): " + lstServicios.size());
        for (Servtbl service : lstServicios) {
            System.out.println("servicio: " + service.getSenombre());
        }

        //ID SERVICIO
        servicio = new Servtbl();
        servicio.setSeidpk(1);

    }

    /*
    PRUEBA SERVICIO
    */
    private Servtbl servicio;
    
    public Servtbl getServicio() {
        return servicio;
    }

    public void setServicio(Servtbl servicio) {
        this.servicio = servicio;
    }
    

    /*
     LISTA DE SERVICIOS
     */
    private List<Servtbl> lstServicios;

    public List<Servtbl> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(List<Servtbl> lstServicios) {
        this.lstServicios = lstServicios;
    }

    /*
     ENTIDAD QUERY
     */
    private Consultbl query;

    public Consultbl getQueryENTIDAD() {
        if (query == null) {
            query = new Consultbl();
        }
        return query;
    }

    public void setQueryENTIDAD(Consultbl queryENTIDAD) {
        this.query = queryENTIDAD;
    }

    /*
     LISTA QUERIES
     */
    private List<Consultbl> lstQueries;

    public List<Consultbl> getLstQueries() {
        return lstQueries;
    }

    public void setLstQueries(List<Consultbl> lstQueries) {
        this.lstQueries = lstQueries;
    }

    /*
     SELECTED QUERY
     */
    private Consultbl selectedQuery;

    public Consultbl getSelectedQuery() {
        return selectedQuery;
    }

    public void setSelectedQuery(Consultbl selectedQuery) {
        this.selectedQuery = selectedQuery;
    }

    /*
     SET SELECTED QUERY
     */
    public void setSelected(Consultbl query) {
        setSelectedQuery(query);
        RequestContext.getCurrentInstance().update("form-edit:gridEdit");
    }

    //SAVE
    public String save(Consultbl query) {

        //////////// PRUEBA
        queryService.createConsultbl(query);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Guardado"));
        getLstQueries().add(query);
        this.setQueryENTIDAD(null);
        return "adminQueries?faces-redirect=true";
    }

    //EDIT
    public String edit(Consultbl query) {
        queryService.editConsultbl(query);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
        getLstQueries().remove(query);
        getLstQueries().add(query);
        return "adminQueries?faces-redirect=true";
    }

    //REMOVE
    public String remove(Consultbl query) {
        
        System.out.println("consulta:" + query.getCosql());
        System.out.println("id:" + query.getCopk());

        try {

            queryService.removeConsultbl(query);
            System.out.println("Despues de eliminar");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Eliminado"));
            getLstQueries().remove(query);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puede eliminar este registro (Esta siendo usado por otro Catalogo)", ""));
        }
        return "adminQueries?faces-redirect=true";
    }

    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Serviciotbl;
import ec.hcam.jpa.ServiciotblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class ServiciotblService implements ServiciotblServiceRemote {

    @EJB
    private ServiciotblFacadeRemote serviciotblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createServiciotbl(Serviciotbl serviciotbl) {
        serviciotblFacade.create(serviciotbl);
    }

    @Override
    public void editServiciotbl(Serviciotbl serviciotbl) {
        serviciotblFacade.edit(serviciotbl);
    }

    @Override
    public void removeServiciotbl(Serviciotbl serviciotbl) {
        serviciotblFacade.remove(serviciotbl);
    }

    @Override
    public Serviciotbl findServiciotblById(Object id) {
        return serviciotblFacade.find(id);
    }

    @Override
    public List<Serviciotbl> findAllServiciotbls() {
        return serviciotblFacade.findAll();
    }

    @Override
    public List<Serviciotbl> findServiciotblbyRange(int[] range) {
        return serviciotblFacade.findRange(range);
    }

    @Override
    public int countServiciotbls() {
        return serviciotblFacade.count();
    }    

    @Override
    public List<Serviciotbl> findAllServicesWithUnidadMedicaID(int idUnidadMedica) {
        return serviciotblFacade.findAllServicesWithDependenciaID(idUnidadMedica);
    }
}

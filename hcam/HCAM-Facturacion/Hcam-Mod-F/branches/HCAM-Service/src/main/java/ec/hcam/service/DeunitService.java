/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Deunitbl;
import ec.hcam.jpa.DeunitblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class DeunitService implements DeunitServiceRemote {

    @EJB
    private DeunitblFacadeRemote deunitblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.create(deunitbl);
    }

    @Override
    public void editDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.edit(deunitbl);
    }

    @Override
    public void removeDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.remove(deunitbl);
    }

    @Override
    public Deunitbl findDeunitblbyId(Object id) {
        return deunitblFacade.find(id);
    }

    @Override
    public List<Deunitbl> findAllDeunitbls() {
        return deunitblFacade.findAll();
    }

    @Override
    public List<Deunitbl> findDeunitblbyRange(int[] range) {
        return deunitblFacade.findRange(range);
    }

    @Override
    public int countDeunitbls() {
        return deunitblFacade.count();
    }

    @Override
    public List<Deunitbl> findAllDependenciasWithUnidadMedicaID(int idUnidadMedica) {
        return deunitblFacade.findAllDependenciasWithUnidMedicaID(idUnidadMedica);
    }

    
    
    
}

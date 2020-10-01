/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Tarifartbl;
import ec.hcam.jpa.TarifartblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class TarifartblService implements TarifartblServiceRemote {

    @EJB
    private TarifartblFacadeRemote tarifartblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createTarifartbl(Tarifartbl tarifartbl) {
        tarifartblFacade.create(tarifartbl);
    }

    @Override
    public void editTarifartbl(Tarifartbl tarifartbl) {
        tarifartblFacade.edit(tarifartbl);
    }

    @Override
    public void removeTarifartbl(Tarifartbl tarifartbl) {
        tarifartblFacade.remove(tarifartbl);
    }

    @Override
    public Tarifartbl findTarifartblById(Object id) {
        return tarifartblFacade.find(id);
    }

    @Override
    public List<Tarifartbl> findAllTarifartbls() {
        return tarifartblFacade.findAll();
    }

    @Override
    public List<Tarifartbl> findTarifartblByRange(int[] range) {
        return tarifartblFacade.findRange(range);
    }

    @Override
    public int countTarifartbls() {
        return tarifartblFacade.count();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Tipostbl;
import ec.hcam.jpa.TipostblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class TipostblService implements TipostblServiceRemote {

    @EJB    
    private TipostblFacadeRemote tipostblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createTipostbl(Tipostbl tipostbl) {
        tipostblFacade.create(tipostbl);
    }

    @Override
    public void editTipostbl(Tipostbl tipostbl) {
        tipostblFacade.edit(tipostbl);
    }

    @Override
    public void removeTipostbl(Tipostbl tipostbl) {
        tipostblFacade.remove(tipostbl);
    }

    @Override
    public Tipostbl findTipostblById(Object id) {
        return tipostblFacade.find(id);
    }

    @Override
    public List<Tipostbl> findAllTipostbls() {
        return tipostblFacade.findAll();
    }

    @Override
    public List<Tipostbl> findTipostblByRange(int[] range) {
        return tipostblFacade.findRange(range);
    }

    @Override
    public int countTipostbls() {
        return tipostblFacade.count();
    }
    
    
}

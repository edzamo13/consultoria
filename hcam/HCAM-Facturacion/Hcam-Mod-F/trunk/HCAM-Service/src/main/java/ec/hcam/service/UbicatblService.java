/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Ubicatbl;
import ec.hcam.jpa.UbicatblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class UbicatblService implements UbicatblServiceRemote {

    @EJB    
    private UbicatblFacadeRemote ubicatblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createUbicatbl(Ubicatbl ubicatbl) {
        ubicatblFacade.create(ubicatbl);
    }

    @Override
    public void editUbicatbl(Ubicatbl ubicatbl) {
        ubicatblFacade.edit(ubicatbl);
    }

    @Override
    public void removeUbicatbl(Ubicatbl ubicatbl) {
        ubicatblFacade.remove(ubicatbl);
    }

    @Override
    public Ubicatbl findUbicatblById(Object id) {
        return ubicatblFacade.find(id);
    }

    @Override
    public List<Ubicatbl> findAllUbicatbls() {
        return ubicatblFacade.findAll();
    }

    @Override
    public List<Ubicatbl> findUbicatblByRange(int[] range) {
        return ubicatblFacade.findRange(range);
    }

    @Override
    public int countUbicatbls() {
        return ubicatblFacade.count();
    }  
    
}

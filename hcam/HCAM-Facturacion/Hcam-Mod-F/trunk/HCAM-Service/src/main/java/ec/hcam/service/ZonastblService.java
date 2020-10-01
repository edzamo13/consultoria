/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Zonastbl;
import ec.hcam.jpa.ZonastblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class ZonastblService implements ZonastblServiceRemote {

    @EJB
    private ZonastblFacadeRemote zonastblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createZonastbl(Zonastbl zonastbl) {
        zonastblFacade.create(zonastbl);
    }

    @Override
    public void editZonastbl(Zonastbl zonastbl) {
        zonastblFacade.edit(zonastbl);
    }

    @Override
    public void removeZonastbl(Zonastbl zonastbl) {
        zonastblFacade.remove(zonastbl);
    }

    @Override
    public Zonastbl findZonastblById(Object id) {
        return zonastblFacade.find(id);
    }

    @Override
    public List<Zonastbl> findAllZonastbl() {
        return zonastblFacade.findAll();
    }

    @Override
    public List<Zonastbl> findZonastblByRange(int[] range) {
        return zonastblFacade.findRange(range);
    }

    @Override
    public int countZonastbl() {
        return zonastblFacade.count();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Detplantbl;
import ec.hcam.jpa.DetplantblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class DetplanService implements DetplanServiceRemote {
    
    @EJB
    private DetplantblFacadeRemote detplantblFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createDetplan(Detplantbl detplantbl) {
        detplantblFacade.create(detplantbl);
    }

    @Override
    public void editDetplan(Detplantbl detplantbl) {
        detplantblFacade.edit(detplantbl);
    }

    @Override
    public void removeDetplan(Detplantbl detplantbl) {
        detplantblFacade.remove(detplantbl);
    }

    @Override
    public Detplantbl findDetplan(Object id) {
        return detplantblFacade.find(id);
    }

    @Override
    public List<Detplantbl> findAllDetplantbls() {
        return detplantblFacade.findAll();
    }

    @Override
    public List<Detplantbl> findDetplanbyRange(int[] range) {
        return detplantblFacade.findRange(range);
    }

    @Override
    public int countDetplantbls() {
        return detplantblFacade.count();
    }
    
    
}

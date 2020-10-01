/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Cabplantbl;
import ec.hcam.jpa.CabplantblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class CabplanService implements CabplanServiceRemote {

    @EJB
    private CabplantblFacadeRemote cabplanttblFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createCabplant(Cabplantbl cabplantbl) {
        cabplanttblFacade.create(cabplantbl);
    }

    @Override
    public void editCabplant(Cabplantbl cabplantbl) {
        cabplanttblFacade.edit(cabplantbl);
    }

    @Override
    public void removeCabplant(Cabplantbl cabplantbl) {
        cabplanttblFacade.remove(cabplantbl);
    }

    @Override
    public Cabplantbl findCabplantbyId(Object id) {
        return cabplanttblFacade.find(id);
    }

    @Override
    public List<Cabplantbl> findAll() {
        return cabplanttblFacade.findAll();
    }

    @Override
    public List<Cabplantbl> findCabplantbyRange(int[] range) {
        return cabplanttblFacade.findRange(range);
    }

    @Override
    public int count() {
        return cabplanttblFacade.count();
    }    
}

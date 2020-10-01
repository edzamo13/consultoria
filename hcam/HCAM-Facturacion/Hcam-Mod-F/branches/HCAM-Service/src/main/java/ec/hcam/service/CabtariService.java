/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Cabtaritbl;
import ec.hcam.jpa.CabtaritblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class CabtariService implements CabtariServiceRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private CabtaritblFacadeRemote cabtaritblFacade;

    @Override
    public void createCabtari(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.create(cabtaritbl);
    }

    @Override
    public void editCabtari(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.edit(cabtaritbl);
    }

    @Override
    public void removeCabtari(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.remove(cabtaritbl);
    }

    @Override
    public Cabtaritbl findCabtaritblbyId(Object id) {
        return cabtaritblFacade.find(id);
    }

    @Override
    public List<Cabtaritbl> findAllCabtaritbls() {
        return cabtaritblFacade.findAll();
    }

    @Override
    public List<Cabtaritbl> findCabtaritblbyRange(int[] range) {
        return cabtaritblFacade.findRange(range);
    }

    @Override
    public int countCabtaritbls() {
        return cabtaritblFacade.count();
    }
    
    
    
}

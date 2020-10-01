/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Unidmedtbl;
import ec.hcam.jpa.UnidmedtblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author programacion
 */
@Stateless
public class UnidmedtblService implements UnidmedtblServiceRemote {

    @EJB
    private UnidmedtblFacadeRemote unidmedtblFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createUnidmedtbl(Unidmedtbl unidmedtbl) {
        unidmedtblFacade.create(unidmedtbl);
    }

    @Override
    public void editUnidmedtbl(Unidmedtbl unidmedtbl) {
        unidmedtblFacade.edit(unidmedtbl);
    }

    @Override
    public void removeUnidmedtbl(Unidmedtbl unidmedtbl) {
        unidmedtblFacade.remove(unidmedtbl);
    }

    @Override
    public Unidmedtbl findUnidmedtblById(Object id) {
        return unidmedtblFacade.find(id);
    }

    @Override
    public List<Unidmedtbl> findAllUnidmedtbls() {
        return unidmedtblFacade.findAll();
    }

    @Override
    public List<Unidmedtbl> findUnidmedtblByRange(int[] range) {
        return unidmedtblFacade.findRange(range);
    }

    @Override
    public int countUnidmedtbls() {
        return unidmedtblFacade.count();
    }    
}

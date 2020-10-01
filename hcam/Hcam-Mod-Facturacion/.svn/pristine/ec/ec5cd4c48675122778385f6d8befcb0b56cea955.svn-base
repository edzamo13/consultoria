/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Parmfactbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class ParmfactblService implements ParmfactblServiceRemote {

    @EJB
    ParmfactblFacadeRemote parmfactblFacade;

    public void createParmfactbl(Parmfactbl parmfactbl) {
        parmfactblFacade.create(parmfactbl);
    }

    public void editParmfactbl(Parmfactbl parmfactbl) {
        parmfactblFacade.edit(parmfactbl);
    }

    public void removeParmfactbl(Parmfactbl parmfactbl) {
        parmfactblFacade.remove(parmfactbl);
    }

    public Parmfactbl findParmfactblById(Object id) {
        return parmfactblFacade.find(id);
    }

    public List<Parmfactbl> findAllParmfactbl() {
        return parmfactblFacade.findAll();
    }

    public List<Parmfactbl> findParmfactblByRange(int[] range) {
        return parmfactblFacade.findRange(range);
    }

    public int countParmfactbl() {
        return parmfactblFacade.count();
    }
    
}

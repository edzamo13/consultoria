/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Esttbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class EsttblService implements EsttblServiceRemote {

    @EJB 
    EsttblFacadeRemote esttblFacade;

    public void createEsttbl(Esttbl esttbl) {
        esttblFacade.create(esttbl);
    }

    public void editEsttbl(Esttbl esttbl) {
        esttblFacade.edit(esttbl);
    }

    public void removeEsttbl(Esttbl esttbl) {
        esttblFacade.remove(esttbl);
    }

    public Esttbl findEsttblById(Object id) {
        return esttblFacade.find(id);
    }

    public List<Esttbl> findAllEsttbl() {
        return esttblFacade.findAll();
    }

    public List<Esttbl> findEsttblByRange(int[] range) {
        return esttblFacade.findRange(range);
    }

    public int countEsttbl() {
        return esttblFacade.count();
    }
    
}

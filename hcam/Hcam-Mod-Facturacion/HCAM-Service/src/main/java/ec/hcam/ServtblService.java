/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Servtbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class ServtblService implements ServtblServiceRemote {

    @EJB
    ServtblFacadeRemote servtblFacade;

    public void createServtbl(Servtbl servtbl) {
        servtblFacade.create(servtbl);
    }

    public void editServtbl(Servtbl servtbl) {
        servtblFacade.edit(servtbl);
    }

    public void removeServtbl(Servtbl servtbl) {
        servtblFacade.remove(servtbl);
    }

    public Servtbl findServtblById(Object id) {
        return servtblFacade.find(id);
    }

    public List<Servtbl> findAllServtbl() {
        return servtblFacade.findAll();
    }

    public List<Servtbl> findServtblByRange(int[] range) {
        return servtblFacade.findRange(range);
    }

    public int countServtbl() {
        return servtblFacade.count();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Histclitbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class HistclitblService implements HistclitblServiceRemote {

    @EJB
    HistclitblFacadeRemote histclitblFacade;

    public void createHistclitbl(Histclitbl histclitbl) {
        histclitblFacade.create(histclitbl);
    }

    public void editHistclitbl(Histclitbl histclitbl) {
        histclitblFacade.edit(histclitbl);
    }

    public void removeHistclitbl(Histclitbl histclitbl) {
        histclitblFacade.remove(histclitbl);
    }

    public Histclitbl findHistclitblById(Object id) {
        return histclitblFacade.find(id);
    }

    public List<Histclitbl> findAllHistclitbl() {
        return histclitblFacade.findAll();
    }

    public List<Histclitbl> findHistclitblByRange(int[] range) {
        return histclitblFacade.findRange(range);
    }

    public int countHistclitbl() {
        return histclitblFacade.count();
    }
    
}

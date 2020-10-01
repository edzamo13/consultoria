/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Esquematbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class EsquematblService implements EsquematblServiceRemote {

    @EJB
    EsquematblFacadeRemote esquematblFacade;

    public void createEsquematbl(Esquematbl esquematbl) {
        esquematblFacade.create(esquematbl);
    }

    public void editEsquematbl(Esquematbl esquematbl) {
        esquematblFacade.edit(esquematbl);
    }

    public void removeEsquematbl(Esquematbl esquematbl) {
        esquematblFacade.remove(esquematbl);
    }

    public Esquematbl findEsquematblById(Object id) {
        return esquematblFacade.find(id);
    }

    public List<Esquematbl> findAllEsquematbl() {
        return esquematblFacade.findAll();
    }

    @Override
    public List<Esquematbl> findEsquematblByRange(int[] range) {
        return esquematblFacade.findRange(range);
    }

    public int countEsquematbl() {
        return esquematblFacade.count();
    }
    
}

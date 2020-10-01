/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Cabtaritbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class CabtaritblService implements CabtaritblServiceRemote {

    @EJB
    CabtaritblFacadeRemote cabtaritblFacade;

    public void createCabtaritbl(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.create(cabtaritbl);
    }

    public void editCabtaritbl(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.edit(cabtaritbl);
    }

    public void removeCabtaritbl(Cabtaritbl cabtaritbl) {
        cabtaritblFacade.remove(cabtaritbl);
    }

    public Cabtaritbl findCabtaritblById(Object id) {
        return cabtaritblFacade.find(id);
    }

    public List<Cabtaritbl> findAllCabtaritbl() {
        return cabtaritblFacade.findAll();
    }

    public List<Cabtaritbl> findCabtaritblByRange(int[] range) {
        return cabtaritblFacade.findRange(range);
    }

    public int countCabtaritbl() {
        return cabtaritblFacade.count();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Formutbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class FormutblService implements FormutblServiceRemote {

    @EJB
    FormutblFacadeRemote  formutblFacade;

    public void createFormutbl(Formutbl formutbl) {
        formutblFacade.create(formutbl);
    }

    public void editFormutbl(Formutbl formutbl) {
        formutblFacade.edit(formutbl);
    }

    public void removeFormutbl(Formutbl formutbl) {
        formutblFacade.remove(formutbl);
    }

    public Formutbl findFormutblById(Object id) {
        return formutblFacade.find(id);
    }

        public List<Formutbl> findAllFormutbl() {
        return formutblFacade.findAll();
    }

    public List<Formutbl> findFormutblByRange(int[] range) {
        return formutblFacade.findRange(range);
    }

    public int countFormutbl() {
        return formutblFacade.count();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Consultbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class ConsultblService implements ConsultblServiceRemote {

    @EJB
    ConsultblFacadeRemote consultblFacade;

    public void createConsultbl(Consultbl consultbl) {
        consultblFacade.create(consultbl);
    }

    public void editConsultbl(Consultbl consultbl) {
        consultblFacade.edit(consultbl);
    }

    public void removeConsultbl(Consultbl consultbl) {
        consultblFacade.remove(consultbl);
    }

    public Consultbl findConsultblById(Object id) {
        return consultblFacade.find(id);
    }

    public List<Consultbl> findAllConsultbl() {
        return consultblFacade.findAll();
    }

    public List<Consultbl> findConsultblByRange(int[] range) {
        return consultblFacade.findRange(range);
    }

    public int countConsultbl() {
        return consultblFacade.count();
    }
    
}

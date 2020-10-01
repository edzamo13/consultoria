/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Detplantbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class DetplantblService implements DetplantblServiceRemote {

    @EJB
    DetplantblFacadeRemote detplantblFacade;

    @Override
    public void createDetplantbl(Detplantbl detplantbl) {
        detplantblFacade.create(detplantbl);
    }

    public void editDetplantbl(Detplantbl detplantbl) {
        detplantblFacade.edit(detplantbl);
    }

    public void removeDetplantbl(Detplantbl detplantbl) {
        detplantblFacade.remove(detplantbl);
    }

    public Detplantbl findDetplantblById(Object id) {
        return detplantblFacade.find(id);
    }

    public List<Detplantbl> findAllDetplantbl() {
        return detplantblFacade.findAll();
    }

    public List<Detplantbl> findDetplantblByRange(int[] range) {
        return detplantblFacade.findRange(range);
    }

    public int countDetplantbl() {
        return detplantblFacade.count();
    }

}

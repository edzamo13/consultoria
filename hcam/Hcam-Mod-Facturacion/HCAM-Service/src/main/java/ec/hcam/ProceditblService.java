/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Proceditbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class ProceditblService implements ProceditblServiceRemote {

    @EJB
    ProceditblFacadeRemote proceditblFacade;

    public void createProceditbl(Proceditbl proceditbl) {
        proceditblFacade.create(proceditbl);
    }

    public void editProceditbl(Proceditbl proceditbl) {
        proceditblFacade.edit(proceditbl);
    }

    public void removeProceditbl(Proceditbl proceditbl) {
        proceditblFacade.remove(proceditbl);
    }

    public Proceditbl findProceditblById(Object id) {
        return proceditblFacade.find(id);
    }

    public List<Proceditbl> findAllProceditbl() {
        return proceditblFacade.findAll();
    }

    public List<Proceditbl> findProceditblByRange(int[] range) {
        return proceditblFacade.findRange(range);
    }

    public int countProceditbl() {
        return proceditblFacade.count();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Areatbl;
import ec.hcam.jpa.AreatblFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AreaService implements AreaServiceRemote {

    @EJB
    private AreatblFacadeRemote areatblFacade;


    @Override
    public void createArea(Areatbl areatbl) {
        areatblFacade.create(areatbl);
    }

    @Override
    public void editArea(Areatbl areatbl) {
        areatblFacade.edit(areatbl);
    }

    @Override
    public void removeArea(Areatbl areatbl) {
        areatblFacade.remove(areatbl);
    }

    @Override
    public Areatbl findAreaById(int id) {
        return areatblFacade.find(id);
    }

    @Override
    public List<Areatbl> findAllAreatbls() {
        return areatblFacade.findAll();
    }

    @Override
    public List<Areatbl> findAreatblsByRange(int[] range) {
        return areatblFacade.findRange(range);
    }

    @Override
    public int countAreatbls() {
        return areatblFacade.count();
    }

}

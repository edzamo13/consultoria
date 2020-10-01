/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Areatbl;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
@LocalBean
public class AreatblService implements AreatblServiceRemote {

    @EJB
    private AreatblFacadeRemote areatblfacade;

    @Override
    public void createArea(Areatbl areatbl) {
        areatblfacade.create(areatbl);
    }

    @Override
    public void editArea(Areatbl areatbl) {
        areatblfacade.edit(areatbl);
    }

    @Override
    public void removeArea(Areatbl areatbl) {
        areatblfacade.remove(areatbl);
    }

    public Areatbl findAreaById(Object id) {
        return areatblfacade.find(id);
    }



    public List<Areatbl> findAreaByRange(int[] range) {
        return areatblfacade.findRange(range);
    }

    public int countArea() {
        return areatblfacade.count();
    }

    @Override
    public List<Areatbl> findAll() {
        List<Areatbl> tmp=new ArrayList<Areatbl>();
        tmp=areatblfacade.findAll();
        for (Areatbl t : tmp) {
            System.out.println("service: "+t.getUbnombre());
        }
      return tmp;
        
    }

  
}

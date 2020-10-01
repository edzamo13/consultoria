/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.jpa;

import ec.hcam.entities.Ubicatbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface UbicatblFacadeRemote {

    void create(Ubicatbl ubicatbl);

    void edit(Ubicatbl ubicatbl);

    void remove(Ubicatbl ubicatbl);

    Ubicatbl find(Object id);

    List<Ubicatbl> findAll();

    List<Ubicatbl> findRange(int[] range);

    int count();
    
}

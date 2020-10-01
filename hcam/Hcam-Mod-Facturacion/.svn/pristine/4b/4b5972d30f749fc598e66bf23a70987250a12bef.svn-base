/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Parmfactbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ParmfactblFacadeRemote {

    void create(Parmfactbl parmfactbl);

    void edit(Parmfactbl parmfactbl);

    void remove(Parmfactbl parmfactbl);

    Parmfactbl find(Object id);

    List<Parmfactbl> findAll();

    List<Parmfactbl> findRange(int[] range);

    int count();
    
}

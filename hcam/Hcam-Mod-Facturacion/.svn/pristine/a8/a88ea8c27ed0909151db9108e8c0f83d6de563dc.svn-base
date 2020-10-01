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
public interface ParmfactblServiceRemote {
    void createParmfactbl(Parmfactbl parmfactbl);
    void editParmfactbl(Parmfactbl parmfactbl);
    void removeParmfactbl(Parmfactbl parmfactbl);
    Parmfactbl findParmfactblById(Object id);
    List<Parmfactbl> findAllParmfactbl();
    List<Parmfactbl> findParmfactblByRange(int[] range);
    int countParmfactbl();
}

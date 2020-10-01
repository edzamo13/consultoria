/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Ubicatbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface UbicatblServiceRemote {
    
    void createUbicatbl(Ubicatbl ubicatbl);
    
    void editUbicatbl(Ubicatbl ubicatbl);
    
    void removeUbicatbl(Ubicatbl ubicatbl);
    
    Ubicatbl findUbicatblById(Object id);
    
    List<Ubicatbl> findAllUbicatbls();
    
    List<Ubicatbl> findUbicatblByRange(int[] range);
    
    int countUbicatbls();
}

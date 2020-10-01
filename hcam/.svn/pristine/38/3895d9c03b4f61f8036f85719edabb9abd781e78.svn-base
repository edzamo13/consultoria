/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Tipostbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface TipostblServiceRemote {
    
    void createTipostbl(Tipostbl tipostbl);
    
    void editTipostbl(Tipostbl tipostbl);
    
    void removeTipostbl(Tipostbl tipostbl);
    
    Tipostbl findTipostblById(Object id);
    
    List<Tipostbl> findAllTipostbls();
    
    List<Tipostbl> findTipostblByRange(int[] range);
    
    int countTipostbls();            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Zonastbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface ZonastblServiceRemote {
    
    void createZonastbl(Zonastbl zonastbl);
    
    void editZonastbl(Zonastbl zonastbl);
    
    void removeZonastbl(Zonastbl zonastbl);
    
    Zonastbl findZonastblById(Object id);
    
    List<Zonastbl> findAllZonastbl();
    
    List<Zonastbl> findZonastblByRange(int[] range);
    
    int countZonastbl();
    
    
}

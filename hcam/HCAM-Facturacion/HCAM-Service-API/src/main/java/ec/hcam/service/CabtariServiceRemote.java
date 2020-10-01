/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Cabtaritbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface CabtariServiceRemote {
    
    void createCabtari(Cabtaritbl cabtaritbl);
    
    void editCabtari(Cabtaritbl cabtaritbl);
    
    void removeCabtari(Cabtaritbl cabtaritbl);
    
    Cabtaritbl findCabtaritblbyId(Object id);
    
    List<Cabtaritbl> findAllCabtaritbls();
    
    List<Cabtaritbl> findCabtaritblbyRange(int[] range);
    
    int countCabtaritbls();
    
}

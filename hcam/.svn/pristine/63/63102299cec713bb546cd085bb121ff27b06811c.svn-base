/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Tarifartbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface TarifartblServiceRemote {
    
    void createTarifartbl(Tarifartbl tarifartbl);
    
    void editTarifartbl(Tarifartbl tarifartbl);
    
    void removeTarifartbl(Tarifartbl tarifartbl);
    
    Tarifartbl findTarifartblById(Object id);
    
    List<Tarifartbl> findAllTarifartbls();
    
    List<Tarifartbl> findTarifartblByRange(int[] range);
    
    int countTarifartbls();
}

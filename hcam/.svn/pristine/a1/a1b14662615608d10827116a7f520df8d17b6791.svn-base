/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.hcam.service;

import ec.hcam.entities.Deunitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */

@Remote
public interface DeunitServiceRemote {
    
    void createDeunitbl(Deunitbl deunitbl);
    
    void editDeunitbl(Deunitbl deunitbl);
    
    void removeDeunitbl(Deunitbl deunitbl);
    
    Deunitbl findDeunitblbyId(Object id);
    
    List<Deunitbl> findAllDeunitbls();
    
    List<Deunitbl> findDeunitblbyRange(int[] range);
    
    int countDeunitbls();
    
    List<Deunitbl> findAllDependenciasWithUnidadMedicaID(int idUnidadMedica);
       
}

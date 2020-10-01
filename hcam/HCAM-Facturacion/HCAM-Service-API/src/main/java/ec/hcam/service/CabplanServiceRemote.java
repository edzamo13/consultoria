/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Cabplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface CabplanServiceRemote {
    
    void createCabplant(Cabplantbl cabplantbl);
    
    void editCabplant(Cabplantbl cabplantbl);
    
    void removeCabplant(Cabplantbl cabplantbl);
    
    Cabplantbl findCabplantbyId(Object id);
    
    List<Cabplantbl> findAll();
    
    List<Cabplantbl> findCabplantbyRange(int[] range);
    
    int count();
}

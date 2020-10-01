/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Detplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface DetplanServiceRemote {
    
    void createDetplan(Detplantbl detplantbl);
    
    void editDetplan(Detplantbl detplantbl);
    
    void removeDetplan(Detplantbl detplantbl);
    
    Detplantbl findDetplan(Object id);
    
    List<Detplantbl> findAllDetplantbls();
    
    List<Detplantbl> findDetplanbyRange(int[] range);
    
    int countDetplantbls();
    
}

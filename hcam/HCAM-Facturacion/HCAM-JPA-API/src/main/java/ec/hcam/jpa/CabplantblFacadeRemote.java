/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.jpa;

import ec.hcam.entities.Cabplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface CabplantblFacadeRemote {

    void create(Cabplantbl cabplantbl);

    void edit(Cabplantbl cabplantbl);

    void remove(Cabplantbl cabplantbl);

    Cabplantbl find(Object id);

    List<Cabplantbl> findAll();

    List<Cabplantbl> findRange(int[] range);

    int count();
    
}

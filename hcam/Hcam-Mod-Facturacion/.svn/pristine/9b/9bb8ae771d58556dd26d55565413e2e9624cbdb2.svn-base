/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Esttbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface EsttblFacadeRemote {

    void create(Esttbl esttbl);

    void edit(Esttbl esttbl);

    void remove(Esttbl esttbl);

    Esttbl find(Object id);

    List<Esttbl> findAll();

    List<Esttbl> findRange(int[] range);

    int count();
    
}

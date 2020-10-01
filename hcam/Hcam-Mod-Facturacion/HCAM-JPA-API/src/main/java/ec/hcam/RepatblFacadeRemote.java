/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Repatbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface RepatblFacadeRemote {

    void create(Repatbl repatbl);

    void edit(Repatbl repatbl);

    void remove(Repatbl repatbl);

    Repatbl find(Object id);

    List<Repatbl> findAll();

    List<Repatbl> findRange(int[] range);

    int count();
    
}

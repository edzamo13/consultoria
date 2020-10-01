/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Servtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ServtblFacadeRemote {

    void create(Servtbl servtbl);

    void edit(Servtbl servtbl);

    void remove(Servtbl servtbl);

    Servtbl find(Object id);

    List<Servtbl> findAll();

    List<Servtbl> findRange(int[] range);

    int count();
    
}

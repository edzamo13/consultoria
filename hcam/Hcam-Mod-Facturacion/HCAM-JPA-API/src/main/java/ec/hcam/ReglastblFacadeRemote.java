/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Reglastbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ReglastblFacadeRemote {

    void create(Reglastbl reglastbl);

    void edit(Reglastbl reglastbl);

    void remove(Reglastbl reglastbl);

    Reglastbl find(Object id);

    List<Reglastbl> findAll();

    List<Reglastbl> findRange(int[] range);

    int count();
    
}

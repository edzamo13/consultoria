/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Paranivetbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface ParanivetblFacadeRemote {

    void create(Paranivetbl paranivetbl);

    void edit(Paranivetbl paranivetbl);

    void remove(Paranivetbl paranivetbl);

    Paranivetbl find(Object id);

    List<Paranivetbl> findAll();

    List<Paranivetbl> findRange(int[] range);

    int count();
    
}

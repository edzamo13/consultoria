/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.jpa;

import ec.hcam.entities.Cabtaritbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface CabtaritblFacadeRemote {

    void create(Cabtaritbl cabtaritbl);

    void edit(Cabtaritbl cabtaritbl);

    void remove(Cabtaritbl cabtaritbl);

    Cabtaritbl find(Object id);

    List<Cabtaritbl> findAll();

    List<Cabtaritbl> findRange(int[] range);

    int count();
    
}

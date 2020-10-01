/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Tipoacrtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface TipoacrtblFacadeRemote {

    void create(Tipoacrtbl tipoacrtbl);

    void edit(Tipoacrtbl tipoacrtbl);

    void remove(Tipoacrtbl tipoacrtbl);

    Tipoacrtbl find(Object id);

    List<Tipoacrtbl> findAll();

    List<Tipoacrtbl> findRange(int[] range);

    int count();
    
}

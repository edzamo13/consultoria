/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Unidmedtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface UnidmedtblFacadeRemote {

    void create(Unidmedtbl unidmedtbl);

    void edit(Unidmedtbl unidmedtbl);

    void remove(Unidmedtbl unidmedtbl);

    Unidmedtbl find(Object id);

    List<Unidmedtbl> findAll();

    List<Unidmedtbl> findRange(int[] range);

    int count();
    
}

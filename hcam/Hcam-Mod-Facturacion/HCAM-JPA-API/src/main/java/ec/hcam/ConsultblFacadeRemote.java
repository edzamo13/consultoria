/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Consultbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ConsultblFacadeRemote {

    void create(Consultbl consultbl);

    void edit(Consultbl consultbl);

    void remove(Consultbl consultbl);

    Consultbl find(Object id);

    List<Consultbl> findAll();

    List<Consultbl> findRange(int[] range);

    int count();
    
}

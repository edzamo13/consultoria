/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Formutbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface FormutblFacadeRemote {

    void create(Formutbl formutbl);

    void edit(Formutbl formutbl);

    void remove(Formutbl formutbl);

    Formutbl find(Object id);

    List<Formutbl> findAll();

    List<Formutbl> findRange(int[] range);

    int count();
    
}

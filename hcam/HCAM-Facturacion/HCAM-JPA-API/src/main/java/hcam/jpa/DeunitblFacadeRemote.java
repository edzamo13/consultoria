/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Deunitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface DeunitblFacadeRemote {

    void create(Deunitbl deunitbl);

    void edit(Deunitbl deunitbl);

    void remove(Deunitbl deunitbl);

    Deunitbl find(Object id);

    List<Deunitbl> findAll();

    List<Deunitbl> findRange(int[] range);

    int count();
    
}

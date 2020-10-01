/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Areatbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface AreatblFacadeRemote {

    void create(Areatbl areatbl);

    void edit(Areatbl areatbl);

    void remove(Areatbl areatbl);

    Areatbl find(Object id);

    List<Areatbl> findAll();

    List<Areatbl> findRange(int[] range);

    int count();
    
}

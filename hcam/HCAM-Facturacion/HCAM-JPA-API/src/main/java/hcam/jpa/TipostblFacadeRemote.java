/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Tipostbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface TipostblFacadeRemote {

    void create(Tipostbl tipostbl);

    void edit(Tipostbl tipostbl);

    void remove(Tipostbl tipostbl);

    Tipostbl find(Object id);

    List<Tipostbl> findAll();

    List<Tipostbl> findRange(int[] range);

    int count();
    
}

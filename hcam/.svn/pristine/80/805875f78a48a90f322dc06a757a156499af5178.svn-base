/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Histclitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface HistclitblFacadeRemote {

    void create(Histclitbl histclitbl);

    void edit(Histclitbl histclitbl);

    void remove(Histclitbl histclitbl);

    Histclitbl find(Object id);

    List<Histclitbl> findAll();

    List<Histclitbl> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Esquematbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface EsquematblFacadeRemote {

    void create(Esquematbl esquematbl);

    void edit(Esquematbl esquematbl);

    void remove(Esquematbl esquematbl);

    Esquematbl find(Object id);

    List<Esquematbl> findAll();

    List<Esquematbl> findRange(int[] range);

    int count();
    
}

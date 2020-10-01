/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Proceditbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ProceditblFacadeRemote {

    void create(Proceditbl proceditbl);

    void edit(Proceditbl proceditbl);

    void remove(Proceditbl proceditbl);

    Proceditbl find(Object id);

    List<Proceditbl> findAll();

    List<Proceditbl> findRange(int[] range);

    int count();
    
}

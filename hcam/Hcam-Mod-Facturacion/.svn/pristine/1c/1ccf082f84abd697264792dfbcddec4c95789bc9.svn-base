/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Tarifaftbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface TarifaftblFacadeRemote {

    void create(Tarifaftbl tarifaftbl);

    void edit(Tarifaftbl tarifaftbl);

    void remove(Tarifaftbl tarifaftbl);

    Tarifaftbl find(Object id);

    List<Tarifaftbl> findAll();

    List<Tarifaftbl> findRange(int[] range);

    int count();
    
}

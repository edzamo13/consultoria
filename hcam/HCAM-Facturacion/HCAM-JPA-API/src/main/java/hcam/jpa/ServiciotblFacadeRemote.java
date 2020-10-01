/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Serviciotbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ServiciotblFacadeRemote {

    void create(Serviciotbl serviciotbl);

    void edit(Serviciotbl serviciotbl);

    void remove(Serviciotbl serviciotbl);

    Serviciotbl find(Object id);

    List<Serviciotbl> findAll();

    List<Serviciotbl> findRange(int[] range);

    int count();
    
}

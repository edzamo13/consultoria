/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Detplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface DetplantblFacadeRemote {

    void create(Detplantbl detplantbl);

    void edit(Detplantbl detplantbl);

    void remove(Detplantbl detplantbl);

    Detplantbl find(Object id);

    List<Detplantbl> findAll();

    List<Detplantbl> findRange(int[] range);

    int count();
    
}

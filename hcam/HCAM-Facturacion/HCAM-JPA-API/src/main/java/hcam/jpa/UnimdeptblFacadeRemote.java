/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Unimdeptbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface UnimdeptblFacadeRemote {

    void create(Unimdeptbl unimdeptbl);

    void edit(Unimdeptbl unimdeptbl);

    void remove(Unimdeptbl unimdeptbl);

    Unimdeptbl find(Object id);

    List<Unimdeptbl> findAll();

    List<Unimdeptbl> findRange(int[] range);

    int count();
    
}

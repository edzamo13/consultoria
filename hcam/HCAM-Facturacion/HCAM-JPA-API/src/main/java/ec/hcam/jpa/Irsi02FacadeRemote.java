/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.jpa;

import ec.hcam.entities1.Irsi02;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface Irsi02FacadeRemote {

    void create(Irsi02 irsi02);

    void edit(Irsi02 irsi02);

    void remove(Irsi02 irsi02);

    Irsi02 find(Object id);

    List<Irsi02> findAll();

    List<Irsi02> findRange(int[] range);

    int count();
    
}

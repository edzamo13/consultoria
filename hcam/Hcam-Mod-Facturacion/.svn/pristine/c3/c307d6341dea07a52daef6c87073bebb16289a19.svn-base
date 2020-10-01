/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Paramtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ParamtblFacadeRemote {

    void create(Paramtbl paramtbl);

    void edit(Paramtbl paramtbl);

    void remove(Paramtbl paramtbl);

    Paramtbl find(Object id);

    List<Paramtbl> findAll();

    List<Paramtbl> findRange(int[] range);

    int count();
    
}

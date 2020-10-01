/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.CtUmtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface CtUmtblFacadeRemote {

    void create(CtUmtbl ctUmtbl);

    void edit(CtUmtbl ctUmtbl);

    void remove(CtUmtbl ctUmtbl);

    CtUmtbl find(Object id);

    List<CtUmtbl> findAll();

    List<CtUmtbl> findRange(int[] range);

    int count();
    
}

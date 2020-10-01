/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Unidmedtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface UnidmedtblServiceRemote {
    
    void createUnidmedtbl(Unidmedtbl unidmedtbl);
    
    void editUnidmedtbl(Unidmedtbl unidmedtbl);
    
    void removeUnidmedtbl(Unidmedtbl unidmedtbl);
    
    Unidmedtbl findUnidmedtblById(Object id);
    
    List<Unidmedtbl> findAllUnidmedtbls();
    
    List<Unidmedtbl> findUnidmedtblByRange(int[] range);
    
    int countUnidmedtbls();
}

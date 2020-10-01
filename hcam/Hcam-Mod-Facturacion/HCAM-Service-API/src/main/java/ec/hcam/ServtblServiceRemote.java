/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Servtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ServtblServiceRemote {
    int countServtbl();
    List<Servtbl> findServtblByRange(int[] range);
    List<Servtbl> findAllServtbl();
    Servtbl findServtblById(Object id);
    void removeServtbl(Servtbl servtbl);
    void editServtbl(Servtbl servtbl);
    void createServtbl(Servtbl servtbl);
    
}

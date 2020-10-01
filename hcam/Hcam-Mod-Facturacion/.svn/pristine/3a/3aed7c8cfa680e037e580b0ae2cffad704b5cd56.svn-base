/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Esttbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface EsttblServiceRemote {
    void createEsttbl(Esttbl esttbl);
    void editEsttbl(Esttbl esttbl);
    void removeEsttbl(Esttbl esttbl);
    Esttbl findEsttblById(Object id);
    List<Esttbl> findAllEsttbl();
    List<Esttbl> findEsttblByRange(int[] range);
    int countEsttbl();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Formutbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface FormutblServiceRemote {
    void createFormutbl(Formutbl formutbl);
    void editFormutbl(Formutbl formutbl);
    void removeFormutbl(Formutbl formutbl);
    Formutbl findFormutblById(Object id);
    List<Formutbl> findAllFormutbl();
    List<Formutbl> findFormutblByRange(int[] range);
    int countFormutbl();
}

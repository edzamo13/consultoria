/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Deunitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface DeunitblServiceRemote {
    void createDeunitbl(Deunitbl deunitbl);
    void editDeunitbl(Deunitbl deunitbl);
    void removeDeunitbl(Deunitbl deunitbl);
    Deunitbl findDeunitblById(Object id);
    List<Deunitbl> findAllDeunitbl();
    String findNameDependencyByCodeDependency(String Dedepend);
    List<Deunitbl> findDeunitblByRange(int[] range);
    int countDeunitbl();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Histclitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface HistclitblServiceRemote {
    void createHistclitbl(Histclitbl histclitbl);
    void editHistclitbl(Histclitbl histclitbl);
    void removeHistclitbl(Histclitbl histclitbl);
    Histclitbl findHistclitblById(Object id);
    List<Histclitbl> findAllHistclitbl();
    List<Histclitbl> findHistclitblByRange(int[] range);
    int countHistclitbl();
}

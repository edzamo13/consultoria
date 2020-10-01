/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Cabtaritbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface CabtaritblServiceRemote {
    void createCabtaritbl(Cabtaritbl cabtaritbl);
    void editCabtaritbl(Cabtaritbl cabtaritbl);
    void removeCabtaritbl(Cabtaritbl cabtaritbl);
    Cabtaritbl findCabtaritblById(Object id);
    List<Cabtaritbl> findAllCabtaritbl();
    List<Cabtaritbl> findCabtaritblByRange(int[] range);
    int countCabtaritbl();
}

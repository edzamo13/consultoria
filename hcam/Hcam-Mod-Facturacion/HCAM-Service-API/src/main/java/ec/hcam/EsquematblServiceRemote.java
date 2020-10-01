/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Esquematbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface EsquematblServiceRemote {
    void createEsquematbl(Esquematbl esquematbl);
    void editEsquematbl(Esquematbl esquematbl);
    void removeEsquematbl(Esquematbl esquematbl);
    Esquematbl findEsquematblById(Object id);
    List<Esquematbl> findAllEsquematbl();
    List<Esquematbl> findEsquematblByRange(int[] range);
    int countEsquematbl();
}

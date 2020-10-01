/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Consultbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ConsultblServiceRemote {
    void createConsultbl(Consultbl consultbl);
    void editConsultbl(Consultbl consultbl);
    void removeConsultbl(Consultbl consultbl);
    Consultbl findConsultblById(Object id);
    List<Consultbl> findAllConsultbl();
    List<Consultbl> findConsultblByRange(int[] range);
    int countConsultbl();
}

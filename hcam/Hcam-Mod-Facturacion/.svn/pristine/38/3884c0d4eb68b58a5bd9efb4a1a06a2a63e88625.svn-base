/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Proceditbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ProceditblServiceRemote {
    void createProceditbl(Proceditbl proceditbl);
    void editProceditbl(Proceditbl proceditbl);
    void removeProceditbl(Proceditbl proceditbl);
    Proceditbl findProceditblById(Object id);
    List<Proceditbl> findAllProceditbl();
    List<Proceditbl> findProceditblByRange(int[] range);
    int countProceditbl();
}

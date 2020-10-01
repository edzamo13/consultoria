/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Paramtbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface ParamtblServiceRemote {
    void createParamtbl(Paramtbl paramtbl);
    void editParamtbl(Paramtbl paramtbl);
    void removeParamtbl(Paramtbl paramtbl);
    Paramtbl findParamtblById(Object id);
    List<Paramtbl> findAllParamtbl();
    List<Paramtbl> findRangeParamtbl(int[] range);
    int countParamtbl();
    
}

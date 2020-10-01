/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Paramtbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class ParamtblService implements ParamtblServiceRemote {

    @EJB
    ParamtblFacadeRemote paramtblFacade;

    public void createParamtbl(Paramtbl paramtbl) {
        paramtblFacade.create(paramtbl);
    }

    public void editParamtbl(Paramtbl paramtbl) {
        paramtblFacade.edit(paramtbl);
    }

    public void removeParamtbl(Paramtbl paramtbl) {
        paramtblFacade.remove(paramtbl);
    }

    public Paramtbl findParamtblById(Object id) {
        return paramtblFacade.find(id);
    }

    public List<Paramtbl> findAllParamtbl() {
        return paramtblFacade.findAll();
    }

    public List<Paramtbl> findRangeParamtbl(int[] range) {
        return paramtblFacade.findRange(range);
    }

    public int countParamtbl() {
        return paramtblFacade.count();
    }
    
}

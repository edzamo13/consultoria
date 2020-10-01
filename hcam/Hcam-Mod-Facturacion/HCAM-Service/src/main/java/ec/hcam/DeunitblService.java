/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Deunitbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class DeunitblService implements DeunitblServiceRemote {

   @EJB
   DeunitblFacadeRemote deunitblFacade;
    @Override
    public void createDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.create(deunitbl);
    }
    @Override
    public void editDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.edit(deunitbl);
    }
    @Override
    public void removeDeunitbl(Deunitbl deunitbl) {
        deunitblFacade.remove(deunitbl);
    }
    @Override
    public Deunitbl findDeunitblById(Object id) {
        return deunitblFacade.find(id);
    }
    @Override
    public List<Deunitbl> findAllDeunitbl() {
        return deunitblFacade.findAll();
    }
    @Override
    public List<Deunitbl> findDeunitblByRange(int[] range) {
        return deunitblFacade.findRange(range);
    }
    @Override
    public int countDeunitbl() {
        return deunitblFacade.count();
    }

    @Override
    public String findNameDependencyByCodeDependency(String Dedepend) {
        try {
            Deunitbl deunitbl = deunitblFacade.findNameByCodeDependency(Dedepend);            
            return deunitbl.getDenombre();
        } catch (javax.persistence.NoResultException nre) {
            return "";
        }
    }
   
}

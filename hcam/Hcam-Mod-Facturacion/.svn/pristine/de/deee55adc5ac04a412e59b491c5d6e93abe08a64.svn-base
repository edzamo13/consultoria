/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Cabplantbl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Programacion
 */
@Stateless
public class CabplantblService implements CabplantblServiceRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    CabplantblFacadeRemote cabPlantblFacade;

    public void createCabPlantbl(Cabplantbl cabplantbl) {
        cabPlantblFacade.create(cabplantbl);
    }

    public void editCabplantbl(Cabplantbl cabplantbl) {
        cabPlantblFacade.edit(cabplantbl);
    }

    public void removeCabplantbl(Cabplantbl cabplantbl) {
        cabPlantblFacade.remove(cabplantbl);
    }

    public Cabplantbl findCabplantblById(Object id) {
        return cabPlantblFacade.find(id);
    }

    public Cabplantbl findCabplantblByMesDia(Integer mes, Integer dia, Integer ano,Integer unimedpk) {
        try {
            Cabplantbl cabplantbl = cabPlantblFacade.findByMesDia(mes, dia, ano,unimedpk);
            return cabplantbl;
        } catch (javax.persistence.NoResultException nre) {
            return null;
        }
    }

    public List<Cabplantbl> findAllCabplantbl() {
        return cabPlantblFacade.findAll();
    }

    public List<Cabplantbl> findCabplantblByRange(int[] range) {
        return cabPlantblFacade.findRange(range);
    }

    public int countCabplantbl() {
        return cabPlantblFacade.count();
    }

//    @Override
//    public Cabplantbl createCabPlantblAndFlush(Cabplantbl cabplantbl) {
//        return cabPlantblFacade.createAndFlush(cabplantbl);
//    }
}

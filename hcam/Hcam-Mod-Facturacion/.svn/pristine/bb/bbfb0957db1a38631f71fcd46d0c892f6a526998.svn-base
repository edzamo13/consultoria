/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Cabplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface CabplantblServiceRemote {

    void createCabPlantbl(Cabplantbl cabplantbl);

    //Cabplantbl createCabPlantblAndFlush(Cabplantbl cabplantbl);

    void editCabplantbl(Cabplantbl cabplantbl);

    void removeCabplantbl(Cabplantbl cabplantbl);

    Cabplantbl findCabplantblById(Object id);

    Cabplantbl findCabplantblByMesDia(Integer mes, Integer dia, Integer ano,Integer unimedpk);

    List<Cabplantbl> findAllCabplantbl();

    List<Cabplantbl> findCabplantblByRange(int[] range);

    int countCabplantbl();
}

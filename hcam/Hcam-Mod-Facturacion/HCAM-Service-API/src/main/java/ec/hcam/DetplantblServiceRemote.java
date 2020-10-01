/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Detplantbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface DetplantblServiceRemote {

    void createDetplantbl(Detplantbl detplantbl);

    void editDetplantbl(Detplantbl detplantbl);

    void removeDetplantbl(Detplantbl detplantbl);

    Detplantbl findDetplantblById(Object id);

    List<Detplantbl> findAllDetplantbl();

    List<Detplantbl> findDetplantblByRange(int[] range);

    int countDetplantbl();
}

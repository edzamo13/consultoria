/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Areatbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface AreaServiceRemote {

    void createArea(Areatbl areatbl);

    void editArea(Areatbl areatbl);

    void removeArea(Areatbl areatbl);

    Areatbl findAreaById(int id);

    List<Areatbl> findAllAreatbls();

    List<Areatbl> findAreatblsByRange(int[] range);

    int countAreatbls();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.jpa;

import ec.hcam.entities.Deunitbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jochoa
 */
@Remote
public interface DeunitblFacadeRemote {

    void create(Deunitbl deunitbl);

    void edit(Deunitbl deunitbl);

    void remove(Deunitbl deunitbl);

    Deunitbl find(Object id);

    List<Deunitbl> findAll();

    List<Deunitbl> findRange(int[] range);

    int count();

    List<Deunitbl> findAllDependenciasWithUnidMedicaID(int idUnidadMedica);

}

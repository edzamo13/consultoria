/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.service;

import ec.hcam.entities.Serviciotbl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface ServiciotblServiceRemote {
    
    void createServiciotbl(Serviciotbl serviciotbl);
    
    void editServiciotbl(Serviciotbl serviciotbl);
    
    void removeServiciotbl(Serviciotbl serviciotbl);
    
    List<Serviciotbl> findAllServicesWithUnidadMedicaID(int idUnidadMedica);
    
    Serviciotbl findServiciotblById(Object id);
    
    List<Serviciotbl> findAllServiciotbls();
    
    List<Serviciotbl> findServiciotblbyRange(int[] range);
    
    int countServiciotbls();
    
    
    
}

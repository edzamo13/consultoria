/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import javax.ejb.Remote;

/**
 *
 * @author ezamora
 */
@Remote
public interface UnidadMedicaServiceRemote {
    

    void obtenerRegistrosF();
    
}

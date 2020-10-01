/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface HonorarioMedicoODServiceRemote {
    
    public Future obtenerRegistrosCE(int nivel, String iounme, Integer ioxdat,Integer unimedpk,Integer ubicapk);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.LaboratorioCli;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface LabClinicoServiceRemote {

    void registrarDetallePlanillaje(LaboratorioCli farmacos, String uniMed, String iofeor);

    Future obtenerRegistrosLaboratorio(String iounme, Integer iofeor, Integer nivel, Integer unidpk, Integer ubicapk);

    List<LaboratorioCli> obtenerTodosLosLaboratorios(String iounme, String iofeor, Double depend, int nivel);
}

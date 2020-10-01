/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.InsumosServicios;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author Programacion
 */
@Remote
public interface InsumosServiceRemote {

    void registrarDetallePlanillaje(InsumosServicios farmacos, String uniMed, String iofeor);

    Future obtenerRegistrosInsumosServicios(String iounme, Integer iofeor, Integer nivel, Integer unidpk, Integer ubicapk);

    List<InsumosServicios> obtenerTodosLosInsumosServicios(String iounme, String iofeor, Double depend);
}

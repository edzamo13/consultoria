/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.DerechoSalaRecuperacion;
import ec.hcam.data.TarifarioCir;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface DerechosSalaRecuperacionServiceRemote {

    Future obtenerRegistros(String opunme, int opdata,Integer nivel,Integer unidpk, Integer ubicapk);

    List<DerechoSalaRecuperacion> ObtenerDerechosSalaRecuperacion(double unidMed, double fecha, int dependencia);

    void registrarDetallePlanillaje(DerechoSalaRecuperacion derSR, TarifarioCir tarifario);

}

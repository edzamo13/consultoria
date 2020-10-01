/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.Procedimientos;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author ezamora
 */
@Remote
public interface ProcedimientosServiceRemote {

    Future obtenerRegistrosProcedimientoEmergecia(String unimed, Integer IOTISE, Integer fecharecibida, Integer nivel, Integer unidpk, Integer ubicapk);

    Future obtenerRegistrosProcedimientoRehabilitacion(String unimed, Integer IOXDAT, Integer nivel, Integer unidpk, Integer ubicapk);

    public void registrarDetallePlanillaje(Procedimientos procedimientos, String iofeor);
}

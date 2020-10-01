/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.DatosPaciente;
import ec.hcam.data.ParteOperatorio;
import ec.hcam.data.ProcedimientoCirugia;
import ec.hcam.data.ProcedimientosQ;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface HonorariosMedicosCirugiaServiceRemote {

    List<ParteOperatorio> obtenerTodosPartesOper(String opunme, int opdata, double dependencia);

    Future obtenerRegistros(String unimed, Integer opdata, Integer nivel, Integer unidpk, Integer ubicapk);

    List<ProcedimientosQ> obtenerProcedimientos(String unidMed, int fechaOp, int hisCli, int horaOp);

    void registrarDetallePlanillaje(ParteOperatorio parteO, ProcedimientoCirugia proCir, int codCirujano, double valorCobrar, String rubro, List<DatosPaciente> datosPaciente);

}

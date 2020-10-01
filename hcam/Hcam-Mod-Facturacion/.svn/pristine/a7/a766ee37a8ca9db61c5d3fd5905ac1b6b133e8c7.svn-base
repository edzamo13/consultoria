/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.CodigosTiempo;
import ec.hcam.data.ParteOperatorio;
import ec.hcam.data.Procedimientos;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface DerechoSalaQServiceRemote {

    List<ParteOperatorio> obtenerTodosPartesOper(String opunme, int opdata, double depend);

    Future obtenerRegistros(String opunme, int opdata, Integer nivel,Integer unimedpk, Integer ubicapk);

    void registrarDetallePlanillaje(ParteOperatorio parteO, CodigosTiempo codTiempo);

    List<Procedimientos> obtenerProcedimientos(int unidMed, int fechaOp);
}

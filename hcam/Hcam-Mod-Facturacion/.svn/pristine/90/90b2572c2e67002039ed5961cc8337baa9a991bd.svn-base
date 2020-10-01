/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.orquestrator;

import ec.hcam.data.Cabecera;
import ec.hcam.data.CodigosTiempo;
import ec.hcam.data.ParteOperatorio;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author programacion
 */
@Remote
public interface MaterialesUsoMenorServiceRemote {

    Future obtenerRegistros(String opunme, int opdata, Integer nivel, Integer unidpk, Integer ubicapk);

    List<ParteOperatorio> obtenerTodosPartesOper(String opunme, int opdata, double depend);

    List<Cabecera> buscadorCabecera(Integer mes, Integer dia);

    void registrarDetallePlanillaje(ParteOperatorio parteO, CodigosTiempo codTiempo);

}

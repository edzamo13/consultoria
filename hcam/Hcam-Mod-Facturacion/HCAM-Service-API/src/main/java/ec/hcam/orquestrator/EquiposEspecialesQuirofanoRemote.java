package ec.hcam.orquestrator;

import java.util.concurrent.Future;
import javax.ejb.Remote;

@Remote
public interface EquiposEspecialesQuirofanoRemote {

    Future obtenerEquiposEspeciales(String unidadMedica, Integer fecha,Integer nivel,Integer unidpk,Integer ubicapk);
    
    //equiposQuirofanoRemote.obtenerEquiposEspeciales("1110100000", 20150402, 1, 8, 1323);

    //List<EquiposEspecialesPOJO> obtenerTodosLosEquiposEspeciales(int iounme, String iofeor);
    //void registrarDetallePlanillaje(Double historiaClinica, int uniMed, String iofeor);
    //void insertarCabecera(int mes, int dia, int anio);
}

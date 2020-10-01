package ec.hcam.orquestrator;

import java.util.concurrent.Future;
import javax.ejb.Remote;

@Remote
public interface ServiciosInstitucionalesRemote {

    Future obtenerRegistrosServiciosInstitucionales(String unidMedica, Integer fecha1, Integer nivel, Integer unidpk, Integer ubicapk);

    //List<EquiposEspecialesPOJO> obtenerTodosLosEquiposEspeciales(int iounme, String iofeor);
    //void registrarDetallePlanillaje(Double historiaClinica, int uniMed, String iofeor);
    //void insertarCabecera(int mes, int dia, int anio);
}

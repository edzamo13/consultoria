package ec.hcam.orquestrator;

import ec.hcam.data.Imagen;
import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface ImagenologiaServiceRemote {

    //void obtenerDependencias(int idUnimed);
    public Future obtenerRegistrosI(int nivel, String iounme, int ioxdat, Integer unidpk, Integer ubicapk);

    void aplicarRegla(Imagen objeto, String ir2unm, int ir2cit);

    void registrarDetallePlanillaje(Imagen objeto, String ir2unm, int ir2cit);

}

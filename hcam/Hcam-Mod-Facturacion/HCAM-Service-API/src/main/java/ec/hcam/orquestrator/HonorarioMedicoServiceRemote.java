package ec.hcam.orquestrator;

import ec.hcam.data.Cabecera;
import ec.hcam.data.Dependencia;
import ec.hcam.data.Imagen;
import ec.hcam.data.InformacionB;
import ec.hcam.data.InformacionHC;
import ec.hcam.entity.Cabplantbl;
import java.math.BigInteger;
import java.util.Date;

import javax.ejb.Remote;

import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface HonorarioMedicoServiceRemote {

    //void obtenerDependencias(int idUnimed);
    
   Future obtenerRegistrosHM(int nivel, String iounme, Integer ioxdat,Integer unimedpk, Integer ubicapk);
   void procesarDependenciasUnaAUna(int nivel, String iounme, int ioxdat, List<Dependencia> listaDependencia,Integer unimedpk, Integer ubicapk);
   void obtenerRegistroDeUnPacientePorHistoriaClinica(int ctidpk, String ir2unm, BigInteger ir2dep, int ir2cit, double ir2his, List<InformacionB> tasksT);
   void aplicarRegla(List<InformacionB> listaB, String ir2unm, BigInteger ir2dep, int ir2cit);
   void registrarDetallePlanillaje(InformacionB objeto, String ir2unm, BigInteger ir2dep, int ir2cit);
    
    
}

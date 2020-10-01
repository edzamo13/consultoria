package ec.hcam.orquestador;

import java.util.Date;

import javax.ejb.Remote;

import ec.hcam.entities.Cabtaritbl;
import ec.hcam.entities.Detplantbl;



@Remote
public interface verificarEstanciaRemote {
	String obtenerReglas();
	//List<Registros> obtenerRegistrosPorPaciente(List<Registros> registrosPorDependencia);
	int consultarValorTarifario(String codigoTarifario);
	int aplicarRegla();
	Cabtaritbl obtenerCabeceraPlanillajeMensual(int mes);
	Cabtaritbl obtenerCabeceraPlanillajeDiario(int dia);
	void registrarDetallePlanillaje();
	
}

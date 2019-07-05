package ec.gob.setec.portal.web.ws.controller.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ec.gob.setec.portal.web.ws.controller.oracle.model.ConsultaPerfile;
import ec.gob.setec.portal.web.ws.controller.oracle.repository.ConsultaPerfileRepository;
import ec.gob.setec.portal.web.ws.utilitario.ListaSql;

@Primary
@Service("consultaPerfileServiceDB")
public class ConsultaPerfileServiceDB implements ConsultaPerfileService {

	@Autowired
	private ConsultaPerfileRepository repositorio;

	/**
	 * 
	 * @author ezamora
	 * @return List<String>
	 */
	public List<String> obtenerFamiliaOrdenado() {
		return repositorio.obtenerFamiliaOrdenado();
	}

	/**
	 * 
	 * @author ezamora
	 * @return List<String>
	 */
	public List<String> obtenerSectotOrdenado() {
		return repositorio.obtenerSectorOrdenado();
	}

	/**
	 * 
	 * @author ezamora
	 * @return List<ConsultaPerfile>
	 * @throws Throwable
	 */
	public List<ConsultaPerfile> obtenerConsultaCampoPorSeleccion(int opcion, String campo) throws Throwable {
		List<ConsultaPerfile> list = new ArrayList<ConsultaPerfile>();
		List<Object[]> objs = new ArrayList<>();

		switch (opcion) {
		case 0:
			objs = repositorio.obtenerPefilOECxFamilia(campo);
			list = ListaSql.retornarDatos(objs, ConsultaPerfile.class);
			break;
		case 1:
			objs = repositorio.obtenerPefilOECxSector(campo);
			list = ListaSql.retornarDatos(objs, ConsultaPerfile.class);
			break;
		case 2:
			objs = repositorio.obtenerPefilOECxDenominacion(campo.toUpperCase());
			list = ListaSql.retornarDatos(objs, ConsultaPerfile.class);
			break;
		case 3:
			objs = repositorio.obtenerPefilOECTodo();
			list = ListaSql.retornarDatos(objs, ConsultaPerfile.class);
			break;

		}
		return list;
	}

}

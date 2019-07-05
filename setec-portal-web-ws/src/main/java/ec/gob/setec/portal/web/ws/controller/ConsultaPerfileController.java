package ec.gob.setec.portal.web.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.setec.portal.web.ws.controller.oracle.model.ConsultaPerfile;
import ec.gob.setec.portal.web.ws.controller.oracle.model.Detalle;
import ec.gob.setec.portal.web.ws.controller.servicios.ConsultaPerfileServiceDB;

@RestController
@RequestMapping("/api/consultaPerfil")
public class ConsultaPerfileController {

	@Autowired
	ConsultaPerfileServiceDB consultaPerfileService;

	@GetMapping("/listarFamilia")
	public List<Detalle> consultaPerfileFamilia() {
		List<Detalle> respuesta = new ArrayList<>();
		List<String> list = consultaPerfileService.obtenerFamiliaOrdenado();
		if (list != null) {
			list.forEach(x -> respuesta.add(new Detalle(x)));
			return respuesta;
		} else {
			throw new ConsultaPerfilNotFoundException();
		}

	}

	@GetMapping("/listarSector")
	public List<Detalle> consultaPerfileSector() {
		List<Detalle> respuesta = new ArrayList<>();
		List<String> list = consultaPerfileService.obtenerSectotOrdenado();
		if (list != null) {
			list.forEach(x -> respuesta.add(new Detalle(x)));
			return respuesta;
		} else {
			throw new ConsultaPerfilNotFoundException();
		}

	}

	@PostMapping("/listarConsultaPerfilPorCampoOEC")
	public List<ConsultaPerfile> consultarCampoPorSeleccion(@RequestBody ConsultaPerfile entrada) throws Throwable, Throwable {
		List<ConsultaPerfile> list = consultaPerfileService
				.obtenerConsultaCampoPorSeleccion(Integer.parseInt(entrada.getOpcion()), entrada.getCampo());
		if (list != null) {
			return list;
		} else {
			throw new ConsultaPerfilNotFoundException();
		}

	}


	
	
	
	
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	private class ConsultaPerfilNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 7295910574475009536L;

		public ConsultaPerfilNotFoundException() {
			super("No existe ningún información");
		}

		@SuppressWarnings("unused")
		public ConsultaPerfilNotFoundException(Integer id) {
			super(String.format("No existe ningún empleado con el ID = %d", id));
		}

	}

}

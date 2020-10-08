package ec.gob.mag.renagro.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.renagro.dto.BrigadaDTO;
import ec.gob.mag.renagro.services.Consumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Api Rest sectorDispersoPeriodoService", description = "sectorDispersoPeriodoService", tags = "sectorDispersoPeriodoService")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class RenagroSectorDispersoPeriodoController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(RenagroSectorDispersoPeriodoController.class);

	@Value("${url.personas}")
	private String urlMicroPersona;

	@Value("${url.servidor_micro}")
	private String urlServidor;

	@Value("${url.renagro}")
	private String urlRenagro;

	private String pathMicro;

	@Autowired
	@Qualifier("consumer")
	private Consumer consumer;

	@PostMapping(value = "/sectorDispersoPeriodo/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una brigada", response = BrigadaDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public Object createBrigadaSector(@RequestBody String sectorDispersoPeriodo, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "sectorDispersoPeriodo/create/";
		Object response = consumer.doPost(pathMicro, sectorDispersoPeriodo.toString(), token);
		return response;
	}

	@PostMapping(value = "/sectorDispersoPeriodo/update", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Actualiza una brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object updateBrigadaSector(@RequestBody String sectorDispersoPeriodo, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "sectorDispersoPeriodo/update/";
		Object response = consumer.doPost(pathMicro, sectorDispersoPeriodo.toString(), token);
		return response;
	}

	@PostMapping(value = "/sectorDispersoPeriodo/delete", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Delete Lógico una  brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object deleteBrigadaSector(@Valid @RequestBody String id, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "sectorDispersoPeriodo/delete/";
		Object response = consumer.doPost(pathMicro, id, token);
		return response;

	}

	@RequestMapping(value = "/sectorDispersoPeriodo/findById/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaSectorByIdEstadoActivo(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "sectorDispersoPeriodo/findById/" + id;
		System.out.println("----------->" + pathMicro);
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

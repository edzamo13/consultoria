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
@Api(value = "Api Rest RenagroBrigadaSector", description = "RenagroBrigadaSector", tags = "RenagroBrigadaSector")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class RenagroBrigadaSectorController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(RenagroBrigadaSectorController.class);

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

	@PostMapping(value = "/brigadaSector/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una brigada", response = BrigadaDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public Object createBrigadaSector(@RequestBody String brigadaSector,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/create/";
		Object response = consumer.doPost(pathMicro, brigadaSector.toString(), token);
		return response;
	}

	@PostMapping(value = "/brigadaSector/update", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Actualiza una brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object updateBrigadaSector(@RequestBody String brigadaSector,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/update/";
		Object response = consumer.doPost(pathMicro, brigadaSector.toString(), token);
		return response;
	}

	@PostMapping(value = "/brigadaSector/delete", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Delete Lógico una  brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object deleteBrigadaSector(@Valid @RequestBody String id,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/delete/";
		Object response = consumer.doPost(pathMicro, id, token);
		return response;

	}

	@RequestMapping(value = "/brigadaSector/findById/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaSectorByIdEstadoActivo(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/findById/" + id;
		System.out.println("----------->" + pathMicro);
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/brigadaSector/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaSectorAll(@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/findAll/";
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/brigadaSector/usupIdInsert/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaSectorUsupIdInsert(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/usupIdInsert/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/brigadaSector/sedpId/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una brigada Sector por sedpId", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigadaSector/sedpId/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}

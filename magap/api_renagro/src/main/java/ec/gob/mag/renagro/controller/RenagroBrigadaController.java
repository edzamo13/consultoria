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
@Api(value = "Api Rest funcionario", description = "Brigada", tags = "Brigada")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class RenagroBrigadaController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(RenagroBrigadaController.class);

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

	@PostMapping(value = "/brigada/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una brigada", response = BrigadaDTO.class)
	@ResponseStatus(HttpStatus.OK)
	public Object createBrigada(@RequestBody String brigada, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/create/";
		Object response = consumer.doPost(pathMicro, brigada.toString(), token);
		return response;
	}

	@PostMapping(value = "/brigada/update", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Actualiza una brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object updateBrigada(@RequestBody String brigada, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/update/";
		Object response = consumer.doPost(pathMicro, brigada.toString(), token);
		return response;
	}

	@PostMapping(value = "/brigada/delete", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Delete Lógico una  brigada")
	@ResponseStatus(HttpStatus.OK)
	public Object deleteBrigada(@Valid @RequestBody String id, @RequestHeader(name = "Authorization") String token)
			throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/delete/";
		Object response = consumer.doPost(pathMicro, id, token);
		return response;

	}

	@RequestMapping(value = "/brigada/findById/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaByIdEstadoActivo(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/findById/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/brigada/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaAll(@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/findAll/";
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@RequestMapping(value = "/brigada/findByUsupIdInsert/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getBrigadaByUsupIdInsert(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/findByUsupIdInsert/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@PostMapping(value = "/brigada/findByUsupIdInsertTipo", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Busca brigada por UsupIdInsert y tipo completa o incompleta")
	@ResponseStatus(HttpStatus.OK)
	public Object brigadaByUsupIdInsert(@RequestBody String brigada,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "brigada/findByUsupIdInsertTipo/";
		Object response = consumer.doPost(pathMicro, brigada.toString(), token);
		return response;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

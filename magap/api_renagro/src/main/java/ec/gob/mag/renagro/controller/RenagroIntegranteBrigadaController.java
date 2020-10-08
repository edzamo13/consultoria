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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
public class RenagroIntegranteBrigadaController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(RenagroIntegranteBrigadaController.class);

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

	@PostMapping(value = "/integranteBrigada/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Delete Lógico una  integranteBrigada")
	@ResponseStatus(HttpStatus.OK)
	public Object creaIntegranteBrigada(@Valid @RequestBody String id,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/create";
		System.out.println("http:------> " + pathMicro);
		Object response = consumer.doPost(pathMicro, id, token);
		return response;

	}

	@PostMapping(value = "/integranteBrigada/delete", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Delete Lógico una  integranteBrigada")
	@ResponseStatus(HttpStatus.OK)
	public Object deleteIntegranteBrigada(@Valid @RequestBody String id,
			@RequestHeader(name = "Authorization") String token) throws IOException {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/delete";
		Object response = consumer.doPost(pathMicro, id, token);
		return response;

	}

	@GetMapping(value = "/integranteBrigada/findById/{id}")
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getIntegranteBrigadaById(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/findById/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@GetMapping(value = "/integranteBrigada/findByBriId/{id}")
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object getIntegranteBrigadaByBriId(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/findByBriId/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@GetMapping(value = "/integranteBrigada/findByUsupId/{id}")
	@ApiOperation(value = "Busca una Brigada por el id Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findByUsupIdEqualsAndIntbEstadoEquals(@Valid @PathVariable String id,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/findByUsupId/" + id;
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@GetMapping(value = "/integranteBrigada/findAll")
	@ApiOperation(value = "Busca Todas las integranteBrigada por Estado Activo", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findAll(@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "integranteBrigada/findAll";
		Object response = consumer.doGet(pathMicro, token);
		return response;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}

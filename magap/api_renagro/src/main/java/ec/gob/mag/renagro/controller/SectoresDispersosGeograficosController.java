package ec.gob.mag.renagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ec.gob.mag.renagro.services.Consumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Api Rest funcionario", description = "SECTORES DISPERSOS GEOGRAFICOS", tags = "SECTORES DISPERSOS GEOGRAFICOS")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class SectoresDispersosGeograficosController implements ErrorController {
	private static final String PATH = "/error";

	@Value("${url.servidor_micro}")
	private String urlServidor;

	@Value("${url.renagro}")
	private String urlMicroRenagro;

	private String pathMicro;

	@Autowired
	@Qualifier("consumer")
	private Consumer consumer;

	@RequestMapping(value = "/sectorDispersoGeografico/findByUbiIdCanton/{idCanton}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Busca todos los puntos geograficos de la tabla sector disperso geografico por canton", response = String.class)
	@ResponseStatus(HttpStatus.OK)
	public String sectorDispersoGeograficofindByUbiIdCanton(@PathVariable Long idCanton,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroRenagro + "sectordisperso/findBySectorDispersoByCanton/" + idCanton;
		Object response = consumer.doGet(pathMicro, token);
		return new Gson().toJson(response);
	}

	@RequestMapping(value = "/sectorDispersoGeografico/findByUbiIdParroquia/{idParr}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Busca todos los puntos geograficos de la tabla sector disperso geografico por parroquia", response = String.class)
	@ResponseStatus(HttpStatus.OK)
	public String sectorDispersoGeograficofindByUbiIdParroquia(@PathVariable String idParr,
			@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlMicroRenagro + "sectordisperso/findBySectorDispersoByParroquia/"
				+ Long.parseLong(idParr);
		Object response = consumer.doGet(pathMicro, token);
		return new Gson().toJson(response);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

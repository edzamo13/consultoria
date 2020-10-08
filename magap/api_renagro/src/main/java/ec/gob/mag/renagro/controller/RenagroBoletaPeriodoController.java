package ec.gob.mag.renagro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.renagro.services.Consumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Api Rest funcionario", description = "BoletaPeriodo", tags = "BoletaPeriodo")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class RenagroBoletaPeriodoController implements ErrorController {
	private static final String PATH = "/error";

	public static final Logger LOGGER = LoggerFactory.getLogger(RenagroBoletaPeriodoController.class);

	@Value("${url.personas}")
	private String urlMicroPersona;

	@Value("${url.servidor_micro}")
	private String urlServidor;

	@Value("${url.renagro}")
	private String urlRenagro;

	private String pathMicro;

//	private RestTemplate plantilla;

	@Autowired
	@Qualifier("consumer")
	private Consumer consumer;

	/**
	 * ------------ PERSONA
	 */
	@RequestMapping(value = "/boletaPeriodo/findByBoletaPeriodoActiva", method = RequestMethod.GET)
	@ApiOperation(value = "Busca una persona por el id del Rna", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public Object findPersonaById(@RequestHeader(name = "Authorization") String token) {
		pathMicro = null;
		pathMicro = urlServidor + urlRenagro + "boletaPeriodo/findByBoletaPeriodoActiva/";
		System.out.println("Ingresp " + "url:" + pathMicro);
//		plantilla = new RestTemplate();
//		Object resultado = plantilla.getForObject(pathMicro, Object.class);
		Object resultado = consumer.doGet(pathMicro, token);
		System.out.println(resultado);
		return resultado;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

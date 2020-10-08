package ec.gob.mag.dinardap.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.dinardap.dto.AntDTO;
import ec.gob.mag.dinardap.dto.CneDTO;
import ec.gob.mag.dinardap.dto.PoliciaDTO;
import ec.gob.mag.dinardap.dto.RegistroCivilCiudadanoDTO;
import ec.gob.mag.dinardap.dto.RegistroCivilDTO;
import ec.gob.mag.dinardap.dto.SciasDTO;
import ec.gob.mag.dinardap.dto.SenescytDTO;
import ec.gob.mag.dinardap.dto.SercopDTO;
import ec.gob.mag.dinardap.dto.SriAutorizacionEmisionDTO;
import ec.gob.mag.dinardap.dto.SriContribuyenteDTO;
import ec.gob.mag.dinardap.dto.SriFormulario101DTO;
import ec.gob.mag.dinardap.dto.SriFormulario102DTO;
import ec.gob.mag.dinardap.dto.SriFormulario104DTO;
import ec.gob.mag.dinardap.enumeration.DinardapTipoPeticionEnum;
import ec.gob.mag.dinardap.exception.ExceptionResponse;
import ec.gob.mag.dinardap.service.AntService;
import ec.gob.mag.dinardap.service.CneService;
import ec.gob.mag.dinardap.service.PoliciaService;
import ec.gob.mag.dinardap.service.RegistroCivilPuntoaPuntoService;
import ec.gob.mag.dinardap.service.RegistroCivilService;
import ec.gob.mag.dinardap.service.SciasService;
import ec.gob.mag.dinardap.service.SenescytService;
import ec.gob.mag.dinardap.service.SercopService;
import ec.gob.mag.dinardap.service.SriAutorizacionEmisionService;
import ec.gob.mag.dinardap.service.SriContribuyenteService;
import ec.gob.mag.dinardap.service.SriFormulario101Service;
import ec.gob.mag.dinardap.service.SriFormulario102Service;
import ec.gob.mag.dinardap.service.SriFormulario104Service;
import ec.gob.mag.dinardap.util.Consumer;
import ec.gob.mag.dinardap.util.ConvertEntityUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCESS"),
		@ApiResponse(code = 404, message = "RESOURCE NOT FOUND"), @ApiResponse(code = 400, message = "BAD REQUEST"),
		@ApiResponse(code = 201, message = "CREATED"), @ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 415, message = "UNSUPPORTED TYPE - Representation not supported for the resource"),
		@ApiResponse(code = 500, message = "SERVER ERROR") })
public class ApiController implements ErrorController {

	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

	/***************************************
	 * SECCION - INYECCION DE DEPENDENCIAS
	 ***************************************/
	@Autowired
	@Qualifier("consumer")
	private Consumer consumer;

	@Autowired
	@Qualifier("convertEntityUtil")
	private ConvertEntityUtil convertEntityUtil;

	/***************************************
	 * SECCION - MICROSERVICIOS
	 ***************************************/
	@Value("${url.servidor_micro}")
	private String urlServidor;

	@Value("${url.persona}")
	private String urlMicroPersona;

	Logger logger = LoggerFactory.getLogger(ApiController.class);

	/***************************************
	 * SECCION - END-POINTS
	 * 
	 * @throws Exception
	 * 
	 * @throws ExceptionResponse
	 ***************************************/
	@RequestMapping(value = "/dinardap/interoperador/{paquete}/{dato}", method = RequestMethod.GET)
	@ApiOperation(value = "Ejemplo de llamada directa al microservicio", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getInterOperador(@Validated @PathVariable String paquete,
			@Validated @PathVariable String dato, @RequestHeader(name = "Authorization") String auth) throws Exception {

		// if
		List<DinardapTipoPeticionEnum> param = Arrays.stream(DinardapTipoPeticionEnum.values())
				.filter(d -> d.getId() == (Integer.valueOf(paquete))).collect(Collectors.toList());

		ResponseEntity<?> responseEntity = null;

		if (!param.isEmpty()) {
			switch (param.get(0).getId()) {
			case 1:
				try {
					RegistroCivilDTO registroCivilDTOs = RegistroCivilService.obtenerDatos(param.get(0), dato);
					responseEntity = ResponseEntity.ok(registroCivilDTOs);
				} catch (Exception e) {
					logger.info("Exception going to Point by Point registroCivil");
					RegistroCivilCiudadanoDTO ciudadanoDTO = RegistroCivilPuntoaPuntoService.obtenerDatos(dato);
					responseEntity = ResponseEntity.ok(ciudadanoDTO);

				}

				break;
			case 2:
				AntDTO antDTO = AntService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(antDTO);
				break;
			case 3:
				AntDTO antDTO2 = AntService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(antDTO2);
				break;
			case 4:
				CneDTO cneDTO = CneService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(cneDTO);
				break;

			case 5:
				SenescytDTO senescytDTO = SenescytService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(senescytDTO);
				break;
			case 6:
				SercopDTO sercopDTO = SercopService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(sercopDTO);
				break;
			case 7:
				// no funciona fuente
				break;
			case 8:
				PoliciaDTO policiaDTO = PoliciaService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(policiaDTO);
				break;
			case 9:
				SciasDTO sciasDTO = SciasService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(sciasDTO);
				break;
			case 10:
				SriFormulario101DTO sriFormulario101DTO = SriFormulario101Service.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(sriFormulario101DTO);
				break;
			case 11:
				SriFormulario102DTO sriFormulario102DTO = SriFormulario102Service.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(sriFormulario102DTO);
				break;
			case 12:
				SriFormulario104DTO sriFormulario104DTO = SriFormulario104Service.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(sriFormulario104DTO);
				break;
			case 13:
				SriContribuyenteDTO contribuyenteDTO = SriContribuyenteService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(contribuyenteDTO);
				break;
			case 14:
				SriContribuyenteDTO contribuyenteCompletoDTO = SriContribuyenteService.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(contribuyenteCompletoDTO);
				break;
			case 15:
				SriAutorizacionEmisionDTO autorizacionEmisionDTO = SriAutorizacionEmisionService
						.obtenerDatos(param.get(0), dato);
				responseEntity = ResponseEntity.ok(autorizacionEmisionDTO);
				break;
			case 16:
				RegistroCivilCiudadanoDTO ciudadanoDTO = RegistroCivilPuntoaPuntoService.obtenerDatos(dato);
				responseEntity = ResponseEntity.ok(ciudadanoDTO);

				break;

			default:

				throw new Exception("default");
			}

		} else {
			throw new Exception("Paquete enviado incorrecto");
		}

		return responseEntity;

	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}

package ec.gob.mag.renagro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.renagro.domain.SectorDisperso;
import ec.gob.mag.renagro.services.SectorDispersoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sectordisperso")
@Api(value = "Sector Disperso", description = "Rest Api de Sector Disperso", tags = "SectorDisperso")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class SectorDispersoController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(SectorDispersoController.class);

	@Autowired
	@Qualifier("sectorDispersoService")
	private SectorDispersoService sectorDispersoService;

	@RequestMapping(value = "/findBySectorDispersoByCanton/{ubiIdCanton}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca ubiIdCanton por su Id", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public String findBySectorDispersoGeograficoByCanton(@Valid @PathVariable String ubiIdCanton,
			@RequestHeader(name = "Authorization") String token) {
		String sectorDisperso = sectorDispersoService.findByUbiIdCanton(Integer.parseInt(ubiIdCanton));
		LOGGER.info("Sectores Dispersos Geograficos por Canton: " + sectorDisperso.toString());
		return sectorDisperso;
	}

	@RequestMapping(value = "/findBySectorDispersoByParroquia/{ubiIdParr}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca ubiIdCanton por su Id", response = Object.class)
	@ResponseStatus(HttpStatus.OK)
	public String findBySectorDispersoByParroquia(@Valid @PathVariable String ubiIdParr,
			@RequestHeader(name = "Authorization") String token) {
		String sectorDisperso = sectorDispersoService.findByUbiIdParroquia(Integer.parseInt(ubiIdParr));
		LOGGER.info("Sectores Dispersos Geograficos por parroquia: " + sectorDisperso.toString());
		return sectorDisperso;
	}

	@RequestMapping(value = "/findBySecdId/{secdId}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca ubiIdCanton por su Id")
	@ResponseStatus(HttpStatus.OK)
	public Object findBySecdId(@Valid @PathVariable String secdId,
			@RequestHeader(name = "Authorization") String token) {
		Optional<SectorDisperso> sectorDisperso = sectorDispersoService.findById(Long.parseLong(secdId));
		LOGGER.info("Sectores Dispersos Geograficos por parroquia: " + sectorDisperso.toString());
		return sectorDisperso;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Busca todas los registros", response = SectorDisperso.class)
	public Object getArea(@RequestHeader(name = "Authorization") String token) {
		List<SectorDisperso> lista = sectorDispersoService.findAll();
		LOGGER.info("Find All: " + lista.toString());
		return lista;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

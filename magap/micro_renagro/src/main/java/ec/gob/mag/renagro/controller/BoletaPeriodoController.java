package ec.gob.mag.renagro.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.services.BoletaPeriodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/boletaPeriodo")
@Api(value = "BoletaPeriodo", description = "Rest Api de BoletaPeriodo", tags = "BoletaPeriodo")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class BoletaPeriodoController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(BoletaPeriodoController.class);

	@Autowired
	@Qualifier("boletaPeriodoService")
	private BoletaPeriodoService boletaPeriodoService;

	@GetMapping(value = "/findByBoletaPeriodoActiva")
	@ApiOperation(value = "Busca  BoletaPeriodo activa")
	public ResponseEntity<BoletaPeriodo> findByBolpEstado(@RequestHeader(name = "Authorization") String token) {
		BoletaPeriodo boletaPeriodo = boletaPeriodoService.findByBolpEstado();
		return ResponseEntity.ok(boletaPeriodo);

	}

	@GetMapping(value = "/findById/{bolpId}")
	@ApiOperation(value = "Busca  BoletaPeriodo activa")
	public ResponseEntity<Optional<BoletaPeriodo>> findByBolPeridoById(@Valid @PathVariable String bolpId,
			@RequestHeader(name = "Authorization") String token) {
		Optional<BoletaPeriodo> boletaPeriodo = boletaPeriodoService.findById(Integer.parseInt(bolpId));
		return ResponseEntity.ok(boletaPeriodo);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
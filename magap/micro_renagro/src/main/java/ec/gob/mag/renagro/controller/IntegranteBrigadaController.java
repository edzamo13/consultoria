package ec.gob.mag.renagro.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.domain.IntegranteBrigada;
import ec.gob.mag.renagro.dto.ResponseUpdate;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.services.BrigadaService;
import ec.gob.mag.renagro.services.IntengranteBrigadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/integranteBrigada")
@Api(value = "Brigada", description = "Rest Api de integranteBrigada", tags = "integranteBrigada")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class IntegranteBrigadaController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(IntegranteBrigadaController.class);

	@Autowired
	@Qualifier("intengranteBrigadaService")
	private IntengranteBrigadaService intengranteBrigadaService;

	@Autowired
	private BrigadaService brigadaService;

	@PostMapping(value = "/create")
	@ApiOperation(value = "Crea una nueva brigada")
	public ResponseEntity<ResponseUpdate> creaIntegranteBrigada(@RequestBody IntegranteBrigada integranteBrigada,
			@RequestHeader(name = "Authorization") String token) {
		try {
			Brigada brigada = new Brigada();
			brigada.setBriId(Long.valueOf(integranteBrigada.getBriId()));
			IntegranteBrigada integrante = new IntegranteBrigada();
			List<IntegranteBrigada> integranteActivos = new ArrayList<>();
			integrante = intengranteBrigadaService.findByBrigadaEqualsAndUsupIdEqualsAndIntbEstadoEquals(brigada,
					integranteBrigada.getUsupId(), Constante.ESTADO_ACTIVO.getCodigo());
			integranteActivos = intengranteBrigadaService.findByUsupIdEqualsAndIntbEstadoEquals(
					integranteBrigada.getUsupId(), Constante.ESTADO_ACTIVO.getCodigo());

			if (integrante == null && integranteActivos.isEmpty()) {
				integrante = intengranteBrigadaService.findByBrigadaEqualsAndUsupIdEqualsAndIntbEstadoEquals(brigada,
						integranteBrigada.getUsupId(), Constante.ESTADO_PASIVO.getCodigo());
				if (integrante == null) {
					integrante = new IntegranteBrigada(integranteBrigada.getIntbId(),
							Constante.ESTADO_ACTIVO.getCodigo(), new Timestamp(System.currentTimeMillis()),
							new Timestamp(System.currentTimeMillis()), integranteBrigada.getUsupId(),
							integranteBrigada.getUsupIdInsert(), integranteBrigada.getUsupIdUpdate(), brigada);
					integrante = intengranteBrigadaService.save(integrante);
					// cambio
					List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService
							.findByBrigadaEqualsAndIntbEstadoEquals(brigada);
					if (integranteBrigadas.size() >= integranteBrigada.getNumIntegrantes()) {						
						brigada = brigadaService.findById(integrante.getBrigada().getBriId());
						brigada.setBriCompleta(Constante.ESTADO_COMPLETA.getCodigo());
						brigadaService.saveBrigada(brigada);
					}

					return ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseUpdate("IntegranteBrigada ", integrante.getIntbId()));
				} else {

					integrante.setIntbEstado(Constante.ESTADO_ACTIVO.getCodigo());
					integrante.setUsupIdUpdate(integranteBrigada.getUsupIdUpdate());
					integrante = intengranteBrigadaService.save(integrante);
					
					// cambio
					List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService
							.findByBrigadaEqualsAndIntbEstadoEquals(brigada);
					if (integranteBrigadas.size() >= integranteBrigada.getNumIntegrantes()) {
						brigada = brigadaService.findById(integrante.getBrigada().getBriId());
						brigada.setBriCompleta(Constante.ESTADO_COMPLETA.getCodigo());
						brigadaService.saveBrigada(brigada);
					}
					return ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseUpdate("IntegranteBrigada Actualizada!..", integrante.getIntbId()));
				}

			} else {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ResponseUpdate("IntegranteBrigada ya existe!.. Brigada - usuario - Activo", 0l));

			}

		} catch (Exception e) {
			System.out.println("enteroo:" + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@PostMapping(value = "/delete")
	@ApiOperation(value = "Delete una nueva IntegranteBrigada")
	public ResponseEntity<ResponseUpdate> deleteIntegranteBrigada(@Valid @RequestBody IntegranteBrigada id,
			@RequestHeader(name = "Authorization") String token) {
		Brigada brigada = new Brigada();
		IntegranteBrigada integranteBrigada = intengranteBrigadaService.findById(id.getIntbId());
		integranteBrigada.setIntbEstado(Constante.ESTADO_PASIVO.getCodigo());
		integranteBrigada = intengranteBrigadaService.save(integranteBrigada);
		brigada = integranteBrigada.getBrigada();
		brigada.setBriCompleta(Constante.ESTADO_INCOMPLETA.getCodigo());
		brigadaService.saveBrigada(brigada);
		return ResponseEntity.ok(new ResponseUpdate("brigada", integranteBrigada.getIntbId()));
	}

	@GetMapping(value = "/findById/{id}")
	@ApiOperation(value = "Busca brigada por Id estado activo")
	public ResponseEntity<?> getIntegranteBrigadaById(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			IntegranteBrigada integranteBrigada = intengranteBrigadaService.findByIntbId(id);
			if (integranteBrigada != null) {
				integranteBrigada.setBriId(integranteBrigada.getBrigada().getBriId().intValue());
				return ResponseEntity.ok(integranteBrigada);
			} else {
				return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No existe información ID: " + id + "");
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findByBriId/{id}")
	@ApiOperation(value = "Busca integranteBrigada por Id estado activo")
	public ResponseEntity<?> getIntegranteBrigadaByBriId(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			Brigada brigada = new Brigada();
			brigada.setBriId(id);
			List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService
					.findByBrigadaEqualsAndIntbEstadoEquals(brigada);
			if (integranteBrigadas != null) {
				integranteBrigadas.forEach(x -> {
					x.setBriId(x.getBrigada().getBriId().intValue());
				});
				return ResponseEntity.ok(integranteBrigadas);
			} else {
				return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No existe información ID: " + id + "");
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findByUsupId/{id}")
	@ApiOperation(value = "Busca brigada por Id estado activo")
	public ResponseEntity<?> findByUsupIdEqualsAndIntbEstadoEquals(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService
					.findByUsupIdEqualsAndIntbEstadoEquals(id, Constante.ESTADO_ACTIVO.getCodigo());
			if (integranteBrigadas != null && !integranteBrigadas.isEmpty()) {
				integranteBrigadas.forEach(x -> {
					x.setBriId(x.getBrigada().getBriId().intValue());
				});
				return ResponseEntity.ok(integranteBrigadas);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findAll")
	@ApiOperation(value = "Busca todad IntegranteBrigada por estado activo")
	public ResponseEntity<?> findAll(@RequestHeader(name = "Authorization") String token) {
		try {
			List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService.findAll();
			if (integranteBrigadas != null && !integranteBrigadas.isEmpty()) {
				integranteBrigadas.forEach(x -> {
					x.setBriId(x.getBrigada().getBriId().intValue());
				});
				return ResponseEntity.ok(integranteBrigadas);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
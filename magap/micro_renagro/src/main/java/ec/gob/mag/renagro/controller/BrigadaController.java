package ec.gob.mag.renagro.controller;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.domain.IntegranteBrigada;
import ec.gob.mag.renagro.dto.BrigadaDTO;
import ec.gob.mag.renagro.dto.ResponseUpdate;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.services.BoletaPeriodoService;
import ec.gob.mag.renagro.services.BrigadaService;
import ec.gob.mag.renagro.services.IntengranteBrigadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/brigada")
@Api(value = "Brigada", description = "Rest Api de Brigada", tags = "Brigada")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class BrigadaController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(BrigadaController.class);

	@Autowired
	@Qualifier("brigadaService")
	private BrigadaService brigadaService;

	@Autowired
	@Qualifier("boletaPeriodoService")
	private BoletaPeriodoService boletaPeriodoService;

	@Autowired
	private IntengranteBrigadaService intengranteBrigadaService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una nueva Brigada")
	public ResponseEntity<ResponseUpdate> createBrigada(@RequestBody Brigada brigada,
			@RequestHeader(name = "Authorization") String token) {
		String codigoBrigada = "";
		int tamanioBriId = 0;
		BoletaPeriodo boletaPeriodo = new BoletaPeriodo();
		boletaPeriodo = boletaPeriodoService.findByBolpEstado();
		Brigada tmp = new Brigada(new Long(0), brigada.getBriCodigo(), brigada.getBriDescripcion(),
				Constante.ESTADO_ACTIVO.getCodigo(), new Timestamp(System.currentTimeMillis()),
				brigada.getUsupIdInsert(), new Timestamp(System.currentTimeMillis()), brigada.getUsupIdInsert(),
				brigada.getBriVehiculoAsignado(), brigada.getBriVehiculoEstado(),
				Constante.ESTADO_INCOMPLETA.getCodigo(), boletaPeriodo);

		Brigada brigadaResponse = brigadaService.saveBrigada(tmp);
		tamanioBriId = Long.toString(brigadaResponse.getBriId()).length();
		if (tamanioBriId == 3) {
			codigoBrigada = "-" + String.valueOf(brigadaResponse.getBriId());
		} else if (tamanioBriId == 2) {
			codigoBrigada = "-0" + String.valueOf(brigadaResponse.getBriId());
		} else if (tamanioBriId == 1) {
			codigoBrigada = "-00" + String.valueOf(brigadaResponse.getBriId());
		}
		brigadaResponse.setBriCodigo(brigada.getBriCodigo() + codigoBrigada);

		brigadaResponse = brigadaService.saveBrigada(brigadaResponse);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseUpdate("brigada", brigadaResponse.getBriId()));

	}

	@PostMapping(value = "/update")
	@ApiOperation(value = "Actualiza una brigada", response = ResponseUpdate.class)
	public ResponseEntity<ResponseUpdate> updateBrigada(@Valid @RequestBody Brigada brigada,
			@RequestHeader(name = "Authorization") String token) {
		BoletaPeriodo boletaPeriodo = new BoletaPeriodo();
		boletaPeriodo = boletaPeriodoService.findByBolpEstado();
		brigada.setBoletaPeriodo(boletaPeriodo);
		Brigada bri = brigadaService.findByBriIdEqualsAndBriEstadoEquals(brigada.getBriId());
		bri.setBriCodigo(brigada.getBriCodigo());
		bri.setBriDescripcion(brigada.getBriDescripcion());
		bri.setBriUpdate(new Timestamp(System.currentTimeMillis()));
		bri.setUsupIdInsert(brigada.getUsupIdInsert());
		bri.setBriVehiculoAsignado(brigada.getBriVehiculoAsignado());
		bri.setBriVehiculoEstado(brigada.getBriVehiculoEstado());
		bri = brigadaService.saveBrigada(brigada);
		return ResponseEntity.ok(new ResponseUpdate("brigada", bri.getBriId()));
	}

	@PostMapping(value = "/delete")
	@ApiOperation(value = "Delete Lógico una  brigada")
	public ResponseEntity<ResponseUpdate> deleteBrigada(@Valid @RequestBody Brigada id,
			@RequestHeader(name = "Authorization") String token) {
		Brigada brigadaResponse = brigadaService.findById(id.getBriId());
		brigadaResponse.setBriEstado(Constante.ESTADO_PASIVO.getCodigo());
		brigadaResponse = brigadaService.saveBrigada(brigadaResponse);
		return ResponseEntity.ok(new ResponseUpdate("brigada", brigadaResponse.getBriId()));
	}

	@GetMapping(value = "/findById/{id}")
	@ApiOperation(value = "Busca brigada por Id", response = Brigada.class)
	public ResponseEntity<?> getBrigadaByIdEstadoActivo(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			Brigada brigada = brigadaService.findByBriIdEqualsAndBriEstadoEquals(id);
			if (brigada != null) {
				brigada.setBolpId(brigada.getBoletaPeriodo().getBolpId());
				return ResponseEntity.ok().body(brigada);
			} else {
				return (ResponseEntity<?>) ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findByIdAndbolpId/{id}/{bolpId}")
	@ApiOperation(value = "Busca brigada por Id", response = Brigada.class)
	public ResponseEntity<?> getBrigadaByIdEstadoActivo(@Valid @PathVariable Long id, @PathVariable Long bolpId,
			@RequestHeader(name = "Authorization") String token) {
		try {
			Brigada brigada = brigadaService.findByBriIdEqualsAndBriEstadoEquals(id);
			if (brigada != null) {
				brigada.setBolpId(brigada.getBoletaPeriodo().getBolpId());
				return ResponseEntity.ok().body(brigada);
			} else {
				return (ResponseEntity<?>) ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findAll")
	@ApiOperation(value = "Busca todas brigada")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Brigada>> getBrigadaAll(@RequestHeader(name = "Authorization") String token) {
		List<Brigada> brigadas = brigadaService.findAll();
		brigadas.forEach(x -> {
			x.setBolpId(x.getBoletaPeriodo().getBolpId());
		});
		return ResponseEntity.ok(brigadas);

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/findByUsupIdInsert/{id}")
	@ApiOperation(value = "Busca brigada por UsupIdInsert")
	public ResponseEntity<List<Brigada>> getBrigadaByUsupIdInsert(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			List<Brigada> brigadas = brigadaService.findByUsupIdInsertEquals(id);
			if (brigadas != null) {
				for (Brigada b : brigadas) {
					b.setBolpId(b.getBoletaPeriodo().getBolpId());
				}
				return ResponseEntity.ok().body(brigadas);
			} else
				return (ResponseEntity<List<Brigada>>) ResponseEntity.status(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/findByUsupIdInsertTipo")
	@ApiOperation(value = "Busca brigada por UsupIdInsert y tipo completa o incompleta")
	public ResponseEntity<List<Brigada>> brigadaByUsupIdInsert(@Valid @RequestBody Brigada brigada,
			@RequestHeader(name = "Authorization") String token) {
		try {
			List<Brigada> brigadas = brigadaService.getBrigadaByUsupIdInsertAndTipo(brigada.getUsupIdInsert(),
					brigada.getBriCompleta());
			if (brigadas != null) {
				for (Brigada b : brigadas) {
					b.setBolpId(b.getBoletaPeriodo().getBolpId());
				}
				return ResponseEntity.ok().body(brigadas);
			} else
				return (ResponseEntity<List<Brigada>>) ResponseEntity.status(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findByIdBrigadaBrigadaBoletaIntegrante/{id}")
	@ApiOperation(value = "Busca brigada por Id estado activo")
	public ResponseEntity<BrigadaDTO> findByIdBrigadaBrigadaBoletaIntegrante(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		// , @RequestHeader(name = "Authorization") String token
		BoletaPeriodo boletaPeriodo = boletaPeriodoService.findByBolpEstado();
		System.out.println("BoletaPeriodo a consultar:" + boletaPeriodo.getBolpId());
		Brigada brigada = brigadaService.findByBriIdEqualsAndBoletaPeriodoEqualsAndBriEstadoEquals(id, boletaPeriodo);

		System.out.println("brigada a consultar**********************************:" + brigada.getBriId());

		List<IntegranteBrigada> integranteBrigadas = intengranteBrigadaService
				.findByBrigadaEqualsAndIntbEstadoEquals(brigada);

		for (IntegranteBrigada integranteBrigada : integranteBrigadas) {
			System.out.println("integrante" + integranteBrigada.getIntbId());
		}
		return null;

	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
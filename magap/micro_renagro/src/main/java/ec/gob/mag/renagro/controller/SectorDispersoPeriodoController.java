package ec.gob.mag.renagro.controller;

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

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.domain.BrigadaSector;
import ec.gob.mag.renagro.domain.SectorDisperso;
import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;
import ec.gob.mag.renagro.dto.ResponseUpdate;
import ec.gob.mag.renagro.dto.SectorDispersoPeriodoAllDTO;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.services.BrigadaSectorService;
import ec.gob.mag.renagro.services.SectorDispersoPeriodoService;
import ec.gob.mag.renagro.util.ListaSql;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sectorDispersoPeriodo")
@Api(value = "sectorDispersoPeriodo", description = "Rest Api de sectorDispersoPeriodo", tags = "sectorDispersoPeriodo")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class SectorDispersoPeriodoController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(SectorDispersoPeriodoController.class);

	@Autowired
	@Qualifier("sectorDispersoPeriodoService")
	private SectorDispersoPeriodoService sectorDispersoPeriodoService;

	@Autowired
	private BrigadaSectorService brigadaSectorService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una nueva sectorDispersoPeriodo")
	public ResponseEntity<ResponseUpdate> createBrigada(@RequestBody SectorDispersoPeriodo sectorDispersoPeriodo,
			@RequestHeader(name = "Authorization") String token) {
		BoletaPeriodo boletaPeriodo = new BoletaPeriodo();
		boletaPeriodo.setBolpId(sectorDispersoPeriodo.getBolpId());
		SectorDisperso sectorDisperso = new SectorDisperso();
		sectorDisperso.setSecdId(sectorDispersoPeriodo.getSecdId());
		sectorDispersoPeriodo.setBoletaPeriodo(boletaPeriodo);
		sectorDispersoPeriodo.setSectorDisperso(sectorDisperso);
		sectorDispersoPeriodo = sectorDispersoPeriodoService.saveSectorDispersoPeriodo(sectorDispersoPeriodo);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseUpdate("sectorDispersoPeriodo", Long.valueOf(sectorDispersoPeriodo.getSedpId())));

	}

	@PostMapping(value = "/update")
	@ApiOperation(value = "Actualiza una SectorDispersoPeriodo", response = ResponseUpdate.class)
	public ResponseEntity<ResponseUpdate> updateBrigada(@Valid @RequestBody SectorDispersoPeriodo sectorDispersoPeriodo,
			@RequestHeader(name = "Authorization") String token) {
		SectorDispersoPeriodo sectorDispersoP = new SectorDispersoPeriodo();
		sectorDispersoP = sectorDispersoPeriodoService.findById(sectorDispersoPeriodo.getSedpId());
		sectorDispersoP.setSedpEstadoAvance(sectorDispersoPeriodo.getSedpEstadoAvance());
		sectorDispersoP = sectorDispersoPeriodoService.saveSectorDispersoPeriodo(sectorDispersoP);

		if (sectorDispersoP.getSedpEstadoAvance().equals(Constante.ESTADO_CODIGOCERRADO.getCodigo())) {
			List<BrigadaSector> brigadaSectors = brigadaSectorService
					.findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(sectorDispersoP);
			for (BrigadaSector b : brigadaSectors) {
				b.setBrisEstado(0);
				b = brigadaSectorService.saveBrigadaSector(b);

			}

		}

		return ResponseEntity
				.ok(new ResponseUpdate("SectorDispersoPeriodo", Long.valueOf(sectorDispersoP.getSedpId())));
	}

	@PostMapping(value = "/delete")
	@ApiOperation(value = "Delete Lógico una  brigada")
	public ResponseEntity<ResponseUpdate> deleteBrigada(@Valid @RequestBody SectorDispersoPeriodo id,
			@RequestHeader(name = "Authorization") String token) {
		SectorDispersoPeriodo sectorDispersoP = new SectorDispersoPeriodo();
		sectorDispersoP = sectorDispersoPeriodoService.findById(id.getSedpId());
		sectorDispersoP.setSedpEstado(Constante.ESTADO_PASIVO.getCodigo());
		sectorDispersoP = sectorDispersoPeriodoService.saveSectorDispersoPeriodo(sectorDispersoP);
		return ResponseEntity
				.ok(new ResponseUpdate("SectorDispersoPeriodo", Long.valueOf(sectorDispersoP.getSedpId())));
	}

	@GetMapping(value = "/findById/{id}")
	@ApiOperation(value = "Busca brigada por Id", response = SectorDispersoPeriodo.class)
	public ResponseEntity<?> getBrigadaByIdEstadoActivo(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			SectorDispersoPeriodo sectorDispersoPeriodo = sectorDispersoPeriodoService.findById(id);
			if (sectorDispersoPeriodo != null) {
				sectorDispersoPeriodo.setBolpId(sectorDispersoPeriodo.getBoletaPeriodo().getBolpId());
				sectorDispersoPeriodo.setSecdId(sectorDispersoPeriodo.getSectorDisperso().getSecdId());
				return ResponseEntity.ok().body(sectorDispersoPeriodo);
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe información ID: " + id + "");

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/findByBolpId/{id}")
	@ApiOperation(value = "Busca brigada por Id", response = SectorDispersoPeriodo.class)
	public ResponseEntity<?> findBySedpEstadoEqualsAndBoletaPeriodoEquals(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			List<Object[]> sectorDispersoPeriodos = sectorDispersoPeriodoService
					.findBySedpEstadoEqualsAndBoletaPeriodoEquals(id);

			List<SectorDispersoPeriodoAllDTO> allDTOs = ListaSql.retornarDatos(sectorDispersoPeriodos,
					SectorDispersoPeriodoAllDTO.class);

			if (allDTOs != null) {
				return ResponseEntity.ok().body(allDTOs);
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe información ID: " + id + "");

		} catch (Throwable e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}

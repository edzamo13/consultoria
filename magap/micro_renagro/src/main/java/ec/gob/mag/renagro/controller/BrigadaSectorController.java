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

import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.domain.BrigadaSector;
import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;
import ec.gob.mag.renagro.dto.BrigadaSectorCountDTO;
import ec.gob.mag.renagro.dto.BrigadaSectorDTO;
import ec.gob.mag.renagro.dto.ResponseUpdate;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.services.BrigadaSectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/brigadaSector")
@Api(value = "brigadaSector", description = "Rest Api de brigadaSector", tags = "brigadaSector")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 201, message = "Objeto creado"),
		@ApiResponse(code = 404, message = "Recurso no encontrado"),
		@ApiResponse(code = 500, message = "Error interno") })
public class BrigadaSectorController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(BrigadaSectorController.class);

	@Autowired
	@Qualifier("brigadaSectorService")
	private BrigadaSectorService brigadaSectorService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crea una nueva BrigadaSector")
	public ResponseEntity<ResponseUpdate> createBrigadaSector(@RequestBody BrigadaSector brigadaSector,
			@RequestHeader(name = "Authorization") String token) {

		SectorDispersoPeriodo sectorDispersoPeriodo = new SectorDispersoPeriodo();
		sectorDispersoPeriodo.setSedpId(brigadaSector.getSedpId());

		BrigadaSector brigadaS = new BrigadaSector(new Long(0l), brigadaSector.getBriId(),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				brigadaSector.getUsupIdInsert(), brigadaSector.getUsupIdUpdate(), Constante.ESTADO_ACTIVO.getCodigo(),
				sectorDispersoPeriodo);

		brigadaS = brigadaSectorService.saveBrigadaSector(brigadaS);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseUpdate("brigada", Long.valueOf(brigadaS.getBrisId())));

	}

	@PostMapping(value = "/update")
	@ApiOperation(value = "Actualiza una brigada", response = ResponseUpdate.class)
	public ResponseEntity<ResponseUpdate> updateBrigadaSector(@Valid @RequestBody BrigadaSector brigadaSector,
			@RequestHeader(name = "Authorization") String token) {
		BrigadaSector brigadaS = brigadaSectorService.findByBrisIdEquals(brigadaSector.getBrisId());
		brigadaS.setBrisEstado(Constante.ESTADO_ACTIVO.getCodigo());
		brigadaS = brigadaSectorService.saveBrigadaSector(brigadaS);

		return ResponseEntity.ok(new ResponseUpdate("BrigadaSector", brigadaS.getBrisId()));
	}

	@PostMapping(value = "/delete")
	@ApiOperation(value = "Delete Lógico una  BrigadaSector")
	public ResponseEntity<ResponseUpdate> deleteBrigada(@Valid @RequestBody BrigadaSector id,
			@RequestHeader(name = "Authorization") String token) {
		BrigadaSector brigadaS = brigadaSectorService.findByBrisIdEquals(id.getBrisId());
		brigadaS.setBrisEstado(Constante.ESTADO_PASIVO.getCodigo());
		brigadaS = brigadaSectorService.saveBrigadaSector(brigadaS);

		return ResponseEntity.ok(new ResponseUpdate("BrigadaSector", brigadaS.getBrisId()));
	}

	@GetMapping(value = "/findById/{id}")
	@ApiOperation(value = "Busca brigada por Id", response = Brigada.class)
	public ResponseEntity<?> getBrigadaSectorByIdEstadoActivo(@Valid @PathVariable Long id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			BrigadaSector brigadaSector = brigadaSectorService.findById(id);
			if (brigadaSector != null) {
				brigadaSector.setSedpId(brigadaSector.getSectorDispersoPeriodo().getSedpId());
				return ResponseEntity.ok().body(brigadaSector);
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe información ID: " + id + "");

		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/findByBriId/{id}")
	@ApiOperation(value = "Busca brigada por briId", response = Brigada.class)
	public ResponseEntity<?> getBrigadaSectorByBriId(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			List<BrigadaSector> brigadaSector = brigadaSectorService.findByBriId(id);
			if (brigadaSector != null) {
				brigadaSector.forEach(x -> {
					x.setSedpId(x.getSectorDispersoPeriodo().getSedpId());

				});
				return ResponseEntity.ok().body(brigadaSector);
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe información ID: " + id + "");

		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/findAll")
	@ApiOperation(value = "Busca todas brigada")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<BrigadaSector>> getBrigadaSectorAll(
			@RequestHeader(name = "Authorization") String token) {
		List<BrigadaSector> brigadaSectors = brigadaSectorService.findAll();
		brigadaSectors.forEach(x -> {
			x.setSedpId(x.getSectorDispersoPeriodo().getSedpId());

		});
		return ResponseEntity.ok(brigadaSectors);
	}

	@GetMapping(value = "/usupIdInsert/{id}")
	@ApiOperation(value = "Busca brigada por Id", response = Brigada.class)
	public ResponseEntity<?> getBrigadaSectorUsupIdInsert(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {

			List<BrigadaSectorDTO> brigadaSectores = brigadaSectorService.getBrigadaSectorUsupIdInsert(id);
			if (brigadaSectores != null) {
				return ResponseEntity.status(HttpStatus.OK).body(brigadaSectores);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe información ID: " + id + "");
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/sedpId/{id}")
	@ApiOperation(value = "Busca brigada Sector por sedpId", response = Brigada.class)
	public ResponseEntity<?> findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			BrigadaSectorCountDTO dto = new BrigadaSectorCountDTO();
			SectorDispersoPeriodo sectorDispersoPeriodo = new SectorDispersoPeriodo();
			sectorDispersoPeriodo.setSedpId(id);
			Integer count = brigadaSectorService
					.findBySectorDispersoPeriodoEqualsAndBrisEstadoEqualsSize(sectorDispersoPeriodo);
			dto.setSedpId(id);
			dto.setCount(count);
			return ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping(value = "/findSedpId/{id}")
	@ApiOperation(value = "Busca brigada Sector por sedpId", response = Brigada.class)
	public ResponseEntity<?> findBySectorDispersoPeriodoEqualsAndBrisEstadoEqualsAll(@Valid @PathVariable Integer id,
			@RequestHeader(name = "Authorization") String token) {
		try {
			SectorDispersoPeriodo sectorDispersoPeriodo = new SectorDispersoPeriodo();
			sectorDispersoPeriodo.setSedpId(id);
			List<BrigadaSector> brigadaSectors = brigadaSectorService
					.findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(sectorDispersoPeriodo);

			return ResponseEntity.status(HttpStatus.OK).body(brigadaSectors);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
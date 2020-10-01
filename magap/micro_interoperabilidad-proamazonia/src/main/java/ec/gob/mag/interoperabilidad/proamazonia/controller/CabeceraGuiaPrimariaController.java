package ec.gob.mag.interoperabilidad.proamazonia.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.mag.interoperabilidad.proamazonia.domain.CabeceraGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoClienteFinalGp;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoExportacionGp;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoIndustriaForestalGp;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DetalleGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.dto.CabeceraGuiaPrimariaDto;
import ec.gob.mag.interoperabilidad.proamazonia.dto.DestinoClienteFinalGpDto;
import ec.gob.mag.interoperabilidad.proamazonia.dto.DestinoExportacionGpDto;
import ec.gob.mag.interoperabilidad.proamazonia.dto.DestinoIndustriaForestalGpDto;
import ec.gob.mag.interoperabilidad.proamazonia.dto.DetalleGuiaPrimariaDto;
import ec.gob.mag.interoperabilidad.proamazonia.services.CabeceraGuiaPrimariaService;
import ec.gob.mag.interoperabilidad.proamazonia.services.DestinoClienteFinalGpService;
import ec.gob.mag.interoperabilidad.proamazonia.services.DestinoExportacionGpService;
import ec.gob.mag.interoperabilidad.proamazonia.services.DestinoIndustriaForestalGpService;
import ec.gob.mag.interoperabilidad.proamazonia.services.DetalleGuiaPrimariaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cabeceraGuiaPrimaria")
@Api(value = "Rest Api example", tags = "OFFICER")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 200, message = "SUCESS"), @ApiResponse(code = 404, message = "RESOURCE NOT FOUND"),
		@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 201, message = "CREATED"),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 415, message = "UNSUPPORTED TYPE - Representation not supported for the resource"),
		@ApiResponse(code = 500, message = "SERVER ERROR") })
public class CabeceraGuiaPrimariaController implements ErrorController {
	private static final String PATH = "/error";
	public static final Logger LOGGER = LoggerFactory.getLogger(CabeceraGuiaPrimariaController.class);

	@Autowired
	@Qualifier("cabeceraGuiaPrimariaService")
	private CabeceraGuiaPrimariaService cabeceraGuiaPrimariaService;

	@Autowired
	@Qualifier("detalleGuiaPrimariaService")
	private DetalleGuiaPrimariaService detalleGuiaPrimariaService;

	@Autowired
	@Qualifier("destinoClienteFinalGpService")
	private DestinoClienteFinalGpService destinoClienteFinalGpService;

	@Autowired
	@Qualifier("destinoExportacionGpService")
	private DestinoExportacionGpService destinoExportacionGpService;

	@Autowired
	@Qualifier("destinoIndustriaForestalGpService")
	private DestinoIndustriaForestalGpService destinoIndustriaForestalGpService;

	/**
	 * Busca todos los registros de la entidad
	 * 
	 * @param id: Identificador de la entidad
	 * @return Entidad: Retorna todos los registros
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene todos los registros no eliminados logicamente", response = CabeceraGuiaPrimaria.class)
	public ResponseEntity<List<CabeceraGuiaPrimariaDto>> findAll(@RequestHeader(name = "Authorization") String token) {
		List<CabeceraGuiaPrimaria> cabeceraGuiaPrimarias = cabeceraGuiaPrimariaService.buscarCabecera();
		List<CabeceraGuiaPrimariaDto> cabeceraGuiaPrimariaDtos = new ArrayList<CabeceraGuiaPrimariaDto>();
		cabeceraGuiaPrimariaDtos = buscarDestinoDetalle(cabeceraGuiaPrimarias);
		return ResponseEntity.ok(cabeceraGuiaPrimariaDtos);
	}

	/**
	 * - Permite recorrer para buscar por el destino y Detalle
	 * 
	 * @param List<CabeceraGuiaPrimaria>
	 * @return List<CabeceraGuiaPrimariaDto>
	 */
	private List<CabeceraGuiaPrimariaDto> buscarDestinoDetalle(List<CabeceraGuiaPrimaria> cabeceraGuiaPrimarias) {

		List<CabeceraGuiaPrimariaDto> cabeceraGuiaPrimariaDtos = new ArrayList<CabeceraGuiaPrimariaDto>();
		ModelMapper modelMapper = new ModelMapper();
		for (CabeceraGuiaPrimaria cabeceraGuiaPrimaria : cabeceraGuiaPrimarias) {
			CabeceraGuiaPrimariaDto guiaPrimariaDto = modelMapper.map(cabeceraGuiaPrimaria,
					CabeceraGuiaPrimariaDto.class);
			guiaPrimariaDto.setDetalleGuiaPrimariaDtos(buscarDetalle(cabeceraGuiaPrimaria));
			guiaPrimariaDto = buscarDestino(guiaPrimariaDto);

			cabeceraGuiaPrimariaDtos.add(guiaPrimariaDto);
			// System.out.println("cabecera" + guiaPrimariaDto.toString());

		}

		return cabeceraGuiaPrimariaDtos;
	}

	/**
	 * - Permite recorrer para buscar el Tipo de destino de la Guia
	 * 
	 * 
	 * @param CabeceraGuiaPrimariaDto
	 * @return CabeceraGuiaPrimariaDto
	 */
	private CabeceraGuiaPrimariaDto buscarDestino(CabeceraGuiaPrimariaDto cabeceraGuiaPrimariaDto) {
		ModelMapper modelMapper = new ModelMapper();
		DestinoClienteFinalGp destinoClienteFinalGp = destinoClienteFinalGpService
				.buscarGmvCodigo(cabeceraGuiaPrimariaDto.getGmvCodigo());
		DestinoExportacionGp destinoExportacionGp = destinoExportacionGpService
				.buscarGmvCodigo(cabeceraGuiaPrimariaDto.getGmvCodigo());
		DestinoIndustriaForestalGp destinoIndustriaForestalGp = destinoIndustriaForestalGpService
				.buscarGmvCodigo(cabeceraGuiaPrimariaDto.getGmvCodigo());

		if (destinoClienteFinalGp != null) {
			DestinoClienteFinalGpDto destinoClienteFinalGpDto = modelMapper.map(destinoClienteFinalGp,
					DestinoClienteFinalGpDto.class);
			cabeceraGuiaPrimariaDto.setDestinoClienteFinalGpDtos(new ArrayList<DestinoClienteFinalGpDto>());
			cabeceraGuiaPrimariaDto.getDestinoClienteFinalGpDtos().add(destinoClienteFinalGpDto);
		} else if (destinoExportacionGp != null) {
			DestinoExportacionGpDto destinoExportacionGpDto = modelMapper.map(destinoExportacionGp,
					DestinoExportacionGpDto.class);
			cabeceraGuiaPrimariaDto.setDestinoExportacionGpDtos(new ArrayList<DestinoExportacionGpDto>());
			cabeceraGuiaPrimariaDto.getDestinoExportacionGpDtos().add(destinoExportacionGpDto);
		} else if (destinoIndustriaForestalGp != null) {
			DestinoIndustriaForestalGpDto destinoIndustriaForestalGpDto = modelMapper.map(destinoIndustriaForestalGp,
					DestinoIndustriaForestalGpDto.class);
			cabeceraGuiaPrimariaDto.setDestinoIndustriaForestalGpDtos(new ArrayList<DestinoIndustriaForestalGpDto>());
			cabeceraGuiaPrimariaDto.getDestinoIndustriaForestalGpDtos().add(destinoIndustriaForestalGpDto);
		}

		return cabeceraGuiaPrimariaDto;
	}

	/**
	 * - Permite recorrer para buscar el Detalle de la Guia
	 * 
	 * @param CabeceraGuiaPrimaria
	 * @return List<DetalleGuiaPrimariaDto>
	 */
	private List<DetalleGuiaPrimariaDto> buscarDetalle(CabeceraGuiaPrimaria cabeceraGuiaPrimaria) {
		DetalleGuiaPrimariaDto detalleGuiaPrimariaDto = new DetalleGuiaPrimariaDto();
		List<DetalleGuiaPrimariaDto> detalleGuiaPrimariaDtos = new ArrayList<DetalleGuiaPrimariaDto>();
		List<DetalleGuiaPrimaria> detalleGuiaPrimarias = detalleGuiaPrimariaService.buscarGmvId(cabeceraGuiaPrimaria);
		if (detalleGuiaPrimarias.size() > 0) {
			/*
			 * List<DetalleGuiaPrimaria> guiaPrimarias = detalleGuiaPrimarias.stream()
			 * .filter(x -> x.getGmvId().getGmvId().equals(cabeceraGuiaPrimaria.getGmvId()))
			 * .collect(Collectors.toList());
			 */
			ModelMapper modelMapper = new ModelMapper();
			for (DetalleGuiaPrimaria detalle : detalleGuiaPrimarias) {
				detalleGuiaPrimariaDto = modelMapper.map(detalle, DetalleGuiaPrimariaDto.class);
				detalleGuiaPrimariaDtos.add(detalleGuiaPrimariaDto);
			}
			return detalleGuiaPrimariaDtos;
		} else {
			return null;
		}

	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}

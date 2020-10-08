package ec.gob.mag.renagro.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import ec.gob.mag.renagro.domain.BrigadaSector;
import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;
import ec.gob.mag.renagro.dto.BrigadaSectorDTO;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.repository.BrigadaRepository;
import ec.gob.mag.renagro.repository.BrigadaSectorRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

/**
 * Clase BrigadaService.
 *
 * @author renagro
 * @version 1.0.0
 */

@Service("brigadaSectorService")
public class BrigadaSectorService {
	@Autowired
	@Qualifier("brigadaSectorRepository")
	private BrigadaSectorRepository brigadaSectorRepository;

	@Autowired
	private BrigadaRepository brigadaRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca una Brigada por Id
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public BrigadaSector findByBrisIdEquals(Long id) {
		BrigadaSector brigadaSector = brigadaSectorRepository.findByBrisIdEquals(id);
		if (brigadaSector == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", id.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return brigadaSector;
	}

	/**
	 * Busca una Brigada por Id
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public BrigadaSector findById(Long id) {
		BrigadaSector brigadaSector = brigadaSectorRepository.findByBrisIdEqualsAndBrisEstadoEquals(id,
				Constante.ESTADO_ACTIVO.getCodigo());
		if (brigadaSector == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", id.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return brigadaSector;
	}

	/**
	 * Busca una Brigada por briId
	 *
	 * @param Long briId
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public List<BrigadaSector> findByBriId(Integer briId) {
		List<BrigadaSector> brigadaSector = brigadaSectorRepository.findByBriIdAndBrisEstadoEquals(briId,
				Constante.ESTADO_ACTIVO.getCodigo());
		if (brigadaSector == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", briId.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return brigadaSector;
	}

	/**
	 * Crea una nueva Brigada
	 *
	 * @param BrigadaDTO Brigada
	 * @return Brigada.
	 */
	public BrigadaSector saveBrigadaSector(BrigadaSector brigadaSector) {
		return brigadaSectorRepository.save(brigadaSector);
	}

	/**
	 * Busca todas las Brigadas
	 * 
	 * @param
	 * @return List<BrigadaSector>
	 */
	public List<BrigadaSector> findAll() {
		return brigadaSectorRepository.findByBrisEstadoEquals(Constante.ESTADO_ACTIVO.getCodigo());
	}

	/**
	 * Busca todas las getBrigadaSectorUsupIdInsert
	 * 
	 * @param
	 * @return List<BrigadaSector>
	 */
	public List<BrigadaSectorDTO> getBrigadaSectorUsupIdInsert(Integer usupIdInsert) {

		List<BrigadaSectorDTO> brigadaSectorDTOs = new ArrayList<>();
		List<BrigadaSector> brigadaSectors = brigadaSectorRepository
				.findByUsupIdInsertEqualsAndBrisEstadoEquals(usupIdInsert, Constante.ESTADO_ACTIVO.getCodigo());

		ModelMapper modelMapper = new ModelMapper();

		for (BrigadaSector brigadaSector : brigadaSectors) {
			brigadaSector.setBrigada(brigadaRepository.findByBriIdEqualsAndBriEstadoEquals(
					brigadaSector.getBriId().longValue(), Constante.ESTADO_ACTIVO.getCodigo()));
			BrigadaSectorDTO dto = modelMapper.map(brigadaSector, BrigadaSectorDTO.class);
			brigadaSectorDTOs.add(dto);
		}

		return brigadaSectorDTOs;

	}

	/**
	 * Busca todas las SectorDispersoPeriodo activos y se envia la cantidad
	 * encontrada
	 * 
	 * @param
	 * @return Integer
	 */
	public Integer findBySectorDispersoPeriodoEqualsAndBrisEstadoEqualsSize(
			SectorDispersoPeriodo sectorDispersoPeriodo) {
		List<BrigadaSector> brigadaSectors = brigadaSectorRepository
				.findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(sectorDispersoPeriodo,
						Constante.ESTADO_ACTIVO.getCodigo());
		return brigadaSectors.size();

	}

	/**
	 * Busca todas las SectorDispersoPeriodo sectorDispersoPeriodo
	 * 
	 * @param
	 * @return Integer
	 */
	public List<BrigadaSector> findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(
			SectorDispersoPeriodo sectorDispersoPeriodo) {
		List<BrigadaSector> brigadaSectors = brigadaSectorRepository
				.findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(sectorDispersoPeriodo,
						Constante.ESTADO_ACTIVO.getCodigo());
		return brigadaSectors;

	}
	
	

}

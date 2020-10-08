package ec.gob.mag.renagro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.repository.SectorDispersoPeriodoRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

/**
 * Clase SectorDispersoPeriodoService.
 *
 * @author renagro
 * @version 1.0.0
 */

@Service("sectorDispersoPeriodoService")
public class SectorDispersoPeriodoService {

	@Autowired
	@Qualifier("sectorDispersoPeriodoRepository")
	private SectorDispersoPeriodoRepository sectorDispersoPeriodoRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca una SectorDispersoPeriodo por Id
	 *
	 * @param Long id
	 * @return SectorDispersoPeriodo, devuelve el objeto con información de
	 *         SectorDispersoPeriodo.
	 */
	public SectorDispersoPeriodo findById(Integer id) {
		SectorDispersoPeriodo sectorDispersoPeriodo = sectorDispersoPeriodoRepository
				.findBySedpIdEqualsAndSedpEstadoEquals(id, Constante.ESTADO_ACTIVO.getCodigo());
		if (sectorDispersoPeriodo == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", id.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return sectorDispersoPeriodo;
	}

	/**
	 * Crea una nueva SectorDispersoPeriodo
	 *
	 * @param BrigadaDTO SectorDispersoPeriodo
	 * @return SectorDispersoPeriodo.
	 */
	public SectorDispersoPeriodo saveSectorDispersoPeriodo(SectorDispersoPeriodo sectorDispersoPeriodo) {
		return sectorDispersoPeriodoRepository.save(sectorDispersoPeriodo);
	}
	
	/**
	 * Busca  boletaPeriodo y estado Activo
	 *
	 * @param Long id 
	 * @return List<SectorDispersoPeriodo>.
	 */
	public List<Object[]> findBySedpEstadoEqualsAndBoletaPeriodoEquals(Integer bolpId) {
		List<Object[]> sectorDispersoPeriodos = sectorDispersoPeriodoRepository
				.findBySedpEstadoEqualsAndBoletaPeriodoEquals(Constante.ESTADO_ACTIVO.getCodigo(),bolpId );
		return sectorDispersoPeriodos;
	}

}

package ec.gob.mag.renagro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.repository.BrigadaRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

/**
 * Clase BrigadaService.
 *
 * @author renagro
 * @version 1.0.0
 */

@Service("brigadaService")
public class BrigadaService {
	@Autowired
	@Qualifier("brigadaRepository")
	private BrigadaRepository brigadaRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca una Brigada por Id
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public Brigada findById(Long id) {
		Brigada brigada = brigadaRepository.findById(id).get();
		if (brigada == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", id.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return brigada;
	}

	/**
	 * Busca una Brigada por Id y estado Activo
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public Brigada findByBriIdEqualsAndBriEstadoEquals(Long id) {
		Brigada brigada = brigadaRepository.findByBriIdEqualsAndBriEstadoEquals(id,
				Constante.ESTADO_ACTIVO.getCodigo());
		return brigada;
	}

	/**
	 * Busca una Brigada por Id y estado Activo
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public Brigada findByBriIdEqualsAndBriEstadoEquals(Long id, Integer bolpId) {
		Brigada brigada = brigadaRepository.findByBriIdEqualsAndBriEstadoEqualsAndBoletaPeriodo_bolpId(id,
				Constante.ESTADO_ACTIVO.getCodigo(), bolpId);
		return brigada;
	}

	/**
	 * Crea una nueva Brigada
	 *
	 * @param BrigadaDTO Brigada
	 * @return Brigada.
	 */
	public Brigada saveBrigada(Brigada brigada) {
		return brigadaRepository.save(brigada);
	}

	/**
	 * Busca todas las Brigadas
	 * 
	 * @param
	 * @return List<Brigada>
	 */
	public List<Brigada> findAll() {
		return brigadaRepository.findByBriEstadoEquals(Constante.ESTADO_ACTIVO.getCodigo());
	}

	/**
	 * Busca todas las Brigadas por UsupIdInsert
	 * 
	 * @param usupIdInsert
	 * @param codigo       ESTADO_ACTIVO
	 * @param codigo       ESTADO_COMPLETA
	 * @return List<Brigada>
	 */
	public List<Brigada> findByUsupIdInsertEquals(Integer usupIdInsert) {
		return brigadaRepository.findByUsupIdInsertEqualsAndBriEstadoEquals(usupIdInsert,
				Constante.ESTADO_ACTIVO.getCodigo());
	}

	/**
	 * Busca todas las Brigadas por UsupIdInsert
	 * 
	 * @param usupIdInsert
	 * @param codigo       ESTADO_ACTIVO
	 * @param codigo       ESTADO_COMPLETA
	 * @return List<Brigada>
	 */
	public List<Brigada> getBrigadaByUsupIdInsertAndTipo(Integer usupIdInsert, Integer tipo) {
		return brigadaRepository.findByUsupIdInsertEqualsAndBriEstadoEqualsAndBriCompletaEquals(usupIdInsert,
				Constante.ESTADO_ACTIVO.getCodigo(), tipo);
	}

	/**
	 * Busca todas las Brigadas por boletaPeriodo
	 * 
	 * @param
	 * @return List<Brigada>
	 */
	public Brigada findByBriIdEqualsAndBoletaPeriodoEqualsAndBriEstadoEquals(Long briId, BoletaPeriodo boletaPeriodo) {
		return brigadaRepository.findByBriIdEqualsAndBoletaPeriodoEqualsAndBriEstadoEquals(briId, boletaPeriodo,
				Constante.ESTADO_ACTIVO.getCodigo());
	}

}

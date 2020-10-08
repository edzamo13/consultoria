package ec.gob.mag.renagro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.domain.IntegranteBrigada;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.repository.IntegranteBrigadaRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

/**
 * Clase BrigadaService.
 *
 * @author renagro
 * @version 1.0.0
 */

@Service("intengranteBrigadaService")
public class IntengranteBrigadaService {
	@Autowired
	@Qualifier("integranteBrigadaRepository")
	private IntegranteBrigadaRepository integranteBrigadaRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca una Brigada por Id
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public IntegranteBrigada findById(Long id) {
		IntegranteBrigada integranteBrigada = integranteBrigadaRepository.findById(id).get();
		if (integranteBrigada == null) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message", id.toString(),
					this.getClass(), "findById", EnumTypeExceptions.INFO, EnumCodeExceptions.DATA_NOT_FOUND_DB,
					messageSource);
			throw new MyNotFoundException(msg);
		}
		return integranteBrigada;
	}

	/**
	 * Busca una Brigada por Id Esatdo Activo
	 *
	 * @param Long id
	 * @return Brigada, devuelve el objeto con información de Brigada.
	 */
	public IntegranteBrigada findByIntbId(Long id) {
		IntegranteBrigada integranteBrigada = integranteBrigadaRepository
				.findByIntbEstadoEqualsAndIntbIdEquals(Constante.ESTADO_ACTIVO.getCodigo(), id);
		return integranteBrigada;
	}

	/**
	 * Crea una nueva Brigada
	 *
	 * @param Brigada Brigada
	 * @return Brigada.
	 */
	public IntegranteBrigada save(IntegranteBrigada integranteBrigada) {
		return integranteBrigadaRepository.save(integranteBrigada);
	}

	/**
	 * Busca todas las Brigadas
	 * 
	 * @param
	 * @return List<Brigada>
	 */
	public List<IntegranteBrigada> findAll() {
		return integranteBrigadaRepository.findByIntbEstadoEquals(Constante.ESTADO_ACTIVO.getCodigo());
	}

	/**
	 * Busca todas las findByBrigadaEqualsAndIntbEstadoEquals
	 * 
	 * @param
	 * @return List<IntegranteBrigada>
	 */
	public List<IntegranteBrigada> findByBrigadaEqualsAndIntbEstadoEquals(Brigada brigada) {
		return integranteBrigadaRepository.findByBrigadaEqualsAndIntbEstadoEquals(brigada,
				Constante.ESTADO_ACTIVO.getCodigo());

	}

	/**
	 * Busca todas las claves Unicas usupId, Brigada
	 * 
	 * @param Integer usupId
	 * @param Brigada briId
	 * @return IntegranteBrigada
	 */
	public IntegranteBrigada findByBrigadaEqualsAndUsupIdEqualsAndIntbEstadoEquals(Brigada brigada, Long usupId,
			Integer intbEstado) {
		return integranteBrigadaRepository.findByBrigadaEqualsAndUsupIdEqualsAndIntbEstadoEquals(brigada, usupId,
				intbEstado);
	}

	/**
	 * Busca todas las claves usupId usupId, estado Activo
	 * 
	 * @param Integer usupId
	 * @param Brigada intbEstado
	 * @return List<IntegranteBrigada>
	 */	
	public List<IntegranteBrigada> findByUsupIdEqualsAndIntbEstadoEquals(Long usupId, Integer intbEstado) {
		return integranteBrigadaRepository.findByUsupIdEqualsAndIntbEstadoEquals(usupId, intbEstado);
	}

}

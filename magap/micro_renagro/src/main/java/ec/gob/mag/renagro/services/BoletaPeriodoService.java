package ec.gob.mag.renagro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.enums.Constante;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.repository.BoletaPeriodoRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

/**
 * Clase BrigadaService.
 *
 * @author renagro
 * @version 1.0.0
 */

@Service("boletaPeriodoService")
public class BoletaPeriodoService {
	@Autowired
	@Qualifier("boletaPeriodoRepository")
	private BoletaPeriodoRepository boletaPeriodoRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Busca todas las Brigadas
	 * 
	 * @param
	 * @return List<Brigada>
	 */
	public BoletaPeriodo findByBolpEstado() {
		return boletaPeriodoRepository.findByBolpEstadoEquals(Constante.ESTADO_ACTIVO.getCodigo());
	}

	/**
	 * Busca las Brigadas por Id
	 * 
	 * @param id
	 * @return Optional<BoletaPeriodo>
	 */
	public Optional<BoletaPeriodo> findById(Integer bolpId) {
		Optional<BoletaPeriodo> boletaPeriodo = boletaPeriodoRepository.findByBolpId(bolpId);
		if (!boletaPeriodo.isPresent()) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_not_exist.message",
					bolpId.toString(), this.getClass(), "findById", EnumTypeExceptions.INFO,
					EnumCodeExceptions.DATA_NOT_FOUND_DB, messageSource);
			throw new MyNotFoundException(msg);
		}
		return boletaPeriodo;
	}
}

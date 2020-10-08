package ec.gob.mag.renagro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.mag.renagro.domain.SectorDisperso;
import ec.gob.mag.renagro.exception.EnumCodeExceptions;
import ec.gob.mag.renagro.exception.EnumTypeExceptions;
import ec.gob.mag.renagro.exception.MyNotFoundException;
import ec.gob.mag.renagro.exception.SectorDispersoNotFoundException;
import ec.gob.mag.renagro.repository.SectorDispersoRepository;
import ec.gob.mag.renagro.util.MyExceptionUtility;

@Service("sectorDispersoService")
public class SectorDispersoService {

	@Autowired
	@Qualifier("sectorDispersoRepository")
	private SectorDispersoRepository sectorDispersoRepository;

	@Autowired
	private MessageSource messageSource;

	public String findByUbiIdCanton(Integer ubiIdCanton) {
		String sectordisperso = sectorDispersoRepository.findByUbiIdCanton(ubiIdCanton);
		if (sectordisperso == null)
			throw new SectorDispersoNotFoundException(messageSource
					.getMessage("error.entity_not_exist_find_array.message", null, LocaleContextHolder.getLocale()));
		return sectordisperso;
	}

	public String findByUbiIdParroquia(Integer ubiIdParr) {
		String sectordisperso = sectorDispersoRepository.findByUbiIdParroquia(ubiIdParr);
		if (sectordisperso == null)
			throw new SectorDispersoNotFoundException(messageSource
					.getMessage("error.entity_not_exist_find_array.message", null, LocaleContextHolder.getLocale()));
		return sectordisperso;
	}

	public Optional<SectorDisperso> findById(Long secdId) {
		Optional<SectorDisperso> sectorDisperso = sectorDispersoRepository.findBySecdId(secdId);
		if (!sectorDisperso.isPresent())
			throw new SectorDispersoNotFoundException(String.format(
					messageSource.getMessage("error.entity_not_exist.message", null, LocaleContextHolder.getLocale()),
					secdId));
		sectorDisperso.get().setSectorDispersoPeriodos(null);
		sectorDisperso.get().setSectorDispersoGeografico(null);

		return sectorDisperso;
	}

	public List<SectorDisperso> findAll() {
		List<SectorDisperso> lstReporte = sectorDispersoRepository.findAll();
		if (lstReporte == null || lstReporte.size() == 0) {
			String msg = MyExceptionUtility.buildExceptionJsonString("error.entity_cero_exist.message",
					SectorDisperso.class.getName(), this.getClass(), "findAll", EnumTypeExceptions.INFO,
					EnumCodeExceptions.DATA_NOT_FOUND_DB, messageSource);
			throw new MyNotFoundException(msg);
		}
		return lstReporte;
	}
}

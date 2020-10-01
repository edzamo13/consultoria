package ec.gob.mag.interoperabilidad.proamazonia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoExportacionGp;
import ec.gob.mag.interoperabilidad.proamazonia.repository.DestinoExportacionGpRepository;

@Service("destinoExportacionGpService")
public class DestinoExportacionGpService {

	@Autowired
	@Qualifier("destinoExportacionGpRepository")
	private DestinoExportacionGpRepository destinoExportacionGpRepository;


	public DestinoExportacionGp buscarGmvCodigo(String gmvCodigo) {
		return destinoExportacionGpRepository.findByGmvCodigoEquals(gmvCodigo);
		
	}

}

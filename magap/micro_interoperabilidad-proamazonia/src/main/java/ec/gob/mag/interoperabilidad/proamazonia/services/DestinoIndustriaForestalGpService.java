package ec.gob.mag.interoperabilidad.proamazonia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoIndustriaForestalGp;
import ec.gob.mag.interoperabilidad.proamazonia.repository.DestinoIndustriaForestalGpRepository;

@Service("destinoIndustriaForestalGpService")
public class DestinoIndustriaForestalGpService {

	@Autowired
	@Qualifier("destinoIndustriaForestalGpRepository")
	private DestinoIndustriaForestalGpRepository destinoIndustriaForestalGpRepository;



	public DestinoIndustriaForestalGp buscarGmvCodigo(String gmvCodigo) {
	return destinoIndustriaForestalGpRepository.findByGmvCodigoEquals(gmvCodigo);
		
	}

}

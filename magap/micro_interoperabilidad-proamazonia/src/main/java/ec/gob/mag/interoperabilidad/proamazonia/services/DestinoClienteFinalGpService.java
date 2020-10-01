package ec.gob.mag.interoperabilidad.proamazonia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoClienteFinalGp;
import ec.gob.mag.interoperabilidad.proamazonia.repository.DestinoClienteFinalGpRepository;

@Service("destinoClienteFinalGpService")
public class DestinoClienteFinalGpService {

	@Autowired
	@Qualifier("destinoClienteFinalGpRepository")
	private DestinoClienteFinalGpRepository destinoClienteFinalGpRepository;

	public DestinoClienteFinalGp buscarGmvCodigo(String gmvCodigo) {
		return destinoClienteFinalGpRepository.findByGmvCodigoEquals(gmvCodigo);

	}

}

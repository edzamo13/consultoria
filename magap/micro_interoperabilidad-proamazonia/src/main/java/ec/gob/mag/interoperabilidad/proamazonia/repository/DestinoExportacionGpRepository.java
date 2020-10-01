package ec.gob.mag.interoperabilidad.proamazonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoExportacionGp;

@Repository("destinoExportacionGpRepository")
public interface DestinoExportacionGpRepository extends CrudRepository<DestinoExportacionGp, Long> {
	
	DestinoExportacionGp findByGmvCodigoEquals(String gmvCodigo);

}

package ec.gob.mag.interoperabilidad.proamazonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoClienteFinalGp;

@Repository("destinoClienteFinalGpRepository")
public interface DestinoClienteFinalGpRepository extends CrudRepository<DestinoClienteFinalGp, Long> {

	DestinoClienteFinalGp findByGmvCodigoEquals(String gmvCodigo);

}

package ec.gob.mag.interoperabilidad.proamazonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.interoperabilidad.proamazonia.domain.DestinoIndustriaForestalGp;

@Repository("destinoIndustriaForestalGpRepository")
public interface DestinoIndustriaForestalGpRepository extends CrudRepository<DestinoIndustriaForestalGp, Long> {

	DestinoIndustriaForestalGp findByGmvCodigoEquals(String gmvCodigo);

}

package ec.gob.mag.interoperabilidad.proamazonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.interoperabilidad.proamazonia.domain.CabeceraGuiaPrimaria;

@Repository("cabeceraGuiaPrimariaRepository")
public interface CabeceraGuiaPrimariaRepository extends CrudRepository<CabeceraGuiaPrimaria, Long> {

	
}

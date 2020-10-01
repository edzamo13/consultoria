package ec.gob.mag.interoperabilidad.proamazonia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.interoperabilidad.proamazonia.domain.CabeceraGuiaPrimaria;
import ec.gob.mag.interoperabilidad.proamazonia.domain.DetalleGuiaPrimaria;

@Repository("detalleGuiaPrimariaRepository")
public interface DetalleGuiaPrimariaRepository extends CrudRepository<DetalleGuiaPrimaria, Long> {

	List<DetalleGuiaPrimaria>  findBygmvIdEquals(CabeceraGuiaPrimaria gmvId);
	

}

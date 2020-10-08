package ec.gob.mag.renagro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.BoletaPeriodo;

@Repository("boletaPeriodoRepository")
public interface BoletaPeriodoRepository extends CrudRepository<BoletaPeriodo, Long> {
	List<BoletaPeriodo> findAll();

	BoletaPeriodo findByBolpEstadoEquals(Integer bolpEstado);

	Optional<BoletaPeriodo> findByBolpId(Integer bolpId);
}

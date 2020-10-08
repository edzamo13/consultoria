package ec.gob.mag.renagro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.Brigada;
import ec.gob.mag.renagro.domain.IntegranteBrigada;

@Repository("integranteBrigadaRepository")
public interface IntegranteBrigadaRepository extends CrudRepository<IntegranteBrigada, Long> {

	List<IntegranteBrigada> findAll();

	List<IntegranteBrigada> findByIntbEstadoEquals(Integer intbEstado);

	IntegranteBrigada findByIntbEstadoEqualsAndIntbIdEquals(Integer intbEstado, Long intbId);

	List<IntegranteBrigada> findByBrigadaEqualsAndIntbEstadoEquals(Brigada brigada, Integer intbEstado);

	IntegranteBrigada findByBrigadaEqualsAndUsupIdEqualsAndIntbEstadoEquals(Brigada brigada, Long usupId,
			Integer intbEstado);

	List<IntegranteBrigada> findByUsupIdEqualsAndIntbEstadoEquals(Long usupId, Integer intbEstado);
}

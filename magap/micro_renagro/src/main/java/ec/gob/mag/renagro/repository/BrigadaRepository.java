package ec.gob.mag.renagro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.BoletaPeriodo;
import ec.gob.mag.renagro.domain.Brigada;

@Repository("brigadaRepository")
public interface BrigadaRepository extends CrudRepository<Brigada, Long> {

	List<Brigada> findAll();

	Brigada findByBriIdEqualsAndBriEstadoEquals(Long briId, Integer briEstado);

	Brigada findByBriIdEqualsAndBriEstadoEqualsAndBoletaPeriodo_bolpId(Long briId, Integer briEstado, Integer bolpId);

	List<Brigada> findByBriEstadoEquals(Integer briEstado);

	List<Brigada> findByUsupIdInsertEqualsAndBriEstadoEquals(Integer usupIdInsert, Integer briEstado);

	List<Brigada> findByUsupIdInsertEqualsAndBriEstadoEqualsAndBriCompletaEquals(Integer usupIdInsert,
			Integer briEstado, Integer briCompleta);

	Brigada findByBriIdEqualsAndBoletaPeriodoEqualsAndBriEstadoEquals(Long briId, BoletaPeriodo boletaPeriodo,
			Integer briEstado);

}

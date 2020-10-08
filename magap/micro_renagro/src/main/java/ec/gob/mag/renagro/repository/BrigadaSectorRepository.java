package ec.gob.mag.renagro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.BrigadaSector;
import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;

@Repository("brigadaSectorRepository")
public interface BrigadaSectorRepository extends CrudRepository<BrigadaSector, Long> {

	BrigadaSector findByBrisIdEquals(Long brisId);

	BrigadaSector findByBrisIdEqualsAndBrisEstadoEquals(Long brisId, Integer brisEstado);

	List<BrigadaSector> findByBriIdAndBrisEstadoEquals(Integer briId, Integer brisEstado);

	List<BrigadaSector> findByBrisEstadoEquals(Integer brisEstado);

	List<BrigadaSector> findByUsupIdInsertEqualsAndBrisEstadoEquals(Integer UsupIdInsert, Integer brisEstado);

	List<BrigadaSector> findBySectorDispersoPeriodoEqualsAndBrisEstadoEquals(
			SectorDispersoPeriodo sectorDispersoPeriodo, Integer brisEstado);
	
	
	

}

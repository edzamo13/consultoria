package ec.gob.mag.renagro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.SectorDispersoPeriodo;

@Repository("sectorDispersoPeriodoRepository")
public interface SectorDispersoPeriodoRepository extends CrudRepository<SectorDispersoPeriodo, UUID> {

	List<SectorDispersoPeriodo> findAll();

	SectorDispersoPeriodo findBySedpIdEqualsAndSedpEstadoEquals(Integer SedpId, Integer SedpEstado);

	List<SectorDispersoPeriodo> findBySedpEstadoEquals(Integer SedpEstado);

	@Query(value = "select * from sc_renagro.sector_disperso_periodo sdp where sdp.bolp_id = :bolpId and sdp.sedp_estado = :sedpEstado ", nativeQuery = true)
	List<Object[]> findBySedpEstadoEqualsAndBoletaPeriodoEquals(Integer sedpEstado, Integer bolpId);

}

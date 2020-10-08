package ec.gob.mag.renagro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.gob.mag.renagro.domain.SectorDisperso;

@Repository("sectorDispersoRepository")
public interface SectorDispersoRepository extends CrudRepository<SectorDisperso, Long> {

	@Query(value = "SELECT sc_renagro.sp_sectores_dispersos_geograficos_canton(?)", nativeQuery = true)
	String findByUbiIdCanton(Integer ubiIdCanton);

	@Query(value = "SELECT sc_renagro.sp_sectores_dispersos_geograficos_parroquia(?)", nativeQuery = true)
	String findByUbiIdParroquia(Integer ubiIdParr);

	Optional<SectorDisperso> findBySecdId(Long secdId);

	List<SectorDisperso> findAll();
}

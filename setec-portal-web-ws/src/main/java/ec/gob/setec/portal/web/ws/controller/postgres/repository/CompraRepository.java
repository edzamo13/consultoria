package ec.gob.setec.portal.web.ws.controller.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.setec.portal.web.ws.controller.postgres.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{

}

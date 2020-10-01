package ec.gob.setec.portal.web.ws.controller.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.setec.portal.web.ws.controller.postgres.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

}

package ec.gob.setec.portal.web.ws.controller.oracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.gob.setec.portal.web.ws.controller.oracle.model.ConsultaPerfile;

public interface ConsultaPerfileRepository extends JpaRepository<ConsultaPerfile, Long> {

	@Query(value = "SELECT DISTINCT FAMILIA AS FAMILIA FROM cncfadmin.CONSULTA_PERFILES ORDER BY FAMILIA", nativeQuery = true)
	List<String> obtenerFamiliaOrdenado();

	@Query(value = "SELECT DISTINCT SECTOR AS SECTOR FROM cncfadmin.CONSULTA_PERFILES ORDER BY SECTOR", nativeQuery = true)
	List<String> obtenerSectorOrdenado();

	@Query(value = "SELECT distinct CODIGO_PERFIL_ESQUEMA, FAMILIA, SECTOR, DENOMINACION, COMPETENCIAS_LABORAL, ARCHIVO_PDF, ESQUEMAS_PDF FROM cncfadmin.CONSULTA_PERFILES c, setec.catalogo_perfiles f WHERE c.CODIGO = f.CODIGO_PERFIL_ESQUEMA AND f.ESTADO = 'S' AND c.ESQUEMAS_PDF is not null AND c.FAMILIA =  ?1 ", nativeQuery = true)
	List<Object[]> obtenerPefilOECxFamilia(String valor);

	@Query(value = "SELECT distinct CODIGO_PERFIL_ESQUEMA, FAMILIA, SECTOR, DENOMINACION, COMPETENCIAS_LABORAL, ARCHIVO_PDF, ESQUEMAS_PDF FROM cncfadmin.CONSULTA_PERFILES, setec.catalogo_perfiles WHERE CODIGO = CODIGO_PERFIL_ESQUEMA AND ESTADO = 'S' AND  ESQUEMAS_PDF is not null and SECTOR = ? ", nativeQuery = true)
	List<Object[]> obtenerPefilOECxSector(String valor);

	@Query(value = "SELECT distinct CODIGO_PERFIL_ESQUEMA, FAMILIA, SECTOR, DENOMINACION, COMPETENCIAS_LABORAL, ARCHIVO_PDF, ESQUEMAS_PDF FROM cncfadmin.CONSULTA_PERFILES, setec.catalogo_perfiles WHERE CODIGO = CODIGO_PERFIL_ESQUEMA AND ESTADO = 'S' AND ESQUEMAS_PDF is not null and DENOMINACION LIKE %? ", nativeQuery = true)
	List<Object[]> obtenerPefilOECxDenominacion(String valor);

	@Query(value = "SELECT distinct CODIGO_PERFIL_ESQUEMA, FAMILIA, SECTOR, DENOMINACION, COMPETENCIAS_LABORAL, ARCHIVO_PDF, ESQUEMAS_PDF FROM cncfadmin.CONSULTA_PERFILES, setec.catalogo_perfiles WHERE CODIGO = CODIGO_PERFIL_ESQUEMA AND ESTADO = 'S' AND ESQUEMAS_PDF is not null  ", nativeQuery = true)
	List<Object[]> obtenerPefilOECTodo();

}
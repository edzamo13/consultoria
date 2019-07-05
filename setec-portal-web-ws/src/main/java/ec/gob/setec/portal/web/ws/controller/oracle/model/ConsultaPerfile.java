package ec.gob.setec.portal.web.ws.controller.oracle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the CONSULTA_PERFILES database table.
 * 
 */
@Entity
public class ConsultaPerfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	private Long idConsulta;

	@Getter
	@Setter
	@Column(name = "CODIGO_PERFIL_ESQUEMA")
	private String codigoPerfilEsquema;
	@Getter
	@Setter
	@Column(name = "FAMILIA")
	private String familia;
	@Getter
	@Setter
	@Column(name = "SECTOR")
	private String sector;
	@Getter
	@Setter
	@Column(name = "DENOMINACION")
	private String denominacion;
	@Getter
	@Setter
	@Column(name = "COMPETENCIAS_LABORAL")
	private String competenciasLaborales;
	@Getter
	@Setter
	@Column(name = "ARCHIVO_PDF")
	private String archivoPdf;//
	@Getter
	@Setter
	@Column(name = "ESQUEMAS_PDF")
	private String esquemaPdf;//
	@Getter
	@Setter
	private String campo;
	@Getter
	@Setter
	private String opcion;

	public ConsultaPerfile() {

	}

	public ConsultaPerfile(String codigoPerfilEsquema, String familia, String sector, String denominacion,
			String competenciasLaborales, String archivoPdf, String esquemaPdf) {
		super();
		this.codigoPerfilEsquema = codigoPerfilEsquema;
		this.familia = familia;
		this.sector = sector;
		this.denominacion = denominacion;
		this.competenciasLaborales = competenciasLaborales;
		this.archivoPdf = archivoPdf;
		this.esquemaPdf = esquemaPdf;
	}

	public ConsultaPerfile(String campo, String opcion) {
		super();
		this.campo = campo;
		this.opcion = opcion;
	}

	
	
}
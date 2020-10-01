/*
* Copyright 2020 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/

package ec.gob.mag.interoperabilidad.proamazonia.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 *         [$Author: ezamora $, $Date: Sep 18, 2020]
 *         </p>
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cabecera_guia_primaria", catalog = "dwh_mag", schema = "interoperabilidad")
public class CabeceraGuiaPrimaria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "gmv_codigo", length = 20)
	private String gmvCodigo;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "gmv_id", nullable = false, precision = 131089, scale = 0)
	private Integer gmvId;
	@Column(name = "prg_id")
	private Integer prgId;
	@Column(name = "gmv_fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gmvFechaInicio;
	@Column(name = "gmv_tipo_destino")
	private Integer gmvTipoDestino;
	@Column(name = "lic_secuencia", length = 100)
	private String licSecuencia;
	@Column(name = "prg_codigo", length = 20)
	private String prgCodigo;
	@Column(name = "propietario_razzonsocial", length = 150)
	private String propietarioRazzonsocial;
	@Column(name = "pripietario_nombres", length = 2147483647)
	private String pripietarioNombres;
	@Column(name = "propietario_ruc", length = 13)
	private String propietarioRuc;
	@Column(name = "ejecutor_nombres", length = 2147483647)
	private String ejecutorNombres;
	@Column(name = "ejecutor_razonsocial", length = 150)
	private String ejecutorRazonsocial;
	@Column(name = "ejecutor_ruc", length = 13)
	private String ejecutorRuc;
	@Column(name = "predio_provincia", length = 80)
	private String predioProvincia;
	@Column(name = "predio_canton", length = 80)
	private String predioCanton;
	@Column(name = "predio_parroquia", length = 80)
	private String predioParroquia;
	@Column(name = "predio_sitio", length = 512)
	private String predioSitio;
	@Column(name = "vehiculo_placa", length = 10)
	private String vehiculoPlaca;
	@Column(name = "vehiculo_color", length = 50)
	private String vehiculoColor;
	@Column(name = "vehiculo_marca", length = 350)
	private String vehiculoMarca;
	@Column(name = "vehiculo_tipo", length = 350)
	private String vehiculoTipo;
	@Column(name = "guipri_fechainicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date guipriFechainicio;
	@Column(name = "guipri_duracionhoras")
	private Long guipriDuracionhoras;
	@Column(name = "guiapri_fechafin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date guiapriFechafin;
	@Column(name = "suc_id_destino", length = 2147483647)
	private String sucIdDestino;
	@OneToMany(mappedBy = "gmvId")
	private List<DestinoClienteFinalGp> destinoClienteFinalGpList;
	@OneToMany(mappedBy = "gmvId")
	private List<DestinoIndustriaForestalGp> destinoIndustriaForestalGpList;
	@OneToMany(mappedBy = "gmvId")
	private List<DetalleGuiaPrimaria> detalleGuiaPrimariaList;
	@OneToMany(mappedBy = "gmvId")
	private List<DestinoExportacionGp> destinoExportacionGpList;

}

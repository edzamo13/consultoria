package ec.gob.mag.renagro.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * The persistent class for the brigada database table.
 * 
 */
@Entity
@Table(name = "brigada", schema = "sc_renagro")
@NamedQuery(name = "Brigada.findAll", query = "SELECT b FROM Brigada b")
public class Brigada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bri_id")
	private Long briId;

	@Column(name = "bri_codigo")
	private String briCodigo;

	@Column(name = "bri_descripcion")
	private String briDescripcion;

	@Column(name = "bri_estado")
	private Integer briEstado;

	@Column(name = "bri_insert")
	private Timestamp briInsert;

	@Column(name = "usup_id_insert")
	private Integer usupIdInsert;

	@Column(name = "bri_update")
	private Timestamp briUpdate;

	@Column(name = "usup_id_update")
	private Integer usupIdUpdate;

	@Column(name = "bri_vehiculo_asignado")
	private Integer briVehiculoAsignado;

	@Column(name = "bri_vehiculo_estado")
	private Integer briVehiculoEstado;

	@Column(name = "bri_completa")
	private Integer briCompleta;

	// bi-directional many-to-one association to BoletaPeriodo
	@ManyToOne
	@JoinColumn(name = "bolp_id")
	@JsonIgnore
	private BoletaPeriodo boletaPeriodo;

	// bi-directional many-to-one association to IntegranteBrigada
	@OneToMany(mappedBy = "brigada")
	@JsonIgnore
	private List<IntegranteBrigada> integranteBrigadas;

	@Transient
	private Integer bolpId;

	public Brigada(Long briId, String briCodigo, String briDescripcion, Integer briEstado, Timestamp briInsert,
			Integer usupIdInsert, Timestamp briUpdate, Integer usupIdUpdate, Integer briVehiculoAsignado,
			Integer briVehiculoEstado, BoletaPeriodo boletaPeriodo) {
		super();
		this.briId = briId;
		this.briCodigo = briCodigo;
		this.briDescripcion = briDescripcion;
		this.briEstado = briEstado;
		this.briInsert = briInsert;
		this.usupIdInsert = usupIdInsert;
		this.briUpdate = briUpdate;
		this.usupIdUpdate = usupIdUpdate;
		this.briVehiculoAsignado = briVehiculoAsignado;
		this.briVehiculoEstado = briVehiculoEstado;
		this.boletaPeriodo = boletaPeriodo;
	}

	public Brigada(Long briId, String briCodigo, String briDescripcion, Integer briEstado, Timestamp briInsert,
			Integer usupIdInsert, Timestamp briUpdate, Integer usupIdUpdate, Integer briVehiculoAsignado,
			Integer briVehiculoEstado, Integer briCompleta, BoletaPeriodo boletaPeriodo) {
		super();
		this.briId = briId;
		this.briCodigo = briCodigo;
		this.briDescripcion = briDescripcion;
		this.briEstado = briEstado;
		this.briInsert = briInsert;
		this.usupIdInsert = usupIdInsert;
		this.briUpdate = briUpdate;
		this.usupIdUpdate = usupIdUpdate;
		this.briVehiculoAsignado = briVehiculoAsignado;
		this.briVehiculoEstado = briVehiculoEstado;
		this.briCompleta = briCompleta;
		this.boletaPeriodo = boletaPeriodo;
	}
}
package ec.gob.mag.renagro.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * The persistent class for the boleta_periodo database table.
 * 
 */
@Entity
@Table(name = "boleta_periodo", schema = "sc_renagro")
//@NamedQuery(name = "BoletaPeriodo.findAll", query = "SELECT b FROM BoletaPeriodo b")
public class BoletaPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bolp_id")
	private Integer bolpId;

	@Column(name = "bolp_descripcion")
	private String bolpDescripcion;

	@Column(name = "bolp_estado")
	private Integer bolpEstado;

	@Column(name = "bolp_insert")
	private Timestamp bolpInsert;

	@Column(name = "bolp_update")
	private Timestamp bolpUpdate;

	@Column(name = "usup_id_insert")
	private Integer usupIdInsert;

	@Column(name = "usup_id_update")
	private Integer usupIdUpdate;

	// bi-directional many-to-one association to Brigada
	@OneToMany(mappedBy = "boletaPeriodo")
	@JsonIgnore
	private List<Brigada> brigadas;

	// bi-directional many-to-one association to SectorDispersoPeriodo
	@OneToMany(mappedBy = "boletaPeriodo")
	@JsonIgnore
	private List<SectorDispersoPeriodo> sectorDispersoPeriodos;

}
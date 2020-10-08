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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * The persistent class for the sector_disperso_periodo database table.
 * 
 */
@Entity
@Table(name = "sector_disperso_periodo", schema = "sc_renagro")
//@NamedQuery(name = "SectorDispersoPeriodo.findAll", query = "SELECT s FROM SectorDispersoPeriodo s")
public class SectorDispersoPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sedp_id")
	private Integer sedpId;

	@Column(name = "sedp_estado")
	private Integer sedpEstado;

	@Column(name = "sedp_estado_avance")
	private Integer sedpEstadoAvance;

	@Column(name = "sedp_insert")
	private Timestamp sedpInsert;

	// bi-directional many-to-one association to BrigadaSector
	@OneToMany(mappedBy = "sectorDispersoPeriodo")
	private List<BrigadaSector> brigadaSectors;

	// bi-directional many-to-one association to BoletaPeriodo
	@ManyToOne
	@JoinColumn(name = "bolp_id")
	@JsonIgnore
	private BoletaPeriodo boletaPeriodo;

	// bi-directional many-to-one association to SectorDisperso
	@ManyToOne
	@JoinColumn(name = "secd_id")
	@JsonIgnore
	private SectorDisperso sectorDisperso;

	@Transient
	private Long secdId;
	@Transient
	private Integer bolpId;
	@Transient
	private SectorDisperso sectorDispersoT;

}
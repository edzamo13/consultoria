package ec.gob.mag.renagro.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
/**
 * The persistent class for the brigada_sector database table.
 * 
 */
@Entity
@Table(name = "brigada_sector", schema = "sc_renagro")
@NamedQuery(name = "BrigadaSector.findAll", query = "SELECT b FROM BrigadaSector b")
public class BrigadaSector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bris_id")
	private Long brisId;

	@Column(name = "bri_id")
	private Integer briId;

	@Column(name = "bris_insert")
	private Timestamp brisInsert;

	@Column(name = "bris_update")
	private Timestamp brisUpdate;

	@Column(name = "usup_id_insert")
	private Integer usupIdInsert;

	@Column(name = "usup_id_update")
	private Integer usupIdUpdate;

	@Column(name = "bris_estado")
	private Integer brisEstado;

	// bi-directional many-to-one association to SectorDispersoPeriodo
	@ManyToOne
	@JoinColumn(name = "sedp_id")
	@JsonIgnore
	private SectorDispersoPeriodo sectorDispersoPeriodo;

	@Transient
	private Integer sedpId;

	@Transient
	private Brigada brigada;

	@Transient
	private SectorDispersoPeriodo sectorDispersoP;

	public BrigadaSector(Long brisId, Integer briId, Timestamp brisInsert, Timestamp brisUpdate, Integer usupIdInsert,
			Integer usupIdUpdate, Integer brisEstado, SectorDispersoPeriodo sectorDispersoPeriodo) {
		super();
		this.brisId = brisId;
		this.briId = briId;
		this.brisInsert = brisInsert;
		this.brisUpdate = brisUpdate;
		this.usupIdInsert = usupIdInsert;
		this.usupIdUpdate = usupIdUpdate;
		this.brisEstado = brisEstado;
		this.sectorDispersoPeriodo = sectorDispersoPeriodo;
	}

}
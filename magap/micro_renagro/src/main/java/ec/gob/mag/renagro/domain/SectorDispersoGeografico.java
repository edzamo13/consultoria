package ec.gob.mag.renagro.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * The persistent class for the sector_disperso_geografico database table.
 * 
 */
@Entity
@Table(name = "sector_disperso_geografico", schema = "sc_renagro")
@NamedQuery(name = "SectorDispersoGeografico.findAll", query = "SELECT s FROM SectorDispersoGeografico s")
public class SectorDispersoGeografico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long secdId;

	private String geom;

	// bi-directional one-to-one association to SectorDisperso
	@OneToOne
	@MapsId
	@JoinColumn(name = "secd_id")
	private SectorDisperso sectorDisperso;

}
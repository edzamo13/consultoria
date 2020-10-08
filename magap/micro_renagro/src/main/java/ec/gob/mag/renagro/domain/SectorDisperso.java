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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
/**
 * The persistent class for the sector_disperso database table.
 * 
 */
@Entity
@Table(name = "sector_disperso", schema = "sc_renagro")
//@NamedQuery(name = "SectorDisperso.findAll", query = "SELECT s FROM SectorDisperso s")
public class SectorDisperso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "secd_id")
	private Long secdId;

	@Column(name = "cod_zon_inec")
	private String codZonInec;

	@Column(name = "ubi_id_canton")
	private Integer ubiIdCanton;

	@Column(name = "ubi_id_parroquia")
	private Integer ubiIdParroquia;

	@Column(name = "ubi_id_provincia")
	private Integer ubiIdProvincia;

	@Column(name = "ubi_inec_canton")
	private String ubiInecCanton;

	@Column(name = "ubi_inec_parroquia")
	private String ubiInecParroquia;

	@Column(name = "ubi_inec_provincia")
	private String ubiInecProvincia;

	@Column(name = "ubi_inec_sector_disperso")
	private String ubiInecSectorDisperso;

	@Column(name = "ubi_nombre_canton")
	private String ubiNombreCanton;

	@Column(name = "ubi_nombre_parroquia")
	private String ubiNombreParroquia;

	@Column(name = "ubi_nombre_provincia")
	private String ubiNombreProvincia;

	@Column(name = "ubi_time_stamp")
	private Timestamp ubiTimeStamp;

	// bi-directional one-to-one association to SectorDispersoGeografico
	@OneToOne(mappedBy = "sectorDisperso")
	@JsonInclude(Include.NON_NULL)
	private SectorDispersoGeografico sectorDispersoGeografico;

	// bi-directional many-to-one association to SectorDispersoPeriodo
	@OneToMany(mappedBy = "sectorDisperso")
	@JsonInclude(Include.NON_NULL)
	private List<SectorDispersoPeriodo> sectorDispersoPeriodos;

}
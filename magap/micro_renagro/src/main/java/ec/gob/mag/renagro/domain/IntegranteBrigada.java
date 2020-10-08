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
import lombok.NoArgsConstructor;
import lombok.ToString;


 @Data
 @ToString
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder

/**
 * The persistent class for the integrante_brigada database table.
 * 
 */
@Entity
@Table(name="integrante_brigada",schema = "sc_renagro")
@NamedQuery(name="IntegranteBrigada.findAll", query="SELECT i FROM IntegranteBrigada i")
public class IntegranteBrigada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="intb_id")
	private Long intbId;

	@Column(name="intb_estado")
	private Integer intbEstado;

	@Column(name="intb_insert")
	private Timestamp intbInsert;

	@Column(name="intb_update")
	private Timestamp intbUpdate;

	@Column(name="usup_id")
	private Long usupId;

	@Column(name="usup_id_insert")
	private Integer usupIdInsert;

	@Column(name="usup_id_update")
	private Integer usupIdUpdate;

	//bi-directional many-to-one association to Brigada
	@ManyToOne
	@JoinColumn(name="bri_id")
	@JsonIgnore
	private Brigada brigada;

	@Transient
	private Integer briId;
	
	@Transient
	private Integer numIntegrantes;

	public IntegranteBrigada(Long intbId, Integer intbEstado, Timestamp intbInsert, Timestamp intbUpdate, Long usupId,
			Integer usupIdInsert, Integer usupIdUpdate, Brigada brigada) {
		super();
		this.intbId = intbId;
		this.intbEstado = intbEstado;
		this.intbInsert = intbInsert;
		this.intbUpdate = intbUpdate;
		this.usupId = usupId;
		this.usupIdInsert = usupIdInsert;
		this.usupIdUpdate = usupIdUpdate;
		this.brigada = brigada;
	}
	
	
	
}
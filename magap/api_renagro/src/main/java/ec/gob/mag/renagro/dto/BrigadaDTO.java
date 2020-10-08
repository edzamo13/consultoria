package ec.gob.mag.renagro.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ezamora
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrigadaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long briId;
	private String briCodigo;
	private String briDescripcion;
	private Integer briEstado;
	private Timestamp briInsert;
	private Timestamp briUpdate;
	private Integer briVehiculoAsignado;
	private Integer usupIdInsert;
	private Integer usupIdUpdate;
	private Integer bolpId;
	private Integer briVehiculoEstado;
	private List<IntegranteBrigadaDTO> integranteBrigadas;

	
	public BrigadaDTO(Long briId, String briCodigo, String briDescripcion, Integer briEstado, Timestamp briInsert,
			Timestamp briUpdate, Integer briVehiculoAsignado, Integer usupIdInsert, Integer usupIdUpdate,
			Integer bolpId, Integer briVehiculoEstado) {
		super();
		this.briId = briId;
		this.briCodigo = briCodigo;
		this.briDescripcion = briDescripcion;
		this.briEstado = briEstado;
		this.briInsert = briInsert;
		this.briUpdate = briUpdate;
		this.briVehiculoAsignado = briVehiculoAsignado;
		this.usupIdInsert = usupIdInsert;
		this.usupIdUpdate = usupIdUpdate;
		this.bolpId = bolpId;
		this.briVehiculoEstado = briVehiculoEstado;
	}
	
	
	
	
	

}
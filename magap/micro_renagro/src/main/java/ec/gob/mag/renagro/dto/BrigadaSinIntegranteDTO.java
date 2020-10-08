package ec.gob.mag.renagro.dto;

import java.io.Serializable;
import java.sql.Timestamp;

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
public class BrigadaSinIntegranteDTO implements Serializable {
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
	

}
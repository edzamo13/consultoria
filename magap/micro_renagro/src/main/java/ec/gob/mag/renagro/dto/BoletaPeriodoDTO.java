package ec.gob.mag.renagro.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
public class BoletaPeriodoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bolpId;
	private String bolpDescripcion;
	private Integer bolpEstado;
	private Timestamp bolpInsert;
	private Timestamp bolpUpdate;
	private Integer usupIdInsert;
	private Integer usupIdUpdate;
	private List<BrigadaDTO> brigadas;

}
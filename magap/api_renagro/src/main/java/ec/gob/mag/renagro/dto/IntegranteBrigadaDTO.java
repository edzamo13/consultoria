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
public class IntegranteBrigadaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long intbId;
	private Integer intbEstado;
	private Timestamp intbInsert;
	private Timestamp intbUpdate;
	private Long usupId;
	private Integer usupIdInsert;
	private Integer usupIdUpdate;
}
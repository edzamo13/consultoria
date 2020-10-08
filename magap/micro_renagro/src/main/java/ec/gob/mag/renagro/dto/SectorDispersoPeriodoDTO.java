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

public class SectorDispersoPeriodoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sedpId;

	private Integer sedpEstado;

	private Integer sedpEstadoAvance;

	private Timestamp sedpInsert;

	private SectorDispersoDTO sectorDisperso;

}
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

public class BrigadaSectorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long brisId;

	private Integer briId;

	private Timestamp brisInsert;

	private Timestamp brisUpdate;

	private Integer usupIdInsert;

	private Integer usupIdUpdate;

	private Integer brisEstado;

	private SectorDispersoPeriodoDTO sectorDispersoPeriodo;

	private BrigadaSinIntegranteDTO brigada;

}
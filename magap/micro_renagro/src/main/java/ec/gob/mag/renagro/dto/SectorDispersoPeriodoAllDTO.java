package ec.gob.mag.renagro.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@Builder


public class SectorDispersoPeriodoAllDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private String sedpId;

	private String boldId;
	
	private String secdId;
	
	private String sedpEstadoAvance;
	
	private String sedpInsert;
	
	private String sedpEstado;

	
	
	public SectorDispersoPeriodoAllDTO(String sedpId, String boldId, String secdId, String sedpEstadoAvance,
			String sedpInsert, String sedpEstado) {
		super();
		this.sedpId = sedpId;
		this.boldId = boldId;
		this.secdId = secdId;
		this.sedpEstadoAvance = sedpEstadoAvance;
		this.sedpInsert = sedpInsert;
		this.sedpEstado = sedpEstado;
	}



	public SectorDispersoPeriodoAllDTO() {
	
	}

	

	


	
	

	
	

}
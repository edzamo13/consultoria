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

public class SectorDispersoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long secdId;

	private String codZonInec;

	private Integer ubiIdCanton;

	private Integer ubiIdParroquia;

	private Integer ubiIdProvincia;

	private String ubiInecCanton;

	private String ubiInecParroquia;

	private String ubiInecProvincia;

	private String ubiInecSectorDisperso;

	private String ubiNombreCanton;

	private String ubiNombreParroquia;

	private String ubiNombreProvincia;

	private Timestamp ubiTimeStamp;

}
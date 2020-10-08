package ec.gob.mag.renagro.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class FuncionariosPaginadoTotalRecords {

	@Id
	private Long nro;
	private Long id;
	private Long usupId;
	private String perIdentificacion;
	private String perNombres;
	private String perCorreo;
	private Long upefId;
	private Long pefId;
	private Long apliId;
	private Long usuId;
	private String tpefNombre;
	private Long briId;
	private Long ubiId;
	private String ubiNombre;
	private String briCodigo;
	private String brisUbiNombreProvincia;
	private String brisUbiNombreCanton;
	private String brisUbiNombreParroquia;
	private Long usupIdInsert;
	private Integer totalRecords;
}

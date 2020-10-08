package ec.gob.mag.dinardap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PoliciaDTO {
  

	

	
	@ApiModelProperty(value = "Este campo nombreEntidad Persona")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo Entidad Telefono ")
	@JsonProperty("Policia")
	private Policia policia;

}

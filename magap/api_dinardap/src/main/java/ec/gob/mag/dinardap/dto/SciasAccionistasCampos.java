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
public class SciasAccionistasCampos {

	

	@ApiModelProperty(value = "Este campo nombre")
	@JsonProperty("nombre")
	private String nombre;
	@ApiModelProperty(value = "Este campo identificacion_accionista")
	@JsonProperty("identificacionAccionista")
	private String identificacionAccionista;
	@ApiModelProperty(value = "Este campo nombre_accionista")
	@JsonProperty("nombreAccionista")
	private String nombreAccionista;


}

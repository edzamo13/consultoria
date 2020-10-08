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
public class Policia {

	@ApiModelProperty(value = "Este campo Entidad documento ")
	@JsonProperty("documento")
	private String documento;
	@ApiModelProperty(value = "Este campo Entidad ordenCaptura ")
	@JsonProperty("ordenCaptura")
	private String ordenCaptura;
	@ApiModelProperty(value = "Este campo Entidad antecedentes ")
	@JsonProperty("antecedentes")
	private String antecedentes;
	@ApiModelProperty(value = "Este campo Entidad impedimentoSalida ")
	@JsonProperty("impedimentoSalida")
	private String impedimentoSalida;
	@ApiModelProperty(value = "Este campo Entidad alertaMigratoria ")
	@JsonProperty("alertaMigratoria")
	private String alertaMigratoria;

}

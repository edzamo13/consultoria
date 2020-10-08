package ec.gob.mag.dinardap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//============== LOMBOK =============
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SenescytTituloDTO {


	@ApiModelProperty(value = "Este campo fechaGrado Persona")
	@JsonProperty("fechaGrado")
	private String fechaGrado;
	@ApiModelProperty(value = "Este campo fechaRegistro Persona")
	@JsonProperty("fechaRegistro")
	private String fechaRegistro;
	@ApiModelProperty(value = "Este campo ies Persona")
	@JsonProperty("ies")
	private String ies;
	@ApiModelProperty(value = "Este campo nombreTitulo Persona")
	@JsonProperty("nombreTitulo")
	private String nombreTitulo;
	@ApiModelProperty(value = "Este campo numeroIdentificacion Persona")
	@JsonProperty("numeroIdentificacion")
	private String numeroIdentificacion;
	@ApiModelProperty(value = "Este campo numeroRegistro Persona")
	@JsonProperty("numeroRegistro")
	private String numeroRegistro;
	@ApiModelProperty(value = "Este campo tipoExtranjeroColegio Persona")
	@JsonProperty("tipoExtranjeroColegio")
	private String tipoExtranjeroColegio;
	@ApiModelProperty(value = "Este campo tipoTitulo Persona")
	@JsonProperty("tipoTitulo")
	private String tipoTitulo;

	
}

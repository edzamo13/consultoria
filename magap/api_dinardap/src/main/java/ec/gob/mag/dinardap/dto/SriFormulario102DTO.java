package ec.gob.mag.dinardap.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//============== LOMBOK =============
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SriFormulario102DTO {

	@ApiModelProperty(value = "Este campo Entidad SRI Formulario 102 ")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo SRI Formulario 102 ")
	@JsonProperty("sriFormulario102Campos")
	private List<SriFormulario102Campos> sriFormulario102Campos;

}

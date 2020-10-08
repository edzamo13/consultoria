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
public class SenescytDTO {
	
	@ApiModelProperty(value = "Este campo nombreEntidad Persona")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	
	@ApiModelProperty(value = "Este campo senescytTituloDTOs Persona")
	@JsonProperty("senescytTituloDTOs")
	private List<SenescytTituloDTO> senescytTituloDTOs;


	
	
}

package ec.gob.mag.dinardap.dto;

import java.util.List;

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
public class SercopDato {


	@ApiModelProperty(value = "Este campo nombreEntidad Persona")
	@JsonProperty("nombreEntidad")
	private String nombreEntidadDato;

	@ApiModelProperty(value = "Este campo nombreEntidad dato")
	@JsonProperty("dato")
	private List<SercopDatoCampos> datos;
	
}

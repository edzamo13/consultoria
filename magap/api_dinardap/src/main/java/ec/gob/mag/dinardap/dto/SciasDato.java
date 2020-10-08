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
public class SciasDato {
	
	

	@ApiModelProperty(value = "Este campo nombreEntidad companiaDatosCompania")
	@JsonProperty("dato")
	private String  companiasDatos;

	@ApiModelProperty(value = "Este campo nombreEntidad dato")
	@JsonProperty("datos")
	private List<SciasDatoCampos> datos;

}

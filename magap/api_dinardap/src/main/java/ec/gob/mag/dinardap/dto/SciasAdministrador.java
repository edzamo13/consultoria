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
public class SciasAdministrador {
	
	@ApiModelProperty(value = "Este campo nombreEntidad compañiasDatosAdministradores")
	@JsonProperty("datosAdministradores")
	private String companiasDatosAdministradores;

	@ApiModelProperty(value = "Este campo nombreEntidad dato")
	@JsonProperty("administradores")
	private List<SciasAdministradorCampos> administradorCampos;

}

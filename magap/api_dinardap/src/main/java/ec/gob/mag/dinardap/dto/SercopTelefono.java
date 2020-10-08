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
public class SercopTelefono {


	@ApiModelProperty(value = "Este campo nombreEntidad nombreEntidadTelefono")
	@JsonProperty("nombreEntidad")
	private String nombreEntidadTelefono;
	@ApiModelProperty(value = "Este campo nombreEntidad telefono")
	@JsonProperty("telefono")
	private List<SercopTelefonoCampos> telefonos;
}

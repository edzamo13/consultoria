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
public class SciasActividadEconomica {

	@ApiModelProperty(value = "Este campo nombreEntidad companiasDatosActividadesEconomicas")
	@JsonProperty("datosActividadesEconomicas")
	private String  companiasDatosActividadesEconomicas;

	@ApiModelProperty(value = "Este campo nombreEntidad dato")
	@JsonProperty("actividadesEconomicas")
	private List<SciasActividadEconomicaCampos> SciasActividadEconomicaCampos;

}

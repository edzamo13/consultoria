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
public class SciasDTO {
  

	

	
	@ApiModelProperty(value = "Este campo Entidad Superintendencia de Compañias Datos ")
	@JsonProperty("datos")
	private SciasDato sciasDato;
	@ApiModelProperty(value = "Este campo Entidad Superintendencia de Compañias Accionistas ")
	@JsonProperty("accionistas")
	private SciasAccionistas sciasAccionistas;
	@ApiModelProperty(value = "Este campo Entidad Superintendencia de Compañias Actividad Economica ")
	@JsonProperty("actividadEconomica")
	private SciasActividadEconomica sciasActividadEconomica;
	@ApiModelProperty(value = "Este campo Entidad Superintendencia de Compañias Administrador ")
	@JsonProperty("administrador")
	private SciasAdministrador sciasAdministrador;
	
}

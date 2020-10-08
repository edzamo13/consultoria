package ec.gob.mag.dinardap.dto;

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
public class CneDTO {

	@ApiModelProperty(value = "Este campo nombreEntidad Persona")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo provincia Persona")
	@JsonProperty("provincia")
	private String provincia;
	@ApiModelProperty(value = "Este campo canton Persona")
	@JsonProperty("canton")
	private String canton;
	@ApiModelProperty(value = "Este campo parroquia Persona")
	@JsonProperty("parroquia")
	private String parroquia;
	@ApiModelProperty(value = "Este campo cedula Persona")
	@JsonProperty("cedula")
	private String cedula;
	@ApiModelProperty(value = "Este campo nombre fechaDefuncion")
	@JsonProperty("nombre")
	private String nombre;
	@ApiModelProperty(value = "Este campo multa Persona")
	@JsonProperty("multa")
	private String multa;
	@ApiModelProperty(value = "Este campo codigoElectoral Persona")
	@JsonProperty("codigoElectoral")
	private String codigoElectoral;
	@ApiModelProperty(value = "Este campo fechaP Persona")
	@JsonProperty("fechaP")
	private String fechaP;
	@ApiModelProperty(value = "Este campo habilitadoTPublico Persona")
	@JsonProperty("habilitadoTPublico")
	private String habilitadoTPublico;

}

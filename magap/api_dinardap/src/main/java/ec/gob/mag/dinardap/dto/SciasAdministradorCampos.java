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
public class SciasAdministradorCampos {

	@ApiModelProperty(value = "Este campo cargo ")
	@JsonProperty("cargo")
	private String  cargo;
	@ApiModelProperty(value = "Este campo fecha_nombramiento ")
	@JsonProperty("fechaNombramiento")
	private String  fechaNombramiento;
	@ApiModelProperty(value = "Este campo cedula_administrador ")
	@JsonProperty("cedulaAdministrador")
	private String  cedulaAdministrador;
	@ApiModelProperty(value = "Este campo nombre ")
	@JsonProperty("nombre")
	private String  nombre;
	@ApiModelProperty(value = "Este campo representante_legal ")
	@JsonProperty("representanteLegal")
	private String  representanteLegal;
	

}

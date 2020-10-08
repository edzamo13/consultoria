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
public class AntDTO {

	@ApiModelProperty(value = "Este campo nombreEntidad ")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo anio ")
	@JsonProperty("anio")
	private String anio;
	@ApiModelProperty(value = "Este campo chasis ")
	@JsonProperty("chasis")
	private String chasis;
	@ApiModelProperty(value = "Este campo cilindraje ")
	@JsonProperty("cilindraje")
	private String cilindraje;
	@ApiModelProperty(value = "Este campo claseVehiculo ")
	@JsonProperty("claseVehiculo")
	private String claseVehiculo;
	@ApiModelProperty(value = "Este campo cedula color")
	@JsonProperty("color")
	private String color;
	@ApiModelProperty(value = "Este campo color2 ")
	@JsonProperty("color2")
	private String color2;
	@ApiModelProperty(value = "Este campo combustible ")
	@JsonProperty("combustible")
	private String combustible;
	@ApiModelProperty(value = "Este campo direccion ")
	@JsonProperty("direccion")
	private String direccion;
	@ApiModelProperty(value = "Este campo docPropietario ")
	@JsonProperty("docPropietario")
	private String docPropietario;
	@ApiModelProperty(value = "Este campo marca ")
	@JsonProperty("marca")
	private String marca;
	@ApiModelProperty(value = "Este campo modelo ")
	@JsonProperty("modelo")
	private String modelo;
	@ApiModelProperty(value = "Este campo motor ")
	@JsonProperty("motor")
	private String motor;
	@ApiModelProperty(value = "Este campo nombres ")
	@JsonProperty("nombres")
	private String nombres;
	@ApiModelProperty(value = "Este campo placaAnterior ")
	@JsonProperty("placaAnterior")
	private String placaAnterior;
	@ApiModelProperty(value = "Este campo tipoVehiculo ")
	@JsonProperty("tipoVehiculo")
	private String tipoVehiculo;

}

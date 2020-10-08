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
public class SercopDatoCampos {


	@ApiModelProperty(value = "Este campo nombreEntidad cedula")
	@JsonProperty("cedula")
	private String cedula;
	@ApiModelProperty(value = "Este campo nombreEntidad anioActividad")
	@JsonProperty("anioActividad")
	private String anioActividad;
	@ApiModelProperty(value = "Este campo nombreEntidad calle")
	@JsonProperty("calle")
	private String calle;
	@ApiModelProperty(value = "Este campo nombreEntidad canton")
	@JsonProperty("canton")
	private String canton;
	@ApiModelProperty(value = "Este campo nombreEntidad departamento")
	@JsonProperty("departamento")
	private String departamento;
	@ApiModelProperty(value = "Este campo nombreEntidad edificio")
	@JsonProperty("edificio")
	private String edificio;
	@ApiModelProperty(value = "Este campo nombreEntidad interseccion")
	@JsonProperty("interseccion")
	private String interseccion;
	@ApiModelProperty(value = "Este campo nombreEntidad nombreComercial")
	@JsonProperty("nombreComercial")
	private String nombreComercial;
	@ApiModelProperty(value = "Este campo nombreEntidad numero")
	@JsonProperty("numero")
	private String numero;
	@ApiModelProperty(value = "Este campo nombreEntidad paginaWeb")
	@JsonProperty("paginaWeb")
	private String paginaWeb;
	@ApiModelProperty(value = "Este campo nombreEntidad parroquia")
	@JsonProperty("parroquia")
	private String parroquia;
	@ApiModelProperty(value = "Este campo nombreEntidad provincia")
	@JsonProperty("provincia")
	private String provincia;
	@ApiModelProperty(value = "Este campo nombreEntidad razonSocial")
	@JsonProperty("razonSocial")
	private String razonSocial;
	@ApiModelProperty(value = "Este campo nombreEntidad ruc")
	@JsonProperty("ruc")
	private String ruc;
	@ApiModelProperty(value = "Este campo nombreEntidad tipoOrigen")
	@JsonProperty("tipoOrigen")
	private String tipoOrigen;
	@ApiModelProperty(value = "Este campo nombreEntidad tipoPersona")
	@JsonProperty("tipoPersona")
	private String tipoPersona;

}

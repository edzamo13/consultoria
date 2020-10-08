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
public class RegistroCivilCiudadanoDTO {
    @ApiModelProperty(value = "Este campo calle ")
	@JsonProperty("calle")
	private String  calle;
    @ApiModelProperty(value = "Este campo codigoDomicilio ")
	@JsonProperty("codigoDomicilio")
	private String  codigoDomicilio;
    @ApiModelProperty(value = "Este campo condicionCedulado ")
	@JsonProperty("condicionCedulado")
	private String  condicionCedulado;
    @ApiModelProperty(value = "Este campo conyuge ")
	@JsonProperty("conyuge")
	private String  conyuge;
    @ApiModelProperty(value = "Este campo nombrePadre ")
	@JsonProperty("nombrePadre")
	private String  nombrePadre;
    @ApiModelProperty(value = "Este campo nombreMadre ")
	@JsonProperty("nombreMadre")
	private String  nombreMadre;
    @ApiModelProperty(value = "Este campo domicilio ")
	@JsonProperty("domicilio")
	private String  domicilio;
    @ApiModelProperty(value = "Este campo error ")
	@JsonProperty("error")
	private String  error;
    @ApiModelProperty(value = "Este campo codigoError ")
	@JsonProperty("codigoError")
	private String  codigoError;
    @ApiModelProperty(value = "Este campo estadoCivil ")
	@JsonProperty("estadoCivil")
	private String  estadoCivil;
    @ApiModelProperty(value = "Este campo fechaInscripcionGenero ")
	@JsonProperty("fechaInscripcionGenero")
	private String  fechaInscripcionGenero;
    @ApiModelProperty(value = "Este campo fechaNacimiento ")
	@JsonProperty("fechaNacimiento")
	private String  fechaNacimiento;
    @ApiModelProperty(value = "Este campo calculo fechaNacimiento ")
   	@JsonProperty("edad")
   	private String  edad;
    @ApiModelProperty(value = "Este campo genero ")
	@JsonProperty("genero")
	private String  genero;
    @ApiModelProperty(value = "Este campo instruccion ")
	@JsonProperty("instruccion")
	private String  instruccion;
    @ApiModelProperty(value = "Este campo lugarInscripcionGenero ")
	@JsonProperty("lugarInscripcionGenero")
	private String  lugarInscripcionGenero;
    @ApiModelProperty(value = "Este campo lugarNacimiento ")
	@JsonProperty("lugarNacimiento")
	private String  lugarNacimiento;
    @ApiModelProperty(value = "Este campo NUI ")
	@JsonProperty("nui")
	private String  NUI;
    @ApiModelProperty(value = "Este campo nombre ")
	@JsonProperty("nombre")
	private String  nombre;
    @ApiModelProperty(value = "Este campo numeroCasa ")
	@JsonProperty("numeroCasa")
	private String  numeroCasa;
    @ApiModelProperty(value = "Este campo sexo ")
	@JsonProperty("sexo")
	private String  sexo;
    @ApiModelProperty(value = "Este campo fechaDefuncion ")
	@JsonProperty("fechaDefuncion")
	private String  fechaDefuncion;
    @ApiModelProperty(value = "Este campo nacionalidad ")
	@JsonProperty("nacionalidad")
	private String  nacionalidad;
    @ApiModelProperty(value = "Este campo origen ")
	@JsonProperty("origen")
	private String  origen;

}

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
public class RegistroCivilDTO {

	@ApiModelProperty(value = "Este campo nombreEntidad Persona")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo cedula Persona")
	@JsonProperty("nui")
	private String cedula;
	@ApiModelProperty(value = "Este campo condicionCiudadano Persona")
	@JsonProperty("condicionCedulado")
	private String condicionCiudadano;
	@ApiModelProperty(value = "Este campo conyuge Persona")
	@JsonProperty("conyuge")
	private String conyuge;
	@ApiModelProperty(value = "Este campo estadoCivil Persona")
	@JsonProperty("estadoCivil")
	private String estadoCivil;
	@ApiModelProperty(value = "Este campo cedula fechaDefuncion")
	@JsonProperty("fechaDefuncion")
	private String fechaDefuncion;
	@ApiModelProperty(value = "Este campo fechaNacimiento Persona")
	@JsonProperty("fechaNacimiento")
	private String fechaNacimiento;
	@ApiModelProperty(value = "Este campo calculo fechaNacimiento Persona")
	@JsonProperty("edad")
	private String edad;
	@ApiModelProperty(value = "Este campo lugarNacimiento Persona")
	@JsonProperty("lugarNacimiento")
	private String lugarNacimiento;
	@ApiModelProperty(value = "Este campo nombre Persona")
	@JsonProperty("nombre")
	private String nombre;
	@ApiModelProperty(value = "Este campo nacionalidad Persona")
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	@ApiModelProperty(value = "Este campo nombreMadre Persona")
	@JsonProperty("nombreMadre")
	private String nombreMadre;
	@ApiModelProperty(value = "Este campo nombrePadre Persona")
	@JsonProperty("nombrePadre")
	private String nombrePadre;
	//campos Regitro Civil union con Punto a Punto
	@ApiModelProperty(value = "Este campo fechaInscripcionGenero ")
	@JsonProperty("fechaInscripcionGenero")
	private String fechaInscripcionGenero;
	@ApiModelProperty(value = "Este campo genero ")
	@JsonProperty("genero")
	private String genero;
	@ApiModelProperty(value = "Este campo lugarInscripcionGenero ")
	@JsonProperty("lugarInscripcionGenero")
	private String lugarInscripcionGenero;	
	@ApiModelProperty(value = "Este campo Sexo ")
	@JsonProperty("sexo")
	private String sexo;
	@ApiModelProperty(value = "Este campo instruccion ")
	@JsonProperty("instruccion")
	private String instruccion;
	@ApiModelProperty(value = "Este campo numeroCasa ")
	@JsonProperty("numeroCasa")
	private String numeroCasa;
	@ApiModelProperty(value = "Este campo calle ")
	@JsonProperty("calle")
	private String calle;
	@ApiModelProperty(value = "Este campo codigoDomicilio ")
	@JsonProperty("codigoDomicilio")
	private String codigoDomicilio;
	@ApiModelProperty(value = "Este campo domicilio ")
	@JsonProperty("domicilio")
	private String domicilio;
	
	

	
	@ApiModelProperty(value = "Este campo origen ")
	@JsonProperty("origen")
	private String origen;

}

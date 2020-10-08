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
public class SriContribuyenteDTO {

	@ApiModelProperty(value = "Este campo nombreEntidad ")
	@JsonProperty("nombreEntidad")
	private String nombreEntidad;
	@ApiModelProperty(value = "Este campo actividadEconomica ")
	@JsonProperty("actividadEconomica")
	private String actividadEconomica;
	@ApiModelProperty(value = "Este campo codigoActividadEconomica ")
	@JsonProperty("codigoActividadEconomica")
	private String codigoActividadEconomica;
	@ApiModelProperty(value = "Este campo estadoContribuyente ")
	@JsonProperty("estadoContribuyente")
	private String estadoContribuyente;
	@ApiModelProperty(value = "Este campo claseContribuyente ")
	@JsonProperty("claseContribuyente")
	private String claseContribuyente;
	@ApiModelProperty(value = "Este campo numeroRuc ")
	@JsonProperty("numeroRuc")
	private String numeroRuc;
	@ApiModelProperty(value = "Este campo tipoContribuyente ")
	@JsonProperty("tipoContribuyente")
	private String tipoContribuyente;
	@ApiModelProperty(value = "Este campo estadoPersona ")
	@JsonProperty("estadoPersona")
	private String estadoPersona;
	@ApiModelProperty(value = "Este campo cedula estadoSociedad")
	@JsonProperty("estadoSociedad")
	private String estadoSociedad;
	@ApiModelProperty(value = "Este campo fechaActualizacion ")
	@JsonProperty("fechaActualizacion")
	private String fechaActualizacion;
	@ApiModelProperty(value = "Este campo fechaCancelacion ")
	@JsonProperty("fechaCancelacion")
	private String fechaCancelacion;
	@ApiModelProperty(value = "Este campo fechaInicioActividades ")
	@JsonProperty("fechaInicioActividades")
	private String fechaInicioActividades;
	@ApiModelProperty(value = "Este campo fechaReinicioActividades ")
	@JsonProperty("fechaReinicioActividades")
	private String fechaReinicioActividades;
	@ApiModelProperty(value = "Este campo fechaSuspensionDefinitiva ")
	@JsonProperty("fechaSuspensionDefinitiva")
	private String fechaSuspensionDefinitiva;
	@ApiModelProperty(value = "Este campo obligado ")
	@JsonProperty("obligado")
	private String obligado;
	@ApiModelProperty(value = "Este campo personaSociedad ")
	@JsonProperty("personaSociedad")
	private String personaSociedad;
	@ApiModelProperty(value = "Este campo razonSocial ")
	@JsonProperty("razonSocial")
	private String razonSocial;
	@ApiModelProperty(value = "Este campo listaBlanca ")
	@JsonProperty("listaBlanca")
	private String listaBlanca;
	

}

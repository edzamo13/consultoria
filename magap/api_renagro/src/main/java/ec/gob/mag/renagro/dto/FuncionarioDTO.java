package ec.gob.mag.renagro.dto;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//============== LOMBOK =============
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
//========== JPA ======================
public class FuncionarioDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731304523828751692L;

	@Id
	@ApiModelProperty(value = "Este campo es  la clave primaria de la tabla Persona", required = false, readOnly = true)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(value = "Campo que extrae el id de la persona", allowableValues = "")
	@JsonProperty("perId")
	@JsonInclude(Include.NON_NULL)
	private Long perId;

	@ApiModelProperty(value = "Campo que extrae el id de la tabla proyecto", allowableValues = "")
	@JsonProperty("proyId")
	@JsonInclude(Include.NON_NULL)
	private Long proyId;

	@ApiModelProperty(value = "Campo que extrae el id de la tabla usuario persona ps", allowableValues = "")
	@JsonProperty("upsId")
	@JsonInclude(Include.NON_NULL)
	private Long upsId;

	@ApiModelProperty(value = "Campo que extrae el id de la tabla padre correspondiente a usuario perfil ps", allowableValues = "")
	@JsonProperty("upsIdPadre")
	@JsonInclude(Include.NON_NULL)
	private Long upsIdPadre;

	@ApiModelProperty(value = "Campo que extrae el id del usuario", allowableValues = "")
	@JsonProperty("usuId")
	@JsonInclude(Include.NON_NULL)
	private Long usuId;

	@ApiModelProperty(value = "Campo que extrae el id de la tabla usuario persona", allowableValues = "")
	@JsonProperty("usupId")
	@JsonInclude(Include.NON_NULL)
	private Long usupId;

	@ApiModelProperty(value = "Campo que extrae el id de la ubicacion", allowableValues = "")
	@JsonProperty("ubiId")
	@JsonInclude(Include.NON_NULL)
	private Long ubiId;

	@ApiModelProperty(value = "Campo que extrae el id de la usuario perfil", allowableValues = "")
	@JsonProperty("upefId")
	@JsonInclude(Include.NON_NULL)
	private Long upefId;

	@ApiModelProperty(value = "Campo que extrae el id del perfil", allowableValues = "")
	@JsonProperty("tpefId")
	@JsonInclude(Include.NON_NULL)
	private Long tpefId;

	@ApiModelProperty(value = "Campo que extrae la cedula de la persona", allowableValues = "")
	@JsonProperty("perIdentificacion")
	@JsonInclude(Include.NON_NULL)
	private String perIdentificacion;

	@ApiModelProperty(value = "Campo que extrae el nombre de la persona", allowableValues = "")
	@JsonProperty("perNombre")
	@JsonInclude(Include.NON_NULL)
	private String perNombre;

	@ApiModelProperty(value = "Campo que extrae el apellido de la persona")
	@JsonProperty("perApellido")
	@JsonInclude(Include.NON_NULL)
	private String perApellido;

	@ApiModelProperty(value = "Campo que extrae los nombres y los apellidos")
	@JsonProperty("perNombresApellidos")
	@JsonInclude(Include.NON_NULL)
	private String perNombresApellidos;

	@ApiModelProperty(value = "Campo que extrae la direccion de la persona")
	@JsonProperty("perDirDomicilio")
	@JsonInclude(Include.NON_NULL)
	private String perDirDomicilio;

	@ApiModelProperty(value = "Campo que extrae el celular de la persona")
	// (name = "per_celular")
	@JsonProperty("perCelular")
	@JsonInclude(Include.NON_NULL)
	private String perCelular;

	@ApiModelProperty(value = "Campo que extrae el correo de la persona")
	@JsonProperty("perCorreo")
	@JsonInclude(Include.NON_NULL)
	private String perCorreo;

	@ApiModelProperty(value = "Campo que extrae la fecha de nacimiento del persona", required = false)
	@Temporal(TemporalType.DATE)
	@JsonProperty("perFechaNac")
	@JsonInclude(Include.NON_NULL)
	private Date perFechaNac;

	@ApiModelProperty(value = "Nombre del proyecto al que pertenece la persona")
	@JsonProperty("proyNombre")
	@JsonInclude(Include.NON_NULL)
	private String proyNombre;

	@ApiModelProperty(value = "Abreviatura del proyecto al que pertenece la persona")
	@JsonProperty("proyAbreviatura")
	@JsonInclude(Include.NON_NULL)
	private String proyAbreviatura;

	@ApiModelProperty(value = "Nombre Perfil Persona")
	@JsonProperty("tpefNombre")
	@JsonInclude(Include.NON_NULL)
	private String tpefNombre;

	@ApiModelProperty(value = "Campo que extrae el id del perfil", allowableValues = "")
	@JsonProperty("pefId")
	@JsonInclude(Include.NON_NULL)
	private Long pefId;

}

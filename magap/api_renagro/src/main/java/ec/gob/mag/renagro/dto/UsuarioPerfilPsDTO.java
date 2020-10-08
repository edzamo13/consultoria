package ec.gob.mag.renagro.dto;

import java.util.Date;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioPerfilPsDTO implements java.io.Serializable {

	private static final long serialVersionUID = -4731304523828751692L;

	@Id
	@ApiModelProperty(value = "", required = false, readOnly = true)
	@JsonProperty("upsId")
	private Long id;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsIdPadre")
	@JsonInclude(Include.NON_NULL)
	private Long upsIdPadre;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("psId")
	@JsonInclude(Include.NON_NULL)
	private Long psId;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefId")
	@JsonInclude(Include.NON_NULL)
	private Long upefId;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("ubiId")
	@JsonInclude(Include.NON_NULL)
	private Long ubiId;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsAsignado")
	@JsonInclude(Include.NON_NULL)
	private Long upsAsignado;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsEstado")
	@JsonInclude(Include.NON_NULL)
	private Long upsEstado;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsEliminado")
	@JsonInclude(Include.NON_NULL)
	private Boolean upsEliminado;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsRegUsu")
	@JsonInclude(Include.NON_NULL)
	private Long upsRegUsu;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsRegFecha")
	@JsonInclude(Include.NON_NULL)
	private Date upsRegFecha;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsActUsu")
	@JsonInclude(Include.NON_NULL)
	private Long upsActUsu;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upsActFecha")
	@JsonInclude(Include.NON_NULL)
	private Date upsActFecha;

}

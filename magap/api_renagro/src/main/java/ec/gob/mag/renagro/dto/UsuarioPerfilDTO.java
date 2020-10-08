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
public class UsuarioPerfilDTO implements java.io.Serializable {

	private static final long serialVersionUID = -4731304523828751692L;
	@Id
	@ApiModelProperty(value = "", required = false, readOnly = true)
	@JsonProperty("upefId")
	private Long id;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("pefId")
	@JsonInclude(Include.NON_NULL)
	private Long pefId;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("apliId")
	@JsonInclude(Include.NON_NULL)
	private Long apliId;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefPorDefecto")
	@JsonInclude(Include.NON_NULL)
	private Long upefPorDefecto;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefEstado")
	@JsonInclude(Include.NON_NULL)
	private Long upefEstado;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefEliminado")
	@JsonInclude(Include.NON_NULL)
	private Boolean upefEliminado;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefRegUsu")
	@JsonInclude(Include.NON_NULL)
	private Long upefRegUsu;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefRegFecha")
	@JsonInclude(Include.NON_NULL)
	private Date upefRegFecha;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefActUsu")
	@JsonInclude(Include.NON_NULL)
	private Long upefActUsu;

	@ApiModelProperty(value = "", allowableValues = "")
	@JsonProperty("upefActFecha")
	@JsonInclude(Include.NON_NULL)
	private Date upefActFecha;
}

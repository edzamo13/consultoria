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
public class SriFormulario104Campos {

	@ApiModelProperty(value = "Este campo anioFiscal ")
	@JsonProperty("anioFiscal")
	private String anioFiscal;

	@ApiModelProperty(value = "Este campo exportacionesNetasBienes800 ")
	@JsonProperty("exportacionesNetasBienes800")
	private String exportacionesNetasBienes800;

	@ApiModelProperty(value = "Este campo razonSocial ")
	@JsonProperty("razonSocial")
	private String razonSocial;

	@ApiModelProperty(value = "Este campo totImpVtEipIafTdc890 ")
	@JsonProperty("totImpVtEipIafTdc890")
	private String totImpVtEipIafTdc890;

	@ApiModelProperty(value = "Este campo totVtExpBruIaf860 ")
	@JsonProperty("totVtExpBruIaf860")
	private String totVtExpBruIaf860;

	@ApiModelProperty(value = "Este campo totVtExpNtaIafTcd870 ")
	@JsonProperty("totVtExpNtaIafTcd870")
	private String totVtExpNtaIafTcd870;

}

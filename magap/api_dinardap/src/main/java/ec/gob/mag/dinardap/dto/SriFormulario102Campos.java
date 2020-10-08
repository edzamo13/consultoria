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
public class SriFormulario102Campos {

	@ApiModelProperty(value = "Este campo anioFiscal ")
	@JsonProperty("anioFiscal")
	private String anioFiscal;

	@ApiModelProperty(value = "Este campo perdida2980 ")
	@JsonProperty("perdida2980")
	private String perdida2980;

	@ApiModelProperty(value = "Este campo perdidaEjercicio2810 ")
	@JsonProperty("perdidaEjercicio2810")
	private String perdidaEjercicio2810;

	@ApiModelProperty(value = "Este campo razonSocial ")
	@JsonProperty("razonSocial")
	private String razonSocial;

	@ApiModelProperty(value = "Este campo totActCorriente410 ")
	@JsonProperty("totActCorriente410")
	private String totActCorriente410;

	@ApiModelProperty(value = "Este campo totActivoNoCorriente812 ")
	@JsonProperty("totActivoNoCorriente812")
	private String totActivoNoCorriente812;

	@ApiModelProperty(value = "Este campo totPasivoPatrimonio1340 ")
	@JsonProperty("totPasivoPatrimonio1340")
	private String totPasivoPatrimonio1340;

	@ApiModelProperty(value = "Este campo totPatrimonioNeto1330 ")
	@JsonProperty("totPatrimonioNeto1330")
	private String totPatrimonioNeto1330;

	@ApiModelProperty(value = "Este campo totalActivo830 ")
	@JsonProperty("totalActivo830")
	private String totalActivo830;

	@ApiModelProperty(value = "Este campo totalActivoFijo560 ")
	@JsonProperty("totalActivoFijo560")
	private String totalActivoFijo560;

	@ApiModelProperty(value = "Este campo totalCostos2660 ")
	@JsonProperty("totalCostos2660")
	private String totalCostos2660;

	@ApiModelProperty(value = "Este campo totalCostosGastos2760 ")
	@JsonProperty("totalCostosGastos2760")
	private String totalCostosGastos2760;

	@ApiModelProperty(value = "Este campo totalGastos2750 ")
	@JsonProperty("totalGastos2750")
	private String totalGastos2750;

	@ApiModelProperty(value = "Este campo totalImpuestoPagar3570 ")
	@JsonProperty("totalImpuestoPagar3570")
	private String totalImpuestoPagar3570;

	@ApiModelProperty(value = "Este campo totalIngresos1440 ")
	@JsonProperty("totalIngresos1440")
	private String totalIngresos1440;

	@ApiModelProperty(value = "Este campo totalPasivo1310 ")
	@JsonProperty("totalPasivo1310")
	private String totalPasivo1310;

	@ApiModelProperty(value = "Este campo utilidadGravable2970 ")
	@JsonProperty("utilidadGravable2970")
	private String utilidadGravable2970;

	@ApiModelProperty(value = "Este campo utilidadNetaEjercicio2800 ")
	@JsonProperty("utilidadNetaEjercicio2800")
	private String utilidadNetaEjercicio2800;

}

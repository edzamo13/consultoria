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
public class SriFormulario101Campos {

	@ApiModelProperty(value = "Este campo anioFiscal ")
	@JsonProperty("anioFiscal")
	private String anioFiscal;

	@ApiModelProperty(value = "Este campo impuestoRentaPagar3680 ")
	@JsonProperty("impuestoRentaPagar3680")
	private String impuestoRentaPagar3680;

	@ApiModelProperty(value = "Este campo perdida3570 ")
	@JsonProperty("perdida3570")
	private String perdida3570;

	@ApiModelProperty(value = "Este campo perdidaEjercicio3430 ")
	@JsonProperty("perdidaEjercicio3430")
	private String perdidaEjercicio3430;

	@ApiModelProperty(value = "Este campo razonSocial ")
	@JsonProperty("razonSocial")
	private String razonSocial;

	@ApiModelProperty(value = "Este campo totActivoNoCorriente1077 ")
	@JsonProperty("totActivoNoCorriente1077")
	private String totActivoNoCorriente1077;

	@ApiModelProperty(value = "Este campo totalActivo1080 ")
	@JsonProperty("totalActivo1080")
	private String totalActivo1080;

	@ApiModelProperty(value = "Este campo totalActivoCorriente470 ")
	@JsonProperty("totalActivoCorriente470")
	private String totalActivoCorriente470;

	@ApiModelProperty(value = "Este campo totalActivosDiferidos780 ")
	@JsonProperty("totalActivosDiferidos780")
	private String totalActivosDiferidos780;

	@ApiModelProperty(value = "Este campo totalActivosFijos690 ")
	@JsonProperty("totalActivosFijos690")
	private String totalActivosFijos690;

	@ApiModelProperty(value = "Este campo totalCostos3360 ")
	@JsonProperty("totalCostos3360")
	private String totalCostos3360;

	@ApiModelProperty(value = "Este campo totalGastos3370 ")
	@JsonProperty("totalGastos3370")
	private String totalGastos3370;

	@ApiModelProperty(value = "Este campo totalIngresos1930 ")
	@JsonProperty("totalIngresos1930")
	private String totalIngresos1930;

	@ApiModelProperty(value = "Este campo totalPasivoPatrimonio1790 ")
	@JsonProperty("totalPasivoPatrimonio1790")
	private String totalPasivoPatrimonio1790;

	@ApiModelProperty(value = "Este campo totalPasivos1620 ")
	@JsonProperty("totalPasivos1620")
	private String totalPasivos1620;

	@ApiModelProperty(value = "Este campo totalPatrimonioNeto1780 ")
	@JsonProperty("totalPatrimonioNeto1780")
	private String totalPatrimonioNeto1780;

	@ApiModelProperty(value = "Este campo totasCostosGastos3380 ")
	@JsonProperty("totasCostosGastos3380")
	private String totasCostosGastos3380;

	@ApiModelProperty(value = "Este campo utiReinvertirCpz3580 ")
	@JsonProperty("utiReinvertirCpz3580")
	private String utiReinvertirCpz3580;

	@ApiModelProperty(value = "Este campo utilidadEjercicio3420 ")
	@JsonProperty("utilidadEjercicio3420")
	private String utilidadEjercicio3420;

	@ApiModelProperty(value = "Este campo utilidadGravable3560 ")
	@JsonProperty("utilidadGravable3560")
	private String utilidadGravable3560;

}

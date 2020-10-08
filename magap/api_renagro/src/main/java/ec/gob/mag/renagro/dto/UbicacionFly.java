package ec.gob.mag.renagro.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//============== LOMBOK =============

@Data
@ToString(of = "ubiId")
@EqualsAndHashCode(of = "ubiId")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UbicacionFly {

	@ApiModelProperty(value = "Este campo es  la clave primaria de la tabla agrupacion")
	@JsonProperty("ubiId")
	private Long ubiId;

	@ApiModelProperty(value = "Nombre de la ubicacion", position = 9)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiNombre")
	private String ubiNombre;

	@ApiModelProperty(value = "Nombre de la ubicacion", position = 9)
	@JsonInclude(Include.NON_NULL)
	// @Column(name = "ubi_nombre")
	@JsonProperty("ubicacionFly")
	private UbicacionFly ubicacionFly;

}

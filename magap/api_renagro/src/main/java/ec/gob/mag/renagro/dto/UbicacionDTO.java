package ec.gob.mag.renagro.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

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

public class UbicacionDTO implements Serializable {
	private static final long serialVersionUID = -6374373201561910245L;

	@ApiModelProperty(value = "Este campo es  la clave primaria de la tabla agrupacion")
	@JsonProperty("ubiId")
	private Long ubiId;

	@ApiModelProperty(value = " ***", position = 2)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("catIdSector")
	private Long catIdSector;

	@ApiModelProperty(value = " ***", position = 3)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("catIdUbicacion")
	private Long catIdUbicacion;

	@ApiModelProperty(value = " ***", position = 4)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("catIdCapital")
	private Long catIdCapital;

	@ApiModelProperty(value = " ***", position = 5)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("catIdZona")
	private Long catIdZona;

	@ApiModelProperty(value = " ***", position = 6)
	@JsonInclude(Include.NON_NULL)

	@OneToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ubi_id_padre", insertable = false, updatable = false)
	@JsonProperty("ubicacion")
	private UbicacionDTO ubicacion;

	@ApiModelProperty(value = " ***", position = 7)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiCodInec")
	private String ubiCodInec;

	@ApiModelProperty(value = " ***", position = 8)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiCanton")
	private String ubiCanton;

	@ApiModelProperty(value = " ***", position = 9)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiNombre")
	private String ubiNombre;

	@ApiModelProperty(value = " ***", position = 10)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiNivel")
	private int ubiNivel;

	@ApiModelProperty(value = " ***", position = 11)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiPrefijoTel")
	private String ubiPrefijoTel;

	@ApiModelProperty(value = " ***", position = 12)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiEstado")
	private int ubiEstado;

	@ApiModelProperty(value = " ***", position = 13)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiEliminado")
	private Boolean ubiEliminado;

	@ApiModelProperty(value = " ***", position = 14)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiRegUsu")
	private Long ubiRegUsu;
	/*
	 *
	 * Pasar a timesatmp
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = " ***", position = 15)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiRegFecha")
	private Date ubiRegFecha;

	@ApiModelProperty(value = " ***", position = 16)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiActUsu")
	private Long ubiActUsu;

	@ApiModelProperty(value = " ***", position = 17)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiActFecha")
	private Date ubiActFecha;

	@ApiModelProperty(value = " ***", position = 18)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLatitud")
	private Float ubiLatitud;

	@ApiModelProperty(value = " ***", position = 19)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLongitud")
	private Float ubiLongitud;

	@ApiModelProperty(value = " ***", position = 20)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiSuperficie")
	private Float ubiSuperficie;

	@ApiModelProperty(value = " ***", position = 21)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLongitudMin")
	private Float ubiLongitudMin;

	@ApiModelProperty(value = " ***", position = 22)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLongitudMax")
	private Float ubiLongitudMax;

	@ApiModelProperty(value = " ***", position = 23)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLatitudMax")
	private Float ubiLatitudMax;

	@ApiModelProperty(value = " ***", position = 26)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiZona")
	private String ubiZona;

	@ApiModelProperty(value = " ***", position = 27)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiHemisferio")
	private String ubiHemisferio;

	@ApiModelProperty(value = " ***", position = 28)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMin17s")
	private Float ubiXMin17s;

	@ApiModelProperty(value = " ***", position = 29)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMax17s")
	private Float ubiXMax17s;

	@ApiModelProperty(value = " ***", position = 30)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMin17s")
	private Float ubiYMin17s;

	@ApiModelProperty(value = " ***", position = 31)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMax17s")
	private Float ubiYMax17s;

	@ApiModelProperty(value = " ***", position = 32)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiLatitudMin")
	private Float ubiLatitudMin;

	@ApiModelProperty(value = " ***", position = 33)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiX17s")
	private Float ubiX17s;

	@ApiModelProperty(value = " ***", position = 34)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiY17s")
	private Float ubiY17s;

	@ApiModelProperty(value = " ***", position = 35)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiX17n")
	private Float ubiX17n;

	@ApiModelProperty(value = " ***", position = 36)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiY17n")
	private Float ubiY17n;

	@ApiModelProperty(value = " ***", position = 37)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiX18s")
	private Float ubiX18s;

	@ApiModelProperty(value = " ***", position = 38)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiY18s")
	private Float ubiY18s;

	@ApiModelProperty(value = " ***", position = 39)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiX18n")
	private Float ubiX18n;

	@ApiModelProperty(value = " ***", position = 40)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiY18n")
	private Float ubiY18n;

	@ApiModelProperty(value = " ***", position = 41)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMax17n")
	private Float ubiXMax17n;

	@ApiModelProperty(value = " ***", position = 42)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMin17n")
	private Float ubiXMin17n;

	@ApiModelProperty(value = " ***", position = 43)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMax17n")
	private Float ubiYMax17n;

	@ApiModelProperty(value = " ***", position = 44)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMin17n")
	private Float ubiYMin17n;

	@ApiModelProperty(value = " ***", position = 45)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMax18s")
	private Float ubiXMax18s;

	@ApiModelProperty(value = " ***", position = 46)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMin18s")
	private Float ubiXMin18s;

	@ApiModelProperty(value = " ***", position = 47)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMax18s")
	private Float ubiYMax18s;

	@ApiModelProperty(value = " ***", position = 48)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMin18s")
	private Float ubiYMin18s;

	@ApiModelProperty(value = " ***", position = 49)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMax18n")
	private Float ubiXMax18n;

	@ApiModelProperty(value = " ***", position = 50)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiXMin18n")
	private Float ubiXMin18n;

	@ApiModelProperty(value = " ***", position = 51)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMax18n")
	private Float ubiYMax18n;

	@ApiModelProperty(value = " ***", position = 52)
	@JsonInclude(Include.NON_NULL)

	@JsonProperty("ubiYMin18n")
	private Float ubiYMin18n;

	public void cleaner() {

	}

}

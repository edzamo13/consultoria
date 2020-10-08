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
public class SriAutorizacionEmisionCampos {

	@ApiModelProperty(value = "Este campo suspensionRuc ")
	@JsonProperty("suspensionRuc")
	private String suspensionRuc;

	@ApiModelProperty(value = "Este campo imprenta ")
	@JsonProperty("imprenta")
	private String imprenta;
	   
                       
	@ApiModelProperty(value = "Este campo suspensionEst ")
	@JsonProperty("suspensionEst")
	private String suspensionEst;
   
                       
	@ApiModelProperty(value = "Este campo fechaInicioDetalle ")
	@JsonProperty("fechaInicioDetalle")
	private String fechaInicioDetalle;
	   
                       
	@ApiModelProperty(value = "Este campo fechaFinDetalle ")
	@JsonProperty("fechaFinDetalle")
	private String fechaFinDetalle;
   
                       
	@ApiModelProperty(value = "Este campo id ")
	@JsonProperty("id")
	private String id;
  
	@ApiModelProperty(value = "Este campo idModalidadEmision ")
	@JsonProperty("idModalidadEmision")
	private String idModalidadEmision;
   
                       
	@ApiModelProperty(value = "Este campo codigoAutorizacion ")
	@JsonProperty("codigoAutorizacion")
	private String codigoAutorizacion;
    
                       
	@ApiModelProperty(value = "Este campo numeroRuc ")
	@JsonProperty("numeroRuc")
	private String numeroRuc;
 
	@ApiModelProperty(value = "Este campo establecContribuyente ")
	@JsonProperty("establecContribuyente")
	private String establecContribuyente;

	@ApiModelProperty(value = "Este campo puntoEmisionContribuyente ")
	@JsonProperty("puntoEmisionContribuyente")
	private String puntoEmisionContribuyente;
   
                       
	@ApiModelProperty(value = "Este campo idTipoDocumento ")
	@JsonProperty("idTipoDocumento")
	private String idTipoDocumento;
  
                       
	@ApiModelProperty(value = "Este campo numeroInicialImpreso ")
	@JsonProperty("numeroInicialImpreso")
	private String numeroInicialImpreso;
  
                       
	@ApiModelProperty(value = "Este campo numeroFinalImpreso ")
	@JsonProperty("numeroFinalImpreso")
	private String numeroFinalImpreso;
	  
                       
	@ApiModelProperty(value = "Este campo idRangoImpreso ")
	@JsonProperty("idRangoImpreso")
	private String idRangoImpreso;
	  
                       
	@ApiModelProperty(value = "Este campo numeroEstablecimientoBaja ")
	@JsonProperty("numeroEstablecimientoBaja")
	private String numeroEstablecimientoBaja;
   
	@ApiModelProperty(value = "Este campo numeroInicialBaja ")
	@JsonProperty("numeroInicialBaja")
	private String numeroInicialBaja;
  
                       
	@ApiModelProperty(value = "Este campo numeroFinalBaja ")
	@JsonProperty("numeroFinalBaja")
	private String numeroFinalBaja;
 
                       
	@ApiModelProperty(value = "Este campo numeroInicialAutoimpreso ")
	@JsonProperty("numeroInicialAutoimpreso")
	private String numeroInicialAutoimpreso;
   
                       
	@ApiModelProperty(value = "Este campo numeroFinalAutoimpreso ")
	@JsonProperty("numeroFinalAutoimpreso")
	private String numeroFinalAutoimpreso;
  
	@ApiModelProperty(value = "Este campo numeroSerie ")
	@JsonProperty("numeroSerie")
	private String numeroSerie;
 
                       
	@ApiModelProperty(value = "Este campo idModeloRegistradora ")
	@JsonProperty("idModeloRegistradora")
	private String idModeloRegistradora;

                       
	@ApiModelProperty(value = "Este campo idEstado ")
	@JsonProperty("idEstado")
	private String idEstado;
   
                       
	@ApiModelProperty(value = "Este campo fechaInicio ")
	@JsonProperty("fechaInicio")
	private String fechaInicio;

                       
	@ApiModelProperty(value = "Este campo fechaFin ")
	@JsonProperty("fechaFin")
	private String fechaFin;
   
                       
	@ApiModelProperty(value = "Este campo codigoImprenta ")
	@JsonProperty("codigoImprenta")
	private String codigoImprenta;
	  
	@ApiModelProperty(value = "Este campo fechaSuspensionRuc ")
	@JsonProperty("fechaSuspensionRuc")
	private String fechaSuspensionRuc;

                       
	@ApiModelProperty(value = "Este campo codigo ")
	@JsonProperty("codigo")
	private String codigo;
    
                       
	@ApiModelProperty(value = "Este campo descripcion ")
	@JsonProperty("descripcion")
	private String descripcion;
   
                       
	@ApiModelProperty(value = "Este campo abreviacion ")
	@JsonProperty("abreviacion")
	private String abreviacion;
 
                       
	@ApiModelProperty(value = "Este campo activo ")
	@JsonProperty("activo")
	private String activo;
  
	@ApiModelProperty(value = "Este campo visualizar ")
	@JsonProperty("visualizar")
	private String visualizar;

                       
                        

	

}

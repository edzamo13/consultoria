package ec.gob.mag.interoperabilidad.proamazonia.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b> Incluir aqui la descripción de la clase. </b>
 *
 * @author ezamora
 *         <p>
 *         [$Author: ezamora $, $Date: Sep 18, 2020]
 *         </p>
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabeceraGuiaPrimariaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gmvCodigo;

	private String gmvId;

	private String prgId;

	private String gmvFechaInicio;

	private Integer gmvTipoDestino;

	private String licSecuencia;

	private String prgCodigo;

	private String propietarioRazzonsocial;

	private String pripietarioNombres;

	private String propietarioRuc;

	private String ejecutorNombres;

	private String ejecutorRazonsocial;

	private String ejecutorRuc;

	private String predioProvincia;

	private String predioCanton;

	private String predioParroquia;

	private String predioSitio;

	private String vehiculoPlaca;

	private String vehiculoColor;

	private String vehiculoMarca;

	private String vehiculoTipo;

	private String guipriFechainicio;

	private String guipriDuracionhoras;

	private String guiapriFechafin;

	private String sucIdDestino;

	private List<DestinoClienteFinalGpDto> destinoClienteFinalGpDtos;

	private List<DestinoExportacionGpDto> destinoExportacionGpDtos;

	private List<DestinoIndustriaForestalGpDto> destinoIndustriaForestalGpDtos;

	private List<DetalleGuiaPrimariaDto> detalleGuiaPrimariaDtos;

}

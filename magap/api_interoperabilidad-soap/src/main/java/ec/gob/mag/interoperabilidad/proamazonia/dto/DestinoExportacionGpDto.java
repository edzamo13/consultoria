package ec.gob.mag.interoperabilidad.proamazonia.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *  <b>
 * Incluir aqui la descripción de la clase.
 * </b>
 *
 * @author ezamora
 * <p>[$Author:  ezamora  $, $Date: Sep 18, 2020]</p>
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinoExportacionGpDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String gmvCodigo;

    private String prgId;

    private String gmvFechaInicio;
    
    private String nombre;
    
    private String direccion;
    
    private String codCanton;

    private String id;
 


    

}

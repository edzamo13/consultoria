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
public class DetalleGuiaPrimariaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String licId;
    
    private String espId;
    
    private String especie;
    
    private String espNombre;
    
    private String gesTipo;
    
    private String tipoEspecie;
    
    private String espTipo;
    
    private String gesLargo;
    
    private String gesAncho;
    
    private String gesEspesor;
    
    private String gesUnidades;
    
    private String gesVolumen;
    
    private String gesVolumenMovilizado;

    private String id;


   

}

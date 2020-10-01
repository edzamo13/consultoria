/*
* Copyright 2020 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/

package ec.gob.mag.interoperabilidad.proamazonia.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "detalle_guia_primaria", catalog = "dwh_mag", schema = "interoperabilidad")
public class DetalleGuiaPrimaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "lic_id", length = 2)
    private String licId;
    @Column(name = "esp_id")
    private Integer espId;
    @Column(length = 2147483647)
    private String especie;
    @Column(name = "esp_nombre", length = 350)
    private String espNombre;
    @Column(name = "ges_tipo")
    private Integer gesTipo;
    @Column(name = "tipo_especie", length = 2147483647)
    private String tipoEspecie;
    @Column(name = "esp_tipo", length = 350)
    private String espTipo;
    @Column(name = "ges_largo")
    private Integer gesLargo;
    @Column(name = "ges_ancho")
    private Integer gesAncho;
    @Column(name = "ges_espesor")
    private Integer gesEspesor;
    @Column(name = "ges_unidades")
    private Long gesUnidades;
    @Column(name = "ges_volumen")
    private Integer gesVolumen;
    @Column(name = "ges_volumen_movilizado")
    private Integer gesVolumenMovilizado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "gmv_id", referencedColumnName = "gmv_id")
    @ManyToOne
    private CabeceraGuiaPrimaria gmvId;

   

}

/*
* Copyright 2020 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
*/

package ec.gob.mag.interoperabilidad.proamazonia.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "destino_industria_forestal_gp", catalog = "dwh_mag", schema = "interoperabilidad")
public class DestinoIndustriaForestalGp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "gmv_codigo", length = 20)
    private String gmvCodigo;
    @Column(name = "prg_id")
    private Integer prgId;
    @Column(name = "gmv_fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmvFechaInicio;
    @Column(length = 2147483647)
    private String direccion;
    @Column(name = "con_telefo", length = 20)
    private String conTelefo;
    @Column(length = 80)
    private String provincia;
    @Column(length = 80)
    private String canton;
    @Column(length = 80)
    private String parroquia;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "gmv_id", referencedColumnName = "gmv_id")
    @ManyToOne
    private CabeceraGuiaPrimaria gmvId;

   

}

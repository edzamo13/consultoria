/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.modelo;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *
 * @author ezamora
 * <p>
 * [$Author: ezamora $, $Date: 02/02/2016]</p>
 */
@Entity
@Table(name = "seg_usuarioshist_tbl", schema = "seguridad")
public class Usuarioshist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "us_id_usuariohist")
    @Getter
    @Setter
    private Integer usIdUsuariohist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "us_clave_anterior")
    @Getter
    @Setter
    private String usClaveAnterior;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "us_clave_actual")
    @Getter
    @Setter
    private String usClaveActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_fec_actualizacion")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date usFecActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "us_direccion_ip")
    @Getter
    @Setter
    private String usDireccionIp;
    @JoinColumn(name = "us_id_usuario", referencedColumnName = "us_id_usuario")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Usuario usIdUsuario;

    public Usuarioshist() {
    }

}

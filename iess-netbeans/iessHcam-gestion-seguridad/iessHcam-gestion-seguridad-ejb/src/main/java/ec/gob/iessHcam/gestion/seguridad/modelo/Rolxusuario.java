/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

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
@Table(name = "seg_rolxusuario_tbl", schema = "seguridad")
public class Rolxusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ru_id_rolxusu")
    @SequenceGenerator(name = "seg_rolxusuario_tbl_seq", schema = "seguridad", sequenceName = "seg_rolxusuario_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_rolxusuario_tbl_seq")
    @Getter
    @Setter
    private Integer ruIdRolxusu;
    @Basic(optional = false)
    @NotNull
    @Size(max = 1)
    @Column(name = "ru_estado")
    @Getter
    @Setter
    private String ruEstado;
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date fecCreacion;
    @Column(name = "id_usu_creacion")
    @Getter
    @Setter
    private Integer idUsuCreacion;
    @Size(max = 20)
    @Column(name = "ip_equipo")
    @Getter
    @Setter
    private String ipEquipo;
    @JoinColumn(name = "ro_id_rol", referencedColumnName = "ro_id_rol")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Rol roIdRol;
    @JoinColumn(name = "us_id_usuario", referencedColumnName = "us_id_usuario")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Usuario usIdUsuario;

    public Rolxusuario() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruIdRolxusu != null ? ruIdRolxusu.hashCode() : 0);
        return hash;
    }
}

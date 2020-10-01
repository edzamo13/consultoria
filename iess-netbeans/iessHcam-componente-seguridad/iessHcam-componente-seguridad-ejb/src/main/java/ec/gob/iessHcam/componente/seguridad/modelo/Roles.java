/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "seg_roles_tbl", schema = "seguridad")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ro_id_rol")
    @SequenceGenerator(name = "seguridad.seg_roles_tbl_seq", schema = "seguridad", sequenceName = "seguridad.seg_roles_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seguridad.seg_roles_tbl_seq")
    @Getter
    @Setter
    private Integer roIdRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ro_nombre")
    @Getter
    @Setter
    private String roNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ro_descripcion")
    @Getter
    @Setter
    private String roDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ro_estado")
    @Getter
    @Setter
    private String roEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roIdRol")
    @Getter
    @Setter
    private List<Rolxdependencias> segRolxdependenciasTblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roIdRol")
    @Getter
    @Setter
    private List<Rolxmenu> segRolxmenuTblList;
    @JoinColumn(name = "tr_id_tiporol", referencedColumnName = "tr_id_tiporol")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Tiporoles trIdTiporol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roIdRol")
    @Getter
    @Setter
    private List<Rolxusuario> segRolxusuarioTblList;

    public Roles() {
    }

}

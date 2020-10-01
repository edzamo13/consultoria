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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "seg_dependencias_tbl",schema = "seguridad")
public class Dependencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "de_id_dependencia")
    @SequenceGenerator(name = "seguridad.seg_dependencias_tbl_seq", schema = "seguridad", sequenceName = "seguridad.seg_dependencias_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seguridad.seg_dependencias_tbl_seq")
    @Getter
    @Setter
    private Integer deIdDependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "de_nombre")
    @Getter
    @Setter
    private String deNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "de_tipo_dependencia")
    @Getter
    @Setter
    private String deTipoDependencia;
    @Column(name = "de_id_dependencia_padre")
    @Getter
    @Setter
    private Integer deIdDependenciaPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "de_estado")
    @Getter
    @Setter
    private String deEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deIdDependencia")
    @Getter
    @Setter
    private List<Aplicacion> segAplicacionesTblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deIdDependencia")
    @Getter
    @Setter
    private List<Rolxdependencias> segRolxdependenciasTblList;
    @JoinColumn(name = "in_id_institucion", referencedColumnName = "in_id_institucion")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Instituciones inIdInstitucion;

    public Dependencias() {
    }

    
}

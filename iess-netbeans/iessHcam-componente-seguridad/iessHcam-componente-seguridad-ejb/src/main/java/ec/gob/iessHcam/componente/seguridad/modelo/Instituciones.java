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
@Table(name = "seg_instituciones_tbl" ,schema = "seguridad")
public class Instituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "in_id_institucion")
    @SequenceGenerator(name = "seguridad.seg_instituciones_tbl_seq", schema = "seguridad", sequenceName = "seguridad.seg_instituciones_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seguridad.seg_instituciones_tbl_seq")
    @Getter
    @Setter
    private Integer inIdInstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "in_nombre")
    @Getter
    @Setter
    private String inNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "in_estado")
    @Getter
    @Setter
    private String inEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inIdInstitucion")
    @Getter
    @Setter
    private List<Dependencias> segDependenciasTblList;

    public Instituciones() {
    }

}

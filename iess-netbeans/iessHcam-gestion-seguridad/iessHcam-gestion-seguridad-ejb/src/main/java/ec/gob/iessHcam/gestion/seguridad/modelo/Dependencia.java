/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

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
@NamedQueries({
    @NamedQuery(name = Dependencia.OBTENER_DEPENDENCIA_POR_NOMBRE, query = "SELECT d FROM Dependencia d WHERE d.deNombre=:nombre"),
    @NamedQuery(name = Dependencia.OBTENER_DEPENDENCIA_NO_ASIGNADAS_ROL, query = "SELECT d FROM Dependencia d WHERE d.inIdInstitucion.inIdInstitucion=:idInstitucion and d.deIdDependencia not in (select rd.deIdDependencia.deIdDependencia from Rolxdependencia rd where rd.roIdRol.roIdRol=:idRol) and d.deEstado='A'"),})

public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_DEPENDENCIA_POR_NOMBRE = "Dependencia.OBTENER_DEPENDENCIA_POR_NOMBRE";
    public static final String OBTENER_DEPENDENCIA_NO_ASIGNADAS_ROL = "Dependencia.OBTENER_DEPENDENCIA_NO_ASIGNADAS_ROL";
    
    @Id
    @Basic(optional = false)
    @Column(name = "de_id_dependencia")
    @SequenceGenerator(name = "seg_dependencias_tbl_seq", schema = "seguridad", sequenceName = "seg_dependencias_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_dependencias_tbl_seq")
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
    private List<Rolxdependencia> segRolxdependenciasTblList;
    @JoinColumn(name = "in_id_institucion", referencedColumnName = "in_id_institucion")
    @ManyToOne(optional = true)
    @Getter
    @Setter
    private Institucion inIdInstitucion;

    public Dependencia() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deIdDependencia != null ? deIdDependencia.hashCode() : 0);
        return hash;
    }
}

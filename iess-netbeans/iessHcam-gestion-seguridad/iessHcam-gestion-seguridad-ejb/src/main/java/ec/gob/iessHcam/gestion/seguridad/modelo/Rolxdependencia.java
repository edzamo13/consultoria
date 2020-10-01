/*
 * Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.gestion.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "seg_rolxdependencias_tbl", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Rolxdependencia.OBTENER_ROLXDEPENDENCIA_POR_IDDEPENDENCI_IDROL, query = "SELECT rd FROM Rolxdependencia rd where rd.deIdDependencia.deIdDependencia=:idDependencia and rd.roIdRol.roIdRol=:idRol"),})

public class Rolxdependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_ROLXDEPENDENCIA_POR_IDDEPENDENCI_IDROL = "Rolxdependencia.OBTENER_ROLXDEPENDENCIA_POR_IDDEPENDENCI_IDROL";

    @Id
    @Basic(optional = false)
    @Column(name = "rd_id_rolxdep")
    @SequenceGenerator(name = "seg_rolxdependencias_tbl_seq", schema = "seguridad", sequenceName = "seg_rolxdependencias_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_rolxdependencias_tbl_seq")
    @Getter
    @Setter
    private Integer rdIdRolxdep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "rd_estado")
    @Getter
    @Setter
    private String rdEstado;
    @JoinColumn(name = "de_id_dependencia", referencedColumnName = "de_id_dependencia")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Dependencia deIdDependencia;
    @JoinColumn(name = "ro_id_rol", referencedColumnName = "ro_id_rol")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Rol roIdRol;

    public Rolxdependencia() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rdIdRolxdep != null ? rdIdRolxdep.hashCode() : 0);
        return hash;
    }
}

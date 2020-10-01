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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "seg_tiporoles_tbl", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Tiporol.OBTENER_TIPOS_ROL_ACTIVAS, query = "SELECT a FROM Tiporol a "),})

public class Tiporol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_TIPOS_ROL_ACTIVAS = "Tiporol.OBTENER_INSTITUCIONES_ACTIVAS";

    @Id
    @Basic(optional = false)
    @Column(name = "tr_id_tiporol")
    @SequenceGenerator(name = "seg_tiporoles_tbl_seq", schema = "seguridad", sequenceName = "seg_tiporoles_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_tiporoles_tbl_seq")
    @Getter
    @Setter
    private Integer trIdTiporol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tr_nombre")
    @Getter
    @Setter
    private String trNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "tr_descripcion")
    @Getter
    @Setter
    private String trDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tr_estado")
    @Getter
    @Setter
    private String trEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trIdTiporol")
    @Getter
    @Setter
    private List<Rol> segRolesTblList;

    public Tiporol() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trIdTiporol != null ? trIdTiporol.hashCode() : 0);
        return hash;
    }
}

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
@Table(name = "seg_rolxmenu_tbl", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Rolxmenu.OBTENER_MENU_ASIGNADO_POR_ROL, query = "SELECT m FROM Menu m, Rolxmenu rm, Rol r WHERE m.meIdOpcion = rm.meIdOpcion.meIdOpcion and rm.roIdRol.roIdRol = r.roIdRol and r.roIdRol=:idRol and m.apIdAplicacion.apIdAplicacion=:idAplicacion "),})

public class Rolxmenu implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_MENU_ASIGNADO_POR_ROL = "Rolxmenu.OBTENER_MENU_ASIGNADO_POR_ROL";
    
    @Id
    @Basic(optional = false)
    @Column(name = "rm_id_rolxmenu")
    @SequenceGenerator(name = "seg_rolxmenu_tbl_seq", schema = "seguridad", sequenceName = "seg_rolxmenu_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_rolxmenu_tbl_seq")
    @Getter
    @Setter
    private Integer rmIdRolxmenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "rm_estado")
    @Getter
    @Setter
    private String rmEstado;
    @JoinColumn(name = "me_id_opcion", referencedColumnName = "me_id_opcion")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Menu meIdOpcion;
    @JoinColumn(name = "ro_id_rol", referencedColumnName = "ro_id_rol")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Rol roIdRol;

    public Rolxmenu() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmIdRolxmenu != null ? rmIdRolxmenu.hashCode() : 0);
        return hash;
    }
}

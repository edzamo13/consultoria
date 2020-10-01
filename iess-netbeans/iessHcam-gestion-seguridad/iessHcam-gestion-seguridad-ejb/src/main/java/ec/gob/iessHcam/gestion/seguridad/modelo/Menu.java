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
import javax.persistence.Transient;
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
@Table(name = "seg_menu_tbl" , schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Menu.OBTENER_MENU_POR_APLICACION, query = "SELECT m FROM Menu m WHERE m.apIdAplicacion.apIdAplicacion=:idAplicacion order by m.meOrden"),
    @NamedQuery(name = Menu.OBTENER_MENU_POR_APLICACION_NO_ASIGNADOS_A_ROL, query = "SELECT m FROM Menu m WHERE m.meEstado='A' and m.apIdAplicacion.apIdAplicacion=:idAplicacion and m.meIdOpcion not in (select rm.meIdOpcion.meIdOpcion from Rolxmenu rm where rm.meIdOpcion.apIdAplicacion.apIdAplicacion=:idAplicacion and rm.roIdRol.roIdRol=:idRol) order by m.meOrden"),})

public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OBTENER_MENU_POR_APLICACION = "Menu.OBTENER_MENU_POR_APLICACION";
    public static final String OBTENER_MENU_POR_APLICACION_NO_ASIGNADOS_A_ROL = "Menu.OBTENER_MENU_POR_APLICACION_NO_ASIGNADOS_A_ROL";
    
    @Id
    @Basic(optional = false)
    @Column(name = "me_id_opcion")
    @SequenceGenerator(name = "seg_menu_tbl_seq", schema = "seguridad", sequenceName = "seg_menu_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seg_menu_tbl_seq")
    @Getter
    @Setter
    private Integer meIdOpcion;
    @Column(name = "me_id_opcion_padre")
    @Getter
    @Setter
    private Integer meIdOpcionPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "me_etiqueta")
    @Getter
    @Setter
    private String meEtiqueta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "me_orden")
    @Getter
    @Setter
    private int meOrden;
    @Size(max = 500)
    @Column(name = "me_url")
    @Getter
    @Setter
    private String meUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "me_nodo_final")
    @Getter
    @Setter
    private int meNodoFinal;
    @Size(max = 200)
    @Column(name = "me_accion")
    @Getter
    @Setter
    private String meAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "me_estado")
    @Getter
    @Setter
    private String meEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "me_auditoria")
    @Getter
    @Setter
    private int meAuditoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meIdOpcion")
    @Getter
    @Setter
    private List<Rolxmenu> segRolxmenuTblList;
    @JoinColumn(name = "ap_id_aplicacion", referencedColumnName = "ap_id_aplicacion")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Aplicacion apIdAplicacion;

    
    @Transient
    @Getter
    @Setter
    private boolean habilitado;
    
    public Menu() {
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meIdOpcion != null ? meIdOpcion.hashCode() : 0);
        return hash;
    }
}

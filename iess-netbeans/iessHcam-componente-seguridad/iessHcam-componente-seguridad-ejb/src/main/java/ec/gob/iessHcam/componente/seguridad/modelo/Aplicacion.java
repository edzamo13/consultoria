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
import javax.persistence.Lob;
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
@Table(name = "seg_aplicaciones_tbl", schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Aplicacion.OBTENER_APLICACION_POR_USUSUARIO, query = "SELECT DISTINCT a FROM Usuario u, Rolxusuario ru, Roles r, Rolxdependencias rd, Dependencias d, Aplicacion a, Rolxmenu rm, Menu m WHERE u=ru.usIdUsuario AND ru.roIdRol=r AND r=rd.roIdRol AND rd.deIdDependencia=d AND d=a.deIdDependencia AND u.usIdUsuario=:usuario and ru.ruEstado LIKE 'A' AND r.roEstado='A' AND rd.rdEstado='A' AND d.deEstado='A' AND a.apEstado LIKE 'A' and rm.roIdRol = r and rm.meIdOpcion = m and m.apIdAplicacion=a and rm.rmEstado like 'A' and m.meEstado like 'A' order by a.apNombre "),

    @NamedQuery(name = Aplicacion.OBTENER_APLICACION_POR_USUARIO_Y_VISIBLES_EN_PANTALLA, query = "SELECT DISTINCT a FROM Usuario u, Rolxusuario ru, Roles r, Rolxdependencias rd, Dependencias d, Aplicacion a, Rolxmenu rm, Menu m WHERE u=ru.usIdUsuario AND ru.roIdRol=r AND r=rd.roIdRol AND rd.deIdDependencia=d AND d=a.deIdDependencia AND u.usIdUsuario=:usuario and ru.ruEstado LIKE 'A' AND r.roEstado='A' AND rd.rdEstado='A' AND d.deEstado='A' AND a.apEstado LIKE 'A' and rm.roIdRol = r and rm.meIdOpcion = m and m.apIdAplicacion=a and rm.rmEstado like 'A' and m.meEstado like 'A' and a.apVisible = 1 order by a.apNombre "),
})


public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String OBTENER_APLICACION_POR_USUSUARIO = "Aplicacion.OBTENER_APLICACION_POR_USUSUARIO";
    
    public static final String OBTENER_APLICACION_POR_USUARIO_Y_VISIBLES_EN_PANTALLA = "Aplicacion.OBTENER_APLICACION_POR_USUARIO_Y_VISIBLES_EN_PANTALLA";

    @Id
    @Basic(optional = false)
    @Column(name = "ap_id_aplicacion")
    @SequenceGenerator(name = "seguridad.seg_aplicaciones_tbl_seq", schema = "seguridad", sequenceName = "seguridad.seg_aplicaciones_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seguridad.seg_aplicaciones_tbl_seq")
    @Getter
    @Setter
    private Integer apIdAplicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ap_nombre")
    @Getter
    @Setter
    private String apNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ap_descripcion")
    @Getter
    @Setter
    private String apDescripcion;
    @Lob
    @Column(name = "ap_imagen")
    @Getter
    @Setter
    private byte[] apImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ap_url")
    @Getter
    @Setter
    private String apUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ap_tipo")
    @Getter
    @Setter
    private String apTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ap_estado")
    @Getter
    @Setter
    private String apEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ca_id_categoria")
    @Getter
    @Setter
    private int caIdCategoria;
    @Size(max = 5)
    @Column(name = "ap_ext_img")
    @Getter
    @Setter
    private String apExtImg;
    @Size(max = 10)
    @Column(name = "ap_cod_aplicacion")
    @Getter
    @Setter
    private String apCodAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ap_visible")
    @Getter
    @Setter
    private int apVisible;
    @Size(max = 50)
    @Column(name = "ap_nom_img")
    @Getter
    @Setter
    private String apNomImg;
    @Size(max = 500)
    @Column(name = "ap_des_cont")
    @Getter
    @Setter
    private String apDesCont;
    @JoinColumn(name = "de_id_dependencia", referencedColumnName = "de_id_dependencia")
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Dependencias deIdDependencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apIdAplicacion")
    @Getter
    @Setter
    private List<Menu> segMenuTblList;
    @Transient
    @Getter
    @Setter
    private String usuario;
    @Transient
    @Getter
    @Setter
    private String idUsuario;
    @Transient
    @Getter
    @Setter
    private String codUnme;
    @Transient
    @Getter
    @Setter
    private String numeroDocumento;
    @Transient
    @Getter
    @Setter
    private String ipUsuario;
    @Transient
    @Getter
    @Setter
    private String nombrePersona;

    public Aplicacion() {
    }

}

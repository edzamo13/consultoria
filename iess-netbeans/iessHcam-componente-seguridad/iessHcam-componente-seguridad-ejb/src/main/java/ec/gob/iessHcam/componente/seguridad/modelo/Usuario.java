/*
* Copyright 2016 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
* Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "seg_usuarios_tbl",schema = "seguridad")
@NamedQueries({
    @NamedQuery(name = Usuario.OBTENER_POR_USUSUARIO, query = "SELECT u FROM Usuario u WHERE u.usUsuario = :nombreUsuario and u.catEstado = 1"),})
public class Usuario implements Serializable {

    public static final String OBTENER_POR_USUSUARIO = "Usuario.OBTENER_POR_USUSUARIO";

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "us_id_usuario")
    @SequenceGenerator(name = "seguridad.seg_usuarios_tbl_seq", schema = "seguridad", sequenceName = "seguridad.seg_usuarios_tbl_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seguridad.seg_usuarios_tbl_seq")
    @Getter
    @Setter
    private Integer usIdUsuario;
    @Size(max = 20)
    @Column(name = "us_usuario")
    @Getter
    @Setter
    private String usUsuario;
    @Size(max = 20)
    @Column(name = "us_cod_unme")
    @Getter
    @Setter
    private String usCodUnme;
    @Size(max = 100)
    @Column(name = "us_nombre_persona")
    @Getter
    @Setter
    private String usNombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "us_num_documento")
    @Getter
    @Setter
    private String usNumDocumento;
    @Size(max = 550)
    @Column(name = "us_clave")
    @Getter
    @Setter
    private String usClave;
    @Size(max = 550)
    @Column(name = "us_clave_anterior")
    @Getter
    @Setter
    private String usClaveAnterior;
    @Column(name = "us_clave_mig")
    @Getter
    @Setter
    private Integer usClaveMig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_funcionario")
    @Getter
    @Setter
    private int usFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_fec_caducidad")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date usFecCaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_fec_creacion")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date usFecCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_id_usuario_creacion")
    @Getter
    @Setter
    private int usIdUsuarioCreacion;
    @Column(name = "us_id_usuario_act")
    @Getter
    @Setter
    private Integer usIdUsuarioAct;
    @Column(name = "us_fec_actualizacion")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date usFecActualizacion;
    @Size(max = 3)
    @Column(name = "us_es_bloqueo")
    @Getter
    @Setter
    private String usEsBloqueo;
    @Lob
    @Column(name = "us_foto")
    @Getter
    @Setter
    private byte[] usFoto;
    @Size(max = 260)
    @Column(name = "us_correo")
    @Getter
    @Setter
    private String usCorreo;
    @Column(name = "cat_estado")
    @Getter
    @Setter
    private Integer catEstado;
    @Size(max = 20)
    @Column(name = "us_telefono")
    @Getter
    @Setter
    private String usTelefono;
    @Column(name = "ca_id_categoria")
    @Getter
    @Setter
    private Integer caIdCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usIdUsuario")
    @Getter
    @Setter
    private List<Usuarioshist> segUsuarioshistTblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usIdUsuario")
    @Getter
    @Setter
    private List<Rolxusuario> segRolxusuarioTblList;

    @OneToMany(mappedBy = "usIdUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private List<Intentos> intentosList;
    
    public Usuario() {
    }

}

package ec.com.vitalgym.modelo;

import java.io.Serializable;

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

/**
 * The persistent class for the rh_glb_permisos_opciones_menu_perfil database
 * table.
 * 
 */
@Entity
@Table(name = "rh_glb_permisos_opciones_menu_perfil", schema = "vitalgym")
@NamedQueries({
		@NamedQuery(name = RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL, query = "SELECT op FROM RhGlbPermisosOpcionesMenuPerfil op where op.rhGlbPerfile.pefCodigo = :codigoPerfil and op.rhGlbOpcionesMenu.opcEstado=true ORDER BY op.rhGlbOpcionesMenu.opcCodigo "),
		@NamedQuery(name = RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL_SUBMENU, query = "SELECT op FROM RhGlbPermisosOpcionesMenuPerfil op where op.rhGlbPerfile.pefCodigo = :codigoPerfil and (op.rhGlbOpcionesMenu.opcCodigo > :codigo) and (op.rhGlbOpcionesMenu.opcCodigo < :codigo2) and op.rhGlbOpcionesMenu.opcEstado=true ORDER BY op.rhGlbOpcionesMenu.opcCodigo "),
		@NamedQuery(name = RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_PERFIL, query = "SELECT prm FROM RhGlbPermisosOpcionesMenuPerfil prm where prm.rhGlbPerfile = :rhGlbPerfil AND prm.rhGlbOpcionesMenu.opcEstado=true ORDER BY prm.rhGlbOpcionesMenu.opcCodigo ") })

public class RhGlbPermisosOpcionesMenuPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL = "RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL";
	public static final String OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL_SUBMENU = "RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_CODIGO_PERFIL_SUBMENU";
	public static final String OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_PERFIL = " RhGlbPermisosOpcionesMenuPerfil.OBTENER_PERMISOS_OPCIONES_MENU_PERTIL_POR_PERFIL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq")
	@SequenceGenerator(name = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq", sequenceName = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "pem_codigo")
	private Integer pemCodigo;

	@Column(name = "pem_estado_registro")
	private Boolean pemEstadoRegistro;

	@Column(name = "pem_usu_registro")
	private String pemUsuRegistro;

	// bi-directional many-to-one association to RhGlbOpcionesMenu
	@ManyToOne
	@JoinColumn(name = "opc_codigo")
	private RhGlbOpcionesMenu rhGlbOpcionesMenu;

	// bi-directional many-to-one association to RhGlbPerfile
	@ManyToOne
	@JoinColumn(name = "pef_codigo")
	private RhGlbPerfil rhGlbPerfile;

	// bi-directional many-to-one association to RhGlbPermiso
	@ManyToOne
	@JoinColumn(name = "per_codigo")
	private RhGlbPermiso rhGlbPermiso;

	public RhGlbPermisosOpcionesMenuPerfil() {
	}

	public Integer getPemCodigo() {
		return this.pemCodigo;
	}

	public void setPemCodigo(Integer pemCodigo) {
		this.pemCodigo = pemCodigo;
	}

	public Boolean getPemEstRegistro() {
		return this.pemEstadoRegistro;
	}

	public void setPemEstRegistro(Boolean pemEstRegistro) {
		this.pemEstadoRegistro = pemEstRegistro;
	}

	public String getPemUsuRegistro() {
		return this.pemUsuRegistro;
	}

	public void setPemUsuRegistro(String pemUsuRegistro) {
		this.pemUsuRegistro = pemUsuRegistro;
	}

	public RhGlbOpcionesMenu getRhGlbOpcionesMenu() {
		return this.rhGlbOpcionesMenu;
	}

	public void setRhGlbOpcionesMenu(RhGlbOpcionesMenu rhGlbOpcionesMenu) {
		this.rhGlbOpcionesMenu = rhGlbOpcionesMenu;
	}

	public RhGlbPerfil getRhGlbPerfile() {
		return this.rhGlbPerfile;
	}

	public void setRhGlbPerfile(RhGlbPerfil rhGlbPerfile) {
		this.rhGlbPerfile = rhGlbPerfile;
	}

	public RhGlbPermiso getRhGlbPermiso() {
		return this.rhGlbPermiso;
	}

	public void setRhGlbPermiso(RhGlbPermiso rhGlbPermiso) {
		this.rhGlbPermiso = rhGlbPermiso;
	}

}
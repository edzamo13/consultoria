package ec.com.vitalgym.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the rh_glb_opciones_menu database table.
 * 
 */
@Entity
@Table(name = "rh_glb_opciones_menu", schema = "vitalgym")
@NamedQueries({ @NamedQuery(name = RhGlbOpcionesMenu.OBTENER_OPCIONES_MENU_TODO, query = "SELECT r FROM RhGlbOpcionesMenu r where r.opcEstado=true ORDER BY r.opcCodigo "),
		@NamedQuery(name = RhGlbOpcionesMenu.OBTENER_OPCIONES_MENU_SUB_MENU, query = "SELECT r FROM  RhGlbOpcionesMenu r where (r.opcCodigo > :codigo) and (r.opcCodigo < :codigo2) and r.opcEstado = true order by r.opcCodigo"),

})
public class RhGlbOpcionesMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String OBTENER_OPCIONES_MENU_TODO = "RhGlbOpcionesMenu.OBTENER_OPCIONES_MENU_TODO";
	public static final String OBTENER_OPCIONES_MENU_SUB_MENU = "RhGlbOpcionesMenu.OBTENER_OPCIONES_MENU_SUB_MENU";

	@Id
	@Column(name = "opc_codigo")
	@Getter
	@Setter
	private Integer opcCodigo;

	@Column(name = "opc_id")
	@Getter
	@Setter
	private Integer opcId;

	@Column(name = "opc_nombre")
	@Getter
	@Setter
	private String opcNombre;

	@Column(name = "opc_url")
	@Getter
	@Setter
	private String opcUrl;

	@Column(name = "opc_estado") 
	@Getter
	@Setter
	private Boolean opcEstado;

	// bi-directional many-to-one association to RhGlbPermisosOpcionesMenuPerfil
	@OneToMany(mappedBy = "rhGlbOpcionesMenu")
	private List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils;

	public RhGlbOpcionesMenu() {
	}

	public RhGlbOpcionesMenu(Integer opcCodigo, Integer opcId, String opcNombre, String opcUrl, Boolean opcEstado, List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils) {
		super();
		this.opcCodigo = opcCodigo;
		this.opcId = opcId;
		this.opcNombre = opcNombre;
		this.opcUrl = opcUrl;
		this.opcEstado = opcEstado;
		this.rhGlbPermisosOpcionesMenuPerfils = rhGlbPermisosOpcionesMenuPerfils;
	}

	@Override
	public String toString() {
		return "RhGlbOpcionesMenu [opcNombre=" + opcNombre + "]";
	}

}
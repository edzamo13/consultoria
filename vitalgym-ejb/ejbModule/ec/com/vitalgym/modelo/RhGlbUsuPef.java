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
 * The persistent class for the rh_glb_usu_pef database table.
 * 
 */
@Entity
@Table(name="rh_glb_usu_pef", schema="vitalgym")
@NamedQueries({
    @NamedQuery(name = RhGlbUsuPef.OBTENER_USUARIO_PERFIL_POR_USUARIO, query = "select p  from RhGlbUsuPef p where p.rhGlbUsuario = :usuario"),
    @NamedQuery(name = RhGlbUsuPef.OBTENER_USUARIO_PERFIL_POR_USUARIO_USUARIOPERFIL, query = "Select p from RhGlbUsuPef p where p.rhGlbUsuario = :usuario")
})
public class RhGlbUsuPef implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    public static final String OBTENER_USUARIO_PERFIL_POR_USUARIO = "RhGlbUsuPef.OBTENER_USUARIO_PERFIL_POR_USUARIO";
	    public static final String OBTENER_USUARIO_PERFIL_POR_USUARIO_USUARIOPERFIL = " RhGlbUsuPef.OBTENER_USUARIO_PERFIL_POR_USUARIO_USUARIOPERFIL";
	   

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_glb_usu_pef_seq")
	@SequenceGenerator(name = "modulos.rh_glb_usu_pef_seq", sequenceName = "modulos.rh_glb_usu_pef_seq", initialValue = 1, allocationSize = 1)
	@Column(name="usp_id")
	private Integer uspId;

	//bi-directional many-to-one association to RhGlbPerfile
	@ManyToOne
	@JoinColumn(name="pef_codigo")
	private RhGlbPerfil rhGlbPerfile;

	//bi-directional many-to-one association to RhGlbUsuario
	@ManyToOne
	@JoinColumn(name="usu_codigo")
	private RhGlbUsuario rhGlbUsuario;

	public RhGlbUsuPef() {
	}

	public Integer getUspId() {
		return this.uspId;
	}

	public void setUspId(Integer uspId) {
		this.uspId = uspId;
	}

	public RhGlbPerfil getRhGlbPerfile() {
		return this.rhGlbPerfile;
	}

	public void setRhGlbPerfile(RhGlbPerfil rhGlbPerfile) {
		this.rhGlbPerfile = rhGlbPerfile;
	}

	public RhGlbUsuario getRhGlbUsuario() {
		return this.rhGlbUsuario;
	}

	public void setRhGlbUsuario(RhGlbUsuario rhGlbUsuario) {
		this.rhGlbUsuario = rhGlbUsuario;
	}

}
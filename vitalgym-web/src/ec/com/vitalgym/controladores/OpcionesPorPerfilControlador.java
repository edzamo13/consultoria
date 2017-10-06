package ec.com.vitalgym.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import ec.com.vitalgym.local.RhGlbPermisosOpcionesMenuPerfilLocal;
import ec.com.vitalgym.modelo.RhGlbPermisosOpcionesMenuPerfil;

@Named
public class OpcionesPorPerfilControlador {
	private List<RhGlbPermisosOpcionesMenuPerfil> opciones;

	@EJB
	private RhGlbPermisosOpcionesMenuPerfilLocal opcionesServicio;

	public OpcionesPorPerfilControlador() {
	}

	@PostConstruct
	public void init() {
		// TODO: Ahorita se muestran tooooodas las opciones hay que jalar solo
		// por el perfil
		opciones = opcionesServicio.getAll();
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getOpciones() {
		return opciones;
	}

}
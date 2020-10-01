package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface RhGlbPermisosOpcionesMenuPerfilLocal extends
		GenericoDAO<RhGlbPermisosOpcionesMenuPerfil, Integer> {
	public List<RhGlbPermisosOpcionesMenuPerfil> getAll(int codigoPerfil);

	public List<RhGlbPermisosOpcionesMenuPerfil> getSubMenu(int codigoPerfil,
			int codigoNodo, int span);

	public List<RhGlbPermisosOpcionesMenuPerfil> buscarXPerfil(
			RhGlbPerfil rhGlbPerfil);

}

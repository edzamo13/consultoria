package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhGlbUsuario;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface RhGlbUsuarioLocal extends GenericoDAO<RhGlbUsuario, Integer> {
	public RhGlbUsuario  buscarUsuario(String usuario);

	public List<RhGlbUsuario> buscarUsuarioOrdenadoxId();

}

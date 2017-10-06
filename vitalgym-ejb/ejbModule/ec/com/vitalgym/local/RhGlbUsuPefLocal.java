package ec.com.vitalgym.local;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.modelo.RhGlbUsuPef;
import ec.com.vitalgym.modelo.RhGlbUsuario;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface RhGlbUsuPefLocal extends GenericoDAO<RhGlbUsuPef, Integer> {

	public RhGlbPerfil buscarPerfilxUsuario(RhGlbUsuario usuario);

	public RhGlbUsuPef buscarUsuPef(RhGlbUsuario usuario);

}

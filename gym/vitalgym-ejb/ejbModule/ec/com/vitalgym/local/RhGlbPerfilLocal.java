package ec.com.vitalgym.local;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhGlbPerfil;
import ec.com.vitalgym.util.GenericoDAO;


@Local
public interface RhGlbPerfilLocal extends GenericoDAO<RhGlbPerfil, Integer>{

}

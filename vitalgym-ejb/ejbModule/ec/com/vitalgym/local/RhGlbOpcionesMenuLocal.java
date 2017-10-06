package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhGlbOpcionesMenu;
import ec.com.vitalgym.util.GenericoDAO;


@Local
public interface RhGlbOpcionesMenuLocal extends GenericoDAO<RhGlbOpcionesMenu, Integer>{
	public List<RhGlbOpcionesMenu> getSubMenu(int codigoNodo, int span);
	
	public List<RhGlbOpcionesMenu> buscarMenuFaltate(Integer codPerfil  );

}

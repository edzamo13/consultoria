package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.SysCatalogo;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface SysCatalogoLocal extends GenericoDAO<SysCatalogo, Integer> {
	
	public List<SysCatalogo> getAll();

}

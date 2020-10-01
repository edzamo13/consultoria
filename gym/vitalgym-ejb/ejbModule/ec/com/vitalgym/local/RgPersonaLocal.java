package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface RgPersonaLocal extends GenericoDAO<RgPersona, Integer> {
	
	public List<RgPersona> getAll();
	
	public List<RgPersona> obtenerTodoActivo();

}

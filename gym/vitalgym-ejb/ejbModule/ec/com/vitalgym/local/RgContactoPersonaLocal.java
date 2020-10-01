package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RgContactoPersona;
import ec.com.vitalgym.modelo.RgPersona;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface RgContactoPersonaLocal extends GenericoDAO<RgContactoPersona, Integer> {

	public List<RgContactoPersona> obtenerContactoPersonasPorIdPersona(RgPersona rgPersona);
	

}

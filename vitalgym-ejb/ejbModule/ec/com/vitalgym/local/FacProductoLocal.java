package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.FacProducto;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface FacProductoLocal extends GenericoDAO<FacProducto, Integer> {

	public List<FacProducto> obtenerProductosActivos();					
	

}

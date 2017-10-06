package ec.com.vitalgym.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.FacProveedor;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface FacProveedorLocal extends GenericoDAO<FacProveedor, Integer> {

	public List<FacProveedor> obtenerProveedoresActivos();					
	

}

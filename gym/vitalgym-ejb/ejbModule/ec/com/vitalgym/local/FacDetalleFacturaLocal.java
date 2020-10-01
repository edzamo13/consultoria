package ec.com.vitalgym.local;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.FacDetalleFactura;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface FacDetalleFacturaLocal extends GenericoDAO<FacDetalleFactura, Integer> {

						
	

}

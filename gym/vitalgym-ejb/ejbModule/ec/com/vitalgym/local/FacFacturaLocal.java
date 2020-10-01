package ec.com.vitalgym.local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.FacFactura;
import ec.com.vitalgym.util.GenericoDAO;

@Local
public interface FacFacturaLocal extends GenericoDAO<FacFactura, Integer> {


	public List<FacFactura> obtenerFacturasActivasFechaInicioFin(Date inicio, Date Fin);	
	

}

package ec.com.vitalgym.local;

import javax.ejb.Local;

import ec.com.vitalgym.modelo.RhParametroSistema;
import ec.com.vitalgym.util.GenericoDAO;


@Local
public interface RhParametroSistemaLocal extends GenericoDAO<RhParametroSistema, Integer>{
	

}

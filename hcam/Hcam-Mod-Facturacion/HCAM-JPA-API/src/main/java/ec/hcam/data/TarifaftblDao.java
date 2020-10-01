package ec.hcam.data;

import ec.hcam.entity.Tarifaftbl;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;



@Stateless
public class TarifaftblDao extends GenericDaoImpl<Tarifaftbl, Serializable> {
        
    private List<Tarifaftbl> listita;

    public List<Tarifaftbl> getListita() {
        return listita;
    }

    public void setListita(List<Tarifaftbl> listita) {
        this.listita = listita;
    }
	public TarifaftblDao(){
		super(Tarifaftbl.class);
	}
	public Tarifaftbl buscarTarifario(){
		Query query = em.createQuery("Select u from Tarifaftbl u");
			//query.setParameter("idusuario", idusuario);
		return (Tarifaftbl) query.getSingleResult();
	}
    
        public List<Tarifaftbl> buscarTodosLosTarifarios(){
           // List<Tarifaftbl> listalarga=null;
		Query query = em.createQuery("Select u from Tarifaftbl u");
			//query.setParameter("idusuario", idusuario);
		return listita=query.getResultList();
                
       }
        
}

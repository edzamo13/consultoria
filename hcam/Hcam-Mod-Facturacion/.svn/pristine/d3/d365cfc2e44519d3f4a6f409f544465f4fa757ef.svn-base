/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Cabplantbl;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author programacion
 */
@Stateless
public class CabplantblFacade extends AbstractFacade<Cabplantbl> implements ec.hcam.CabplantblFacadeRemote {
    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CabplantblFacade() {
        super(Cabplantbl.class);
    }
    
    @Override
    public Cabplantbl findByMesDia(Integer mes, Integer dia,Integer ano,Integer unimedpk) {
        try {
        TypedQuery<Cabplantbl> query = em.createNamedQuery("Cabplantbl.findByMesDia", Cabplantbl.class);
        query.setParameter("mesplanilla", mes);
        query.setParameter("diaplanilla", dia);
        query.setParameter("anoplanilla", ano);
        query.setParameter("unimedpk", unimedpk);
        

        Cabplantbl encontroEntidad = null;
        List<Cabplantbl> listCabplantbl = query.getResultList();
        if(!listCabplantbl.isEmpty()){
        // ignores multiple results
        encontroEntidad = listCabplantbl.get(0);
        return encontroEntidad;
        }
        return encontroEntidad;
        
           // Cabplantbl cabplantbl = query.getSingleResult();
           // return cabplantbl;
        } catch (javax.persistence.NoResultException nre) {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Deunitbl;
import ec.hcam.entities.Deunitbl_;
import ec.hcam.entities.Serviciotbl;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Programacion
 */
@Stateless
public class DeunitblFacade extends AbstractFacade<Deunitbl> implements hcam.jpa.DeunitblFacadeRemote {
    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeunitblFacade() {
        super(Deunitbl.class);
    }
    
    //@Override
//    public List<Deunitbl> findAllDependenciasWithUnidMedicaID(int idUnidadMedica) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Deunitbl> criteria = cb.createQuery(Deunitbl.class);
//        Root<Deunitbl> dependenciaRoot = criteria.from(Deunitbl.class);
//        criteria.select(dependenciaRoot);
//        criteria.where(cb.equal(dependenciaRoot.get(Deunitbl_.depunpk), idUnidadMedica));
//        List<Deunitbl> dependencias = em.createQuery(criteria).getResultList();
//
//        return dependencias;
//    }
    
}

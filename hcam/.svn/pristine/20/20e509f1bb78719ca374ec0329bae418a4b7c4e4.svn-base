
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import hcam.entity.Serviciotbl;
import ec.hcam.entities.Serviciotbl_;
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
public class ServiciotblFacade extends AbstractFacade<Serviciotbl> implements hcam.jpa.ServiciotblFacadeRemote {

    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciotblFacade() {
        super(Serviciotbl.class);
    }

//    @Override
//    public List<Serviciotbl> findAllServicesWithDependenciaID(int idUnidadMedica) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Serviciotbl> criteria = cb.createQuery(Serviciotbl.class);
//        Root<Serviciotbl> servicioRoot = criteria.from(Serviciotbl.class);
//        criteria.select(servicioRoot);
//        criteria.where(cb.equal(servicioRoot.get(Serviciotbl_.seunmedfk), idUnidadMedica));
//        List<Serviciotbl> servicios = em.createQuery(criteria).getResultList();
//
//        return servicios;
//    }

}

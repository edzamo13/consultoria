/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Areatbl;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Programacion
 */
@Stateless
public class AreatblFacade extends AbstractFacade<Areatbl> implements AreatblFacadeRemote {

    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreatblFacade() {
        super(Areatbl.class);
    }

//    @Override
//    public List<Areatbl> findAll() {
//        TypedQuery<Areatbl> query
//                = em.createQuery("select a FROM Areatbl a", Areatbl.class);
//        List<Areatbl> results = query.getResultList();
//        return results;
//    }
}

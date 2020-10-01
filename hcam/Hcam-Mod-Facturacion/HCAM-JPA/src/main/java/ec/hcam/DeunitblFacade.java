/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Deunitbl;
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
public class DeunitblFacade extends AbstractFacade<Deunitbl> implements ec.hcam.DeunitblFacadeRemote {

    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeunitblFacade() {
        super(Deunitbl.class);
    }

    @Override
    public Deunitbl findNameByCodeDependency(String Dedepend) {
        TypedQuery<Deunitbl> query = em.createNamedQuery("Deunitbl.findByDedepend", Deunitbl.class);
        query.setParameter("dedepend", Dedepend);
        try {
            List<Deunitbl> listDeunitbl = query.getResultList();
            if (listDeunitbl != null && !listDeunitbl.isEmpty()) {
                return listDeunitbl.get(0);
            } else {
                return null;
            }
        } catch (javax.persistence.NoResultException nre) {
            return null;
        }
    }

}

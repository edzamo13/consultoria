/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam;

import ec.hcam.entity.Servtbl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programacion
 */
@Stateless
public class ServtblFacade extends AbstractFacade<Servtbl> implements ec.hcam.ServtblFacadeRemote {
    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServtblFacade() {
        super(Servtbl.class);
    }
    
}

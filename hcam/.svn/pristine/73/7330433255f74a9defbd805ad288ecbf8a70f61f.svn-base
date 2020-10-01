/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcam.jpa;

import ec.hcam.entities1.Irsi02;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jochoa
 */
@Stateless
public class Irsi02Facade extends AbstractFacade<Irsi02> implements ec.hcam.jpa.Irsi02FacadeRemote {
    @PersistenceContext(unitName = "hcam_HCAM-JPA_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Irsi02Facade() {
        super(Irsi02.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.crud.dao.impl;

import ec.gob.cne.ws.crud.CrudImpl;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import lombok.Getter;

/**
 *
 * @author ezamora
 */
@PersistenceContexts({
    @PersistenceContext(name = DaoImpl.GESTION_PRESIDENTES_PU, unitName = DaoImpl.GESTION_PRESIDENTES_PU)})
public class DaoImpl<T> {

    public static final String GESTION_PRESIDENTES_PU = "gestion_presidentes_ws_PU";

    @Resource
    @Getter
    private EJBContext ejbContext;

    private final CrudImpl<T> dao;

    public DaoImpl() {
        dao = new CrudImpl<>();
    }

    public DaoImpl(Class<T> entidad) {
        dao = new CrudImpl();
        dao.setEntity(entidad);
    }

    public CrudImpl<T> getDao() {

        EntityManager em = (EntityManager) ejbContext.lookup(GESTION_PRESIDENTES_PU);
        dao.setEntityManager(em);
        return dao;
    }
    
     public CrudImpl<T> getDao(String unidadPersistencia) {
        EntityManager em = (EntityManager) ejbContext.lookup(unidadPersistencia);
        dao.setEntityManager(em);
        return dao;
    }

}

/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.seguridad.dao.impl;
 
import ec.gob.iessHcam.componente.comun.crud.GenericoDao;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import lombok.Getter;

/**
 * <b> Clase generica para gestionar las operaciones de base. </b>
 *
 * @author jpatino
 * @version $Revision: 1.0 $
 * <p>
 * [$Author: jpatino $, $Date: 18/8/2015 $]
 * </p>
 * @param <T>
 */
@PersistenceContexts({
    @PersistenceContext(name = DaoImpl.DEFAULT_PU, unitName = DaoImpl.DEFAULT_PU)
})
public class DaoImpl<T> {

    public static final String DEFAULT_PU = "ap-componente-seguridad-postgres-PU";

    @Resource
    @Getter
    private EJBContext ejbContext;

    private final GenericoDao<T> dao;

    /**
     * <b>Constructor de la clase. </b>
     * <p>
     * [Author: jpatino, Date: 18/8/2015]
     * </p>
     */
    public DaoImpl() {
        dao = new GenericoDao();
    }

    /**
     *
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: jpatino, Date: 18/8/2015]
     * </p>
     *
     * @param entidad Entidad
     */
    public DaoImpl(Class<T> entidad) {
        dao = new GenericoDao();
        dao.setEntity(entidad);
    }

    /**
     * <b> Metodo para obtener el dao para gestionar las operaciones contra la
     * base utilizando el PU principal. </b>
     * <p>
     * [Author: jpatino, Date: 18/8/2015]
     * </p>
     *
     * @return genericoDao
     */
    public GenericoDao<T> getDao() {

        EntityManager em = (EntityManager) ejbContext.lookup(DEFAULT_PU);
        dao.setEntityManager(em);
        return dao;
    }

    /**
     * <b> Metodo para obtener la el dao para interactuar con una unidad de
     * persistencia especifica. </b>
     * <p>
     * [Author: jpatino, Date: 18/8/2015]
     * </p>
     *
     * @param unidadPersistencia a colocar en caso requerir para otro esquema de
     * base
     * @return genericoDao
     */
    public GenericoDao<T> getDao(String unidadPersistencia) {
        EntityManager em = (EntityManager) ejbContext.lookup(unidadPersistencia);
        dao.setEntityManager(em);
        return dao;
    }

}

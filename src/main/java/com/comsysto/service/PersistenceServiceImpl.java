package com.comsysto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sekibomazic
 */
@Service
public class PersistenceServiceImpl implements PersistenceService {

    /**
     * Entity manager, injected by Spring using @PersistenceContext
     * annotation on setEntityManager() or entityManager field
     */
    @PersistenceContext //(unitName=PERSISTENCE_UNIT_NAME)
    protected EntityManager entityManager;

    @PersistenceUnit
    protected EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public <T> T create(T t) {
        this.getEntityManager().persist(t);
        return t;
        // return this.save(t);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public <T, PK extends Serializable> T retrieve(Class<T> type, PK id) {
        T entity = this.getEntityManager().find(type, id);

        if (entity == null) {
            String msg = type.getName() + " object with id '" + id + "' not found...";
            throw new EntityNotFoundException(msg);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public <T> T update(T t) {
        return this.save(t);
    }

    private <T> T save(T object) {
        return this.getEntityManager().merge(object);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public <T, PK extends Serializable> void delete(Class<T> type, PK id) {
        this.getEntityManager().remove(this.retrieve(type, id));
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    public <T, PK extends Serializable> boolean exists(Class<T> type, PK id) {
        T entity = this.getEntityManager().find(type, id);
        return entity != null;
    }

    @Transactional(readOnly = true)
    public <T> List<T> findAll(Class<T> type) {
        TypedQuery<T> typedQuery = entityManager.createQuery("select obj from " + type.getName() + " obj", type);
        return typedQuery.getResultList();
    }


    @Transactional(readOnly = true)
    public <T> List<T> findByNamedQuery(String queryName, Class<T> type) {
        TypedQuery<T> typedQuery = getEntityManager().createNamedQuery(queryName, type);
        return typedQuery.getResultList();
    }

}
package com.comsysto.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author sekibomazic
 */
public interface PersistenceService {

    // CRUD methods
    public <T> T create(T t);
    public <T, PK extends Serializable> T retrieve(Class<T> type, PK id);
    public <T> T update(T t);
    public <T, PK extends Serializable> void delete(Class<T> type, PK id);

    public <T, PK extends Serializable> boolean exists(Class<T> type, PK id);
    public <T> List<T> findAll(Class<T> type);

    // test for not serializable objects
    //public <T, D> List<D> findAllDTO(Class<T> type);

    /**
     *
     * @param queryName
     * @return
     */
    public <T> List<T> findByNamedQuery(String queryName, Class<T> type);

}
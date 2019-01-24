package com.eventui.customer.tracking.club.customertrackerclub.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractHibernateDao< T extends Serializable> {

    private Class< T> clazz;
    
    @PersistenceContext
    private EntityManager entityManager;
  
    public void setClazz(Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(int id) {
        return (T) entityManager.find(clazz, id);
    }

    public List< T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public T loadByQuery(String username) {
        List<T> entities = entityManager
                .createQuery("from User where username=?1")
                .setParameter(1, username)
                .getResultList();

        if (entities.size() > 0) {
            return entities.get(0);
        } else {
            return null;
        }

    }
}

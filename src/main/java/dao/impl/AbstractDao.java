package dao.impl;

import dao.Dao;
import dao.exceptions.DaoException;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class AbstractDao<K, E> implements Dao<K, E> {

    protected Class<E> entityClass;


    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AbstractDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    @PostConstruct
    private void createEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pl.wipek.database");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @PreDestroy
    private void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }


    @Override
    public E persist(E entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    }


    @Override
    public E merge(E entity)
    {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param id of entity
     * @throws NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean remove(K id) throws NotFoundException, DaoException {
        E entity = this.findById(id);
        if (entity != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(entity);
                getEntityManager().flush();
                getEntityManager().clear();
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                getEntityManager().getTransaction().rollback();
                throw new DaoException(e);
            }
            return true;
        } else {
            throw new NotFoundException("Can not remove object which doesn't exists");
        }
    }

    /**
     * Deletes the entity.
     *
     * @param id entity
     * @throws NotFoundException if the entity does not exist in database.
     */
    @Override
    public E findById(K id) throws NotFoundException {
        E entity = getEntityManager().find(entityClass, id);
        if (entity != null) {
            return entity;
        }
        throw new NotFoundException("Can not find object with id");
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    @Override
    public Set<E> getAll() {
//        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
//        criteriaQuery.from(entityClass);
        Query query = getEntityManager().createQuery("from " + entityClass.getCanonicalName() + " e", entityClass);
        List<E> res = query.getResultList();
        return new HashSet<>(res);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

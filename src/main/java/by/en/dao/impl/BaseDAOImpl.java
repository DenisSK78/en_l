package by.en.dao.impl;

import by.en.dao.BaseDao;
import by.en.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public abstract class BaseDAOImpl<E extends BaseEntity> implements BaseDao<E> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDAOImpl() {
        this.entityClass = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDAOImpl.class);
    }

    @Override
    public List<E> findAll() {
        return getSession().createQuery("select e from "
                + entityClass.getSimpleName()
                + " e", entityClass)
                .getResultList();
    }

    @Override
    public E getById(Long id) {
        return getSession().find(entityClass, id);
    }

    @Override
    public void save(E entity) {
        getSession().save(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    Session getSession(){return sessionFactory.getCurrentSession();}
}

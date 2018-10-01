package by.en.dao.base;

import by.en.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

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
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<E> eList = session.createQuery("select e from "
                + entityClass.getSimpleName()
                + " e", entityClass)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return eList;
    }

    @Override
    public E getById(Long id) {
        E entity;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        entity = session.find(entityClass, id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public void save(E entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(E entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(E entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit( );
        session.close();
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

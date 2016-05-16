package dataaccess;

import bean.IEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public abstract class Manager<T extends IEntity> {

    abstract Class<T> getEntityClass();

    abstract Criteria createFindQuery(Criteria criteria, T entity);

    public void create(T entity) {
        Session session = DataBaseManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }


    public void delete(int id) {

        Session session = DataBaseManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.get(getEntityClass(), id));
        transaction.commit();
        session.close();

    }

    public List<T> all() {

        Session session = DataBaseManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(getEntityClass());
        List<T> entities = criteria.list();
        session.close();
        return entities;


    }

    public List<T> all(T entity) {
        Session session = DataBaseManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria = createFindQuery(criteria, entity);
        List<T> entities = criteria.list();
        session.close();
        return entities;

    }

    public T findById(int id) {

            Session session = DataBaseManager.getSessionFactory().openSession();
            Class<? extends IEntity> a = getEntityClass();
            T entity = (T) session.get(getEntityClass(), id);
            session.close();
            return entity;
    }

    public void update(T entity) {
            Session session = DataBaseManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
    }
}

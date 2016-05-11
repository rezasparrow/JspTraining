package dataaccess;

import bean.RealCustomer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Dotin School1 on 5/11/2016.
 */
public abstract class Manager<T extends IEntity> {

    abstract Class<T> getEntityClass();

    public void create(T entity) {
        DataBaseManager dataBaseManager = new DataBaseManager();

        Session session = dataBaseManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }

    ;

    public void delete(int id) {
        DataBaseManager dataBaseManager = new DataBaseManager();

        Session session = dataBaseManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.get(getEntityClass(), id));
        transaction.commit();
        session.close();
    }

    public List<T> all() {
        DataBaseManager dataBaseManager = new DataBaseManager();
        Session session = dataBaseManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(RealCustomer.class);
        List<T> entities = criteria.list();
        session.close();
        return entities;
    }


    public T findById(int id) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        Session session = dataBaseManager.getSessionFactory().openSession();
        Class<? extends IEntity> a = getEntityClass();
        T entity = (T) session.get(getEntityClass(), id);
        session.close();
        return entity;
    }

    public void update(T entity) {
        try (DataBaseManager dataBaseManager = new DataBaseManager()) {


            Session session = dataBaseManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
        }
    }
}

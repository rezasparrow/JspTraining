package dataaccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Closeable;


public class DataBaseManager implements Closeable {

    private SessionFactory session;
    public DataBaseManager(){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        session = configuration
                .buildSessionFactory(builder.build());
    }

    public  SessionFactory getSessionFactory()  {

        return session;
    }


    public void close()  {
        session.close();
    }
}

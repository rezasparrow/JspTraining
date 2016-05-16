package dataaccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Closeable;


public class DataBaseManager implements Closeable {

    private static SessionFactory session;
    private DataBaseManager(){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        session = configuration
                .buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory()  {

        if(session == null || session.isClosed()){
            new DataBaseManager();
        }
        return session;
    }


    public void close()  {

    }
}

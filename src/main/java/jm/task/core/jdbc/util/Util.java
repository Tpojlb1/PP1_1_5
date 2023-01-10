package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;


public class Util {
private static final String URL = "jdbc:mysql://localhost:3306/username";
private static final String USER = "root";
private static final String PASSWORD = "root";
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
private static SessionFactory sessionFactory;

public static SessionFactory getSessionFactory() {

    if (sessionFactory == null) {

        try {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.URL, URL);
            properties.put(Environment.USER, USER);
            properties.put(Environment.PASS, PASSWORD);
            properties.put(Environment.DRIVER, DRIVER);
            properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(AvailableSettings.SHOW_SQL, "true");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.out.println("Check Util configuration!");
            e.printStackTrace();
        }

    }
    return sessionFactory;
}

}

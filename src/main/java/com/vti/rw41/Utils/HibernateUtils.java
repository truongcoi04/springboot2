package com.vti.rw41.Utils;


import com.vti.rw41.Entity.AccountEntity;
import com.vti.rw41.Entity.Department;
import com.vti.rw41.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(AccountEntity.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(registry);

    }
}



package com.yauhenav.logic.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionUtilProd {
    private static final SessionFactory sessionFactory;

    static {
        try {
			//sessionFactory = new Configuration().configure().buildSessionFactory();

            Configuration configuration = new Configuration();
            configuration = configuration.configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder = builder.applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

            //System.out.println(sessionFactory.toString());
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
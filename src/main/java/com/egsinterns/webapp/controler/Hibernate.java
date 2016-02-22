package com.egsinterns.webapp.controler;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by User on 2/21/2016.
 */
public class Hibernate {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package org.example.np.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError("Hibernate SessionFactory creation failed: " + ex);
        }
    }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }


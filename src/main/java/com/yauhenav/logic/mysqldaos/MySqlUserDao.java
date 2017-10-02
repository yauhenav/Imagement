package com.yauhenav.logic.mysqldaos;

import java.util.*;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

/**
 * Created by yauhenav on 1.10.17.
 */
public class MySqlUserDao {

    private SessionFactory factory;

    public MySqlUserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void create (User user) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldnt'roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlUserDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    public User readByUsername (User user) throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query<User> query = session.createQuery("from User u where u.username=:username", User.class);
            query.setParameter("username", user.getUsername());
            return query.uniqueResult();
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlUserDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }


}

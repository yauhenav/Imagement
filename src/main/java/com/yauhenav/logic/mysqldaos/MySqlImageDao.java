package com.yauhenav.logic.mysqldaos;

import java.util.*;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

/**
 * Created by yauhenav on 24.10.17.
 */
public class MySqlImageDao {

    private SessionFactory factory;

    public MySqlImageDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void create (Image image) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(image);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlImageDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    public Image readByImageByID (int imageID) throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query<Image> query = session.createQuery("from Image i where i.id=:id", Image.class);
            query.setParameter("id", imageID);
            return query.uniqueResult();
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqloImageDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }


}

package com.yauhenav;

import com.yauhenav.logic.exception.DaoException;
import com.yauhenav.logic.mysqldaos.*;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.yauhenav.logic.dto.*;

import javax.management.*;
import java.sql.*;
/**
 * Created by yauhenav on 8.8.17.
 */
public class TestsHandler {
    private MySqlUserDao testMSUD;
    private MySqlImageDao testMSID;

    SessionFactory factory = null;

    public TestsHandler() throws DaoException {
        this.factory = HibernateUtilTest.getSessionFactory();
        testMSUD = new MySqlUserDao(factory);
        testMSID = new MySqlImageDao(factory);
    }

    public MySqlUserDao getMySqlUserDaoInstance() {
        return testMSUD;
    }

    public MySqlImageDao getMySqlImageDaoInstance() {
        return testMSID;
    }



    public void populateDataBase() throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(new User (1,"Testusername1", "testmail1@tut.by", "Testpass@01"));
            session.save(new User (2,"Testusername2", "testmail2@tut.by", "Testpass@02"));
            session.save(new User (3,"Testusername3", "testmail3@tut.by", "Testpass@03"));
            session.save(new User (4,"Testusername4", "testmail4@tut.by", "Testpass@04"));
            session.save(new User (5, "Testusername5", "testmail5@tut.by", "Testpass@05"));
            session.save(new User (6, "Testusername6", "testmail6@tut.by", "Testpass@06"));

            session.save(new Image ("Testtitle1", "Testdescription1", 1, new byte[] {(byte)0xe0}));
            session.save(new Image ("Testtitle2", "Testdescription2", 1, new byte[] {(byte)0xe0}));
            session.save(new Image ("Testtitle3", "Testdescription3", 1, new byte[] {(byte)0xe0}));
            session.save(new Image ("Testtitle4", "Testdescription4", 1, new byte[] {(byte)0xe0}));
            session.save(new Image ("Testtitle5", "Testdescription5", 1, new byte[] {(byte)0xe0}));
            session.save(new Image ("Testtitle6", "Testdescription6", 1, new byte[] {(byte)0xe0}));


            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in TestHandler object", exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void emptyDataBase() throws SQLException, DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from User urs");
            query.executeUpdate();
            Query query1 = session.createQuery("delete from Image ims");
            query1.executeUpdate();

            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in TestHandler object", exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

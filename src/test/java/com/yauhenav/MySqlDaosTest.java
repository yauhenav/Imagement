package com.yauhenav;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import com.yauhenav.logic.service.SessionUtilProd;
import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.yauhenav.logic.exception.DaoException;

import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.mysqldaos.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by yauhenav on 29.10.17.
 */


public class MySqlDaosTest {

    private TestsHandler testsHandler;
    private MySqlUserDao testMSUD;
    private MySqlImageDao testMSID;


    @BeforeMethod
    public void fillDBWithTestData() throws SQLException, DaoException {
        try {
            testsHandler = new TestsHandler();
            testsHandler.populateUsersTable();
            testsHandler.populateImagesTable();
            testMSUD = testsHandler.getMySqlUserDaoInstance();
            testMSID = testsHandler.getMySqlImageDaoInstance();


        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @AfterMethod
    public void wipeDBTestData() throws SQLException, DaoException {
        try {
            testsHandler.emptyDataBase();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void dummyMethod () {
        System.out.println("Test run");
    }

    @Test
    public void TestReadAllUsersMethod() throws DaoException {
        List<User> lst = testMSUD.readAllUsers();
        Assert.assertEquals(lst.size(), 6);
    }

}

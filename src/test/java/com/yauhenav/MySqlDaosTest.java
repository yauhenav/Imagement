package com.yauhenav;

import java.io.*;
import java.util.*;

import com.yauhenav.logic.service.SessionUtilProd;
import org.hibernate.SessionFactory;
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
    private MySqlUserDao testMSUD;
    private MySqlImageDao testMSID;

/*
    @BeforeMethod
    public void createTestClasses() throws DaoException {
        SessionFactory factory = SessionUtilProd.getSessionFactory();
        testMSUD = new MySqlUserDao(factory);
        testMSID = new MySqlImageDao(factory);
    }

    @Test
    public void TestCreateImageMethod() throws DaoException {


        try {
            byte [] picture = null;
            FileInputStream inputSt = new FileInputStream("/home/yauhenav/Pictures/navitski.jpg");

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte buffer[] = new byte [1024];
            for (int length = 0; (length = inputSt.read(buffer))>0; ) {
                output.write(buffer, 0, length);
            }
            picture = output.toByteArray();


            Image testImage = new Image ("portrait", "me looking over horizons", 1, picture);

            testMSID.create(testImage);

        } catch (DaoException exc) {
            exc.printStackTrace();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }*/
}

package com.yauhenav.logic.service;

import java.util.*;

import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;
import com.yauhenav.logic.mysqldaos.*;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;

/**
 * Created by yauhenav on 9.10.17.
 */
public class Service {

    private MySqlUserDao msud = null;

    public Service() throws ServiceException {
        SessionFactory factory = SessionUtilProd.getSessionFactory();
        msud = new MySqlUserDao(factory);
    }

    public boolean checkIfUserExists (User user) throws ServiceException {
        try {
            return msud.checkIfUserExistsInDataBase(user);
        } catch (DaoException exc) {
            throw new ServiceException("Exception caught in Service object");
        }
    }

    public boolean checkIfUsersPasswordCorresponds (User user) throws ServiceException {
        try {
            return msud.validateIfExistingUsersPasswordIsCorrect(user);
        } catch (DaoException exc) {
            throw new ServiceException("Exception caught in Service object");
        }
    }

    public int assignIdToUser() {
        return msud.assignIdToNextUser();
    }

    public void createNewUser (User user) throws ServiceException {
        try {
            msud.create(user);
        } catch (DaoException exc) {
            throw new ServiceException ("Exception caught in Service object", exc);
        }
    }

}

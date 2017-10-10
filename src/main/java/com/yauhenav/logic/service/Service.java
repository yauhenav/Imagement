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
        try {
            SessionFactory factory = SessionUtilProd.getSessionFactory();
            msud = new MySqlUserDao(factory);

        }
    }
}

package com.yauhenav.logic.web;

import com.yauhenav.logic.exception.ServiceException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by yauhenav on 9.5.17.
 */
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent e) {
        try {
            HttpSession sessionObject = e.getSession();
            Service serviceObject = new Service();
            sessionObject.setAttribute("sessionObject", serviceObject);
        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
    public void sessionDestroyed(HttpSessionEvent e) {
        try {
            HttpSession sessionObject = e.getSession();
            Service serviceObject = (Service) sessionObject.getAttribute("sessionObject");
            serviceObject.close();
            sessionObject.removeAttribute("sessionObject");
        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}

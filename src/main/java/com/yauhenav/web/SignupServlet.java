package com.yauhenav.web;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yauhenav.logic.service.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

/**
 * Created by yauhenav on 15.10.17.
 */
public class SignupServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();

            HttpSession sessionObject = req.getSession(true);
            Service servObj = (Service) sessionObject.getAttribute("sessionObject");





        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}

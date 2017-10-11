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
 * Created by yauhenav on 9.10.17.
 */
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Service servObj = null;
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
try {
    servObj = new Service();
} catch (ServiceException exc) {
    exc.printStackTrace();
}

        String name = req.getParameter("username");
        String pass = req.getParameter("userpass");

        User temporUser = new User(-1, name, null, pass);
        try {
            if (servObj.validate(temporUser)) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome-page.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}




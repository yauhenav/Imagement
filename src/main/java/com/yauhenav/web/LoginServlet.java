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
        try {
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();

            HttpSession sessionObject = req.getSession(true);
            Service servObj = (Service) sessionObject.getAttribute("sessionObject");

            String name = req.getParameter("username");
            String pass = req.getParameter("userpass");

            User temporUser = new User(-1, name, null, pass);

            if (servObj.checkIfUserExists(temporUser)) {
                if (servObj.checkIfUsersPasswordCorresponds(temporUser)) {
                    req.setAttribute("username", temporUser.getUsername());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome-page.jsp");
                    //dispatcher.include(req, resp);
                    dispatcher.forward(req, resp);
                } else {
                    pw.println("<br><font color=\"red\">You've entered invalid password, " +
                            "go back and enter a valid password</font><br><br>");
                    pw.println("<a href=\"index.html\">Go to Home Page</a>");
                }
            } else {
                pw.println("<br><font color=\"red\">The user with such username does not exist, " +
                        "please sign up first</font><br><br>");
                pw.println("<a href=\"signup.html\">Go to Sign Up Page</a>");
            }

        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}




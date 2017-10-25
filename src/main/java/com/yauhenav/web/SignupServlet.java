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

        /*Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = params.nextElement();
            System.out.println("Parameter Name - "+paramName+", Value - "+req.getParameter(paramName));
        }*/

        try {
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();

            HttpSession sessionObject = req.getSession(true);
            Service servObj = (Service) sessionObject.getAttribute("sessionObject");


            String name = req.getParameter ("username");
            String pass = req.getParameter("userpass");
            String confirmPass = req.getParameter("confirmeduserpass");
            String email = req.getParameter("email");
            int id;

            if (name.matches("^(?=.{5,10}$)(?!.*[._-]{2})[a-z][a-z0-9._-]*[a-z0-9]$")) {
                if (pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                    if (email.matches("([\\w-+]+(?:\\.[\\w-+]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7})")) {
                        if (pass.equals(confirmPass)) {
                            id = servObj.assignIdToUser();
                            User tempUser = new User (id, name, email, pass);
                            servObj.createNewUser(tempUser);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
                            dispatcher.forward(req, resp);
                        } else {
                            pw.print("<font color=\"red\">Passwords you entered do not match, " +
                                    "go back to signup page and enter matching passwords</font><br><br>");
                            pw.println("<a href=\"signup.html\">Go to Sign Up Page</a>");
                        }

                    } else {
                        pw.print("<font color=\"red\">You've entered invalid email, " +
                                "go back to signup page and enter a valid email</font><br><br>");
                        pw.println("<a href=\"signup.html\">Go to Sign Up Page</a>");
                    }

                } else {
                    pw.print("<font color=\"red\">You've entered invalid password, " +
                            "go back to signup page and enter a valid password</font><br><br>");
                    pw.println("<a href=\"signup.html\">Go to Sign Up Page</a>");
                }

            } else {
                pw.print("<font color=\"red\">You've entered invalid username, " +
                        "go back to signup page and enter a valid username</font><br><br>");
                pw.println("<a href=\"signup.html\">Go to Sign Up Page</a>");
            }

        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}

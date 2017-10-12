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

            Service servObj = new Service();


            String name = req.getParameter("username");
            String pass = req.getParameter("userpass");

            User temporUser = new User(-1, name, null, pass);

                if (servObj.validate(temporUser)) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome-page.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    pw.println("<font color=\"red\">You've entered invalid ID value, " +
                            "go back and enter a valid ID</font>");
                    pw.println("<a href=\"index.html\">Go to Home Page</a>");
                }

        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}




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
public class Imagement extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter pw;

            HttpSession sessionObject = req.getSession(true);
            Service serviceObject = (Service) sessionObject.getAttribute("sessionObject");
            resp.setContentType("text/html,charset=utf-8");
            pw = resp.getWriter();
            String action = req.getParameter("action");

            switch (action) {
                case "":
            }


        }
    }

package com.yauhenav.web;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.yauhenav.logic.service.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;
import javax.servlet.http.Part;


/**
 * Created by yauhenav on 9.10.17.
 */
@MultipartConfig(maxFileSize = 16177215)
public class Management extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    try {
        //resp.setContentType("text/html");
        //PrintWriter pw = resp.getWriter();

        HttpSession sessionObject = req.getSession(true);
        Service servObj = (Service) sessionObject.getAttribute("sessionObject");

        String idNumber = req.getParameter("id");
        int imageID = Integer.parseInt(idNumber);
        Image tempImage = servObj.readImageFromDB(imageID);




        byte[] picture = tempImage.getFile();

        resp.setContentType("image/jpeg");
        resp.setContentLength(picture.length);
        resp.getOutputStream().write(picture);


    } catch (ServiceException exc) {
        exc.printStackTrace();
    }

    }
}

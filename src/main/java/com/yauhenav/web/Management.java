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
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("This must be printed to browser before the parameters of the HTTPRequest");
        System.out.println("This must be printed to console before the parameters of the HTTPRequest");

        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            System.out.println("Parameter Name - " + paramName + ", Value - " + req.getParameter(paramName));
        }

        Part filePart1 = req.getPart("newImageId");
        //String idValue = req.getParameter("number");
        System.out.println(filePart1);

        Part filePart2 = req.getPart("imageTitle");
        System.out.println(filePart2);

        Part filePart3 = req.getPart("imageDescription");
        System.out.println(filePart3);

        Part filePart4 = req.getPart("userId");
        System.out.println(filePart4);

        Part filePart5 = req.getPart("photo");
        System.out.println(filePart5);

        /*String imageId = req.getParameter("newImageId");
        pw.println(imageId);
        int imageIdInt = Integer.parseInt(imageId);
        pw.println("This is parsed string which is now int " + imageIdInt);*/

        HttpSession sessionObject = req.getSession(true);
        Service servObj = (Service) sessionObject.getAttribute("sessionObject");

        String imageId = req.getParameter("newImageId");
        int imageKey = Integer.parseInt(imageId);

        String imageTitle = req.getParameter("imageTitle");
        String imageDesc = req.getParameter("imageDescription");

        String userId = req.getParameter("userId");
        int userKey = Integer.parseInt(userId);

        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = req.getPart("photo");

        byte[] picture = null;
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            for (int length = 0; (length = inputStream.read(buffer)) > 0; ) {
                output.write(buffer, 0, length);
            }
            picture = output.toByteArray();
        }

        Image tempImage = new Image(imageKey, imageTitle, imageDesc, userKey, picture);

        try {
            servObj.createNewImage(tempImage);


        } catch (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}

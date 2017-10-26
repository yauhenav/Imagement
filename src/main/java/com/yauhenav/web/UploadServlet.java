package com.yauhenav.web;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.yauhenav.logic.service.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;
import sun.misc.IOUtils;


/**
 * Created by yauhenav on 26.10.17.
 */
public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();

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
                for (int length = 0; (length = inputStream.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }
                picture = output.toByteArray();
            }

            Image tempImage = new Image (imageKey, imageTitle, imageDesc, userKey, picture);


                servObj.createNewImage(tempImage);





        } catch  (ServiceException exc) {
            exc.printStackTrace();
        }
    }
}

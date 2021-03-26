package by.gomel.novik.library.controller;


import by.gomel.novik.library.controller.constant.SetAttribute;
import by.gomel.novik.library.temp.CurrentDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet implements SetAttribute {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getParameter("target");

        if (target == null){
            target = "main";
        }
        setAttribute(target, request);
        String path = "/" + target + ".jsp";
        getServletContext().getRequestDispatcher(path).forward(request, response);
    }


}

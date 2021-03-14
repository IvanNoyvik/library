package by.gomel.novik.library.controller;

import by.gomel.novik.library.controller.constant.SetAttribute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public abstract class FrontCommand implements SetAttribute {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) {

        try {

            setAttribute(target, request);

            target = PREFIX + target + POSTFIX;
            RequestDispatcher dispatcher = context.getRequestDispatcher(target);

            dispatcher.forward(request, response);

        } catch (Exception e) {

            errorForward(MAIN_JSP);
        }
    }

    protected void errorForward(String target) {

        try {

//            setAttribute(target);
            target = PREFIX + target + POSTFIX + ERROR_MESSAGE;

            RequestDispatcher dispatcher = context.getRequestDispatcher(target);
            dispatcher.forward(request, response);

        } catch (Exception e) {

            redirect(ERROR_JSP); // problem
        }
    }

    protected void redirect(String target) {
        try {
//            setAttribute(target);
            target = PREFIX + target + POSTFIX + ERROR_MESSAGE;
            response.sendRedirect(target);
        } catch (Exception e) {
            throw new RuntimeException("ERROR REDIRECT", e);
        }
    }

    protected void redirectWithTarget(String target) {
        try {
            target = "/redirect?target=" + target;
            response.sendRedirect(target);
        } catch (Exception e) {
            throw new RuntimeException("ERROR redirectWithMarker", e);
        }
    }


}

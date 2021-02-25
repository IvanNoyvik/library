package by.gomel.novik.library.controller;

import by.gomel.novik.library.controller.constant.CommandConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.DELIMITER;
import static by.gomel.novik.library.controller.constant.CommandConstant.JSP_PATH;

public abstract class FrontCommand {

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
        target = DELIMITER + target + JSP_PATH;
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            redirect(CommandConstant.ERROR); // problem
        }
    }

    protected void redirect(String target) {
        target = DELIMITER + target + JSP_PATH;
        try {
            response.sendRedirect(target);
        } catch (Exception e) {
            redirect(CommandConstant.ERROR); // problem
        }
    }


}

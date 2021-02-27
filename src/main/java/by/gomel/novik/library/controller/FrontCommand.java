package by.gomel.novik.library.controller;

import by.gomel.novik.library.controller.constant.CommandConstant;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;
import static by.gomel.novik.library.controller.constant.CommandConstant.ORDERS;

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

        try {

            setAttribute(target);

            target = PREFIX + target + CommandConstant.POSTFIX;
            RequestDispatcher dispatcher = context.getRequestDispatcher(target);

            dispatcher.forward(request, response);

        } catch (Exception e) {
            redirect(CommandConstant.ERROR); // problem
        }
    }

    protected void redirect(String target) {
        try {
            setAttribute(target);
            target = PREFIX + target + CommandConstant.POSTFIX;
            response.sendRedirect(target);
        } catch (Exception e) {
            redirect(CommandConstant.ERROR); // problem
        }
    }

    private void setAttribute(String target){

        if (target.equalsIgnoreCase(MAIN_JSP)){

            BookJdbcDao bookDao = new BookJdbcDao();
            List<Book> books = bookDao.findAll();
            request.setAttribute(BOOKS, books);
        }

        if (target.equalsIgnoreCase(PROFILE_JSP)) {

            OrderJdbcDao orderDao = new OrderJdbcDao();
            List<Order> orders = orderDao.findAll();
            request.setAttribute(ORDERS, orders);

        }
    }

}

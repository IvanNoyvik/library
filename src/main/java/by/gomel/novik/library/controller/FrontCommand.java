package by.gomel.novik.library.controller;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Message;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.MessageJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

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

            target = PREFIX + target + POSTFIX;
            RequestDispatcher dispatcher = context.getRequestDispatcher(target);

            dispatcher.forward(request, response);

        } catch (Exception e) {

            errorForward(MAIN_JSP);
        }
    }

    protected void errorForward(String target) {

        try {

            setAttribute(target);
            target = PREFIX + target + POSTFIX + ERROR_MESSAGE;

            RequestDispatcher dispatcher = context.getRequestDispatcher(target);
            dispatcher.forward(request, response);

        } catch (Exception e) {

            redirect(ERROR_JSP); // problem
        }
    }

    protected void redirect(String target) {
        try {
            setAttribute(target);
            target = PREFIX + target + POSTFIX + ERROR_MESSAGE;
            response.sendRedirect(target);
        } catch (Exception e) {
            throw new RuntimeException("ERROR REDIRECT", e);
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
//            User user = (User) request.getSession().getAttribute("user");
            long userId = Long.parseLong(request.getParameter("userId"));
            List<Order> orders = orderDao.findByUserId(userId);
            request.setAttribute(ORDERS, orders);

        }

        if (target.equalsIgnoreCase(BOOK_JSP)) {

            BookJdbcDao bookDao = new BookJdbcDao();
            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookDao.findById(bookId);
            request.setAttribute(BOOK, book);

        }

        if (target.equalsIgnoreCase(ADMIN_JSP)) {

            UserJdbcDao userDao = new UserJdbcDao();
            List<User> users = userDao.findAll();
            request.setAttribute(USERS, users);

            MessageJdbcDao messageDao = new MessageJdbcDao();
            List<Message> messages = messageDao.findAll();
            request.setAttribute(MESSAGES, messages);

            OrderJdbcDao orderDao = new OrderJdbcDao();
            List<Order> orders = orderDao.findAllOverdueOrder();
            request.setAttribute(ORDERS, orders);

        }
    }

}

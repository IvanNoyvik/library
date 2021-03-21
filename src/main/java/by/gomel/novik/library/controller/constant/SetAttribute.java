package by.gomel.novik.library.controller.constant;

import by.gomel.novik.library.model.*;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.AuthorJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.GenreJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.MessageJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;
import static by.gomel.novik.library.controller.constant.CommandConstant.MESSAGES;

public interface SetAttribute {

    default void setAttribute(String target, HttpServletRequest request){

        String resp = request.getParameter("resp");
        request.setAttribute("resp", resp);

        if (target.equalsIgnoreCase(MAIN_JSP)){

            BookJdbcDao bookDao = new BookJdbcDao();
            List<Book> books = bookDao.findAll();
            request.setAttribute(BOOKS, books);
        }

        if (target.equalsIgnoreCase(PROFILE_JSP)) {

            OrderJdbcDao orderDao = new OrderJdbcDao();
            User user = (User) request.getSession().getAttribute(USER);
            long userId = user.getId();
            List<Order> orders = orderDao.findByUserId(userId);
            request.setAttribute(ORDERS, orders);

        }

        if (target.equalsIgnoreCase(BOOK_JSP)) {

            BookJdbcDao bookDao = new BookJdbcDao();
            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookDao.findById(bookId);
            request.setAttribute(BOOK, book);

            OrderJdbcDao orderDao = new OrderJdbcDao();
            List<Order> orders = orderDao.findByBookId(bookId);
            request.setAttribute(ORDERS, orders);


        }

        if (target.equalsIgnoreCase(EDIT_BOOK_JSP)) {

            BookJdbcDao bookDao = new BookJdbcDao();
            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookDao.findById(bookId);
            request.setAttribute(BOOK, book);
            GenreJdbcDao genreDao = new GenreJdbcDao();
            List<Genre> genres = genreDao.findAll();
            request.setAttribute(GENRES, genres);
            AuthorJdbcDao authorDao = new AuthorJdbcDao();
            List<Author> authors = authorDao.findAll();
            request.setAttribute(AUTHORS, authors);

        }

        if (target.equalsIgnoreCase(ADD_BOOK_JSP)) {

            GenreJdbcDao genreDao = new GenreJdbcDao();
            List<Genre> genres = genreDao.findAll();
            request.setAttribute(GENRES, genres);
            AuthorJdbcDao authorDao = new AuthorJdbcDao();
            List<Author> authors = authorDao.findAll();
            request.setAttribute(AUTHORS, authors);

        }

        if (target.equalsIgnoreCase(ADMIN_JSP)) {

            OrderJdbcDao orderDao = new OrderJdbcDao();
            List<Order> orders = orderDao.findAllOverdueOrder();
            request.setAttribute(ORDERS, orders);

            UserJdbcDao userDao = new UserJdbcDao();
            List<User> users = userDao.findAll();
            Map<User, Integer> userWithCountOverdueOrder= new HashMap<>();
            for (User user: users) {
                int countOverdueOrder = orderDao.findNumberOfOverdueOrdersByUserId(user.getId());
                userWithCountOverdueOrder.put(user, countOverdueOrder);
            }
            request.setAttribute(USERS, userWithCountOverdueOrder);

            MessageJdbcDao messageDao = new MessageJdbcDao();
            List<Message> messages = messageDao.findAll();
            request.setAttribute(MESSAGES, messages);

        }
    }
}

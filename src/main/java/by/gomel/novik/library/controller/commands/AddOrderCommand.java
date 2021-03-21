package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDate;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class AddOrderCommand extends FrontCommand {

    OrderJdbcDao orderDao = new OrderJdbcDao();
    BookJdbcDao bookDao = new BookJdbcDao();



    @Override
    public void process() throws ServletException, IOException {

        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
        User user = (User) request.getSession().getAttribute(USER);
        Book book = bookDao.findById(bookId);
        long userId =user.getId();
        int duration = Integer.parseInt(request.getParameter(DAYS));

        if (user.getStatus().getStatus().equalsIgnoreCase("OK")
                && !orderDao.findByBookAndUserId(bookId,userId)
                && book.getQuantity() > 0
                && duration <= 180) {



            Order order = new Order(LocalDate.now(), duration, book, user);

            orderDao.save(order);

            redirectWithResp(PROFILE_JSP, ADD_ORDER_OK);

        } else {

            redirectWithResp(MAIN_JSP, ADD_ORDER_FAIL);

        }


    }
}

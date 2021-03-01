package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDate;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class ReturnOrderCommand extends FrontCommand {

    OrderJdbcDao orderDao = new OrderJdbcDao();



    @Override
    public void process() throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter(ID));
        orderDao.deleteById(id);

        forward(PROFILE_JSP);

    }
}

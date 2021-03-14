package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class ForwardCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        String target = request.getParameter(FORWARD);

        forward(target);
    }
}

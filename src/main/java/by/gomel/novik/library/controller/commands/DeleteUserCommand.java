package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class DeleteUserCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        long userId = Long.parseLong(request.getParameter(USER_ID));
        userDao.deleteById(userId);

        forward(ADMIN_JSP);

    }
}

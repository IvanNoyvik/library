package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class LoginCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User user = userDao.findByLoginAndPasswordSqlQuery(login, password);

        if (user != null) {
            request.getSession().setAttribute(USER, user);
            forward(MAIN_JSP);
        } else {

        request.setAttribute(ERROR, LOGIN_MESSAGE);
        forward(LOGIN_JSP);

        }



    }
}

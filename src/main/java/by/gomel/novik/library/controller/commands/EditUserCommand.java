package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class EditUserCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute(USER);
        if (user != null) {

            String name = request.getParameter(NAME);

            user.setName(name);
            user = userDao.update(user);

            request.getSession().setAttribute(USER, user);
            redirectWithTarget(PROFILE_JSP);
        } else {

//            request.setAttribute(ERROR, LOGIN_MESSAGE);
            redirectWithTarget(MAIN_JSP);

        }


    }
}

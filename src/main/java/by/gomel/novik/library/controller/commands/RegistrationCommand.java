package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.RoleJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserStatusJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class RegistrationCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();
    RoleJdbcDao roleDao = new RoleJdbcDao();
    UserStatusJdbcDao statusDao = new UserStatusJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);

        User user = userDao.findByLoginSqlQuery(login);

        if (user == null){
            user = userDao.save(new User(login, password, name,
                    statusDao.getOkStatus(), roleDao.getGuestStatus()));
            request.setAttribute(MESSAGE, REGISTRATION_MESSAGE);
            forward(MAIN_JSP);

        } else {

            request.setAttribute(ERROR, REGISTRATION_MESSAGE);
            forward(REGISTRATION_JSP);
        }

    }
}

package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserStatusJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDate;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class LoginCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        User user = userDao.findByLoginAndPasswordSqlQuery(login, password);

        if (user != null) {

            if (user.getStatus().getStatus().equalsIgnoreCase(LIMITED) && user.getStatus().getDuration().isBefore(LocalDate.now())) {

                UserStatusJdbcDao statusDao = new UserStatusJdbcDao();
                long statusId = user.getStatus().getId();

                user.setStatus(statusDao.getOkStatus());
                userDao.update(user);
                statusDao.deleteById(statusId);

            }

            request.getSession().setAttribute(USER, user);
            if (!user.getStatus().getStatus().equalsIgnoreCase(LOCKED)) {
                redirectWithTarget(MAIN_JSP);
            } else {
                redirect(BLOCK_JSP);
            }
        } else {

            redirect(LOGIN_JSP);

        }


    }
}

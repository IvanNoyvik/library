package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class EditUserCommand extends FrontCommand {

    private static final UserJdbcDao USER_DAO = new UserJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute(USER);

        if (user != null) {

            String name = request.getParameter(NAME);

            user.setName(name);
            user = USER_DAO.update(user);

            request.getSession().setAttribute(USER, user);

            redirectWithResp(PROFILE_JSP, EDIT_USER_OK);

        } else {

            redirectWithResp(MAIN_JSP, EDIT_USER_FAIL);

        }


    }
}

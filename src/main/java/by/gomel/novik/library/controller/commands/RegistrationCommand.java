package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class RegistrationCommand extends FrontCommand {


    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);

//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        User user = userDao.saveUser(new User(login, password, Role.USER));
//
//        getServletContext().getRequestDispatcher("/main").forward(request, response);

        forward(MAIN);
    }
}

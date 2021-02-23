package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import static by.gomel.novik.library.controller.constant.CommandConstant.UNKNOWN;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        response.sendRedirect("/WEB-INF/jsp/unknown.jsp");
    }
}

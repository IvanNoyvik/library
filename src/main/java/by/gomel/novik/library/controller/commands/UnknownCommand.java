package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
    request.setAttribute(ERROR, UNKNOWN);
    forward(MAIN_JSP);
    }
}

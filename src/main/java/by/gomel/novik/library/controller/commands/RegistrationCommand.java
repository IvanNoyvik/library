package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.controller.constant.CommandConstant;

import javax.servlet.ServletException;
import java.io.IOException;

public class RegistrationCommand extends FrontCommand {


    @Override
    public void process() throws ServletException, IOException {

        String login = request.getParameter(CommandConstant.LOGIN);
        String password = request.getParameter(CommandConstant.PASSWORD);
        String name = request.getParameter(CommandConstant.NAME);



        forward("main");
    }
}

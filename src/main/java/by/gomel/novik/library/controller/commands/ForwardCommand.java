package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.controller.constant.CommandConstant;

import javax.servlet.ServletException;
import java.io.IOException;

public class ForwardCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        String target = request.getParameter(CommandConstant.FORWARD);

        forward(target);
    }
}

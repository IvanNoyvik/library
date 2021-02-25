package by.gomel.novik.library.controller;

import by.gomel.novik.library.controller.commands.UnknownCommand;
import by.gomel.novik.library.controller.constant.CommandConstant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/front"})
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        doFrontCommand(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doFrontCommand(request, response);
    }

    private void doFrontCommand(HttpServletRequest request, HttpServletResponse response){
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        try {
            command.process();
        } catch (Exception e) {

        }
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format( CommandConstant.COMMAND_PATH,
                    request.getParameter(CommandConstant.COMMAND)));
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}

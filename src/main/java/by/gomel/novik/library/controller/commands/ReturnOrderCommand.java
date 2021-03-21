package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class ReturnOrderCommand extends FrontCommand {

    OrderJdbcDao orderDao = new OrderJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        try {
            long id = Long.parseLong(request.getParameter(ID));
            orderDao.deleteById(id);
            redirectWithResp(PROFILE_JSP, RETURN_ORDER_OK);

        } catch (Exception e) {

            redirectWithResp(PROFILE_JSP, RETURN_ORDER_FAIL);
        }
    }
}

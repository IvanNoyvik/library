package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserStatusJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class ChangeStatusCommand extends FrontCommand {

    UserJdbcDao userDao = new UserJdbcDao();
    UserStatusJdbcDao statusDao = new UserStatusJdbcDao();
    OrderJdbcDao orderDao = new OrderJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        try {
        long userId = Long.parseLong(request.getParameter(USER_ID));
        String status = request.getParameter(STATUS);

        User user = userDao.findById(userId);

        if (status.equalsIgnoreCase(OK)){

            user.setStatus(statusDao.getOkStatus());

        } else if (status.equalsIgnoreCase(LOCKED)) {

            user.setStatus(statusDao.getLockedStatus());
            List<Order> orders = orderDao.findByUserId(userId);
            orders.forEach(order -> orderDao.deleteById(order.getId()));


        } else if (status.equalsIgnoreCase(LIMITED)) {

            int duration = Integer.parseInt(request.getParameter(DURATION));
            UserStatus newStatus = statusDao.save(new UserStatus(LIMITED, duration));
            user.setStatus(newStatus);

        }



            userDao.update(user);

            redirectWithResp(ADMIN_JSP, CHANGE_STATUS_OK);

        } catch (Exception e){

            redirectWithResp(ADMIN_JSP, CHANGE_STATUS_FAIL);

        }


    }
}

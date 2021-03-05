package by.gomel.novik.library.temp;

import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    OrderJdbcDao orderJdbcDao = new OrderJdbcDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orders = orderJdbcDao.findNumberOfOverdueOrdersByUserId(1l);
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}

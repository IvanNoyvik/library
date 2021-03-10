package by.gomel.novik.library.temp;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.connection.Connector;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Test2Servlet", urlPatterns = "/test2")
public class Test2Servlet extends HttpServlet {

    BookJdbcDao BookJdbcDao = new BookJdbcDao();
    private static final Connector CONNECTOR = Connector.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        try {

            conn = CONNECTOR.getConnection();
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("id"));
            } catch (Exception e) {

            }
            Book book = BookJdbcDao.findById(id);
//            if (person == null) {
//                // No record found, redirect to default image.
//
//            }

            response.getOutputStream().write(book.getImage());

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

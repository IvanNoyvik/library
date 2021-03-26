package by.gomel.novik.library.controller;

import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

@WebServlet(name = "AddImageServlet", urlPatterns = {"/addImage"})
@MultipartConfig
public class AddImageServlet extends HttpServlet {

    BookJdbcDao bookJdbcDao = BookJdbcDao.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            long id = Long.parseLong(request.getParameter(BOOK_ID));
            Part part = null;
            part = request.getPart(IMAGE);

            if (part != null) {

                try (InputStream inputStream = part.getInputStream()) {
                    bookJdbcDao.addImage(id, inputStream);
                    response.sendRedirect("/redirect?target=main&resp=Add image completed");

                }

            } else {
                response.sendRedirect("/redirect?target=main&resp=Add image fail");

            }

        } catch (Exception e) {
            response.sendRedirect("/redirect?target=main&resp=Add image fail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}

package by.gomel.novik.library.controller;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

import static by.gomel.novik.library.controller.constant.CommandConstant.BOOK_ID;

@WebServlet(name = "AddImageServlet", urlPatterns = {"/addImage"})
@MultipartConfig
public class AddImageServlet extends HttpServlet {

    BookJdbcDao bookJdbcDao = new BookJdbcDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter(BOOK_ID));
        Part part = request.getPart("file");
        Book book;
        if (part != null){
            try (InputStream inputStream = part.getInputStream()){

                book = bookJdbcDao.addImage(id, inputStream);

            }

            request.setAttribute("command", "UpdateBook");
            getServletContext().getRequestDispatcher("/front").forward(request,response);

        } else {

            response.sendRedirect("/editBook.jsp");

        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

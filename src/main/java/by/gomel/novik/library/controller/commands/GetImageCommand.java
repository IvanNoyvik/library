package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class GetImageCommand extends FrontCommand {

    BookJdbcDao bookDao = new BookJdbcDao();



    @Override
    public void process() throws ServletException, IOException {

        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
        byte[] image = bookDao.findImageById(bookId);


        if (image != null) {

            try (ServletOutputStream outputStream = response.getOutputStream()){
                outputStream.write(image);
            }

        } else {
//            response.getOutputStream().write();
            response.sendRedirect(request.getContextPath() + "/static/main/images/no_image.png");
        }


    }
}

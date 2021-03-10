package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.BOOK_ID;

public class EditBookCommand extends FrontCommand {

    BookJdbcDao bookDao = new BookJdbcDao();



    @Override
    public void process() throws ServletException, IOException {

        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
        byte[] image = bookDao.findImageById(bookId);


        if (image != null) {

            response.getOutputStream().write(image);

        } else {
//            response.getOutputStream().write();
            response.sendRedirect(request.getContextPath() + "/static/main/images/no_image.png");
        }


    }
}

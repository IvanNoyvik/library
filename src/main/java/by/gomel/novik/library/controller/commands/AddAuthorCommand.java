package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.*;
import by.gomel.novik.library.persistance.dao.bookimpl.AuthorJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class AddAuthorCommand extends FrontCommand {

    AuthorJdbcDao authorDao = new AuthorJdbcDao();


    @Override
    public void process() throws ServletException, IOException {


        String author = request.getParameter(AUTHOR);

        if (author != null && authorDao.findByAuthor(author) == null) {

            authorDao.save(new Author(author));

            redirectWithResp(ADMIN_JSP, ADD_AUTHOR_OK);

        } else {

            redirectWithResp(ADMIN_JSP, ADD_AUTHOR_FAIL);

        }


    }
}

package by.gomel.novik.library.controller.commands;

import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.dao.bookimpl.AuthorJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.GenreJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class AddBookCommand extends FrontCommand {

    BookJdbcDao bookDao = new BookJdbcDao();
    GenreJdbcDao genreDao = new GenreJdbcDao();
    AuthorJdbcDao authorDao = new AuthorJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        String title = request.getParameter(TITLE);
        String description = request.getParameter(DESCRIPTION);
        int quantity = Integer.parseInt(request.getParameter(QUANTITY));

        long genreId = Long.parseLong(request.getParameter(GENRE));
        Genre genre = genreDao.findById(genreId);

        long authorId = Long.parseLong(request.getParameter(AUTHOR));
        Author author = authorDao.findById(authorId);

        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setQuantity(quantity);
        book.setGenre(genre);
        book.setAuthor(author);

        try {

            book = bookDao.save(book);

            redirectWithResp(MAIN_JSP, ADD_BOOK_OK);

        } catch (DaoPartException e) {

            redirectWithResp(MAIN_JSP, ADD_BOOK_FAIL);

        }


    }
}

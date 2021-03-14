package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.dao.bookimpl.AuthorJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.bookimpl.GenreJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class EditBookCommand extends FrontCommand {

    BookJdbcDao bookDao = new BookJdbcDao();
    GenreJdbcDao genreDao = new GenreJdbcDao();
    AuthorJdbcDao authorDao = new AuthorJdbcDao();


    @Override
    public void process() throws ServletException, IOException {

        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
        Book book = bookDao.findById(bookId);

        String title = request.getParameter(TITLE);
        String description = request.getParameter(DESCRIPTION);
        int quantity = Integer.parseInt(request.getParameter(QUANTITY));

        long genreId = Long.parseLong(request.getParameter(GENRE));
        Genre genre = genreDao.findById(genreId);

        long authorId = Long.parseLong(request.getParameter(AUTHOR));
        Author author = authorDao.findById(authorId);

        book.setTitle(title);
        book.setDescription(description);
        book.setQuantity(quantity);
        book.setGenre(genre);
        book.setAuthor(author);

        book = bookDao.update(book);

        redirectWithTarget(MAIN_JSP);

    }
}

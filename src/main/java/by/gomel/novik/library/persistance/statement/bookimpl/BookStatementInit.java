package by.gomel.novik.library.persistance.statement.bookimpl;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookStatementInit extends EntityStatementInit<Book> {


    @Override
    public void initStatement(PreparedStatement ps, Book book) throws SQLException {

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getDescription());
        ps.setInt(3,book.getQuantity());
        ps.setLong(4, book.getAuthor().getId());
        ps.setLong(5, book.getGenre().getId());
    }

    @Override
    public void initStatement(PreparedStatement ps, Book book, long id) throws SQLException {

        initStatement(ps, book);
        ps.setLong(6, id);

    }

    public void initStatement(PreparedStatement ps, InputStream inputStream, long id) throws SQLException {

        ps.setBlob(1, inputStream);
        ps.setLong(2, id);

    }

    public void initStatement(PreparedStatement ps, String title, String author) throws SQLException {

        ps.setString(1, title);
        ps.setString(2, author);

    }
}

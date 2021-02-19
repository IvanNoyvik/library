package by.gomel.novik.library.persistance.statement.bookimpl;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookStatementInit extends EntityStatementInit<Book> {


    @Override
    public void initStatement(PreparedStatement ps, Book book) throws SQLException {

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getDescription());
        ps.setString(3, book.getCoverLink());
        ps.setInt(4,book.getQuantity());
        ps.setLong(5, book.getAuthor().getId());
        ps.setLong(6, book.getGenre().getId());
    }

    @Override
    public void initStatement(PreparedStatement ps, Book book, long id) throws SQLException {

        initStatement(ps, book);
        ps.setLong(7, id);

    }
}

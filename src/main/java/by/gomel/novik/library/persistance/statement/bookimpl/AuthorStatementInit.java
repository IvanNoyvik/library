package by.gomel.novik.library.persistance.statement.bookimpl;

import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorStatementInit extends EntityStatementInit<Author> {
    @Override
    public void initStatement(PreparedStatement ps, Author author) throws SQLException {
        ps.setString(1, author.getAuthor());
    }

    @Override
    public void initStatement(PreparedStatement ps, Author author, long id) throws SQLException {
        initStatement(ps, author);
        ps.setLong(2, id);
    }
}

package by.gomel.novik.library.persistance.rsmapper.bookimpl;

import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorResultSetMapper implements ResultSetMapper<Author> {
    @Override
    public Author processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String author = rs.getString("author");

        return new Author(id, author);

    }
}

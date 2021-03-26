package by.gomel.novik.library.persistance.statement.bookimpl;

import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreStatementInit extends EntityStatementInit<Genre> {

    @Override
    public void initStatement(PreparedStatement ps, Genre genre) throws SQLException {
        ps.setString(1, genre.getGenre());

    }

    @Override
    public void initStatement(PreparedStatement ps, Genre genre, long id) throws SQLException {
        initStatement(ps, genre);
        ps.setLong(2, id);
    }
}

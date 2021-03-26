package by.gomel.novik.library.persistance.rsmapper.bookimpl;

import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreResultSetMapper implements ResultSetMapper<Genre> {
    @Override
    public Genre processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String genre = rs.getString("genre");

        return new Genre(id, genre);
    }
}

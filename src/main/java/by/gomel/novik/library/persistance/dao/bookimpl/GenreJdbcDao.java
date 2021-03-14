package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.query.bookimpl.GenreSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.GenreResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.bookimpl.GenreStatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreJdbcDao extends JdbcDao<Genre> {
    @Override
    protected GenreSqlQuery getSqlQuery() {
        return new GenreSqlQuery();
    }

    @Override
    protected ResultSetMapper<Genre> getResultSetMapper() {
        return new GenreResultSetMapper();
    }

    @Override
    protected StatementInit<Genre> getStatementInitializer() {
        return new GenreStatementInit();
    }

    public Genre findByGenre(String genre) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByGenreSqlQuery())) {
            getStatementInitializer().initStatement(prSt, new Genre(genre));

            try (ResultSet rs = prSt.executeQuery()) {
                if (rs.next()) {
                    return getResultSetMapper().processResultSet(rs);
                }

                return null;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByGenre entity method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection or prepare Statement: " + e.getMessage());
        }
    }
}

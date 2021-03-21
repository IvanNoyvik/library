package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.persistance.query.bookimpl.AuthorSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.AuthorResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.bookimpl.AuthorStatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorJdbcDao extends JdbcDao<Author> {
    @Override
    protected AuthorSqlQuery getSqlQuery() {
        return new AuthorSqlQuery();
    }

    @Override
    protected ResultSetMapper<Author> getResultSetMapper() {
        return new AuthorResultSetMapper();
    }

    @Override
    protected StatementInit<Author> getStatementInitializer() {
        return new AuthorStatementInit();
    }

    public Author findByAuthor(String author) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByAuthorSqlQuery())) {
            getStatementInitializer().initStatement(prSt, new Author(author));

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

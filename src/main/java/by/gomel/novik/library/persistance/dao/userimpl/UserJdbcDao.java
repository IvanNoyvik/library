package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.UserSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.UserResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.UserStatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcDao extends JdbcDao<User> {

    @Override
    protected UserSqlQuery getSqlQuery() {
        return new UserSqlQuery();
    }

    @Override
    protected ResultSetMapper<User> getResultSetMapper() {
        return new UserResultSetMapper();
    }

    @Override
    protected UserStatementInit getStatementInitializer() {
        return new UserStatementInit();
    }

    public User findByLoginAndPasswordSqlQuery(String login, String password) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByLoginAndPasswordSqlQuery())) {
            getStatementInitializer().initStatement(prSt, login, password);

            try (ResultSet rs = prSt.executeQuery()) {
                if (rs.next()) {
                    return getResultSetMapper().processResultSet(rs);
                }

                return null;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByLoginAndPasswordSqlQuery entity method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    public User findByLoginSqlQuery(String login) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByLoginSqlQuery())) {
            getStatementInitializer().initStatement(prSt, login);

            try (ResultSet rs = prSt.executeQuery()) {
                if (rs.next()) {
                    return getResultSetMapper().processResultSet(rs);
                }

                return null;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByLoginAndPasswordSqlQuery entity method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

}

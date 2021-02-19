package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.model.entity.Entity;
import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDao<T extends Entity> extends JdbcConnector implements BaseDao<T> {

    protected abstract CrudSqlQuery getSqlQuery();

    protected abstract ResultSetMapper<T> getResultSetMapper();

    protected abstract StatementInit<T> getStatementInitializer();

    @Override
    public T findById(long id) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByIdSqlQuery())) {
            getStatementInitializer().initStatement(prSt, id);

            try (ResultSet rs = prSt.executeQuery()) {
                if (rs.next()) {
                    return getResultSetMapper().processResultSet(rs);
                }
                throw new DaoPartException("Invalid entity id: " + id);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process getById entity method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try (Connection conn = getConnector().getConnection()) {

            try (PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findAllSqlQuery());
                 ResultSet rs = prSt.executeQuery()) {

                List<T> t = new ArrayList<>();
                while (rs.next()) {
                    t.add(getResultSetMapper().processResultSet(rs));
                }
                return t;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process getAll entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    @Override
    public T save(T t) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().saveSqlQuery())) {

            getStatementInitializer().initStatement(prSt, t);
            prSt.executeUpdate();

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error process update entity method: " + e.getMessage());
        }
    }


    @Override
    public T update(T t) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().updateSqlQuery())) {

            getStatementInitializer().initStatement(prSt, t, t.getId());
            prSt.executeUpdate();

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error process update entity method: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().deleteByIdSqlQuery())) {

            getStatementInitializer().initStatement(prSt, id);
            prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error process delete entity method: " + e.getMessage());
        }
    }

}


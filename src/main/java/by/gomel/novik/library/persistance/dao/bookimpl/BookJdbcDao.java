package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.bookimpl.BookSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.BookResultSetMapper;
import by.gomel.novik.library.persistance.statement.bookimpl.BookStatementInit;
import by.gomel.novik.library.persistance.statement.StatementInit;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookJdbcDao extends JdbcDao<Book> {

    @Override
    protected BookSqlQuery getSqlQuery() {
        return new BookSqlQuery();
    }

    @Override
    protected ResultSetMapper<Book> getResultSetMapper() {
        return new BookResultSetMapper();
    }

    @Override
    protected BookStatementInit getStatementInitializer() {
        return new BookStatementInit();
    }

    public byte[] findImageById(long id) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findImageByIdSqlQuery())) {
            getStatementInitializer().initStatement(prSt, id);

            try (ResultSet rs = prSt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("image");
                }
                throw new DaoPartException("Invalid entity id: " + id);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findImageById method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }


    public Book addImage(long id, InputStream inputStream) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prStAddImage = conn.prepareStatement(getSqlQuery().addImageSqlQuery())) {

            conn.setAutoCommit(false);
            getStatementInitializer().initStatement(prStAddImage, inputStream, id);
            prStAddImage.executeUpdate();

            conn.commit();

            try ( PreparedStatement prStFindById = conn.prepareStatement(getSqlQuery().findByIdSqlQuery())) {
                getStatementInitializer().initStatement(prStFindById, id);

                try (ResultSet rs = prStFindById.executeQuery()) {
                    if (rs.next()) {
                        return getResultSetMapper().processResultSet(rs);
                    }
                    throw new DaoPartException("Invalid entity id in addImage method: " + id);

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DaoPartException("Error process getById in addImage method: " + e.getMessage());
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process addImage entity method: " + e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error process addImage entity method: " + e.getMessage());
        }
    }


}

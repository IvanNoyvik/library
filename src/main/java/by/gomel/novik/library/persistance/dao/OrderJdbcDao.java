package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;
import by.gomel.novik.library.model.Order;
import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.query.OrderSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.OrderResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.statement.OrderStatementInit;
import by.gomel.novik.library.persistance.statement.StatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderJdbcDao extends AbstractOrderJdbcDao {

    private static final BookJdbcDao BOOK_DAO = new BookJdbcDao();
    private static final UserJdbcDao USER_DAO = new UserJdbcDao();


    @Override
    protected OrderSqlQuery getSqlQuery() {
        return new OrderSqlQuery();
    }

    @Override
    protected ResultSetMapper<Order> getResultSetMapper() {
        return new OrderResultSetMapper();
    }

    @Override
    protected StatementInit<Order> getStatementInitializer() {
        return new OrderStatementInit();
    }

    @Override
    public Order findById(long id) {
        Order order = super.findById(id);
        order.setBook(BOOK_DAO.findById(order.getBook().getId()));
        order.setUser(USER_DAO.findById(order.getUser().getId()));
        return order;
    }

    @Override
    public List<Order> findAll() {

        List<Order> orders = super.findAll();
        orders.forEach(order -> order.setBook(BOOK_DAO.findById(order.getBook().getId())));
        orders.forEach(order -> order.setUser(USER_DAO.findById(order.getUser().getId())));

        return orders;
    }

    @Override
    public List<Order> findByBookId(long id) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByBookIdSqlQuery())) {

            getStatementInitializer().initStatement(prSt, id);


            try (ResultSet rs = prSt.executeQuery()) {

                return getOrders(rs);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByBookId entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    @Override
    public List<Order> findByUserId(long id) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findByUserIdSqlQuery())) {

            getStatementInitializer().initStatement(prSt, id);


            try (ResultSet rs = prSt.executeQuery()) {

                return getOrders(rs);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByUserId entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    @Override
    public List<Order> findAllOverdueOrderSqlQuery() {
        try (Connection conn = getConnector().getConnection()) {

            try (PreparedStatement prSt = conn.prepareStatement(getSqlQuery().findAllOverdueOrderSqlQuery());
                 ResultSet rs = prSt.executeQuery()) {

                return getOrders(rs);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findAllOverdueOrderSqlQuery entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }    }

    private List<Order> getOrders(ResultSet rs) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = getResultSetMapper().processResultSet(rs);
            order.setBook(BOOK_DAO.findById(order.getBook().getId()));
            order.setUser(USER_DAO.findById(order.getUser().getId()));
            orders.add(order);
        }
        return orders;
    }
}

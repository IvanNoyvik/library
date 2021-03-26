package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.novik.library.persistance.dao.userimpl.UserJdbcDao;
import by.gomel.novik.library.model.Order;
import by.gomel.library.exception.DaoPartException;
import by.gomel.novik.library.persistance.query.OrderSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.OrderResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.statement.OrderStatementInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderJdbcDao extends AbstractOrderJdbcDao {

    private static final OrderJdbcDao instance = new OrderJdbcDao();

    private static final BookJdbcDao BOOK_DAO = BookJdbcDao.getInstance();
    private static final UserJdbcDao USER_DAO = UserJdbcDao.getInstance();

    private OrderJdbcDao(){}

    public static OrderJdbcDao getInstance(){
        return instance;
    }

    @Override
    protected OrderSqlQuery getSqlQuery() {
        return new OrderSqlQuery();
    }

    @Override
    protected ResultSetMapper<Order> getResultSetMapper() {
        return new OrderResultSetMapper();
    }

    @Override
    protected OrderStatementInit getStatementInitializer() {
        return new OrderStatementInit();
    }

    @Override
    public Order save(Order order) {
        Book book = order.getBook();
        if (book.getQuantity() < 1) {
            throw new DaoPartException();
        }
        book.setQuantity(book.getQuantity() - 1);
        BOOK_DAO.update(book);

        return super.save(order);
    }

    @Override
    public void deleteById(long id) {
        Order order = findById(id);
        Book book = order.getBook();
        book.setQuantity(book.getQuantity() + 1);
        BOOK_DAO.update(book);
        super.deleteById(id);

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
    public List<Order> findAllOverdueOrder() {
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
        }
    }

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

    @Override
    public boolean findByBookAndUserId(long bookId, long userId) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().getFindByBookAndUserIdSqlQuery())) {

            getStatementInitializer().initStatement(prSt, bookId, userId);


            try (ResultSet rs = prSt.executeQuery()) {

                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByBookAndUserId entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }

    public int findNumberOfOverdueOrdersByUserId(long userId) {
        try (Connection conn = getConnector().getConnection();
             PreparedStatement prSt = conn.prepareStatement(getSqlQuery().getFindOverdueOrdersByUserIdSqlQuery())) {

            getStatementInitializer().initStatement(prSt, userId);


            try (ResultSet rs = prSt.executeQuery()) {

                rs.last();
                int row = rs.getRow();

                return row;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoPartException("Error process findByBookAndUserId entities method: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoPartException("Error receive database connection: " + e.getMessage());
        }
    }
}


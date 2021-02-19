package by.gomel.novik.library.persistance.statement;

import by.gomel.novik.library.model.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderStatementInit extends EntityStatementInit<Order> {

    @Override
    public void initStatement(PreparedStatement ps, Order order) throws SQLException {
        ps.setDate(1, Date.valueOf(order.getDate()));
        ps.setInt(2, order.getDuration());
        ps.setLong(3,order.getBook().getId());
        ps.setLong(4,order.getUser().getId());
    }

    @Override
    public void initStatement(PreparedStatement ps, Order order, long id) throws SQLException {
        initStatement(ps, order);
        ps.setLong(5, id);
    }
}

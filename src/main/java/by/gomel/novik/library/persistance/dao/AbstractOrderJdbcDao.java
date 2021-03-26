package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.model.Order;;

import java.util.List;

public abstract class AbstractOrderJdbcDao extends JdbcDao<Order> {


    public abstract List<Order> findByBookId(long id);


    public abstract List<Order> findByUserId(long id);


    public abstract List<Order> findAllOverdueOrder();

    public abstract boolean findByBookAndUserId(long bookId, long userId);
}

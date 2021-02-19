package by.gomel.novik.library.persistance.rsmapper;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderResultSetMapper implements ResultSetMapper<Order> {
    @Override
    public Order processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        LocalDate date = rs.getDate("date_receiving").toLocalDate();
        int days = rs.getInt("days");
        Long bookId = rs.getLong("books_id");
        Long userId = rs.getLong("users_id");
        Book book = new Book();
        User user = new User();
        book.setId(bookId);
        user.setId(userId);

        return new Order(id, date, days, book, user);
    }
}

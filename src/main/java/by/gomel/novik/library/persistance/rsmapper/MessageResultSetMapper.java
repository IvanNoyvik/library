package by.gomel.novik.library.persistance.rsmapper;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Message;
import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MessageResultSetMapper implements ResultSetMapper<Message> {
    @Override
    public Message processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        LocalDate date = rs.getDate("date_sent").toLocalDate();
        String context = rs.getString("context");
        Long userId = rs.getLong("users_id");
        User user = new User();
        user.setId(userId);

        return new Message(id, date, context, user);
    }
}

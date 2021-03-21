package by.gomel.novik.library.persistance.statement.userimpl;

import by.gomel.novik.library.model.Message;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageStatementInit extends EntityStatementInit<Message> {

    @Override
    public void initStatement(PreparedStatement ps, Message message) throws SQLException {
        ps.setDate(1, Date.valueOf(message.getDateSent()));
        ps.setString(2, message.getContent());
        ps.setLong(3,message.getUser().getId());
    }

    @Override
    public void initStatement(PreparedStatement ps, Message message, long id) throws SQLException {
        initStatement(ps, message);
        ps.setLong(4, id);
    }

    public void initStatement(PreparedStatement ps, long bookId, long userId) throws SQLException {
        ps.setLong(1, bookId);
        ps.setLong(2, userId);
    }
}

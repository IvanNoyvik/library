package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.novik.library.model.Message;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.MessageSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.MessageResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.MessageStatementInit;

import java.util.List;

public class MessageJdbcDao extends JdbcDao<Message> {

    private static final MessageJdbcDao instance = new MessageJdbcDao();

    private static final UserJdbcDao USER_DAO = UserJdbcDao.getInstance();

    private MessageJdbcDao(){}

    public static MessageJdbcDao getInstance(){
        return instance;
    }

    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new MessageSqlQuery();
    }

    @Override
    protected ResultSetMapper<Message> getResultSetMapper() {
        return new MessageResultSetMapper();
    }

    @Override
    protected StatementInit<Message> getStatementInitializer() {
        return new MessageStatementInit();
    }


    @Override
    public Message findById(long id) {
        Message message = super.findById(id);
        message.setUser(USER_DAO.findById(message.getUser().getId()));
        return message;
    }

    @Override
    public List<Message> findAll() {

        List<Message> messages = super.findAll();
        messages.forEach(message ->  message.setUser(USER_DAO.findById(message.getUser().getId())));

        return messages;
    }

}

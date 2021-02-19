package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.UserSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.UserResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.UserStatementInit;

public class UserJdbcDao extends JdbcDao<User> {

    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new UserSqlQuery();
    }

    @Override
    protected ResultSetMapper<User> getResultSetMapper() {
        return new UserResultSetMapper();
    }

    @Override
    protected StatementInit<User> getStatementInitializer() {
        return new UserStatementInit();
    }


}

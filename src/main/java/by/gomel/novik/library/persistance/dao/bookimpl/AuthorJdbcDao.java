package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.bookimpl.AuthorSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.AuthorResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.bookimpl.AuthorStatementInit;

public class AuthorJdbcDao extends JdbcDao<Author> {
    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new AuthorSqlQuery();
    }

    @Override
    protected ResultSetMapper<Author> getResultSetMapper() {
        return new AuthorResultSetMapper();
    }

    @Override
    protected StatementInit<Author> getStatementInitializer() {
        return new AuthorStatementInit();
    }
}

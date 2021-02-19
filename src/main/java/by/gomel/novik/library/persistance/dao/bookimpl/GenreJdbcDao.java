package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.bookimpl.GenreSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.GenreResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.bookimpl.GenreStatementInit;

public class GenreJdbcDao extends JdbcDao<Genre> {
    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new GenreSqlQuery();
    }

    @Override
    protected ResultSetMapper<Genre> getResultSetMapper() {
        return new GenreResultSetMapper();
    }

    @Override
    protected StatementInit<Genre> getStatementInitializer() {
        return new GenreStatementInit();
    }
}

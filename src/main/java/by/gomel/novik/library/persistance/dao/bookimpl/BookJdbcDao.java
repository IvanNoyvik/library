package by.gomel.novik.library.persistance.dao.bookimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.bookimpl.BookSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.bookimpl.BookResultSetMapper;
import by.gomel.novik.library.persistance.statement.bookimpl.BookStatementInit;
import by.gomel.novik.library.persistance.statement.StatementInit;

public class BookJdbcDao extends JdbcDao<Book> {

    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new BookSqlQuery();
    }

    @Override
    protected ResultSetMapper<Book> getResultSetMapper() {
        return new BookResultSetMapper();
    }

    @Override
    protected StatementInit<Book> getStatementInitializer() {
        return new BookStatementInit();
    }


}

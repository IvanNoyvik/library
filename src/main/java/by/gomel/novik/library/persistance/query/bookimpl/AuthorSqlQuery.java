package by.gomel.novik.library.persistance.query.bookimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class AuthorSqlQuery implements CrudSqlQuery {

    private static final String FIND_BY_ID_SQL_QUERY = "SELECT ID, AUTHOR FROM AUTHORS WHERE ID = ?";
    private static final String FIND_ALL_SQL_QUERY = "SELECT ID, AUTHOR FROM AUTHORS";
    private static final String SAVE_SQL_QUERY = "INSERT INTO AUTHORS (AUTHOR) VALUES ?";
    private static final String UPDATE_SQL_QUERY = "UPDATE AUTHORS SET AUTHOR = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM AUTHORS WHERE ID = ?";

    private static final String FIND_BY_AUTHOR_SQL_QUERY = "SELECT ID, AUTHOR FROM AUTHORS WHERE AUTHOR = ?";
    public String findByAuthorSqlQuery() {
        return FIND_BY_AUTHOR_SQL_QUERY;
    }


    @Override
    public String findByIdSqlQuery() {
        return FIND_BY_ID_SQL_QUERY;
    }

    @Override
    public String findAllSqlQuery() {
        return FIND_ALL_SQL_QUERY;
    }

    @Override
    public String saveSqlQuery() {
        return SAVE_SQL_QUERY;
    }

    @Override
    public String updateSqlQuery() {
        return UPDATE_SQL_QUERY;
    }

    @Override
    public String deleteByIdSqlQuery() {
        return DELETE_BY_ID_SQL_QUERY;
    }
}

package by.gomel.novik.library.persistance.query.bookimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class GenreSqlQuery implements CrudSqlQuery {

    private static final String FIND_BY_ID_SQL_QUERY = "SELECT ID, GENRE FROM GENRES WHERE ID = ?";
    private static final String FIND_ALL_SQL_QUERY = "SELECT ID, GENRE FROM GENRES";
    private static final String SAVE_SQL_QUERY = "INSERT INTO GENRES (GENRE) VALUES ?";
    private static final String UPDATE_SQL_QUERY = "UPDATE GENRES SET GENRE = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM GENRES WHERE ID = ?";

    private static final String FIND_BY_GENRE_SQL_QUERY = "SELECT ID, GENRE FROM GENRES WHERE GENRE = ?";

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

    public String findByGenreSqlQuery() {
        return FIND_BY_GENRE_SQL_QUERY;
    }

}

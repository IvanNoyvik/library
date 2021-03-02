package by.gomel.novik.library.persistance.query.userimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class MessageSqlQuery implements CrudSqlQuery {


    private static final String FIND_BY_ID_SQL_QUERY =
            " SELECT ID, DATE_SENT, CONTENT, USERS_ID FROM MESSAGES WHERE ID = ?";
    private static final String FIND_ALL_SQL_QUERY =
            " SELECT ID, DATE_SENT, CONTENT, USERS_ID FROM MESSAGES";
    private static final String SAVE_SQL_QUERY = "INSERT INTO MESSAGES (DATE_SENT, CONTENT, USERS_ID) VALUES (?,?,?)";
    private static final String UPDATE_SQL_QUERY = "UPDATE MESSAGES SET DATE_SENT = ?, CONTENT = ?, USERS_ID = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM MESSAGES WHERE ID = ?";


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

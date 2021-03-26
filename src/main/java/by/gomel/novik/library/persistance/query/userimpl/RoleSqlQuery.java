package by.gomel.novik.library.persistance.query.userimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class RoleSqlQuery implements CrudSqlQuery {

    private static final String FIND_BY_ID_SQL_QUERY = "SELECT ID, ROLE FROM ROLES WHERE ID = ?";
    private static final String FIND_ALL_SQL_QUERY = "SELECT ID, ROLE FROM ROLES";
    private static final String SAVE_SQL_QUERY = "INSERT INTO ROLES (ROLE) VALUES ?";
    private static final String UPDATE_SQL_QUERY = "UPDATE ROLES SET ROLE = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM ROLES WHERE ID = ?";

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

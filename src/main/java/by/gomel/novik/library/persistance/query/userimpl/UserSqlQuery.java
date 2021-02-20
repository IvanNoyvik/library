package by.gomel.novik.library.persistance.query.userimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class UserSqlQuery implements CrudSqlQuery {

    private static final String FIND_BY_ID_SQL_QUERY =
            " SELECT U.ID AS U_ID, U.LOGIN, U.PASSWORD, U.NAME, R.ID AS R_ID, R.ROLE, US.ID AS US_ID, US.STATUS " +
            "FROM USERS U LEFT JOIN ROLES R ON R.ID= U.ROLES_ID " +
            "LEFT JOIN  USERS_STATUSES US ON US.ID = U.USERS_STATUSES_ID WHERE U.ID = ?";
    private static final String FIND_ALL_SQL_QUERY =
            " SELECT U.ID AS U_ID, U.LOGIN, U.PASSWORD, U.NAME, R.ID AS R_ID, R.ROLE, US.ID AS US_ID, US.STATUS " +
            "FROM USERS U LEFT JOIN ROLES R ON R.ID= U.ROLES_ID " +
            "LEFT JOIN  USERS_STATUSES US ON US.ID = U.USERS_STATUSES_ID";
    private static final String SAVE_SQL_QUERY = "INSERT INTO USERS (LOGIN, PASSWORD, NAME, ROLES_ID, USERS_STATUSES_ID) VALUES (?,?,?,?,?)";

    private static final String UPDATE_SQL_QUERY = "UPDATE USERS SET LOGIN = ?, PASSWORD = ?, NAME = ?, ROLES_ID = ?, USERS_STATUSES_ID = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM USERS WHERE ID = ?";
    private static final String FIND_BY_LOGIN_AND_PASSWORD_SQL_QUERY = " SELECT U.ID AS U_ID, U.LOGIN, U.PASSWORD, U.NAME, R.ID AS R_ID, R.ROLE, US.ID AS US_ID, US.STATUS " +
            "FROM USERS U LEFT JOIN ROLES R ON R.ID= U.ROLES_ID " +
            "LEFT JOIN  USERS_STATUSES US ON US.ID = U.USERS_STATUSES_ID WHERE U.LOGIN = ? AND U.PASSWORD = ?";

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

    public String findByLoginAndPasswordSqlQuery() {
        return FIND_BY_LOGIN_AND_PASSWORD_SQL_QUERY;
    }

}

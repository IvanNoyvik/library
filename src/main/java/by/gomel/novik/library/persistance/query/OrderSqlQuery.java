package by.gomel.novik.library.persistance.query;

public class OrderSqlQuery implements CrudSqlQuery{

    private static final String FIND_BY_ID_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS WHERE ID = ?";
    private static final String FIND_ALL_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS";
    private static final String SAVE_SQL_QUERY = "INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES (?,?,?,?)";
    private static final String UPDATE_SQL_QUERY = "UPDATE ORDERS SET DATE_RECEIVING = ?, DAYS = ?, BOOKS_ID = ?, USERS_ID = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM ORDERS WHERE ID = ?";
    private static final String FIND_BY_BOOK_ID_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS WHERE BOOKS_ID = ?";
    private static final String FIND_BY_USER_ID_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS WHERE USERS_ID = ?";
    private static final String FIND_ALL_OVERDUE_ORDERS_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS " +
            "WHERE DATEADD('DAY', DAYS, DATE_RECEIVING) < CURRENT_TIMESTAMP()";//
    private static final String FIND_BY_BOOK_AND_USER_ID_SQL_QUERY = "SELECT ID, DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID FROM ORDERS WHERE BOOKS_ID = ? AND USERS_ID = ?";


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


    public String findByBookIdSqlQuery() {
        return FIND_BY_BOOK_ID_SQL_QUERY;
    }

    public String findByUserIdSqlQuery() {
        return FIND_BY_USER_ID_SQL_QUERY;
    }

    public String findAllOverdueOrderSqlQuery() {
        return FIND_ALL_OVERDUE_ORDERS_SQL_QUERY;
    }

    public String getFindByBookAndUserIdSqlQuery() {
        return FIND_BY_BOOK_AND_USER_ID_SQL_QUERY;
    }

}

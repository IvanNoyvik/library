package by.gomel.novik.library.persistance.query.bookimpl;

import by.gomel.novik.library.persistance.query.CrudSqlQuery;

public class BookSqlQuery implements CrudSqlQuery {

    private static final String FIND_BY_ID_SQL_QUERY = " SELECT B.ID AS B_ID, B.TITLE, B.DESCRIPTION, B.QUANTITY, A.ID AS A_ID, A.AUTHOR, G.ID AS G_ID, G.GENRE " +
            "FROM BOOKS B LEFT JOIN AUTHORS A ON A.ID= B.AUTHORS_ID " +
            "LEFT JOIN  GENRES G ON G.ID = B.GENRES_ID WHERE B.ID = ?";
    private static final String FIND_BY_TITLE_AND_AUTHOR_SQL_QUERY = " SELECT B.ID FROM BOOKS B LEFT " +
            "JOIN AUTHORS A ON A.ID= B.AUTHORS_ID " +
            " WHERE B.TITLE = ? AND A.AUTHOR = ?";
    private static final String FIND_ALL_SQL_QUERY = " SELECT B.ID AS B_ID, B.TITLE, B.DESCRIPTION, B.QUANTITY, A.ID AS A_ID, A.AUTHOR, G.ID AS G_ID, G.GENRE " +
            "FROM BOOKS B LEFT JOIN AUTHORS A ON A.ID= B.AUTHORS_ID " +
            "LEFT JOIN  GENRES G ON G.ID = B.GENRES_ID";
    private static final String SAVE_SQL_QUERY = "INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL_QUERY = "UPDATE BOOKS SET TITLE = ?, DESCRIPTION = ?, QUANTITY = ?, AUTHORS_ID = ?, GENRES_ID = ? WHERE ID = ?";
    private static final String ADD_IMAGE_SQL_QUERY = "UPDATE BOOKS SET IMAGE = ? WHERE ID = ?";
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM BOOKS WHERE ID = ?";

    private static final String FIND_IMAGE_BY_ID_SQL_QUERY = " SELECT IMAGE FROM BOOKS WHERE ID = ?";
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

    public String findImageByIdSqlQuery() {
        return FIND_IMAGE_BY_ID_SQL_QUERY;
    }

    public String addImageSqlQuery() {
        return ADD_IMAGE_SQL_QUERY;
    }

    public String findByTitleAndAuthorSqlQuery() {
        return FIND_BY_TITLE_AND_AUTHOR_SQL_QUERY;
    }


}

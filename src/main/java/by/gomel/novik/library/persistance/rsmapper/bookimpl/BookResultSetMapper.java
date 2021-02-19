package by.gomel.novik.library.persistance.rsmapper.bookimpl;

import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookResultSetMapper implements ResultSetMapper<Book> {


    @Override
    public Book processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("b_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String coverLink = rs.getString("cover_Link");
        int quantity = rs.getInt("quantity");
        Author author = new Author();
        author.setId(rs.getLong("a_id"));
        author.setAuthor(rs.getString("author"));
        Genre genre = new Genre();
        genre.setId(rs.getLong("g_id"));
        genre.setGenre(rs.getString("genre"));


        Book book = new Book(id, title, description, coverLink, quantity, author, genre);

        return book;

    }
}

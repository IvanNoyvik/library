package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.persistance.dao.bookimpl.GenreJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class AddGenreCommand extends FrontCommand {

    GenreJdbcDao genreDao = new GenreJdbcDao();


    @Override
    public void process() throws ServletException, IOException {


        String genre = request.getParameter(GENRE);

        if (genre != null && genreDao.findByGenre(genre) == null) {

            genreDao.save(new Genre(genre));

            redirectWithResp(ADMIN_JSP, ADD_GENRE_OK);

        } else {

            redirectWithResp(ADMIN_JSP, ADD_GENRE_FAIL);


        }


    }
}

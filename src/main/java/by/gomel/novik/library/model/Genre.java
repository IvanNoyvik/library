package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Genre extends Entity {

    private String genre;

    public Genre() {
    }

    public Genre(long id, String genre) {
        super(id);
        this.genre = genre;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

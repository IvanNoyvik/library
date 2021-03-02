package by.gomel.novik.library.model;

import by.gomel.novik.library.model.Author;
import by.gomel.novik.library.model.Genre;
import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Book extends Entity {

    private String title;
    private String description;
    private byte[] image;
    private int quantity;
    private Author author;
    private Genre genre;

    public Book() {
    }

    public Book(long id, String title, String description, byte[] image, int quantity, Author author, Genre genre) {
        super(id);
        this.title = title;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

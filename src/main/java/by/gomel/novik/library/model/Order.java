package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Order extends Entity {

    private LocalDate date;
    private int duration;
    private Book book;
    private User user;


    public Order(LocalDate date, int duration, Book book, User user) {
        this.date = date;
        this.duration = duration;
        this.book = book;
        this.user = user;
    }

    public Order(long id, LocalDate date, int duration, Book book, User user) {
        super(id);
        this.date = date;
        this.duration = duration;
        this.book = book;
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Message extends Entity {

    private LocalDate dateSent;
    private String context;
    private User user;

    public Message(long id, LocalDate dateSent, String context, User user) {
        super(id);
        this.dateSent = dateSent;
        this.context = context;
        this.user = user;
    }

    public Message(LocalDate dateSent, String context, User user) {
        this.dateSent = dateSent;
        this.context = context;
        this.user = user;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Message extends Entity {

    private LocalDate dateSent;
    private String content;
    private User user;

    public Message(long id, LocalDate dateSent, String content, User user) {
        super(id);
        this.dateSent = dateSent;
        this.content = content;
        this.user = user;
    }

    public Message(LocalDate dateSent, String content, User user) {
        this.dateSent = dateSent;
        this.content = content;
        this.user = user;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

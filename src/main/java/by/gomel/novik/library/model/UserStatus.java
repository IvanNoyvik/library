package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
public class UserStatus extends Entity {


    private String status;
    private LocalDate duration = LocalDate.now();  // measured in days

    public UserStatus() {
    }

    public UserStatus(long id, String status) {
        super(id);
        this.status = status;
    }

    public UserStatus(long id, String status, int duration) {
        super(id);
        this.status = status;
        this.duration = LocalDate.now().plusDays(duration);

    }
    public UserStatus(String status, int duration) {
        this.status = status;
        this.duration = LocalDate.now().plusDays(duration);
    }

    public UserStatus(long id, String status, LocalDate duration) {
        super(id);
        this.status = status;
        this.duration = duration;

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDuration() {
        return duration;
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }
}

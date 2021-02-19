package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class UserStatus extends Entity {

    private String status;

    public UserStatus() {
    }

    public UserStatus(long id, String status) {
        super(id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

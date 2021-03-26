package by.gomel.novik.library.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
public abstract class Entity implements Serializable {

    private long id;

    public Entity() {
    }

    public Entity(long id) {
        super();
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
